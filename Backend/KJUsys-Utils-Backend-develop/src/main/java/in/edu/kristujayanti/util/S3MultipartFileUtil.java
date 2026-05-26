//package in.edu.kristujayanti.util;
//
//
//import org.bson.Document;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
//import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
//import software.amazon.awssdk.core.exception.SdkException;
//import software.amazon.awssdk.regions.Region;
//import software.amazon.awssdk.services.s3.S3Client;
//import software.amazon.awssdk.services.s3.model.*;
//import software.amazon.awssdk.services.s3.presigner.S3Presigner;
//import software.amazon.awssdk.services.s3.presigner.model.PresignedUploadPartRequest;
//import software.amazon.awssdk.services.s3.presigner.model.UploadPartPresignRequest;
//
//import java.io.IOException;
//import java.io.InputStream;
//import java.time.Duration;
//import java.time.Instant;
//import java.time.temporal.ChronoUnit;
//import java.util.*;
//import java.util.stream.Collectors;
//
///**
// * Utility class for S3 Multipart Upload operations
// * Handles large file uploads (50GB+) using S3's multipart upload API
// *
// * @author Joyal-Saji
// * @since 2025-11-11
// */
//public class S3MultipartFileUtil {
//    private static final Logger LOGGER = LoggerFactory.getLogger(S3MultipartFileUtil.class);
//    private static final Region REGION = Region.AP_SOUTH_1;
//
//    private static S3Client s3Client;
//    private static volatile S3Presigner presigner;
//    private final Properties awsProperties = loadAwsProperties();
//
//    // Constants for part size calculation
//    private static final long MIN_PART_SIZE = 5L * 1024L * 1024L; // 5 MB (S3 minimum)
//    private static final long MAX_PART_SIZE = 5L * 1024L * 1024L * 1024L; // 5 GB (S3 maximum)
//    private static final int MAX_PARTS = 10000; // S3 limit
//    private static final long DEFAULT_PART_SIZE = 100L * 1024L * 1024L; // 100 MB default
//    private static final int EXPIRY_HOURS = 24;
//
//    public S3MultipartFileUtil() {
//    }
//
//    /**
//     * Load AWS configuration properties from aws_config.properties
//     */
//    private Properties loadAwsProperties() {
//        Properties properties = new Properties();
//        try (InputStream input = getClass().getClassLoader().getResourceAsStream("aws_config.properties")) {
//            if (input == null) {
//                LOGGER.error("Unable to find aws_config.properties");
//                return properties;
//            }
//            properties.load(input);
//            LOGGER.info("AWS properties loaded successfully");
//        } catch (IOException ex) {
//            LOGGER.error("Error loading aws properties", ex);
//        }
//        return properties;
//    }
//
//    /**
//     * Initialize S3 Client (lazy initialization with double-check locking)
//     */
//    private void initializeS3Client() throws IOException {
//        if (s3Client == null) {
//            synchronized (S3MultipartFileUtil.class) {
//                if (s3Client == null) {
//                    try {
//                        AwsBasicCredentials awsCreds = AwsBasicCredentials.create(
//                                awsProperties.getProperty("aws.accessKeyId"),
//                                awsProperties.getProperty("aws.secretKey")
//                        );
//                        s3Client = S3Client.builder()
//                                .region(REGION)
//                                .credentialsProvider(StaticCredentialsProvider.create(awsCreds))
//                                .build();
//                        LOGGER.info("S3 Client initialized successfully for region: {}", REGION);
//                    } catch (Exception e) {
//                        LOGGER.error("Failed to initialize S3 Client", e);
//                        throw new IOException("Failed to initialize S3 Client: " + e.getMessage(), e);
//                    }
//                }
//            }
//        }
//    }
//
//    /**
//     * Initialize S3 Presigner (lazy initialization with double-check locking)
//     */
//    private void initializePresigner() throws IOException {
//        if (presigner == null) {
//            synchronized (S3MultipartFileUtil.class) {
//                if (presigner == null) {
//                    try {
//                        AwsBasicCredentials awsCreds = AwsBasicCredentials.create(
//                                awsProperties.getProperty("aws.accessKeyId"),
//                                awsProperties.getProperty("aws.secretKey")
//                        );
//                        presigner = S3Presigner.builder()
//                                .region(REGION)
//                                .credentialsProvider(StaticCredentialsProvider.create(awsCreds))
//                                .build();
//                        LOGGER.info("S3 Presigner initialized successfully for region: {}", REGION);
//                    } catch (Exception e) {
//                        LOGGER.error("Failed to initialize S3 Presigner", e);
//                        throw new IOException("Failed to initialize S3 Presigner: " + e.getMessage(), e);
//                    }
//                }
//            }
//        }
//    }
//
//    /**
//     * Initialize multipart upload and return uploadId, key, partSize, etc.
//     *
//     * @param paramsDoc Document containing:
//     *                  - fileName_Upload_Text (required): Name of the file
//     *                  - contentType_Upload_Text (optional): MIME type, defaults to application/octet-stream
//     *                  - fileSize_Upload_Long (optional): File size in bytes for part size calculation
//     *                  - metadata_Upload_Document (optional): Additional metadata to store
//     *                  - userId (optional): User ID for key generation
//     * @return Document containing uploadId, key, partSizeRecommended, expiresAt, bucket, totalParts
//     * @throws IOException if S3 operation fails
//     * @throws IllegalArgumentException if required fields are missing
//     */
//    public Document initializeMultipartUpload(Document paramsDoc) throws IOException {
//        initializeS3Client();
//
//        // Extract and validate required fields
//        String fileName = paramsDoc.getString("fileName_Upload_Text");
//        if (fileName == null || fileName.trim().isEmpty()) {
//            LOGGER.error("fileName_Upload_Text is required but not provided");
//            throw new IllegalArgumentException("fileName is required");
//        }
//
//        String contentType = paramsDoc.getString("contentType_Upload_Text");
//        if (contentType == null || contentType.trim().isEmpty()) {
//            contentType = "application/octet-stream";
//            LOGGER.debug("contentType not provided, using default: application/octet-stream");
//        }
//
//        Long fileSize = paramsDoc.getLong("fileSize_Upload_Long");
//        String userId = paramsDoc.getString("userId");
//
//        LOGGER.info("Initializing multipart upload - fileName: {}, contentType: {}, fileSize: {}, userId: {}",
//                fileName, contentType, fileSize, userId);
//
//        // Generate unique S3 key
//        String sanitizedFileName = sanitizeFileName(fileName);
//        String key = String.format("uploads/%s/%d_%s_%s",
//                userId != null ? userId : "anonymous",
//                System.currentTimeMillis(),
//                UUID.randomUUID().toString().substring(0, 8),
//                sanitizedFileName
//        );
//
//        // Build S3 metadata
//        Map<String, String> s3Metadata = new HashMap<>();
//        Document metadataDoc = paramsDoc.get("metadata_Upload_Document", Document.class);
//        if (metadataDoc != null) {
//            metadataDoc.forEach((metaKey, metaValue) -> {
//                if (metaValue != null) {
//                    s3Metadata.put(metaKey, metaValue.toString());
//                }
//            });
//        }
//        s3Metadata.put("original-filename", fileName);
//        if (userId != null) {
//            s3Metadata.put("uploaded-by", userId);
//        }
//        s3Metadata.put("upload-timestamp", Instant.now().toString());
//
//        try {
//            // Create multipart upload request
//            CreateMultipartUploadRequest request = CreateMultipartUploadRequest.builder()
//                    .bucket(awsProperties.getProperty("aws.bucketName"))
//                    .key(key)
//                    .contentType(contentType)
//                    .metadata(s3Metadata)
//                    .build();
//
//            CreateMultipartUploadResponse response = s3Client.createMultipartUpload(request);
//
//            // Calculate recommended part size
//            long partSizeRecommended = calculatePartSize(fileSize);
//            Instant expiresAt = Instant.now().plus(EXPIRY_HOURS, ChronoUnit.HOURS);
//
//            // Calculate total parts
//            Integer totalParts = null;
//            if (fileSize != null && fileSize > 0) {
//                totalParts = calculateTotalParts(fileSize, partSizeRecommended);
//            }
//
//            // Build response document
//            Document resultDoc = new Document()
//                    .append("uploadId", response.uploadId())
//                    .append("key", key)
//                    .append("partSizeRecommended", partSizeRecommended)
//                    .append("expiresAt", expiresAt.toString())
//                    .append("bucket", awsProperties.getProperty("aws.bucketName"))
//                    .append("totalParts", totalParts);
//
//            LOGGER.info("Successfully initialized multipart upload - uploadId: {}, key: {}, partSize: {}, totalParts: {}",
//                    response.uploadId(), key, partSizeRecommended, totalParts);
//
//            return resultDoc;
//
//        } catch (S3Exception e) {
//            LOGGER.error("S3 error while initializing multipart upload: {}", e.awsErrorDetails().errorMessage(), e);
//            throw new IOException("S3 error: " + e.awsErrorDetails().errorMessage(), e);
//        } catch (SdkException e) {
//            LOGGER.error("AWS SDK error while initializing multipart upload", e);
//            throw new IOException("AWS SDK error: " + e.getMessage(), e);
//        }
//    }
//
//    /**
//     * Generate presigned URLs for uploading parts
//     * Client will use these URLs to upload parts directly to S3
//     *
//     * @param paramsDoc Document containing:
//     *                  - key_Upload_Text (required): S3 key from init response
//     *                  - uploadId_Upload_Text (required): Upload ID from init response
//     *                  - partNumber_Upload_Int (single part) OR partNumbers_Upload_IntArray (batch)
//     *                  - expiryMinutes_Upload_Int (optional): URL expiry in minutes, default 60
//     * @return Document containing urls array with partNumber, url, expiresAt, httpMethod
//     * @throws IOException if S3 operation fails
//     * @throws IllegalArgumentException if required fields are missing or invalid
//     */
//    public Document generatePresignedUrls(Document paramsDoc) throws IOException {
//        initializePresigner();
//
//        String key = paramsDoc.getString("key_Upload_Text");
//        String uploadId = paramsDoc.getString("uploadId_Upload_Text");
//        Integer expiryMinutes = paramsDoc.getInteger("expiryMinutes_Upload_Int", 60);
//
//        if (key == null || key.trim().isEmpty()) {
//            LOGGER.error("key_Upload_Text is required but not provided");
//            throw new IllegalArgumentException("key is required");
//        }
//        if (uploadId == null || uploadId.trim().isEmpty()) {
//            LOGGER.error("uploadId_Upload_Text is required but not provided");
//            throw new IllegalArgumentException("uploadId is required");
//        }
//        if (expiryMinutes < 1 || expiryMinutes > 10080) {
//            LOGGER.error("Invalid expiryMinutes: {}. Must be between 1 and 10080", expiryMinutes);
//            throw new IllegalArgumentException("expiryMinutes must be between 1 and 10080 (7 days)");
//        }
//
//        // Extract part numbers (single or array)
//        List<Integer> partNumbers = new ArrayList<>();
//        Integer singlePart = paramsDoc.getInteger("partNumber_Upload_Int");
//        if (singlePart != null) {
//            partNumbers.add(singlePart);
//        } else {
//            List<Integer> partsArray = paramsDoc.getList("partNumbers_Upload_IntArray", Integer.class);
//            if (partsArray != null && !partsArray.isEmpty()) {
//                partNumbers.addAll(partsArray);
//            }
//        }
//
//        if (partNumbers.isEmpty()) {
//            LOGGER.error("Either partNumber_Upload_Int or partNumbers_Upload_IntArray is required");
//            throw new IllegalArgumentException("Either partNumber or partNumbers array is required");
//        }
//
//        LOGGER.info("Generating presigned URLs for uploadId: {}, parts: {}, expiry: {} minutes",
//                uploadId, partNumbers.size(), expiryMinutes);
//
//        Duration expiry = Duration.ofMinutes(expiryMinutes);
//        Instant expiresAt = Instant.now().plus(expiry);
//
//        List<Document> urls = new ArrayList<>();
//
//        for (Integer partNumber : partNumbers) {
//            if (partNumber < 1 || partNumber > 10000) {
//                LOGGER.error("Invalid part number: {}. Must be between 1 and 10000", partNumber);
//                throw new IllegalArgumentException(
//                        String.format("Part number %d is invalid. Must be between 1 and 10000", partNumber)
//                );
//            }
//
//            try {
//                UploadPartRequest uploadPartRequest = UploadPartRequest.builder()
//                        .bucket(awsProperties.getProperty("aws.bucketName"))
//                        .key(key)
//                        .uploadId(uploadId)
//                        .partNumber(partNumber)
//                        .build();
//
//                UploadPartPresignRequest presignRequest = UploadPartPresignRequest.builder()
//                        .signatureDuration(expiry)
//                        .uploadPartRequest(uploadPartRequest)
//                        .build();
//
//                PresignedUploadPartRequest presignedRequest = presigner.presignUploadPart(presignRequest);
//
//                Document urlDoc = new Document()
//                        .append("partNumber", partNumber)
//                        .append("url", presignedRequest.url().toString())
//                        .append("expiresAt", expiresAt.toString())
//                        .append("httpMethod", presignedRequest.httpRequest().method().name());
//
//                urls.add(urlDoc);
//
//            } catch (SdkException e) {
//                LOGGER.error("Error generating presigned URL for part {}: {}", partNumber, e.getMessage(), e);
//                throw new IOException("Error generating presigned URL for part " + partNumber + ": " + e.getMessage(), e);
//            }
//        }
//
//        LOGGER.info("Successfully generated {} presigned URLs", urls.size());
//
//        return new Document()
//                .append("urls", urls)
//                .append("totalUrls", urls.size())
//                .append("expiresAt", expiresAt.toString());
//    }
//
//    /**
//     * List already uploaded parts (useful for resume functionality)
//     *
//     * @param paramsDoc Document containing:
//     *                  - key_Upload_Text (required): S3 key
//     *                  - uploadId_Upload_Text (required): Upload ID
//     *                  - maxParts_Upload_Int (optional): Max parts to return, default 1000
//     *                  - partNumberMarker_Upload_Int (optional): For pagination
//     * @return Document containing parts array with partNumber, etag, size, lastModified
//     * @throws IOException if S3 operation fails
//     * @throws IllegalArgumentException if upload doesn't exist or fields are invalid
//     */
//    public Document listParts(Document paramsDoc) throws IOException {
//        initializeS3Client();
//
//        String key = paramsDoc.getString("key_Upload_Text");
//        String uploadId = paramsDoc.getString("uploadId_Upload_Text");
//        Integer maxParts = paramsDoc.getInteger("maxParts_Upload_Int", 1000);
//        Integer partNumberMarker = paramsDoc.getInteger("partNumberMarker_Upload_Int");
//
//        if (key == null || key.trim().isEmpty()) {
//            LOGGER.error("key_Upload_Text is required but not provided");
//            throw new IllegalArgumentException("key is required");
//        }
//        if (uploadId == null || uploadId.trim().isEmpty()) {
//            LOGGER.error("uploadId_Upload_Text is required but not provided");
//            throw new IllegalArgumentException("uploadId is required");
//        }
//        if (maxParts < 1 || maxParts > 1000) {
//            LOGGER.error("Invalid maxParts: {}. Must be between 1 and 1000", maxParts);
//            throw new IllegalArgumentException("maxParts must be between 1 and 1000");
//        }
//
//        LOGGER.info("Listing parts for uploadId: {}, maxParts: {}, marker: {}", uploadId, maxParts, partNumberMarker);
//
//        try {
//            ListPartsRequest.Builder requestBuilder = ListPartsRequest.builder()
//                    .bucket(awsProperties.getProperty("aws.bucketName"))
//                    .key(key)
//                    .uploadId(uploadId)
//                    .maxParts(maxParts);
//
//            if (partNumberMarker != null) {
//                requestBuilder.partNumberMarker(partNumberMarker);
//            }
//
//            ListPartsResponse response = s3Client.listParts(requestBuilder.build());
//
//            List<Document> partsArray = new ArrayList<>();
//            long totalSize = 0;
//
//            for (Part part : response.parts()) {
//                Document partDoc = new Document()
//                        .append("partNumber", part.partNumber())
//                        .append("etag", part.eTag())
//                        .append("size", part.size())
//                        .append("lastModified", part.lastModified() != null ? part.lastModified().toString() : null);
//
//                partsArray.add(partDoc);
//                totalSize += part.size();
//            }
//
//            Document result = new Document()
//                    .append("parts", partsArray)
//                    .append("totalParts", partsArray.size())
//                    .append("totalSize", totalSize)
//                    .append("isTruncated", response.isTruncated())
//                    .append("key", key)
//                    .append("uploadId", uploadId)
//                    .append("bucket", awsProperties.getProperty("aws.bucketName"));
//
//            if (response.isTruncated()) {
//                result.append("nextPartNumberMarker", response.nextPartNumberMarker());
//            }
//
//            if (response.initiator() != null) {
//                result.append("initiator", new Document()
//                        .append("id", response.initiator().id())
//                        .append("displayName", response.initiator().displayName()));
//            }
//
//            result.append("storageClass", response.storageClassAsString());
//
//            LOGGER.info("Successfully listed {} parts, totalSize: {} bytes, isTruncated: {}",
//                    partsArray.size(), totalSize, response.isTruncated());
//
//            return result;
//
//        } catch (NoSuchUploadException e) {
//            LOGGER.error("Upload does not exist - uploadId: {}", uploadId, e);
//            throw new IllegalArgumentException("Upload does not exist: " + e.awsErrorDetails().errorMessage());
//        } catch (S3Exception e) {
//            LOGGER.error("S3 error listing parts: {}", e.awsErrorDetails().errorMessage(), e);
//            throw new IOException("S3 error listing parts: " + e.awsErrorDetails().errorMessage(), e);
//        } catch (SdkException e) {
//            LOGGER.error("AWS SDK error listing parts", e);
//            throw new IOException("AWS SDK error: " + e.getMessage(), e);
//        }
//    }
//
//    /**
//     * Complete multipart upload and finalize the object in S3
//     *
//     * @param paramsDoc Document containing:
//     *                  - key_Upload_Text (required): S3 key
//     *                  - uploadId_Upload_Text (required): Upload ID
//     *                  - parts_Upload_DocumentArray (required): Array of {partNumber_Upload_Int, etag_Upload_Text}
//     * @return Document containing location, bucket, key, etag, size, contentType, status
//     * @throws IOException if S3 operation fails
//     * @throws IllegalArgumentException if required fields are missing or parts are invalid
//     */
//    public Document completeMultipartUpload(Document paramsDoc) throws IOException {
//        initializeS3Client();
//
//        String key = paramsDoc.getString("key_Upload_Text");
//        String uploadId = paramsDoc.getString("uploadId_Upload_Text");
//        List<Document> partsDocs = paramsDoc.getList("parts_Upload_DocumentArray", Document.class);
//
//        if (key == null || key.trim().isEmpty()) {
//            LOGGER.error("key_Upload_Text is required but not provided");
//            throw new IllegalArgumentException("key is required");
//        }
//        if (uploadId == null || uploadId.trim().isEmpty()) {
//            LOGGER.error("uploadId_Upload_Text is required but not provided");
//            throw new IllegalArgumentException("uploadId is required");
//        }
//        if (partsDocs == null || partsDocs.isEmpty()) {
//            LOGGER.error("parts_Upload_DocumentArray is required and cannot be empty");
//            throw new IllegalArgumentException("parts array is required and cannot be empty");
//        }
//        if (partsDocs.size() > 10000) {
//            LOGGER.error("Too many parts: {}. Maximum 10000 allowed", partsDocs.size());
//            throw new IllegalArgumentException("Maximum 10000 parts allowed, received: " + partsDocs.size());
//        }
//
//        LOGGER.info("Completing multipart upload - uploadId: {}, totalParts: {}", uploadId, partsDocs.size());
//
//        try {
//            // Sort and build completed parts
//            List<CompletedPart> completedParts = partsDocs.stream()
//                    .sorted(Comparator.comparingInt(d -> d.getInteger("partNumber_Upload_Int")))
//                    .map(partDoc -> {
//                        Integer partNumber = partDoc.getInteger("partNumber_Upload_Int");
//                        String etag = partDoc.getString("etag_Upload_Text");
//
//                        if (partNumber == null || partNumber < 1 || partNumber > 10000) {
//                            throw new IllegalArgumentException("Invalid part number: " + partNumber);
//                        }
//                        if (etag == null || etag.trim().isEmpty()) {
//                            throw new IllegalArgumentException("Missing etag for part " + partNumber);
//                        }
//
//                        return CompletedPart.builder()
//                                .partNumber(partNumber)
//                                .eTag(etag)
//                                .build();
//                    })
//                    .collect(Collectors.toList());
//
//            // Validate first part is part 1
//            if (completedParts.get(0).partNumber() != 1) {
//                LOGGER.error("First part must be part number 1, got: {}", completedParts.get(0).partNumber());
//                throw new IllegalArgumentException("First part must be part number 1");
//            }
//
//            CompletedMultipartUpload completedMultipartUpload = CompletedMultipartUpload.builder()
//                    .parts(completedParts)
//                    .build();
//
//            CompleteMultipartUploadRequest request = CompleteMultipartUploadRequest.builder()
//                    .bucket(awsProperties.getProperty("aws.bucketName"))
//                    .key(key)
//                    .uploadId(uploadId)
//                    .multipartUpload(completedMultipartUpload)
//                    .build();
//
//            CompleteMultipartUploadResponse response = s3Client.completeMultipartUpload(request);
//
//            Document result = new Document()
//                    .append("location", response.location())
//                    .append("bucket", response.bucket())
//                    .append("key", response.key())
//                    .append("etag", response.eTag())
//                    .append("uploadId", uploadId)
//                    .append("totalParts", completedParts.size())
//                    .append("status", "completed");
//
//            // Get object metadata
//            try {
//                HeadObjectRequest headRequest = HeadObjectRequest.builder()
//                        .bucket(awsProperties.getProperty("aws.bucketName"))
//                        .key(key)
//                        .build();
//                HeadObjectResponse headResponse = s3Client.headObject(headRequest);
//                result.append("size", headResponse.contentLength());
//                result.append("contentType", headResponse.contentType());
//                result.append("lastModified", headResponse.lastModified().toString());
//            } catch (Exception e) {
//                LOGGER.warn("Could not retrieve object metadata: {}", e.getMessage());
//            }
//
//            LOGGER.info("Successfully completed multipart upload - location: {}, etag: {}, size: {} bytes",
//                    response.location(), response.eTag(), result.get("size"));
//
//            return result;
//
//        } catch (S3Exception e) {
//            LOGGER.error("S3 error completing multipart upload: {}", e.awsErrorDetails().errorMessage(), e);
//            if (e.statusCode() == 400) {
//                throw new IllegalArgumentException("Invalid multipart upload: " + e.awsErrorDetails().errorMessage());
//            }
//            throw new IOException("S3 error: " + e.awsErrorDetails().errorMessage(), e);
//        } catch (SdkException e) {
//            LOGGER.error("AWS SDK error completing multipart upload", e);
//            throw new IOException("AWS SDK error: " + e.getMessage(), e);
//        }
//    }
//
//    /**
//     * Abort multipart upload and clean up all uploaded parts
//     *
//     * @param paramsDoc Document containing:
//     *                  - key_Upload_Text (required): S3 key
//     *                  - uploadId_Upload_Text (required): Upload ID
//     * @return Document containing status, message, key, uploadId
//     * @throws IOException if S3 operation fails
//     * @throws IllegalArgumentException if upload doesn't exist or fields are invalid
//     */
//    public Document abortMultipartUpload(Document paramsDoc) throws IOException {
//        initializeS3Client();
//
//        String key = paramsDoc.getString("key_Upload_Text");
//        String uploadId = paramsDoc.getString("uploadId_Upload_Text");
//
//        if (key == null || key.trim().isEmpty()) {
//            LOGGER.error("key_Upload_Text is required but not provided");
//            throw new IllegalArgumentException("key is required");
//        }
//        if (uploadId == null || uploadId.trim().isEmpty()) {
//            LOGGER.error("uploadId_Upload_Text is required but not provided");
//            throw new IllegalArgumentException("uploadId is required");
//        }
//
//        LOGGER.info("Aborting multipart upload - uploadId: {}, key: {}", uploadId, key);
//
//        try {
//            AbortMultipartUploadRequest request = AbortMultipartUploadRequest.builder()
//                    .bucket(awsProperties.getProperty("aws.bucketName"))
//                    .key(key)
//                    .uploadId(uploadId)
//                    .build();
//
//            s3Client.abortMultipartUpload(request);
//
//            LOGGER.info("Successfully aborted multipart upload - uploadId: {}, key: {}", uploadId, key);
//
//            return new Document()
//                    .append("status", "aborted")
//                    .append("message", "Multipart upload successfully aborted and cleaned up")
//                    .append("key", key)
//                    .append("uploadId", uploadId)
//                    .append("bucket", awsProperties.getProperty("aws.bucketName"));
//
//        } catch (NoSuchUploadException e) {
//            LOGGER.warn("Upload not found (may be already completed/aborted) - uploadId: {}, key: {}", uploadId, key);
//            throw new IllegalArgumentException("Upload does not exist: " + e.awsErrorDetails().errorMessage());
//        } catch (S3Exception e) {
//            LOGGER.error("S3 error aborting upload: {}", e.awsErrorDetails().errorMessage(), e);
//            throw new IOException("S3 error: " + e.awsErrorDetails().errorMessage(), e);
//        } catch (SdkException e) {
//            LOGGER.error("AWS SDK error aborting upload", e);
//            throw new IOException("AWS SDK error: " + e.getMessage(), e);
//        }
//    }
//
//    // ========== Helper Methods ==========
//
//    /**
//     * Calculate optimal part size based on file size
//     * Ensures total parts stay under S3's 10,000 part limit
//     */
//    private long calculatePartSize(Long fileSize) {
//        if (fileSize == null || fileSize <= 0) {
//            return DEFAULT_PART_SIZE; // 100 MB default
//        }
//
//        // For very large files (> 500 GB), use larger parts
//        if (fileSize > 500L * 1024L * 1024L * 1024L) {
//            return 500L * 1024L * 1024L; // 500 MB
//        }
//
//        // For 50-500 GB files, calculate to keep under 10k parts
//        if (fileSize > 50L * 1024L * 1024L * 1024L) {
//            long calculatedSize = fileSize / (MAX_PARTS - 100); // leave buffer
//            // Round up to nearest 10 MB
//            calculatedSize = ((calculatedSize / (10L * 1024L * 1024L)) + 1) * (10L * 1024L * 1024L);
//            return Math.max(MIN_PART_SIZE, Math.min(calculatedSize, MAX_PART_SIZE));
//        }
//
//        // For files < 50 GB
//        if (fileSize > 5L * 1024L * 1024L * 1024L) {
//            return 100L * 1024L * 1024L; // 100 MB
//        }
//
//        return 50L * 1024L * 1024L; // 50 MB
//    }
//
//    /**
//     * Calculate total number of parts needed
//     */
//    private int calculateTotalParts(long fileSize, long partSize) {
//        return (int) Math.ceil((double) fileSize / partSize);
//    }
//
//    /**
//     * Sanitize filename to be S3-safe
//     * Removes special characters and limits length
//     */
//    private String sanitizeFileName(String fileName) {
//        // Replace unsafe characters with underscore
//        String safe = fileName.replaceAll("[^a-zA-Z0-9._-]", "_");
//
//        // Limit length to 200 chars while preserving extension
//        if (safe.length() > 200) {
//            int lastDot = safe.lastIndexOf('.');
//            if (lastDot > 0) {
//                String ext = safe.substring(lastDot);
//                safe = safe.substring(0, 200 - ext.length()) + ext;
//            } else {
//                safe = safe.substring(0, 200);
//            }
//        }
//
//        return safe;
//    }
//
//    /**
//     * Get S3 Client instance (for testing/debugging)
//     */
//    public S3Client getS3Client() throws IOException {
//        initializeS3Client();
//        return s3Client;
//    }
//
//    /**
//     * Get S3 Presigner instance (for testing/debugging)
//     */
//    public S3Presigner getPresigner() throws IOException {
//        initializePresigner();
//        return presigner;
//    }
//}





