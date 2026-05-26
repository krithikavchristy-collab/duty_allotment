package in.edu.kristujayanti.util;

import com.razorpay.Payment;
import in.edu.kristujayanti.constants.PaymentServiceKeys;
import io.vertx.core.CompositeFuture;
import io.vertx.core.Future;
import io.vertx.core.json.JsonObject;
import io.vertx.redis.client.RedisAPI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Instant;
import java.util.*;

public class PaymentTransactionManager {

    private final RedisAPI redis;
    private static final int FEE_LOCK_TTL = 300; // 5 mins
    private static final int TRANSACTION_TTL = 86400; // 24 hour
    private static final int PAID_FEE_TTL = 172800; // 2 days (48 hours) in seconds
    private static final String TRANSACTION_PREFIX = "active-transactions:";
    private static final String FEE_LOCK_PREFIX = "feelock:";
    private static final String PAID_FEE_PREFIX = "paid-fee:"; // Track paid fees with expiry

    private final Logger LOGGER = LoggerFactory.getLogger(PaymentTransactionManager.class);

    public PaymentTransactionManager(RedisAPI redis) {
        this.redis = redis;
    }

    /**
     * Check if fee heads are already permanently paid (not just locked)
     * Returns list of fee heads that are already paid
     */
    public Future<List<String>> checkAlreadyPaidFeeHeads(
            List<String> feeHeads,
            String payeeId) {

        List<Future<String>> checks = feeHeads.stream()
                .map(feeHead -> {
                    String paidFeeKey = generatePaidFeeKey(feeHead, payeeId);
                    return redis.get(paidFeeKey)
                            .map(response -> {
                                if (response != null && PaymentServiceKeys.PAID.equals(response.toString())) {
                                    return feeHead;
                                }
                                return null;
                            })
                            .recover(err -> Future.succeededFuture(null));
                })
                .toList();

        return CompositeFuture.all(new ArrayList<>(checks))
                .map(cf -> {
                    List<String> alreadyPaid = new ArrayList<>();
                    for (Future<String> check : checks) {
                        String feeHead = check.result();
                        if (feeHead != null) {
                            alreadyPaid.add(feeHead);
                        }
                    }
                    return alreadyPaid;
                });
    }

    /**
     * Mark fee heads as paid with 2-day expiry
     * This ensures the flag clears after 2 days (4 sync cycles if running twice daily)
     */
    public Future<Void> markFeeHeadsAsPaid(
            List<String> feeHeads,
            String payeeId,
            String transactionId) {

        List<Future<Object>> markings = feeHeads.stream()
                .map(feeHead -> {
                    String paidFeeKey = generatePaidFeeKey(feeHead, payeeId);
                    String metadataKey = paidFeeKey + ":metadata";

                    // Set paid flag with 2-day expiry using SETEX
                    return redis.setex(paidFeeKey, String.valueOf(PAID_FEE_TTL), PaymentServiceKeys.PAID)
                            .compose(v -> {
                                // Set metadata with same expiry
                                return redis.hset(List.of(
                                        metadataKey,
                                        "transactionId", transactionId,
                                        "paidAt", Instant.now().toString(),
                                        "payeeId", payeeId,
                                        "feeHead", feeHead
                                ));
                            })
                            .compose(v -> {
                                // Set expiry on metadata hash as well
                                return redis.expire(List.of(metadataKey, String.valueOf(PAID_FEE_TTL)));
                            })
                            .mapEmpty();
                })
                .toList();

        return CompositeFuture.all(new ArrayList<>(markings)).mapEmpty();
    }

