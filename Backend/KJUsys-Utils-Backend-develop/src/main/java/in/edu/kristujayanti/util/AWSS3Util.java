package in.edu.kristujayanti.util;

import io.vertx.core.Future;
import io.vertx.core.Promise;
import org.apache.tika.Tika;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.core.async.AsyncRequestBody;
import software.amazon.awssdk.core.async.AsyncResponseTransformer;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3AsyncClient;
import software.amazon.awssdk.services.s3.model.*;
import software.amazon.awssdk.services.s3.presigner.S3Presigner;
import software.amazon.awssdk.services.s3.presigner.model.GetObjectPresignRequest;
import software.amazon.awssdk.services.s3.presigner.model.PresignedGetObjectRequest;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Map;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AWSS3Util {

    private static final Region REGION = Region.AP_SOUTH_1; // Change this to your preferred region
    private static S3AsyncClient s3Client;

    private static final Logger LOGGER = LoggerFactory.getLogger(AWSS3Util.class);

    private static final Tika TIKA_INSTANCE = new Tika();

    private final Properties awsProperties;

    private static volatile S3Presigner presigner;

    private static final Map<String, String> EXTENSION_TO_MIME = Map.of(
            "jpg", "image/jpeg",
            "jpeg", "image/jpeg",
            "png", "image/png",
            "pdf", "application/pdf"
    );

    public AWSS3Util() {
        this.awsProperties = loadAwsProperties();
    }

    private Properties loadAwsProperties() {
        Properties properties = new Properties();
        try (InputStream input = getClass().getClassLoader().getResourceAsStream("aws_config.properties")) {
            if (input == null) {
                LOGGER.error("Unable to find aws_config.properties");
                return properties;
            }
            properties.load(input);
        } catch (IOException ex) {
            LOGGER.error("Error loading aws properties", ex);
        }
        return properties;
    }

    public void initializeAWSS3() throws IOException {
        if (s3Client == null) {
            AwsBasicCredentials awsCreds = AwsBasicCredentials.create(
                    this.awsProperties.getProperty("aws.accessKeyId"),
                    this.awsProperties.getProperty("aws.secretKey")
            );
            s3Client = S3AsyncClient.builder()
                    .region(REGION)
                    .credentialsProvider(StaticCredentialsProvider.create(awsCreds))
                    .build();
        }
    }

    public Future<String> uploadFileToS3WithBucketName(File file, String keyWithoutExtension, String bucketName) throws IOException {
        Promise<String> promise = Promise.promise();
        this.initializeAWSS3();

        String fileExtension = this.getFileExtension(file.getName());
        String key = keyWithoutExtension + (fileExtension.isEmpty() ? "" : "." + fileExtension);

        String awsBucketName = bucketName !=null ? bucketName : this.awsProperties.getProperty("aws.bucketName");


        PutObjectRequest request = PutObjectRequest.builder()
                    .bucket(awsBucketName)
                    .key(key)
                    .contentType(this.determineContentType(file))
                    .build();


        s3Client.putObject(request, AsyncRequestBody.fromFile(file))
                .thenApply(response -> {
                    String region = REGION.toString();
                    String s3Url = "https://" + awsBucketName + ".s3." + region + ".amazonaws.com/" + key;
                    promise.complete(s3Url);
                    return s3Url;
                })
                .exceptionally(ex -> {
                    LOGGER.error("Error uploading file to S3: {}", ex.getMessage(), ex);
                    promise.fail("Error uploading file to S3: " + ex.getMessage());
                    return null;
                });

        return promise.future();
    }

    public Future<String> uploadFileToS3(File file, String keyWithoutExtension) throws IOException {
        return uploadFileToS3WithBucketName ( file, keyWithoutExtension, null);
    }

    public Future<String> uploadFileToS3(byte[] buffer, String keyWithoutExtension, String extension, String contentType) throws IOException {
        Promise<String> promise = Promise.promise();
        this.initializeAWSS3();

        String key = keyWithoutExtension + (extension == null || extension.isEmpty() ? "" : "." + extension);

        PutObjectRequest request = PutObjectRequest.builder()
                .bucket(this.awsProperties.getProperty("aws.bucketName"))
                .key(key)
                .contentType(contentType)
                .build();

        s3Client.putObject(request, AsyncRequestBody.fromBytes(buffer))
                .thenApply(response -> {
                    String bucketName = this.awsProperties.getProperty("aws.bucketName");
                    String region = REGION.toString();
                    String s3Url = "https://" + bucketName + ".s3." + region + ".amazonaws.com/" + key;
                    promise.complete(s3Url);
                    return s3Url;
                })
                .exceptionally(ex -> {
                    LOGGER.error("Error uploading buffer to S3: {}", ex.getMessage(), ex);
                    promise.fail("Error uploading buffer to S3: " + ex.getMessage());
                    return null;
                });

        return promise.future();
    }

    public String determineContentType(File file) {
        String ext = getFileExtension(file.getName()).toLowerCase();
        if (EXTENSION_TO_MIME.containsKey(ext)) {
            return EXTENSION_TO_MIME.get(ext);
        }
        // Fallback to Tika for unknown types
        try {
            return TIKA_INSTANCE.detect(file);
        } catch (Exception e) {
            return "application/octet-stream";
        }
    }


    // Helper method to extract the file extension from the file name
    private String getFileExtension(String fileName) {
        int lastIndex = fileName.lastIndexOf('.');
        return (lastIndex == -1) ? "" : fileName.substring(lastIndex + 1);
    }

    public void deleteFileFromS3(String key) throws IOException {
        initializeAWSS3();
        try {
            DeleteObjectRequest request = DeleteObjectRequest.builder()
                    .bucket(this.awsProperties.getProperty("aws.bucketName"))
                    .key(key)
                    .build();
            s3Client.deleteObject(request);
        } catch (Exception e) {
            throw new IOException("Error deleting file from S3: " + e.getMessage(), e);
        }
    }

    public Future<ByteArrayInputStream> downloadFileFromS3(String key) throws IOException {
        Promise<ByteArrayInputStream> promise = Promise.promise();
        initializeAWSS3();

        if (!doesObjectExist(key)) {
            LOGGER.error("The specified file does not exist in S3 {}", key);
            promise.complete(new ByteArrayInputStream(new byte[0])); // Return empty stream
            return promise.future();
        }

        GetObjectRequest getObjectRequest = GetObjectRequest.builder()
                .bucket(this.awsProperties.getProperty("aws.bucketName"))
                .key(key)
                .build();

        s3Client.getObject(getObjectRequest, AsyncResponseTransformer.toBytes())
                .thenApply(responseBytes -> new ByteArrayInputStream(responseBytes.asByteArray()))
                .thenAccept(promise::complete)
                .exceptionally(ex -> {
                    LOGGER.error("Error downloading file from S3: {}", ex.getMessage());
                    promise.fail("Error downloading file from S3: " + ex.getMessage());
                    return null;
                });

        return promise.future();
    }

    public Future<ByteArrayInputStream> downloadFileFromS3Url(String url) throws IOException {
        Promise<ByteArrayInputStream> promise = Promise.promise();
        initializeAWSS3();

        // Parse the bucket name and key from the URL
        Pattern pattern = Pattern.compile("https?://([^.]+)\\.s3[.-][^/]+\\.amazonaws\\.com/(.+)");
        Matcher matcher = pattern.matcher(url);
        if (!matcher.matches()) {
            LOGGER.error("Invalid S3 URL: {}", url);
            promise.fail("Invalid S3 URL: " + url);
            return promise.future();
        }
        String bucketName = matcher.group(1);
        String key = matcher.group(2);

        // Optionally, you may want to check if the object exists here (if you have a doesObjectExist(bucket, key) method)
        // For now, let's assume doesObjectExist(key) only checks the default bucket, so we'll skip it or you can modify it.

        GetObjectRequest getObjectRequest = GetObjectRequest.builder()
                .bucket(bucketName)
                .key(key)
                .build();

        s3Client.getObject(getObjectRequest, AsyncResponseTransformer.toBytes())
                .thenApply(responseBytes -> new ByteArrayInputStream(responseBytes.asByteArray()))
                .thenAccept(promise::complete)
                .exceptionally(ex -> {
                    LOGGER.error("Error downloading file from S3: {}", ex.getMessage());
                    promise.fail("Error downloading file from S3: " + ex.getMessage());
                    return null;
                });

        return promise.future();
    }


    public boolean doesObjectExist(String key) throws IOException {
        String bucketName = this.awsProperties.getProperty("aws.bucketName");
        return doesObjectExist(bucketName, key);
    }

    /**
     * Checks if an object exists in the given bucket and key.
     */
    public boolean doesObjectExist(String bucketName, String key) throws IOException {
        initializeAWSS3();
        try {
            HeadObjectRequest headObjectRequest = HeadObjectRequest.builder()
                    .bucket(bucketName)
                    .key(key)
                    .build();

            s3Client.headObject(headObjectRequest);
            return true;
        } catch (NoSuchKeyException e) {
            return false;
        } catch (S3Exception e) {
            if (e.statusCode() == 404) {
                return false;
            }
            throw new IOException("Error while checking object existence in S3", e);
        }
    }


    //return the object
    public S3AsyncClient getS3Client() {
        if (s3Client == null) {
            try {
                initializeAWSS3();
            } catch (IOException e) {
                LOGGER.error("Failed to initialize S3 client", e);
                return null;
            }
        }
        return s3Client;
    }

    // Static presigner initializer (thread-safe)
    private void initializePresigner() {
        if (presigner == null) {
            synchronized (AWSS3Util.class) {
                if (presigner == null) {
                    AwsBasicCredentials awsCreds = AwsBasicCredentials.create(
                            this.awsProperties.getProperty("aws.accessKeyId"),
                            this.awsProperties.getProperty("aws.secretKey")
                    );
                    presigner = S3Presigner.builder()
                            .region(REGION)
                            .credentialsProvider(StaticCredentialsProvider.create(awsCreds))
                            .build();
                }
            }
        }
    }

    // Use this method to generate a presigned download URL
    public String getPresignedDownloadUrlIfExists(String key) throws IOException {
        initializeAWSS3();        // S3AsyncClient for existence check
        initializePresigner();    // S3Presigner for URL generation

        // Check if the object exists
        if (!doesObjectExist(key)) {
            LOGGER.error("The specified file does not exist in S3: {}", key);
            throw new IOException("Object does not exist in S3: " + key);
        }

        // Build GetObjectRequest
        GetObjectRequest getObjectRequest = GetObjectRequest.builder()
                .bucket(this.awsProperties.getProperty("aws.bucketName"))
                .key(key)
                .build();

        // Build the presign request (valid for 1 day)
        GetObjectPresignRequest presignRequest = GetObjectPresignRequest.builder()
                .signatureDuration(Duration.ofDays(1))
                .getObjectRequest(getObjectRequest)
                .build();

        // Generate the presigned URL
        PresignedGetObjectRequest presignedRequest = presigner.presignGetObject(presignRequest);

        return presignedRequest.url().toString();
    }


    public String getPresignedDownloadUrlIfExists(String key,String bucketName) throws IOException {
        initializeAWSS3();        // S3AsyncClient for existence check
        initializePresigner();    // S3Presigner for URL generation

        // Check if the object exists
        if (!doesObjectExist(key)) {
            LOGGER.error("The specified file does not exist in S3: {}", key);
            throw new IOException("Object does not exist in S3: " + key);
        }

        // Build GetObjectRequest
        GetObjectRequest getObjectRequest = GetObjectRequest.builder()
                .bucket(bucketName)
                .key(key)
                .build();

        // Build the presign request (valid for 1 day)
        GetObjectPresignRequest presignRequest = GetObjectPresignRequest.builder()
                .signatureDuration(Duration.ofDays(1))
                .getObjectRequest(getObjectRequest)
                .build();

        // Generate the presigned URL
        PresignedGetObjectRequest presignedRequest = presigner.presignGetObject(presignRequest);

        return presignedRequest.url().toString();
    }

    public String getPresignedDownloadUrlFromUrl(String s3Url) throws IOException {
        initializeAWSS3();       // S3AsyncClient for existence check
        initializePresigner();   // S3Presigner for URL generation

        try {
            // Extract bucket and key from URL
            String bucketName = getBucketNameFromUrl(s3Url);
            String key = getKeyFromUrl(s3Url);

            // Check if object exists
            if (!doesObjectExist(bucketName, key)) {
                LOGGER.error("The specified file does not exist in S3: {}/{}", bucketName, key);
                throw new IOException("Object does not exist in S3: " + key);
            }

            // Build GetObjectRequest
            GetObjectRequest getObjectRequest = GetObjectRequest.builder()
                    .bucket(bucketName)
                    .key(key)
                    .build();

            // Build Presign Request (valid for 1 day)
            GetObjectPresignRequest presignRequest = GetObjectPresignRequest.builder()
                    .signatureDuration(Duration.ofDays(1))
                    .getObjectRequest(getObjectRequest)
                    .build();

            // Generate the presigned URL
            PresignedGetObjectRequest presignedRequest = presigner.presignGetObject(presignRequest);

            return presignedRequest.url().toString();
        } catch (MalformedURLException e) {
            throw new IOException("Invalid S3 URL: " + s3Url, e);
        }
    }

    public String getBucketNameFromUrl(String s3Url) throws MalformedURLException {
        URL url = new URL(s3Url);
        String host = url.getHost();
        String path = url.getPath();

        if (host.contains(".s3.")) {
            return host.substring(0, host.indexOf(".s3."));
        }

        String[] parts = path.split("/");
        if (parts.length > 1) {
            return parts[1];
        }

        throw new IllegalArgumentException("Could not extract bucket name from URL: " + s3Url);
    }

    public String getKeyFromUrl(String s3Url) throws MalformedURLException {
        URL url = new URL(s3Url);
        String path = url.getPath();

        // remove leading "/" or "//"
        while (path.startsWith("/")) {
            path = path.substring(1);
        }
        return path;
    }

    /**
     * Generates a presigned download URL for a given S3 object URI (e.g. "s3://bucket/key").
     *
     * @param s3Uri The S3 object URI in "s3://bucket/key" format.
     * @return The presigned download URL as a string.
     * @throws IOException If the URI is invalid or the object does not exist.
     */
    public String getPresignedDownloadUrlFromS3Uri(String s3Uri) throws IOException {
        initializeAWSS3();
        initializePresigner();

        // Parse the S3 URI
        Pattern pattern = Pattern.compile("s3://([^/]+)/(.+)");
        Matcher matcher = pattern.matcher(s3Uri);
        if (!matcher.matches()) {
            throw new IOException("Invalid S3 URI format: " + s3Uri);
        }
        String bucket = matcher.group(1);
        String key = matcher.group(2);

        // Check if object exists
        if (!doesObjectExist(bucket, key)) {
            LOGGER.error("The specified file does not exist in S3: {}/{}", bucket, key);
            throw new IOException("Object does not exist in S3: " + key);
        }

        // Build Presign Request (valid for 1 hour)
        GetObjectPresignRequest presignRequest = GetObjectPresignRequest.builder()
                .signatureDuration(Duration.ofHours(1))
                .getObjectRequest(b -> b.bucket(bucket).key(key))
                .build();

        // Generate the presigned URL
        PresignedGetObjectRequest presignedRequest = presigner.presignGetObject(presignRequest);

        return presignedRequest.url().toString();
    }

}