package in.edu.kristujayanti.util;

import in.edu.kristujayanti.enums.CustomMethodResult;
import org.bson.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.core.exception.SdkException;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.*;
import software.amazon.awssdk.services.s3.presigner.S3Presigner;
import software.amazon.awssdk.services.s3.presigner.model.PresignedUploadPartRequest;
import software.amazon.awssdk.services.s3.presigner.model.UploadPartPresignRequest;

import software.amazon.awssdk.services.s3.presigner.S3Presigner;
import software.amazon.awssdk.services.s3.presigner.model.UploadPartPresignRequest;
import software.amazon.awssdk.services.s3.presigner.model.PresignedUploadPartRequest;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLOutput;
import java.time.Duration;
import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.stream.Collectors;

import static in.edu.kristujayanti.enums.CustomMethodResult.FAILURE;
import static in.edu.kristujayanti.enums.CustomMethodResult.SUCCESS;
import static in.edu.kristujayanti.propertyBinder.Examination.ExaminationKeysPBinder.COURSE_CODE;
import static in.edu.kristujayanti.propertyBinder.Examination.ExaminationKeysPBinder.EXAM_CODE;

/**
 * Utility class for S3 Multipart Upload operations
 * Handles large file uploads (50GB+) using S3's multipart upload API
 *
 * @author Joyal-Saji
 * @since 2025-11-11
 */
