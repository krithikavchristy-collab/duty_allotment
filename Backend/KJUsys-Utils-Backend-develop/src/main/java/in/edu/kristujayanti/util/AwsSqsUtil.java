package in.edu.kristujayanti.util;

import io.vertx.core.Future;
import io.vertx.core.Vertx;
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.sqs.SqsAsyncClient;
import software.amazon.awssdk.services.sqs.SqsClient;
import software.amazon.awssdk.services.sqs.model.MessageAttributeValue;
import software.amazon.awssdk.services.sqs.model.SendMessageRequest;
import software.amazon.awssdk.services.sqs.model.SendMessageResponse;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

/**
 * Minimal AWS SQS utility for sending messages.
 * Loads credentials and region from aws_config.properties.
 */
public class AwsSqsUtil {

    private static final String CONFIG_FILE = "aws_config.properties";
    private static final String DEFAULT_REGION = "ap-south-1";

    private final Properties awsProperties = loadAwsProperties();
    private final AtomicReference<SqsClient> sqsClientRef = new AtomicReference<>();
    private final AtomicReference<SqsAsyncClient> sqsAsyncClientRef = new AtomicReference<>();

    private Properties loadAwsProperties() {
        Properties props = new Properties();
        try (InputStream in = getClass().getClassLoader().getResourceAsStream(CONFIG_FILE)) {
            if (in != null) {
                props.load(in);
            }
        } catch (IOException ignored) {
            // ignored
        }
        return props;
    }

    private AwsBasicCredentials creds() {
        String key = Objects.requireNonNullElse(awsProperties.getProperty("aws.accessKeyId"), "");
        String secret = Objects.requireNonNullElse(awsProperties.getProperty("aws.secretKey"), "");
        return AwsBasicCredentials.create(key, secret);
    }

    private Region region() {
        return Region.of(Objects.requireNonNullElse(awsProperties.getProperty("aws.region"), DEFAULT_REGION));
    }

    private void initSync() {
        if (sqsClientRef.get() == null) {
            SqsClient client = SqsClient.builder()
                    .credentialsProvider(StaticCredentialsProvider.create(creds()))
                    .region(region())
                    .applyMutation(b -> {
                        String endpoint = awsProperties.getProperty("aws.sqs.endpointOverride");
                        if (endpoint != null && !endpoint.isBlank()) {
                            b.endpointOverride(URI.create(endpoint));
                        }
                    })
                    .build();
            sqsClientRef.compareAndSet(null, client);
        }
    }

    private void initAsync() {
        if (sqsAsyncClientRef.get() == null) {
            SqsAsyncClient client = SqsAsyncClient.builder()
                    .credentialsProvider(StaticCredentialsProvider.create(creds()))
                    .region(region())
                    .applyMutation(b -> {
                        String endpoint = awsProperties.getProperty("aws.sqs.endpointOverride");
                        if (endpoint != null && !endpoint.isBlank()) {
                            b.endpointOverride(URI.create(endpoint));
                        }
                    })
                    .build();
            sqsAsyncClientRef.compareAndSet(null, client);
        }
    }

    /**
     * Send a message synchronously (executed on a Vert.x worker thread).
     */
    public Future<String> sendMessage(Vertx vertx, String queueUrl, String body, Map<String, String> attributes) {
        initSync();
        return vertx.executeBlocking(() -> {
            SendMessageRequest request = buildSendMessageRequest(queueUrl, body, attributes);
            SendMessageResponse resp = sqsClientRef.get().sendMessage(request);
            return resp.messageId();
        }, true);
    }

    /**
     * Send a message asynchronously using SqsAsyncClient.
     */
    public Future<String> sendMessageAsync(String queueUrl, String body, Map<String, String> attributes) {
        initAsync();
        SendMessageRequest request = buildSendMessageRequest(queueUrl, body, attributes);
        CompletableFuture<SendMessageResponse> cf = sqsAsyncClientRef.get().sendMessage(request);
        io.vertx.core.Promise<String> promise = io.vertx.core.Promise.promise();
        cf.whenComplete((resp, err) -> {
            if (err != null) {
                promise.fail(err);
            } else {
                promise.complete(resp.messageId());
            }
        });
        return promise.future();
    }

    private static SendMessageRequest buildSendMessageRequest(String queueUrl, String body, Map<String, String> attributes) {
        SendMessageRequest.Builder builder = SendMessageRequest.builder()
                .queueUrl(queueUrl)
                .messageBody(body);
        if (attributes != null && !attributes.isEmpty()) {
            builder.messageAttributes(
                    attributes.entrySet().stream().collect(Collectors.toMap(
                            Map.Entry::getKey,
                            e -> MessageAttributeValue.builder()
                                    .dataType("String")
                                    .stringValue(e.getValue())
                                    .build()
                    ))
            );
        }
        return builder.build();
    }
}