    /**
     * Get metadata about when a fee head was paid
     * Useful for debugging and auditing
     */
    public Future<JsonObject> getPaidFeeMetadata(String feeHead, String payeeId) {
        String paidFeeKey = generatePaidFeeKey(feeHead, payeeId);
        String metadataKey = paidFeeKey + ":metadata";

        return redis.hgetall(metadataKey)
                .compose(response -> {
                    if (response == null || response.size() == 0) {
                        return Future.succeededFuture(new JsonObject());
                    }

                    JsonObject metadata = new JsonObject();

                    // response is MULTI: [field1, value1, field2, value2, ...]
                    for (int i = 0; i < response.size(); i += 2) {
                        String key = response.get(i).toString();
                        String value = response.get(i + 1).toString();
                        metadata.put(key, value);
                    }

                    // Also get TTL to show when it will expire
                    return redis.ttl(paidFeeKey)
                            .map(ttlResponse -> {
                                if (ttlResponse != null) {
                                    // ttl returns an integer (or -1/-2); toInteger() is fine
                                    metadata.put("expiresInSeconds", ttlResponse.toInteger());
                                }
                                return metadata;
                            });
                })
                .recover(err -> Future.succeededFuture(new JsonObject()));
    }

    /**
     * Manually clear paid fee head marker (for admin use)
     */
    public Future<Void> clearPaidFeeHead(String feeHead, String payeeId) {
        String paidFeeKey = generatePaidFeeKey(feeHead, payeeId);
        String metadataKey = paidFeeKey + ":metadata";

        return redis.del(List.of(paidFeeKey, metadataKey))
                .mapEmpty();
    }

    private String generatePaidFeeKey(String feeHead, String payeeId) {
        return PAID_FEE_PREFIX + payeeId + ":" + feeHead;
    }

    /**
     * Attempt to start a transaction with the given fee heads
     */
    public Future<TransactionResult> startTransaction(
            String transactionId,
            List<String> feeHeads,
            String payeeId) {

        String transactionKey = TRANSACTION_PREFIX + transactionId;

        // First check if any fee heads are already permanently paid
        return checkAlreadyPaidFeeHeads(feeHeads, payeeId)
                .compose(alreadyPaid -> {
                    if (!alreadyPaid.isEmpty()) {
                        LOGGER.warn("Fee heads already paid: {}", String.join(", ", alreadyPaid));
                        return Future.succeededFuture(
                                TransactionResult.alreadyPaid(
                                        transactionId,
                                        alreadyPaid,
                                        "The Selected fee head(s) are already paid. Exiting Transaction"
                                )
                        );
                    }

                    // Then check for in-progress conflicts
                    return checkAllFeeHeadsAvailable(feeHeads, payeeId)
                            .compose(conflicts -> {
                                if (!conflicts.isEmpty()) {
                                    return checkConflictingTransactions(conflicts)
                                            .compose(activeConflict -> {
                                                if (activeConflict != null) {
                                                    LOGGER.warn("Fee head '{}' is already in use by transaction: {}", activeConflict.feeHead(), activeConflict.transactionId());
                                                    return Future.succeededFuture(
                                                            TransactionResult.conflict(
                                                                    activeConflict.transactionId(),
                                                                    activeConflict.feeHead(),
                                                                    "There is already an active transaction. Please wait for it to complete or Try Again after 5 min(s)"
                                                            )
                                                    );
                                                } else {
                                                    return createTransactionWithLocks(
                                                            transactionId,
                                                            feeHeads,
                                                            payeeId,
                                                            transactionKey
                                                    );
                                                }
                                            });
                                } else {
                                    return createTransactionWithLocks(
                                            transactionId,
                                            feeHeads,
                                            payeeId,
                                            transactionKey
                                    );
                                }
                            });
                });
    }

    /**
     * Check if any fee head is already locked
     * Returns map of feeHead -> transactionId for conflicts
     */
    private Future<Map<String, String>> checkAllFeeHeadsAvailable(
            List<String> feeHeads,
            String payeeId) {

        List<Future<Map.Entry<String, String>>> checks = feeHeads.stream()
                .map(feeHead -> {
                    String lockKey = generateFeeLockKey(feeHead, payeeId);
                    return redis.get(lockKey)
                            .map(response -> {
                                if (response != null) {
                                    return Map.entry(feeHead, response.toString());
                                }
                                return null;
                            })
                            .recover(err -> Future.succeededFuture(null));
                })
                .toList();

        return CompositeFuture.all(new ArrayList<>(checks))
                .map(cf -> {
                    Map<String, String> conflicts = new HashMap<>();
                    for (int i = 0; i < checks.size(); i++) {
                        Map.Entry<String, String> entry = checks.get(i).result();
                        if (entry != null) {
                            conflicts.put(entry.getKey(), entry.getValue());
                        }
                    }
                    return conflicts;
                });
    }