public class S3MultipartFileUtil {
    private static final Logger LOGGER = LoggerFactory.getLogger(S3MultipartFileUtil.class);
    private static final Region REGION = Region.AP_SOUTH_1;

//    private static S3Client s3Client;

    // changed to volatile for thread safety
    private static  volatile S3Client s3Client;
    private static volatile S3Presigner presigner;
//    private final Properties awsProperties = loadAwsProperties();

    private static final Properties awsProperties = loadAwsProperties();

    // Constants for part size calculation
    private static final long MIN_PART_SIZE = 5L * 1024L * 1024L; // 5 MB (S3 minimum)
    private static final long MAX_PART_SIZE = 5L * 1024L * 1024L * 1024L; // 5 GB (S3 maximum)
    private static final int MAX_PARTS = 10000; // S3 limit
    private static final long DEFAULT_PART_SIZE = 250L * 1024L * 1024L; // 250  MB default
    private static final int EXPIRY_HOURS = 24;

    public S3MultipartFileUtil() {
    }

    /**
     * Load AWS configuration properties from aws_config.properties
     */
    private static Properties loadAwsProperties() {
        Properties properties = new Properties();
//        try (InputStream input = getClass().getClassLoader().getResourceAsStream("aws_config.properties")) {
        try (InputStream input = S3MultipartFileUtil.class.getClassLoader().getResourceAsStream("aws_config.properties")) {
            if (input == null) {
                LOGGER.error("Unable to find aws_config.properties");
                return properties;
            }
            properties.load(input);
            LOGGER.info("AWS properties loaded successfully");
        } catch (IOException ex) {
            LOGGER.error("Error loading aws properties", ex);
        }
        return properties;
    }

