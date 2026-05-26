package in.edu.kristujayanti.util;

import in.edu.kristujayanti.constants.AuthConstantKeys;
import io.vertx.core.Future;
import io.vertx.redis.client.RedisAPI;
import io.vertx.redis.client.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Utility class for revoking access tokens associated with a specific user from a Redis store.
 */
public class RevokeAccessTokenInRedisUtil {

    private static final Logger LOGGER = LoggerFactory.getLogger(RevokeAccessTokenInRedisUtil.class);

    private final RedisAPI redisAPI;
    private final String redisHashKey;

    /**
     * Constructs a RevokeAccessTokenInRedisUtil instance with default Redis hash key.
     *
     * @param redisAPI Redis client instance used for interacting with the Redis server
     */
    public RevokeAccessTokenInRedisUtil(RedisAPI redisAPI) {
        this(redisAPI, AuthConstantKeys.JWT_TOKENS_HASH_KEY);
    }

    /**
     * Constructs a RevokeAccessTokenInRedisUtil instance with a specified Redis hash key.
     *
     * @param redisAPI     Redis client instance used for interacting with the Redis server
     * @param redisHashKey The Redis hash key where the tokens are stored (e.g., "jwtTokens", "accessTokens")
     */
    public RevokeAccessTokenInRedisUtil(RedisAPI redisAPI, String redisHashKey) {
        this.redisAPI = redisAPI;
        this.redisHashKey = redisHashKey;
    }

    /**
     * Revokes all refresh tokens associated with a specific user by deleting the corresponding token entries from Redis.
     *
     * @param userId The user ID for whom all associated refresh tokens will be revoked
     * @return {@link Future<Boolean>} indicating the success (true) or failure (false) of the operation
     */
    public Future<Boolean> revokeUserTokens(String userId) {
        return this.redisAPI.hkeys(this.redisHashKey)
                .compose(keys -> {
                    List<String> keysToDelete = new ArrayList<>();
                    for (Response key : keys) {
                        if (key.toString().startsWith(userId + ":")) {
                            keysToDelete.add(key.toString());
                        }
                    }

                    if (keysToDelete.isEmpty()) {
                        LOGGER.warn("No tokens found to revoke for user: {}", userId);
                        return Future.succeededFuture(true);
                    }

                    return this.redisAPI.hdel(keysToDelete.stream()
                                    .map(key -> List.of(this.redisHashKey, key))
                                    .flatMap(List::stream)
                                    .toList())
                            .map(deletedCount -> {
                                LOGGER.info("Revoked {} tokens for user: {}", deletedCount.toInteger(), userId);
                                return true;
                            });
                })
                .recover(err -> {
                    LOGGER.error("Error revoking tokens for user: {} <{}>", userId, err.getMessage());
                    return Future.succeededFuture(false);
                });
    }

    /**
     * Revokes a specific token associated with a specific user by deleting the corresponding token entry from Redis.
     *
     * @param userId      The user ID for whom the token is to be revoked.
     * @param accessToken The access token to be revoked.
     * @return {@link Future<Boolean>} indicating the success (true) or failure (false) of the operation.
     */
    public Future<Boolean> revokeUserToken(String userId, String accessToken) {
        String tokenKey = userId + ":" + accessToken;

        return this.redisAPI.hdel(List.of(this.redisHashKey, tokenKey))
                .compose(deletedCount -> {
                    if (deletedCount.toInteger() > 0) {
                        LOGGER.info("Successfully revoked token for user: {} (Key: {})", userId, tokenKey);
                        return Future.succeededFuture(true);
                    } else {
                        LOGGER.warn("No matching token found for user: {} with accessToken: {}", userId, accessToken);
                        return Future.succeededFuture(false);
                    }
                })
                .recover(err -> {
                    LOGGER.error("Error revoking token for user: {} with accessToken: {} <{}>",
                            userId, accessToken, err.getMessage());
                    return Future.succeededFuture(false);
                });
    }

}