    /**
     * Check if any conflicting transaction is still active (PENDING or SUCCESS)
     * Returns the first active conflict found, or null if all are FAILED
     */
    private Future<ConflictInfo> checkConflictingTransactions(
            Map<String, String> conflicts) {

        List<Future<ConflictInfo>> statusChecks = conflicts.entrySet().stream()
                .map(entry -> {
                    String feeHead = entry.getKey();
                    String txnId = entry.getValue();
                    return getTransactionStatus(txnId)
                            .map(status -> {
                                if (!PaymentServiceKeys.FAILED.equals(status)) {
                                    // PENDING or SUCCESS - this is an active conflict
                                    return new ConflictInfo(txnId, feeHead, status);
                                }
                                return null;
                            });
                })
                .toList();

        return CompositeFuture.all(new ArrayList<>(statusChecks))
                .map(cf -> {
                    // Return first active conflict
                    for (Future<ConflictInfo> check : statusChecks) {
                        ConflictInfo conflict = check.result();
                        if (conflict != null) {
                            return conflict;
                        }
                    }
                    return null;
                });
    }

    /**
     * Get transaction status
     */
    public Future<String> getTransactionStatus(String transactionId) {
        String transactionKey = TRANSACTION_PREFIX + transactionId;
        return redis.hget(transactionKey, "status")
                .map(response -> response == null ? "UNKNOWN" : response.toString())
                .recover(err -> Future.succeededFuture("UNKNOWN"));
    }

    private String generateFeeLockKey(String feeHead, String payeeId) {
        return FEE_LOCK_PREFIX + payeeId + ":" + feeHead;
    }

    /**
     * Create transaction and lock all fee heads atomically using Lua script
     */
    private Future<TransactionResult> createTransactionWithLocks(
            String transactionId,
            List<String> feeHeads,
            String payeeId,
            String transactionKey) {

        // Use Lua script for atomic operation
        String luaScript = buildLuaScript(feeHeads.size());

        List<String> keys = new ArrayList<>();
        keys.add(transactionKey);
        feeHeads.forEach(fh -> keys.add(generateFeeLockKey(fh, payeeId)));

        List<String> args = new ArrayList<>();
        args.add(transactionId);
        args.add(PaymentServiceKeys.IN_PROGRESS);
        args.add(String.join(",", feeHeads));
        args.add(Instant.now().toString());
        args.add(String.valueOf(FEE_LOCK_TTL));
        args.add(String.valueOf(TRANSACTION_TTL));

        List<String> evalArgs = new ArrayList<>();
        evalArgs.add(luaScript);
        evalArgs.add(String.valueOf(keys.size()));
        evalArgs.addAll(keys);
        evalArgs.addAll(args);

        return redis.eval(evalArgs)
                .map(response -> {
                    String result = response.toString();
                    if ("OK".equals(result)) {
                        return TransactionResult.success(transactionId);
                    } else {
                        return TransactionResult.error("Failed to create transaction: " + result);
                    }
                })
                .recover(err -> Future.succeededFuture(
                        TransactionResult.error("Failed to create transaction: " + err.getMessage())
                ));
    }