    /**
     * Initialize S3 Client (lazy initialization with double-check locking)
     */
    private void initializeS3Client1() throws IOException {
        if (s3Client == null) {
            synchronized (S3MultipartFileUtil.class) {
                if (s3Client == null) {
                    try {
                        AwsBasicCredentials awsCreds = AwsBasicCredentials.create(
                                awsProperties.getProperty("aws.accessKeyId"),
                                awsProperties.getProperty("aws.secretKey")
                        );

                        s3Client = S3Client.builder()
                                .region(REGION)
                                .credentialsProvider(StaticCredentialsProvider.create(awsCreds))
                                .build();
                        LOGGER.info("S3 Client initialized successfully for region: {}", REGION);
                    } catch (Exception e) {
                        LOGGER.error("Failed to initialize S3 Client", e);
                        throw new IOException("Failed to initialize S3 Client: " + e.getMessage(), e);
                    }
                }
            }
        }
    }

    private void initializeS3Client() throws IOException {
        if (s3Client == null) {
            synchronized (S3MultipartFileUtil.class) {
                if (s3Client == null) {
                    try {
                        // ADD THIS DEBUG CODE
                        LOGGER.info("=== INITIALIZING S3 CLIENT ===");

                        String accessKeyId = awsProperties.getProperty("aws.accessKeyId");
                        String secretKey = awsProperties.getProperty("aws.secretKey");

                        // Log what was loaded (MASKED for security)
                        if (accessKeyId == null || accessKeyId.isEmpty()) {
                            LOGGER.error(" aws.accessKeyId is NULL or EMPTY!");
                            throw new IllegalStateException("AWS Access Key ID is missing");
                        }

                        if (secretKey == null || secretKey.isEmpty()) {
                            LOGGER.error(" aws.secretKey is NULL or EMPTY!");
                            throw new IllegalStateException("AWS Secret Key is missing");
                        }

                        LOGGER.info("Access Key ID: {}...{} (length: {})",
                                accessKeyId.substring(0, 4),
                                accessKeyId.substring(accessKeyId.length() - 4),
                                accessKeyId.length());

                        LOGGER.info("Secret Key: {}...{} (length: {})",
                                secretKey.substring(0, 4),
                                secretKey.substring(secretKey.length() - 4),
                                secretKey.length());

                        // Check secret key length
                        if (secretKey.length() != 40) {
                            LOGGER.error(" SECRET KEY LENGTH IS {} BUT SHOULD BE 40!", secretKey.length());
                            LOGGER.error(" Your secret key is CORRUPTED or INCORRECT!");
                        }

                        LOGGER.info("Region: {}", REGION);
                        LOGGER.info("Bucket: {}", awsProperties.getProperty("aws.bucketName"));

                        //  CREATE CREDENTIALS
                        AwsBasicCredentials awsCreds = AwsBasicCredentials.create(accessKeyId, secretKey);

                        s3Client = S3Client.builder()
                                .region(REGION)
                                .credentialsProvider(StaticCredentialsProvider.create(awsCreds))
                                .build();

                        LOGGER.info(" S3 Client initialized successfully for region: {}", REGION);

                    } catch (Exception e) {
                        LOGGER.error(" Failed to initialize S3 Client", e);
                        throw new IOException("Failed to initialize S3 Client: " + e.getMessage(), e);
                    }
                }
            }
        }
    }

    private void initializeS3ClientTest() throws IOException {
        if (s3Client == null) {
            synchronized (S3MultipartFileUtil.class) {
                if (s3Client == null) {
                    try {
                        //  FIX : Log initialization (helps debug the "missing log" issue)
                        LOGGER.info("=== INITIALIZING S3 CLIENT ===");

                        String accessKeyId = awsProperties.getProperty("aws.accessKeyId");
                        String secretKey = awsProperties.getProperty("aws.secretKey");


                        if (accessKeyId == null || accessKeyId.trim().isEmpty()) {
                            throw new IllegalStateException("AWS Access Key ID is missing in properties");
                        }
                        if (secretKey == null || secretKey.trim().isEmpty()) {
                            throw new IllegalStateException("AWS Secret Key is missing in properties");
                        }

                        // FIX : Log credentials (masked) for debugging
                        LOGGER.info("Access Key ID: {}...{}",
                                accessKeyId.substring(0, Math.min(4, accessKeyId.length())),
                                accessKeyId.length() > 4 ? accessKeyId.substring(accessKeyId.length() - 4) : "");
                        LOGGER.info("Secret Key length: {} characters", secretKey.length());
                        LOGGER.info("Expected Secret Key length: 40 characters");

                        if (secretKey.length() != 40) {
                            LOGGER.warn(" Secret Key length is {} but should be 40! Key may be corrupted.",
                                    secretKey.length());
                        }

                        AwsBasicCredentials awsCreds = AwsBasicCredentials.create(accessKeyId, secretKey);

                        s3Client = S3Client.builder()
                                .region(REGION)
                                .credentialsProvider(StaticCredentialsProvider.create(awsCreds))
                                .build();

                        LOGGER.info(" S3 Client initialized successfully for region: {}", REGION);

                    } catch (Exception e) {
                        LOGGER.error(" Failed to initialize S3 Client", e);
                        throw new IOException("Failed to initialize S3 Client: " + e.getMessage(), e);
                    }
                } else {
                    //   Log when reusing existing client
                    LOGGER.debug("S3 Client already initialized, reusing existing instance");
                }
            }
        } else {
            //  Log when skipping initialization (helps debug)
            LOGGER.debug("S3 Client already exists, skipping initialization");
        }
    }

    /**
     * Initialize S3 Presigner (lazy initialization with double-check locking)
     */
    private void initializePresigner1() throws IOException {
        if (presigner == null) {
            synchronized (S3MultipartFileUtil.class) {
                if (presigner == null) {
                    try {
                        AwsBasicCredentials awsCreds = AwsBasicCredentials.create(
                                awsProperties.getProperty("aws.accessKeyId"),
                                awsProperties.getProperty("aws.secretKey")
                        );
                        presigner = S3Presigner.builder()
                                .region(REGION)
                                .credentialsProvider(StaticCredentialsProvider.create(awsCreds))
                                .build();
                        LOGGER.info("S3 Presigner initialized successfully for region: {}", REGION);
                    } catch (Exception e) {
                        LOGGER.error("Failed to initialize S3 Presigner", e);
                        throw new IOException("Failed to initialize S3 Presigner: " + e.getMessage(), e);
                    }
                }
            }
        }
    }

    /**
     * Initialize S3 Presigner (lazy initialization with double-check locking)
     * Used for generating presigned PUT URLs for uploading parts
     */
    private void initializePresigner() {
        if (presigner == null) {
            synchronized (S3MultipartFileUtil.class) {
                if (presigner == null) {
                    LOGGER.info("=== INITIALIZING S3 PRESIGNER ===");
                    AwsBasicCredentials awsCreds = AwsBasicCredentials.create(
                            awsProperties.getProperty("aws.accessKeyId"),
                            awsProperties.getProperty("aws.secretKey")
                    );
                    presigner = S3Presigner.builder()
                            .region(REGION)
                            .credentialsProvider(StaticCredentialsProvider.create(awsCreds))
                            .build();
                    LOGGER.info(" S3 Presigner initialized for region: {} (PUT operations)", REGION);
                }
            }
        }
    }

    /**
     * Initialize multipart upload and return uploadId, key, partSize, etc.
     *
     * @param paramsDoc Document containing:
     *                  - fileName_Upload_Text (required): Name of the file
     *                  - contentType_Upload_Text (optional): MIME type, defaults to application/octet-stream
     *                  - fileSize_Upload_Long (optional): File size in bytes for part size calculation
     *                  - metadata_Upload_Document (optional): Additional metadata to store
     *                  - userId (optional): User ID for key generation
     * @return CustomMethodResult with SUCCESS containing uploadId, key, partSizeRecommended, expiresAt, bucket, totalParts
     *         or FAILURE with error message
     */
    public CustomMethodResult initializeMultipartUpload(Document paramsDoc) {
        try {
            initializeS3Client();

            // Extract and validate required fields
            String fileName = paramsDoc.getString("fileName");
            if (fileName == null || fileName.trim().isEmpty()) {
                LOGGER.error("fileName_Upload_Text is required but not provided");
                return FAILURE.withMessage("fileName is required");
            }

            String contentType = paramsDoc.getString("contentType");
            if (contentType == null || contentType.trim().isEmpty()) {
                contentType = "application/octet-stream";
                LOGGER.debug("contentType not provided, using default: application/octet-stream");
            }


            Number fileSizeNumber = (Number) paramsDoc.get("fileSize");
            long fileSize = fileSizeNumber.longValue();


            LOGGER.info("File: {}, Size: {}, ContentType: {}", fileName, fileSize, contentType);

            // Validate file size
            if (fileSize <= 0) {
                return CustomMethodResult.FAILURE.withMessage("fileSize must be greater than 0");
            }

            if (fileSize > 5L * 1024 * 1024 * 1024 * 1024) { // 5 TB max
                return CustomMethodResult.FAILURE.withMessage("fileSize exceeds maximum allowed (5 TB)");
            }

            String userId = paramsDoc.getString("userId");

            LOGGER.info("Initializing multipart upload - fileName: {}, contentType: {}, fileSize: {}, userId: {}",
                    fileName, contentType, fileSize, userId);

            // Generate unique S3 key
            String sanitizedFileName = sanitizeFileName(fileName);
            String key = String.format("uploads/%s/%d_%s_%s",
                    userId != null ? userId : "anonymous",
                    System.currentTimeMillis(),
                    UUID.randomUUID().toString().substring(0, 8),
                    sanitizedFileName
            );

            // Build S3 metadata
            Map<String, String> s3Metadata = new HashMap<>();
            Document metadataDoc = paramsDoc.get("metadata", Document.class);
            if (metadataDoc != null) {
                metadataDoc.forEach((metaKey, metaValue) -> {
                    if (metaValue != null) {
                        s3Metadata.put(metaKey, metaValue.toString());
                    }
                });
            }
            s3Metadata.put("original-filename", fileName);
            if (userId != null) {
                s3Metadata.put("uploaded-by", userId);
            }
            s3Metadata.put("upload-timestamp", Instant.now().toString());

            // Create multipart upload request
            CreateMultipartUploadRequest request = CreateMultipartUploadRequest.builder()
                    .bucket(awsProperties.getProperty("aws.bucketName"))
                    .key(key)
                    .contentType(contentType)
                    .metadata(s3Metadata)
                    .build();

            CreateMultipartUploadResponse response = s3Client.createMultipartUpload(request);

            // Calculate recommended part size
            long partSizeRecommended = calculatePartSize(fileSize);
            Instant expiresAt = Instant.now().plus(EXPIRY_HOURS, ChronoUnit.HOURS);

            // Calculate total parts
            Integer totalParts = null;
//            if (fileSize != null && fileSize > 0) {
//                totalParts = calculateTotalParts(fileSize, partSizeRecommended);
//            }

            // Build response document
            Document resultDoc = new Document()
                    .append("uploadId", response.uploadId())
                    .append("key", key)
                    .append("partSizeRecommended", partSizeRecommended)
                    .append("expiresAt", expiresAt.toString())
                    .append("bucket", awsProperties.getProperty("aws.bucketName"))
                    .append("totalParts", totalParts);

            LOGGER.info("Successfully initialized multipart upload - uploadId: {}, key: {}, partSize: {}, totalParts: {}",
                    response.uploadId(), key, partSizeRecommended, totalParts);

            return SUCCESS.withFields("Multipart upload initialized successfully", resultDoc);

        } catch (S3Exception e) {
            LOGGER.error("S3 error while initializing multipart upload: {}", e.awsErrorDetails().errorMessage(), e);
            return FAILURE.withMessage("S3 error: " + e.awsErrorDetails().errorMessage());
        } catch (IOException e) {
            LOGGER.error("IO error while initializing S3 client", e);
            return FAILURE.withMessage("Failed to initialize S3 client: " + e.getMessage());
        } catch (SdkException e) {
            LOGGER.error("AWS SDK error while initializing multipart upload", e);
            return FAILURE.withMessage("AWS SDK error: " + e.getMessage());
        } catch (Exception e) {
            LOGGER.error("Unexpected error while initializing multipart upload", e);
            return FAILURE.withMessage("Unexpected error: " + e.getMessage());
        }
    }


    public CustomMethodResult initializeMultipartUploadLatest(Document paramsDoc) {
        try {
            initializeS3Client();

            // Extract and validate required fields
            String fileName = paramsDoc.getString("fileName");
            if (fileName == null || fileName.trim().isEmpty()) {
                LOGGER.error("fileName is required but not provided");
                return FAILURE.withMessage("fileName is required");
            }

            String contentType = paramsDoc.getString("contentType");
            if (contentType == null || contentType.trim().isEmpty()) {
                contentType = "application/octet-stream";
                LOGGER.debug("contentType not provided, using default: application/octet-stream");
            }

            Number fileSizeNumber = (Number) paramsDoc.get("fileSize");
            if (fileSizeNumber == null) {
                LOGGER.error("fileSize is required but not provided");
                return FAILURE.withMessage("fileSize is required");
            }
            long fileSize = fileSizeNumber.longValue();

            LOGGER.info("File: {}, Size: {}, ContentType: {}", fileName, fileSize, contentType);

            // Validate file size
            if (fileSize <= 0) {
                return CustomMethodResult.FAILURE.withMessage("fileSize must be greater than 0");
            }

            if (fileSize > 5L * 1024 * 1024 * 1024 * 1024) { // 5 TB max
                return CustomMethodResult.FAILURE.withMessage("fileSize exceeds maximum allowed (5 TB)");
            }

            String userId = paramsDoc.getString("userId");

            String examCode = paramsDoc.getString(EXAM_CODE.getPropertyName());
            String courseCode = paramsDoc.getString(COURSE_CODE.getPropertyName());

            System.out.println("exam code in util: " + examCode);
            System.out.println("course code in util: " + courseCode);

            DateTimeFormatter formatter = DateTimeFormatter
                    .ofPattern("yyyy-MM-dd_HH-mm-ss")
                    .withZone(ZoneId.of("Asia/Kolkata")); // IST timezone

            String timeStamp = formatter.format(Instant.now());

            LOGGER.info("Initializing multipart upload - fileName: {}, contentType: {}, fileSize: {}, userId: {}",
                    fileName, contentType, fileSize, userId);

            // Generate unique S3 key
//            String sanitizedFileName = sanitizeFileName(fileName);
//            String key = String.format("uploads/%s/%d_%s_%s",
//                    userId != null ? userId : "anonymous",
//                    System.currentTimeMillis(),
//                    UUID.randomUUID().toString().substring(0, 8),
//                    sanitizedFileName
//            );

            ///  commented above code and added examCode and courseCode in the key generation previous working fine

            String sanitizedFileName = sanitizeFileName(fileName);
            String key = String.format("Answer_Scripts_Zip_Files/%s/%s/%s_%s_%s",
                    examCode,
                    courseCode,
                    courseCode,
                    timeStamp,
                    sanitizedFileName
            );


            // Build S3 metadata
            Map<String, String> s3Metadata = new HashMap<>();
            Document metadataDoc = paramsDoc.get("metadata", Document.class);
            if (metadataDoc != null) {
                metadataDoc.forEach((metaKey, metaValue) -> {
                    if (metaValue != null) {
                        s3Metadata.put(metaKey, metaValue.toString());
                    }
                });
            }
            s3Metadata.put("original-filename", fileName);
            if (userId != null) {
                s3Metadata.put("uploaded-by", userId);
            }
            s3Metadata.put("upload-timestamp", Instant.now().toString());

            String bucketName = awsProperties.getProperty("aws.bucketName");
            if (bucketName == null || bucketName.trim().isEmpty()) {
                LOGGER.error("AWS bucket name is not configured");
                return FAILURE.withMessage("AWS bucket name is not configured");
            }

            // Create multipart upload request
            CreateMultipartUploadRequest request = CreateMultipartUploadRequest.builder()
                    .bucket(awsProperties.getProperty("aws.bucketName"))
                    .key(key)
                    .contentType(contentType)
                    .metadata(s3Metadata)
                    .serverSideEncryption(ServerSideEncryption.AES256)
                    .build();

            if (s3Client == null) {
                LOGGER.error("S3 Client is null after initialization attempt");
                return FAILURE.withMessage("S3 Client initialization failed");
            }

            LOGGER.info("Creating multipart upload in S3...");

            CreateMultipartUploadResponse response = s3Client.createMultipartUpload(request);

            // Calculate recommended part size
            long partSizeRecommended = calculatePartSize(fileSize);
            Instant expiresAt = Instant.now().plus(EXPIRY_HOURS, ChronoUnit.HOURS);

            //  Calculate total parts (uncommented!)
            int totalParts = calculateTotalParts(fileSize, partSizeRecommended);

            // Build response document
            Document resultDoc = new Document()
                    .append("uploadId", response.uploadId())
                    .append("key", key)
                    .append("partSizeRecommended", partSizeRecommended)
                    .append("expiresAt", expiresAt.toString())
                    .append("bucket", awsProperties.getProperty("aws.bucketName"))
                    .append("totalParts", totalParts);  // ✅ Now has a value!

            LOGGER.info("Successfully initialized multipart upload - uploadId: {}, key: {}, partSize: {} MB, totalParts: {}",
                    response.uploadId(), key, partSizeRecommended / (1024 * 1024), totalParts);

            return SUCCESS.withFields("Multipart upload initialized successfully", resultDoc);

        } catch (S3Exception e) {
            LOGGER.error("S3 error while initializing multipart upload: {}", e.awsErrorDetails().errorMessage(), e);
            return FAILURE.withMessage("S3 error: " + e.awsErrorDetails().errorMessage());
        } catch (IOException e) {
            LOGGER.error("IO error while initializing S3 client", e);
            return FAILURE.withMessage("Failed to initialize S3 client: " + e.getMessage());
        } catch (SdkException e) {
            LOGGER.error("AWS SDK error while initializing multipart upload", e);
            return FAILURE.withMessage("AWS SDK error: " + e.getMessage());
        } catch (Exception e) {
            LOGGER.error("Unexpected error while initializing multipart upload", e);
            return FAILURE.withMessage("Unexpected error: " + e.getMessage());
        }
    }



    /**
     * Generate presigned URLs for uploading parts
     * Client will use these URLs to upload parts directly to S3
     *
     * @param paramsDoc Document containing:
     *                  - key_Upload_Text (required): S3 key from init response
     *                  - uploadId_Upload_Text (required): Upload ID from init response
     *                  - partNumber_Upload_Int (single part) OR partNumbers_Upload_IntArray (batch)
     *                  - expiryMinutes_Upload_Int (optional): URL expiry in minutes, default 60
     * @return CustomMethodResult with SUCCESS containing urls array with partNumber, url, expiresAt, httpMethod
     *         or FAILURE with error message
     */
//    public CustomMethodResult generatePresignedUrls(Document paramsDoc) {
//        try {
//            initializePresigner();
//
//            String key = paramsDoc.getString("key");
//            String uploadId = paramsDoc.getString("uploadId");
//            Integer expiryMinutes = paramsDoc.getInteger("expiryMinutes", 60);
//
//            if (key == null || key.trim().isEmpty()) {
//                LOGGER.error("key_Upload_Text is required but not provided");
//                return FAILURE.withMessage("key is required");
//            }
//            if (uploadId == null || uploadId.trim().isEmpty()) {
//                LOGGER.error("uploadId_Upload_Text is required but not provided");
//                return FAILURE.withMessage("uploadId is required");
//            }
//            if (expiryMinutes < 1 || expiryMinutes > 10080) {
//                LOGGER.error("Invalid expiryMinutes: {}. Must be between 1 and 10080", expiryMinutes);
//                return FAILURE.withMessage("expiryMinutes must be between 1 and 10080 (7 days)");
//            }
//
//            // Extract part numbers (single or array)
//            List<Integer> partNumbers = new ArrayList<>();
//            Integer singlePart = paramsDoc.getInteger("partNumber");
//            if (singlePart != null) {
//                partNumbers.add(singlePart);
//            } else {
////                List<Integer> partsArray = paramsDoc.getList("partNumbers_Upload_IntArray", Integer.class);
//                List<Integer> partsArray = paramsDoc.getList("partNumbers", Integer.class);
//                if (partsArray != null && !partsArray.isEmpty()) {
//                    partNumbers.addAll(partsArray);
//                }
//            }
//
//            if (partNumbers.isEmpty()) {
//                LOGGER.error("Either partNumber_Upload_Int or partNumbers_Upload_IntArray is required");
//                return FAILURE.withMessage("Either partNumber or partNumbers array is required");
//            }
//
//            LOGGER.info("Generating presigned URLs for uploadId: {}, parts: {}, expiry: {} minutes",
//                    uploadId, partNumbers.size(), expiryMinutes);
//
//            Duration expiry = Duration.ofMinutes(expiryMinutes);
//            Instant expiresAt = Instant.now().plus(expiry);
//
//            List<Document> urls = new ArrayList<>();
//
//            for (Integer partNumber : partNumbers) {
//                if (partNumber < 1 || partNumber > 10000) {
//                    LOGGER.error("Invalid part number: {}. Must be between 1 and 10000", partNumber);
//                    return FAILURE.withMessage(
//                            String.format("Part number %d is invalid. Must be between 1 and 10000", partNumber)
//                    );
//                }
//
//                UploadPartRequest uploadPartRequest = UploadPartRequest.builder()
//                        .bucket(awsProperties.getProperty("aws.bucketName"))
//                        .key(key)
//                        .uploadId(uploadId)
//                        .partNumber(partNumber)
//                        .build();
//
//                UploadPartPresignRequest presignRequest = UploadPartPresignRequest.builder()
//                        .signatureDuration(expiry)
//                        .uploadPartRequest(uploadPartRequest)
//                        .build();
//
//                PresignedUploadPartRequest presignedRequest = presigner.presignUploadPart(presignRequest);
//
//                Document urlDoc = new Document()
//                        .append("partNumber", partNumber)
//                        .append("url", presignedRequest.url().toString())
//                        .append("expiresAt", expiresAt.toString())
//                        .append("httpMethod", presignedRequest.httpRequest().method().name());
//
//                urls.add(urlDoc);
//            }
//
//            LOGGER.info("Successfully generated {} presigned URLs", urls.size());
//
//            Document resultDoc = new Document()
//                    .append("urls", urls)
//                    .append("totalUrls", urls.size())
//                    .append("expiresAt", expiresAt.toString());
//
//            return SUCCESS.withFields("Presigned URLs generated successfully", resultDoc);
//
//        } catch (IOException e) {
//            LOGGER.error("IO error while initializing S3 presigner", e);
//            return FAILURE.withMessage("Failed to initialize S3 presigner: " + e.getMessage());
//        } catch (SdkException e) {
//            LOGGER.error("AWS SDK error generating presigned URLs", e);
//            return FAILURE.withMessage("AWS SDK error: " + e.getMessage());
//        } catch (Exception e) {
//            LOGGER.error("Unexpected error generating presigned URLs", e);
//            return FAILURE.withMessage("Unexpected error: " + e.getMessage());
//        }
//    }