    /**
     * Build Lua script to atomically check and set all locks
     */
    private String buildLuaScript(int feeHeadCount) {
        StringBuilder script = new StringBuilder();
        script.append("local txnKey = KEYS[1]\n");
        script.append("local txnId = ARGV[1]\n");
        script.append("local status = ARGV[2]\n");
        script.append("local feeHeads = ARGV[3]\n");
        script.append("local timestamp = ARGV[4]\n");
        script.append("local ttl = tonumber(ARGV[5])\n\n");
        script.append("local ttlHead = tonumber(ARGV[6])\n\n");

        // Check all fee locks first
        script.append("-- Check if any fee head is locked by another transaction\n");
        for (int i = 0; i < feeHeadCount; i++) {
            int keyIndex = i + 2; // KEYS[2] onwards are fee locks
            script.append("local lock").append(i).append(" = redis.call('GET', KEYS[").append(keyIndex).append("])\n");
            script.append("if lock").append(i).append(" then\n");
            script.append("  local lockTxnStatus = redis.call('HGET', 'active-transactions:' .. lock").append(i).append(", 'status')\n");
            script.append("  if lockTxnStatus and lockTxnStatus ~= 'FAILED' then\n");
            script.append("    return 'CONFLICT:  ' .. lock").append(i).append("\n");
            script.append("  end\n");
            script.append("end\n\n");
        }

        // If we reach here, all checks passed - create locks
        script.append("-- Create transaction\n");
        script.append("redis.call('HSET', txnKey, 'transactionId', txnId, 'status', status, 'feeHeads', feeHeads, 'timestamp', timestamp)\n");
        script.append("redis.call('EXPIRE', txnKey, ttlHead)\n\n");

        script.append("-- Lock all fee heads\n");
        for (int i = 0; i < feeHeadCount; i++) {
            int keyIndex = i + 2;
            script.append("redis.call('SETEX', KEYS[").append(keyIndex).append("], ttl, txnId)\n");
        }

        script.append("\nreturn 'OK'\n");

        return script.toString();
    }

    /**
     * Update transaction status
     */
    public Future<Void> updateTransactionStatus(
            String transactionId,
            String status,
            String payeeId,
            String message) {

        String transactionKey = TRANSACTION_PREFIX + transactionId;

        return redis.hset(List.of(
                        transactionKey,
                        "status", status,
                        "message", message != null ? message : ""
                ))
                .compose(v -> {
                    if (PaymentServiceKeys.PAID.equals(status) || PaymentServiceKeys.USER_CANCELLED.equals(status)) {
                        // Release locks when transaction succeeds or fails
                        return releaseFeeLocks(transactionId, payeeId);
                    }
                    return Future.succeededFuture();
                })
                .mapEmpty();
    }

    /**
     * Release all fee locks for a transaction
     */
    public Future<Object> releaseFeeLocks(String transactionId, String payeeId) {
        String transactionKey = TRANSACTION_PREFIX + transactionId;

        return redis.hget(transactionKey, "feeHeads")
                .compose(response -> {
                    if (response == null) {
                        return Future.succeededFuture();
                    }

                    String feeHeadsStr = response.toString();
                    List<String> feeHeads = Arrays.asList(feeHeadsStr.split(","));

                    // Delete all fee locks that still point to this transaction
                    List<Future<Object>> deletions = feeHeads.stream()
                            .map(feeHead -> {
                                String lockKey = generateFeeLockKey(feeHead, payeeId);
                                return redis.get(lockKey)
                                        .compose(lockResponse -> {
                                            if (lockResponse != null &&
                                                    lockResponse.toString().equals(transactionId)) {
                                                return redis.del(List.of(lockKey)).mapEmpty();
                                            }
                                            return Future.succeededFuture();
                                        })
                                        .recover(err -> Future.succeededFuture());
                            })
                            .toList();

                    return CompositeFuture.all(new ArrayList<>(deletions)).mapEmpty();
                })
                .recover(err -> Future.succeededFuture());
    }

    /**
     * Conflict information
     */
    private record ConflictInfo(String transactionId, String feeHead, String status) {
    }

    /**
     * Result object
     */
    public static class TransactionResult {
        private final boolean success;
        private final String transactionId;
        private final String message;
        private final boolean conflict;
        private final String conflictFeeHead;
        private final boolean alreadyPaid;
        private final List<String> paidFeeHeads;