    /// / the above used ids get changed to below ones in the method



    public CustomMethodResult generatePresignedUrls2(Document paramsDoc) {
        try {
            initializePresigner();

            String key = paramsDoc.getString("key");
            String uploadId = paramsDoc.getString("uploadId");
            Integer expiryMinutes = paramsDoc.getInteger("expiryMinutes", 60);

            // Validation...

            List<Integer> partNumbers = new ArrayList<>();
            // Extract part numbers...

            Duration expiry = Duration.ofMinutes(expiryMinutes);
            List<Document> urls = new ArrayList<>();

            for (Integer partNumber : partNumbers) {
                // Build UploadPart request
                UploadPartRequest uploadPartRequest = UploadPartRequest.builder()
                        .bucket(awsProperties.getProperty("aws.bucketName"))
                        .key(key)
                        .uploadId(uploadId)
                        .partNumber(partNumber)
                        .build();

                // Presign for PUT (upload)
                UploadPartPresignRequest presignRequest = UploadPartPresignRequest.builder()
                        .signatureDuration(expiry)
                        .uploadPartRequest(uploadPartRequest)
                        .build();

                PresignedUploadPartRequest presignedRequest = presigner.presignUploadPart(presignRequest);

                urls.add(new Document()
                        .append("partNumber", partNumber)
                        .append("url", presignedRequest.url().toString())
                        .append("expiresAt", Instant.now().plus(expiry).toString())
                        .append("httpMethod", "PUT"));
            }

            return SUCCESS.withFields("Presigned URLs generated successfully",
                    new Document().append("urls", urls).append("totalUrls", urls.size()));

        } catch (Exception e) {
            LOGGER.error("Error generating presigned URLs", e);
            return FAILURE.withMessage(e.getMessage());
        }
    }


    /**
     * Generate presigned URLs for uploading parts
     * Client will use these URLs to upload parts directly to S3
     *
     * @param paramsDoc Document containing:
     *                  - key (required): S3 key from init response
     *                  - uploadId (required): Upload ID from init response
     *                  - partNumber (single part) OR partNumbers (batch)
     *                  - expiryMinutes (optional): URL expiry in minutes, default 60
     * @return CustomMethodResult with SUCCESS containing urls array with partNumber, url, expiresAt, httpMethod
     *         or FAILURE with error message
     */
    public CustomMethodResult generatePresignedUrls(Document paramsDoc) {
        try {
            // NEW: Force presigner recreation to avoid cached GET presigner
            synchronized (S3MultipartFileUtil.class) {
                if (presigner != null) {
                    presigner.close();
                    presigner = null;
                    LOGGER.info("Presigner reset for fresh PUT initialization");
                }
            }

            initializePresigner(); // Initialize fresh presigner for PUT operations


            LOGGER.info("paramsDoc keys: {}", paramsDoc.keySet());
            LOGGER.info("paramsDoc JSON: {}", paramsDoc.toJson());

            // Extract required fields
            String key = paramsDoc.getString("key");
            String uploadId = paramsDoc.getString("uploadId");
            Integer expiryMinutes = paramsDoc.getInteger("expiryMinutes", 60);

            LOGGER.info("Extracted - key: {}, uploadId: {}, expiryMinutes: {}", key, uploadId, expiryMinutes);

            // Validate required fields
            if (key == null || key.trim().isEmpty()) {
                LOGGER.error("key is required but not provided");
                return FAILURE.withMessage("key is required");
            }
            if (uploadId == null || uploadId.trim().isEmpty()) {
                LOGGER.error("uploadId is required but not provided");
                return FAILURE.withMessage("uploadId is required");
            }
            if (expiryMinutes < 1 || expiryMinutes > 10080) {
                LOGGER.error("Invalid expiryMinutes: {}. Must be between 1 and 10080", expiryMinutes);
                return FAILURE.withMessage("expiryMinutes must be between 1 and 10080 (7 days)");
            }

            // Extract part numbers - try single part first, then array
            List<Integer> partNumbers = new ArrayList<>();

            // Try single part number
            Integer singlePart = paramsDoc.getInteger("partNumber");
            if (singlePart != null) {
                partNumbers.add(singlePart);
                LOGGER.info("Found SINGLE partNumber: {}", singlePart);
            }

            // Try array of part numbers
            if (partNumbers.isEmpty()) {
                Object partsObj = paramsDoc.get("partNumbers");
                LOGGER.info("partNumbers object: {} (type: {})",
                        partsObj,
                        partsObj != null ? partsObj.getClass().getName() : "null");

                if (partsObj instanceof List) {
                    List<?> partsList = (List<?>) partsObj;
                    LOGGER.info("partNumbers is List with {} elements", partsList.size());
                    for (Object item : partsList) {
                        if (item instanceof Number) {
                            int partNum = ((Number) item).intValue();
                            partNumbers.add(partNum);
                        } else if (item instanceof String) {
                            try {
                                int partNum = Integer.parseInt((String) item);
                                partNumbers.add(partNum);
                            } catch (NumberFormatException e) {
                                LOGGER.warn("Could not parse string to int: {}", item);
                            }
                        }
                    }
                }
            }

            LOGGER.info("FINAL extracted partNumbers: {} (total: {})", partNumbers, partNumbers.size());

            // Validate we have part numbers
            if (partNumbers.isEmpty()) {
                LOGGER.error("No part numbers found. Available keys: {}", paramsDoc.keySet());
                return FAILURE.withMessage("Either partNumber or partNumbers array is required");
            }

            // Validate each part number
            for (Integer partNumber : partNumbers) {
                if (partNumber == null || partNumber < 1 || partNumber > 10000) {
                    LOGGER.error("Invalid part number: {}. Must be between 1 and 10000", partNumber);
                    return FAILURE.withMessage(
                            String.format("Part number %d is invalid. Must be between 1 and 10000", partNumber)
                    );
                }
            }

            // Prepare for URL generation
            Duration expiry = Duration.ofMinutes(expiryMinutes);
            Instant expiresAt = Instant.now().plus(expiry);
            List<Document> urls = new ArrayList<>();

            LOGGER.info("Starting to generate {} presigned URLs with {} minutes expiry",
                    partNumbers.size(), expiryMinutes);

            // Generate presigned URL for each part
            for (Integer partNumber : partNumbers) {
                LOGGER.info("Generating presigned URL for part {}/{}", partNumber, partNumbers.size());

                // Build UploadPartRequest for PUT operation
                UploadPartRequest uploadPartRequest = UploadPartRequest.builder()
                        .bucket(awsProperties.getProperty("aws.bucketName"))
                        .key(key)
                        .uploadId(uploadId)
                        .partNumber(partNumber)
                        .build();

                // Build UploadPartPresignRequest for PUT operation
                UploadPartPresignRequest presignRequest = UploadPartPresignRequest.builder()
                        .signatureDuration(expiry)
                        .uploadPartRequest(uploadPartRequest)
                        .build();

                // Generate presigned PUT URL
                PresignedUploadPartRequest presignedRequest = presigner.presignUploadPart(presignRequest);

                // Extract URL and HTTP method
                String url = presignedRequest.url().toString();
                String httpMethod = presignedRequest.httpRequest().method().name();

                // NEW: Log HTTP method to verify it's PUT
                LOGGER.info("Part {}: HTTP Method = {}", partNumber, httpMethod);
                LOGGER.info("Part {}: URL = {}...", partNumber, url.substring(0, Math.min(120, url.length())));

                // NEW: Critical check - fail if not PUT
                if (!"PUT".equals(httpMethod)) {
                    LOGGER.error(" CRITICAL ERROR: Generated {} URL instead of PUT for part {}", httpMethod, partNumber);
                    LOGGER.error("URL was: {}", url);
                    return FAILURE.withMessage(
                            String.format("Internal error: Generated %s URL instead of PUT for part %d", httpMethod, partNumber)
                    );
                }

                // Add to results
                urls.add(new Document()
                        .append("partNumber", partNumber)
                        .append("url", url)
                        .append("expiresAt", expiresAt.toString())
                        .append("httpMethod", httpMethod)); // Use actual method from response
            }

            LOGGER.info("Successfully generated {} PUT presigned URLs", urls.size());
            LOGGER.info("=== generatePresignedUrls END ===");

            // Build result document
            Document resultDoc = new Document()
                    .append("urls", urls)
                    .append("totalUrls", urls.size())
                    .append("expiresAt", expiresAt.toString());

            return SUCCESS.withFields("Presigned URLs generated successfully", resultDoc);

        } catch (Exception e) {
            LOGGER.error("Error generating presigned URLs", e);
            e.printStackTrace();
            return FAILURE.withMessage("Error generating presigned URLs: " + e.getMessage());
        }
    }

    /**
     * List already uploaded parts (useful for resume functionality)
     *
     * @param paramsDoc Document containing:
     *                  - key_Upload_Text (required): S3 key
     *                  - uploadId_Upload_Text (required): Upload ID
     *                  - maxParts_Upload_Int (optional): Max parts to return, default 1000
     *                  - partNumberMarker_Upload_Int (optional): For pagination
     * @return CustomMethodResult with SUCCESS containing parts array with partNumber, etag, size, lastModified
     *         or FAILURE with error message
     */
    public CustomMethodResult listParts(Document paramsDoc) {
        try {
            initializeS3Client();

            String key = paramsDoc.getString("key");
            String uploadId = paramsDoc.getString("uploadId");
            Integer maxParts = paramsDoc.getInteger("maxParts", 1000);
            Integer partNumberMarker = paramsDoc.getInteger("partNumberMarker");

            if (key == null || key.trim().isEmpty()) {
                LOGGER.error("key_Upload_Text is required but not provided");
                return FAILURE.withMessage("key is required");
            }
            if (uploadId == null || uploadId.trim().isEmpty()) {
                LOGGER.error("uploadId_Upload_Text is required but not provided");
                return FAILURE.withMessage("uploadId is required");
            }
            if (maxParts < 1 || maxParts > 1000) {
                LOGGER.error("Invalid maxParts: {}. Must be between 1 and 1000", maxParts);
                return FAILURE.withMessage("maxParts must be between 1 and 1000");
            }

            LOGGER.info("Listing parts for uploadId: {}, maxParts: {}, marker: {}", uploadId, maxParts, partNumberMarker);

            ListPartsRequest.Builder requestBuilder = ListPartsRequest.builder()
                    .bucket(awsProperties.getProperty("aws.bucketName"))
                    .key(key)
                    .uploadId(uploadId)
                    .maxParts(maxParts);

            if (partNumberMarker != null) {
                requestBuilder.partNumberMarker(partNumberMarker);
            }

            ListPartsResponse response = s3Client.listParts(requestBuilder.build());

            List<Document> partsArray = new ArrayList<>();
            long totalSize = 0;

            for (Part part : response.parts()) {
                Document partDoc = new Document()
                        .append("partNumber", part.partNumber())
                        .append("etag", part.eTag())
                        .append("size", part.size())
                        .append("lastModified", part.lastModified() != null ? part.lastModified().toString() : null);

                partsArray.add(partDoc);
                totalSize += part.size();
            }

            Document result = new Document()
                    .append("parts", partsArray)
                    .append("totalParts", partsArray.size())
                    .append("totalSize", totalSize)
                    .append("isTruncated", response.isTruncated())
                    .append("key", key)
                    .append("uploadId", uploadId)
                    .append("bucket", awsProperties.getProperty("aws.bucketName"));

            if (response.isTruncated()) {
                result.append("nextPartNumberMarker", response.nextPartNumberMarker());
            }

            if (response.initiator() != null) {
                result.append("initiator", new Document()
                        .append("id", response.initiator().id())
                        .append("displayName", response.initiator().displayName()));
            }

            result.append("storageClass", response.storageClassAsString());

            LOGGER.info("Successfully listed {} parts, totalSize: {} bytes, isTruncated: {}",
                    partsArray.size(), totalSize, response.isTruncated());

            return SUCCESS.withFields("Parts listed successfully", result);

        } catch (NoSuchUploadException e) {
            LOGGER.error("Upload does not exist - uploadId: {}", paramsDoc.getString("uploadId"), e);
            return FAILURE.withMessage("Upload does not exist");
        } catch (IOException e) {
            LOGGER.error("IO error while initializing S3 client", e);
            return FAILURE.withMessage("Failed to initialize S3 client: " + e.getMessage());
        } catch (S3Exception e) {
            LOGGER.error("S3 error listing parts: {}", e.awsErrorDetails().errorMessage(), e);
            return FAILURE.withMessage("S3 error: " + e.awsErrorDetails().errorMessage());
        } catch (SdkException e) {
            LOGGER.error("AWS SDK error listing parts", e);
            return FAILURE.withMessage("AWS SDK error: " + e.getMessage());
        } catch (Exception e) {
            LOGGER.error("Unexpected error listing parts", e);
            return FAILURE.withMessage("Unexpected error: " + e.getMessage());
        }
    }

    /**
     * Complete multipart upload and finalize the object in S3
     *
     * @param paramsDoc Document containing:
     *                  - key_Upload_Text (required): S3 key
     *                  - uploadId_Upload_Text (required): Upload ID
     *                  - parts_Upload_DocumentArray (required): Array of {partNumber_Upload_Int, etag_Upload_Text}
     * @return CustomMethodResult with SUCCESS containing location, bucket, key, etag, size, contentType, status
     *         or FAILURE with error message
     */
    public CustomMethodResult completeMultipartUpload(Document paramsDoc) {
        try {
            initializeS3Client();

            String key = paramsDoc.getString("key");
            String uploadId = paramsDoc.getString("uploadId");
            List<Document> partsDocs = paramsDoc.getList("parts", Document.class);

            if (key == null || key.trim().isEmpty()) {
                LOGGER.error("key_Upload_Text is required but not provided");
                return FAILURE.withMessage("key is required");
            }
            if (uploadId == null || uploadId.trim().isEmpty()) {
                LOGGER.error("uploadId_Upload_Text is required but not provided");
                return FAILURE.withMessage("uploadId is required");
            }
            if (partsDocs == null || partsDocs.isEmpty()) {
                LOGGER.error("parts_Upload_DocumentArray is required and cannot be empty");
                return FAILURE.withMessage("parts array is required and cannot be empty");
            }
            if (partsDocs.size() > 10000) {
                LOGGER.error("Too many parts: {}. Maximum 10000 allowed", partsDocs.size());
                return FAILURE.withMessage("Maximum 10000 parts allowed, received: " + partsDocs.size());
            }

            LOGGER.info("Completing multipart upload - uploadId: {}, totalParts: {}", uploadId, partsDocs.size());

            // Sort and build completed parts
            List<CompletedPart> completedParts = partsDocs.stream()
                    .sorted(Comparator.comparingInt(d -> d.getInteger("partNumber")))
                    .map(partDoc -> {
                        Integer partNumber = partDoc.getInteger("partNumber");
                        String etag = partDoc.getString("etag");

                        if (partNumber == null || partNumber < 1 || partNumber > 10000) {
                            throw new IllegalArgumentException("Invalid part number: " + partNumber);
                        }
                        if (etag == null || etag.trim().isEmpty()) {
                            throw new IllegalArgumentException("Missing etag for part " + partNumber);
                        }

                        return CompletedPart.builder()
                                .partNumber(partNumber)
                                .eTag(etag)
                                .build();
                    })
                    .collect(Collectors.toList());

            // Validate first part is part 1
            if (completedParts.get(0).partNumber() != 1) {
                LOGGER.error("First part must be part number 1, got: {}", completedParts.get(0).partNumber());
                return FAILURE.withMessage("First part must be part number 1");
            }

            CompletedMultipartUpload completedMultipartUpload = CompletedMultipartUpload.builder()
                    .parts(completedParts)
                    .build();

            CompleteMultipartUploadRequest request = CompleteMultipartUploadRequest.builder()
                    .bucket(awsProperties.getProperty("aws.bucketName"))
                    .key(key)
                    .uploadId(uploadId)
                    .multipartUpload(completedMultipartUpload)
                    .build();

            CompleteMultipartUploadResponse response = s3Client.completeMultipartUpload(request);

            Document result = new Document()
                    .append("location", response.location())
                    .append("bucket", response.bucket())
                    .append("key", response.key())
                    .append("etag", response.eTag())
                    .append("uploadId", uploadId)
                    .append("totalParts", completedParts.size())
                    .append("status", "completed");

            // Get object metadata
            try {
                HeadObjectRequest headRequest = HeadObjectRequest.builder()
                        .bucket(awsProperties.getProperty("aws.bucketName"))
                        .key(key)
                        .build();
                HeadObjectResponse headResponse = s3Client.headObject(headRequest);
                result.append("size", headResponse.contentLength());
                result.append("contentType", headResponse.contentType());
                result.append("lastModified", headResponse.lastModified().toString());
            } catch (Exception e) {
                LOGGER.warn("Could not retrieve object metadata: {}", e.getMessage());
            }

            LOGGER.info("Successfully completed multipart upload - location: {}, etag: {}, size: {} bytes",
                    response.location(), response.eTag(), result.get("size"));

            return SUCCESS.withFields("Multipart upload completed successfully", result);

        } catch (IllegalArgumentException e) {
            LOGGER.error("Validation error completing multipart upload", e);
            return FAILURE.withMessage(e.getMessage());
        } catch (IOException e) {
            LOGGER.error("IO error while initializing S3 client", e);
            return FAILURE.withMessage("Failed to initialize S3 client: " + e.getMessage());
        } catch (S3Exception e) {
            LOGGER.error("S3 error completing multipart upload: {}", e.awsErrorDetails().errorMessage(), e);
            if (e.statusCode() == 400) {
                return FAILURE.withMessage("Invalid multipart upload: " + e.awsErrorDetails().errorMessage());
            }
            return FAILURE.withMessage("S3 error: " + e.awsErrorDetails().errorMessage());
        } catch (SdkException e) {
            LOGGER.error("AWS SDK error completing multipart upload", e);
            return FAILURE.withMessage("AWS SDK error: " + e.getMessage());
        } catch (Exception e) {
            LOGGER.error("Unexpected error completing multipart upload", e);
            return FAILURE.withMessage("Unexpected error: " + e.getMessage());
        }
    }