        private TransactionResult(boolean success, String transactionId,
                                  String message, boolean conflict, String conflictFeeHead,
                                  boolean alreadyPaid, List<String> paidFeeHeads) {
            this.success = success;
            this.transactionId = transactionId;
            this.message = message;
            this.conflict = conflict;
            this.conflictFeeHead = conflictFeeHead;
            this.alreadyPaid = alreadyPaid;
            this.paidFeeHeads = paidFeeHeads;
        }

        public static TransactionResult success(String transactionId) {
            return new TransactionResult(true, transactionId, "Transaction started", false, null, false, null);
        }

        public static TransactionResult conflict(String existingTxnId, String feeHead, String message) {
            return new TransactionResult(false, existingTxnId, message, true, feeHead, false, null);
        }

        public static TransactionResult alreadyPaid(String transactionId, List<String> paidFeeHeads, String message) {
            return new TransactionResult(false, transactionId, message, false, null, true, paidFeeHeads);
        }

        public static TransactionResult error(String message) {
            return new TransactionResult(false, null, message, false, null, false, null);
        }

        public boolean isSuccess() {
            return success;
        }

        public String getTransactionId() {
            return transactionId;
        }

        public String getMessage() {
            return message;
        }

        public boolean isConflict() {
            return conflict;
        }

        public String getConflictFeeHead() {
            return conflictFeeHead;
        }

        public boolean isAlreadyPaid() {
            return alreadyPaid;
        }

        public List<String> getPaidFeeHeads() {
            return paidFeeHeads;
        }
    }


    /**
     * Check if fee heads are paid or locked
     * Returns a status object indicating which fee heads are paid, locked, or available
     *
     * @param feeHeads List of fee heads to check
     * @param payeeId  The payee ID
     * @return Future containing FeeHeadStatusResult with detailed status information
     */
    public Future<FeeHeadStatusResult> checkFeeHeadStatus(
            List<String> feeHeads,
            String payeeId) {

        List<Future<FeeHeadStatus>> checks = feeHeads.stream()
                .map(feeHead -> checkSingleFeeHeadStatus(feeHead, payeeId))
                .toList();

        return CompositeFuture.all(new ArrayList<>(checks))
                .map(cf -> {
                    List<String> paidFeeHeads = new ArrayList<>();
                    List<String> lockedFeeHeads = new ArrayList<>();
                    Map<String, String> lockTransactionIds = new HashMap<>();
                    List<String> availableFeeHeads = new ArrayList<>();

                    for (Future<FeeHeadStatus> check : checks) {
                        FeeHeadStatus status = check.result();

                        if (status.isPaid()) {
                            paidFeeHeads.add(status.feeHead());
                        } else if (status.isLocked()) {
                            lockedFeeHeads.add(status.feeHead());
                            lockTransactionIds.put(status.feeHead(), status.lockingTransactionId());
                        } else {
                            availableFeeHeads.add(status.feeHead());
                        }
                    }

                    return new FeeHeadStatusResult(
                            paidFeeHeads,
                            lockedFeeHeads,
                            lockTransactionIds,
                            availableFeeHeads
                    );
                });
    }

    /**
     * Check status of a single fee head
     */
    private Future<FeeHeadStatus> checkSingleFeeHeadStatus(String feeHead, String payeeId) {
        String paidFeeKey = generatePaidFeeKey(feeHead, payeeId);
        String lockKey = generateFeeLockKey(feeHead, payeeId);

        // First check if it's paid
        return redis.get(paidFeeKey)
                .compose(paidResponse -> {
                    if (paidResponse != null && PaymentServiceKeys.PAID.equals(paidResponse.toString())) {
                        // Fee head is paid
                        return Future.succeededFuture(FeeHeadStatus.paid(feeHead));
                    }

                    // Not paid, check if it's locked
                    return redis.get(lockKey)
                            .compose(lockResponse -> {
                                if (lockResponse != null) {
                                    String lockingTxnId = lockResponse.toString();

                                    // Verify the locking transaction is still active
                                    return getTransactionStatus(lockingTxnId)
                                            .map(txnStatus -> {
                                                if (!PaymentServiceKeys.FAILED.equals(txnStatus)) {
                                                    // Fee head is locked by active transaction
                                                    return FeeHeadStatus.locked(feeHead, lockingTxnId, txnStatus);
                                                } else {
                                                    // Lock exists but transaction failed - consider available
                                                    return FeeHeadStatus.available(feeHead);
                                                }
                                            });
                                }

                                // Not paid and not locked - available
                                return Future.succeededFuture(FeeHeadStatus.available(feeHead));
                            });
                })
                .recover(err -> {
                    LOGGER.error("Error checking fee head status for {}: {}", feeHead, err.getMessage());
                    // On error, assume available to prevent blocking updates
                    return Future.succeededFuture(FeeHeadStatus.available(feeHead));
                });
    }