    public CustomMethodResult completeMultipartUploadEfficient(Document paramsDoc) {
        try {
            initializeS3Client();

            String key = paramsDoc.getString("key");
            String uploadId = paramsDoc.getString("uploadId");
            List<Document> partsDocs = paramsDoc.getList("parts", Document.class);

            // Validation
            if (key == null || key.trim().isEmpty()) {
                LOGGER.error("key is required");
                return FAILURE.withMessage("key is required");
            }
            if (uploadId == null || uploadId.trim().isEmpty()) {
                LOGGER.error("uploadId is required");
                return FAILURE.withMessage("uploadId is required");
            }

            LOGGER.info("=== SMART COMPLETE MULTIPART UPLOAD ===");
            LOGGER.info("Key: {}", key);
            LOGGER.info("UploadId: {}", uploadId);
            LOGGER.info("Parts provided: {}", partsDocs != null ? partsDocs.size() : 0);

            List<CompletedPart> completedParts;

            // ✅ NEW: Auto-fetch parts from S3 if not provided
            if (partsDocs == null || partsDocs.isEmpty()) {
                LOGGER.info("No parts provided in request. Auto-fetching from S3...");
                completedParts = fetchAllPartsFromS3(key, uploadId);
                LOGGER.info("✅ Auto-fetched {} parts from S3", completedParts.size());
            } else {
                // Use provided parts (for backward compatibility)
                LOGGER.info("Using {} parts from request body", partsDocs.size());
                completedParts = partsDocs.stream()
                        .sorted(Comparator.comparingInt(d -> d.getInteger("partNumber")))
                        .map(partDoc -> {
                            Integer partNumber = partDoc.getInteger("partNumber");
                            String etag = partDoc.getString("etag");

                            if (partNumber == null || partNumber < 1 || partNumber > 10000) {
                                throw new IllegalArgumentException("Invalid part number: " + partNumber);
                            }
                            if (etag == null || etag.trim().isEmpty()) {
                                throw new IllegalArgumentException("Missing etag for part " + partNumber);
                            }

                            return CompletedPart.builder()
                                    .partNumber(partNumber)
                                    .eTag(etag)
                                    .build();
                        })
                        .collect(Collectors.toList());
            }

            // Validate we have parts
            if (completedParts.isEmpty()) {
                LOGGER.error("No parts found to complete upload");
                return FAILURE.withMessage("No parts uploaded. Upload at least one part before completing.");
            }

            // Validate first part is part 1
            if (completedParts.get(0).partNumber() != 1) {
                LOGGER.error("First part must be part number 1, got: {}", completedParts.get(0).partNumber());
                return FAILURE.withMessage("First part must be part number 1");
            }

            LOGGER.info("Completing upload with {} parts...", completedParts.size());

            // Complete the upload
            CompletedMultipartUpload completedMultipartUpload = CompletedMultipartUpload.builder()
                    .parts(completedParts)
                    .build();

            CompleteMultipartUploadRequest request = CompleteMultipartUploadRequest.builder()
                    .bucket(awsProperties.getProperty("aws.bucketName"))
                    .key(key)
                    .uploadId(uploadId)
                    .multipartUpload(completedMultipartUpload)
                    .build();

            CompleteMultipartUploadResponse response = s3Client.completeMultipartUpload(request);

            Document result = new Document()
                    .append("location", response.location())
                    .append("bucket", response.bucket())
                    .append("key", response.key())
                    .append("etag", response.eTag())
                    .append("uploadId", uploadId)
                    .append("totalParts", completedParts.size())
                    .append("status", "completed");

            // Get object metadata
            try {
                HeadObjectRequest headRequest = HeadObjectRequest.builder()
                        .bucket(awsProperties.getProperty("aws.bucketName"))
                        .key(key)
                        .build();
                HeadObjectResponse headResponse = s3Client.headObject(headRequest);
                result.append("size", headResponse.contentLength());
                result.append("contentType", headResponse.contentType());
                result.append("lastModified", headResponse.lastModified().toString());
            } catch (Exception e) {
                LOGGER.warn("Could not retrieve object metadata: {}", e.getMessage());
            }

            LOGGER.info("✅ Successfully completed multipart upload");
            LOGGER.info("   Location: {}", response.location());
            LOGGER.info("   ETag: {}", response.eTag());
            LOGGER.info("   Size: {} bytes", result.getLong("size"));
            LOGGER.info("   Parts: {}", completedParts.size());

            return SUCCESS.withFields("Multipart upload completed successfully", result);

        } catch (IllegalArgumentException e) {
            LOGGER.error("Validation error", e);
            return FAILURE.withMessage(e.getMessage());
        } catch (NoSuchUploadException e) {
            LOGGER.error("Upload does not exist", e);
            return FAILURE.withMessage("Upload does not exist or was already completed/aborted");
        } catch (IOException e) {
            LOGGER.error("IO error initializing S3 client", e);
            return FAILURE.withMessage("Failed to initialize S3 client: " + e.getMessage());
        } catch (S3Exception e) {
            LOGGER.error("S3 error: {}", e.awsErrorDetails().errorMessage(), e);
            return FAILURE.withMessage("S3 error: " + e.awsErrorDetails().errorMessage());
        } catch (Exception e) {
            LOGGER.error("Unexpected error", e);
            return FAILURE.withMessage("Unexpected error: " + e.getMessage());
        }
    }

    /**
     * Fetch all uploaded parts from S3 using List Parts API
     * Handles pagination automatically (S3 returns max 1000 parts per request)
     *
     * @param key S3 object key
     * @param uploadId Multipart upload ID
     * @return List of CompletedPart objects sorted by part number
     */
    private List<CompletedPart> fetchAllPartsFromS3(String key, String uploadId) throws S3Exception {
        List<CompletedPart> allParts = new ArrayList<>();
        Integer partNumberMarker = null;
        boolean isTruncated = true;

        LOGGER.info("Fetching all parts from S3 for uploadId: {}", uploadId);

        // Paginate through all parts (S3 returns max 1000 per request)
        while (isTruncated) {
            ListPartsRequest.Builder requestBuilder = ListPartsRequest.builder()
                    .bucket(awsProperties.getProperty("aws.bucketName"))
                    .key(key)
                    .uploadId(uploadId)
                    .maxParts(1000); // S3 maximum

            if (partNumberMarker != null) {
                requestBuilder.partNumberMarker(partNumberMarker);
            }

            ListPartsResponse response = s3Client.listParts(requestBuilder.build());

            // Convert S3 Parts to CompletedParts
            for (Part part : response.parts()) {
                CompletedPart completedPart = CompletedPart.builder()
                        .partNumber(part.partNumber())
                        .eTag(part.eTag())
                        .build();
                allParts.add(completedPart);
            }

            isTruncated = response.isTruncated();
            partNumberMarker = response.nextPartNumberMarker();

            LOGGER.debug("Fetched {} parts (batch), total so far: {}, more: {}",
                    response.parts().size(), allParts.size(), isTruncated);
        }

        // Sort by part number (important!)
        allParts.sort(Comparator.comparingInt(CompletedPart::partNumber));

        LOGGER.info("✅ Total parts fetched from S3: {}", allParts.size());

        if (allParts.isEmpty()) {
            throw new IllegalStateException("No parts found in S3 for this upload");
        }

        // Log first and last parts for verification
        LOGGER.info("   First part: {} (ETag: {})", allParts.get(0).partNumber(), allParts.get(0).eTag());
        LOGGER.info("   Last part: {} (ETag: {})",
                allParts.get(allParts.size() - 1).partNumber(),
                allParts.get(allParts.size() - 1).eTag());

        return allParts;
    }

    /**
     * Abort multipart upload and clean up all uploaded parts
     *
     * @param paramsDoc Document containing:
     *                  - key_Upload_Text (required): S3 key
     *                  - uploadId_Upload_Text (required): Upload ID
     * @return CustomMethodResult with SUCCESS containing status, message, key, uploadId
     *         or FAILURE with error message
     */
    public CustomMethodResult abortMultipartUpload(Document paramsDoc) {
        try {
            initializeS3Client();

            String key = paramsDoc.getString("key");
            String uploadId = paramsDoc.getString("uploadId");

            if (key == null || key.trim().isEmpty()) {
                LOGGER.error("key is required but not provided");
                return FAILURE.withMessage("key is required");
            }
            if (uploadId == null || uploadId.trim().isEmpty()) {
                LOGGER.error("uploadId is required but not provided");
                return FAILURE.withMessage("uploadId is required");
            }

            LOGGER.info("Aborting multipart upload - uploadId: {}, key: {}", uploadId, key);

            AbortMultipartUploadRequest request = AbortMultipartUploadRequest.builder()
                    .bucket(awsProperties.getProperty("aws.bucketName"))
                    .key(key)
                    .uploadId(uploadId)
                    .build();

            s3Client.abortMultipartUpload(request);

            LOGGER.info("Successfully aborted multipart upload - uploadId: {}, key: {}", uploadId, key);

            Document result = new Document()
                    .append("status", "aborted")
                    .append("message", "Multipart upload successfully aborted and cleaned up")
                    .append("key", key)
                    .append("uploadId", uploadId)
                    .append("bucket", awsProperties.getProperty("aws.bucketName"));

            return SUCCESS.withFields("Multipart upload aborted successfully", result);

        } catch (NoSuchUploadException e) {
            LOGGER.warn("Upload not found (may be already completed/aborted) - uploadId: {}",
                    paramsDoc.getString("uploadId"));
            return FAILURE.withMessage("Upload does not exist (may have been completed or already aborted)");
        } catch (IOException e) {
            LOGGER.error("IO error while initializing S3 client", e);
            return FAILURE.withMessage("Failed to initialize S3 client: " + e.getMessage());
        } catch (S3Exception e) {
            LOGGER.error("S3 error aborting upload: {}", e.awsErrorDetails().errorMessage(), e);
            return FAILURE.withMessage("S3 error: " + e.awsErrorDetails().errorMessage());
        } catch (SdkException e) {
            LOGGER.error("AWS SDK error aborting upload", e);
            return FAILURE.withMessage("AWS SDK error: " + e.getMessage());
        } catch (Exception e) {
            LOGGER.error("Unexpected error aborting upload", e);
            return FAILURE.withMessage("Unexpected error: " + e.getMessage());
        }
    }


    // ========== Helper Methods ==========

    /**
     * Calculate optimal part size based on file size
     * Ensures total parts stay under S3's 10,000 part limit
     */
    private long calculatePartSize(Long fileSize) {
        if (fileSize == null || fileSize <= 0) {
            return DEFAULT_PART_SIZE;
        }
        if (fileSize > 500L * 1024L * 1024L * 1024L) {
            return 500L * 1024L * 1024L;
        }
        if (fileSize > 250L * 1024L * 1024L * 1024L) {
            long calculatedSize = fileSize / (MAX_PARTS - 100);
            calculatedSize = ((calculatedSize / (10L * 1024L * 1024L)) + 1) * (10L * 1024L * 1024L);
            return Math.max(MIN_PART_SIZE, Math.min(calculatedSize, MAX_PART_SIZE));
        }
        if (fileSize > 5L * 1024L * 1024L * 1024L) {
            return 100L * 1024L * 1024L;
        }
        return 250L * 1024L * 1024L;
    }

    /**
     * Calculate total number of parts needed
     */
    private int calculateTotalParts(long fileSize, long partSize) {
        return (int) Math.ceil((double) fileSize / partSize);
    }

    /**
     * Sanitize filename to be S3-safe
     */
    private String sanitizeFileName(String fileName) {
        String safe = fileName.replaceAll("[^a-zA-Z0-9._-]", "_");
        if (safe.length() > 200) {
            int lastDot = safe.lastIndexOf('.');
            if (lastDot > 0) {
                String ext = safe.substring(lastDot);
                safe = safe.substring(0, 200 - ext.length()) + ext;
            } else {
                safe = safe.substring(0, 200);
            }
        }
        return safe;
    }
}