    /**
     * Status information for a single fee head
     */
    private record FeeHeadStatus(
            String feeHead,
            boolean isPaid,
            boolean isLocked,
            String lockingTransactionId,
            String lockingTransactionStatus) {

        public static FeeHeadStatus paid(String feeHead) {
            return new FeeHeadStatus(feeHead, true, false, null, null);
        }

        public static FeeHeadStatus locked(String feeHead, String txnId, String txnStatus) {
            return new FeeHeadStatus(feeHead, false, true, txnId, txnStatus);
        }

        public static FeeHeadStatus available(String feeHead) {
            return new FeeHeadStatus(feeHead, false, false, null, null);
        }
    }

    /**
     * Result object containing status of all checked fee heads
     */
    public static class FeeHeadStatusResult {
        private final List<String> paidFeeHeads;
        private final List<String> lockedFeeHeads;
        private final Map<String, String> lockTransactionIds;
        private final List<String> availableFeeHeads;

        public FeeHeadStatusResult(
                List<String> paidFeeHeads,
                List<String> lockedFeeHeads,
                Map<String, String> lockTransactionIds,
                List<String> availableFeeHeads) {
            this.paidFeeHeads = Collections.unmodifiableList(paidFeeHeads);
            this.lockedFeeHeads = Collections.unmodifiableList(lockedFeeHeads);
            this.lockTransactionIds = Collections.unmodifiableMap(lockTransactionIds);
            this.availableFeeHeads = Collections.unmodifiableList(availableFeeHeads);
        }

        /**
         * Check if all fee heads are available for update
         */
        public boolean allAvailable() {
            return paidFeeHeads.isEmpty() && lockedFeeHeads.isEmpty();
        }

        /**
         * Check if any fee heads are paid
         */
        public boolean hasAnyPaid() {
            return !paidFeeHeads.isEmpty();
        }

        /**
         * Check if any fee heads are locked
         */
        public boolean hasAnyLocked() {
            return !lockedFeeHeads.isEmpty();
        }

        /**
         * Get human-readable status message
         */
        public String getStatusMessage() {
            StringBuilder message = new StringBuilder();

            if (!paidFeeHeads.isEmpty()) {
                message.append("Paid fee heads: ").append(String.join(", ", paidFeeHeads)).append(". ");
            }

            if (!lockedFeeHeads.isEmpty()) {
                message.append("Locked fee heads: ").append(String.join(", ", lockedFeeHeads)).append(". ");
            }

            if (allAvailable()) {
                message.append("All fee heads are available.");
            }

            return message.toString().trim();
        }

        // Getters
        public List<String> getPaidFeeHeads() {
            return paidFeeHeads;
        }

        public List<String> getLockedFeeHeads() {
            return lockedFeeHeads;
        }

        public Map<String, String> getLockTransactionIds() {
            return lockTransactionIds;
        }

        public List<String> getAvailableFeeHeads() {
            return availableFeeHeads;
        }

        /**
         * Get transaction ID that is locking a specific fee head
         */
        public String getLockingTransactionId(String feeHead) {
            return lockTransactionIds.get(feeHead);
        }
    }
}