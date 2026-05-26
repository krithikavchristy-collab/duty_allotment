package in.edu.kristujayanti.util;

import io.vertx.core.Future;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.lambda.LambdaClient;
import software.amazon.awssdk.services.lambda.model.InvokeRequest;
import software.amazon.awssdk.services.lambda.model.InvokeResponse;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.atomic.AtomicReference;

/**
 * AWS Lambda Utility Helper for Vert.x applications.
 * Loads AWS credentials and region from aws_config.properties.
 * Provides async and fire-and-forget Lambda invoke methods.
 */
public class AwsLambdaUtil {

    private static final Logger LOGGER = LoggerFactory.getLogger(AwsLambdaUtil.class);

    private static final Region REGION = Region.AP_SOUTH_1; // Change if needed

    private final Properties awsProperties;
    private final AtomicReference<LambdaClient> lambdaClient = new AtomicReference<>();

    public AwsLambdaUtil() {
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

    /**
     * Thread-safe LambdaClient initializer using AtomicReference.
     * Ensures that only one instance of LambdaClient is created.
     */
    private void initializeLambdaClient() {
        if (lambdaClient.get() == null) {
            AwsBasicCredentials awsCreds = AwsBasicCredentials.create(
                    awsProperties.getProperty("aws.accessKeyId"),
                    awsProperties.getProperty("aws.secretKey")
            );
            LambdaClient newClient = LambdaClient.builder()
                    .credentialsProvider(StaticCredentialsProvider.create(awsCreds))
                    .region(REGION)
                    .build();
            // Only sets if still null, discards newClient if another thread has set it.
            lambdaClient.compareAndSet(null, newClient);
        }
    }

    /**
     * Invokes an AWS Lambda function synchronously using Vert.x's non-blocking executeBlocking method.
     * Waits for the Lambda function to complete and returns its output as a String.
     *
     * @param functionName the Lambda function name or Amazon Resource Name (ARN)
     * @param payloadJson  the JSON payload to send to the Lambda function
     * @param vertx        the Vert.x instance to use for non-blocking execution
     * @return a Future containing the result of the Lambda invocation as a String
     * @throws RuntimeException if the invocation fails (wrapped from any underlying AWS SDK exceptions)
     */
    public Future<String> invokeLambda(String functionName, String payloadJson, io.vertx.core.Vertx vertx) {
        initializeLambdaClient();
        // ordered=true is typically safer unless you need unordered
        return vertx.executeBlocking(() -> {
            InvokeRequest request = InvokeRequest.builder()
                    .functionName(functionName)
                    .payload(software.amazon.awssdk.core.SdkBytes.fromUtf8String(payloadJson))
                    .build();
            InvokeResponse response = lambdaClient.get().invoke(request);
            return response.payload().asUtf8String();
        }, true);
    }

    /**
     * Invokes an AWS Lambda function asynchronously ("fire-and-forget") using Vert.x's non-blocking executeBlocking method.
     * Does not wait for the Lambda function's output; returns success if the invocation is accepted (status code 202).
     *
     * @param functionName the Lambda function name or Amazon Resource Name (ARN)
     * @param payloadJson  the JSON payload to send to the Lambda function
     * @param vertx        the Vert.x instance to use for non-blocking execution
     * @return a Future containing true if the event was accepted (HTTP status code 202), false otherwise
     * @throws RuntimeException if the invocation fails (wrapped from any underlying AWS SDK exceptions)
     */
    public Future<Boolean> invokeLambdaAsync(String functionName, String payloadJson, io.vertx.core.Vertx vertx) {
        initializeLambdaClient();
        return vertx.executeBlocking(() -> {
            InvokeRequest request = InvokeRequest.builder()
                    .functionName(functionName)
                    .payload(software.amazon.awssdk.core.SdkBytes.fromUtf8String(payloadJson))
                    .invocationType("Event") // Fire-and-forget
                    .build();
            InvokeResponse response = lambdaClient.get().invoke(request);
            return response.statusCode() == 202;
        }, true);
    }

    /**
     * Returns the underlying LambdaClient, initializing it if necessary.
     */
    public LambdaClient getLambdaClient() {
        if (lambdaClient.get() == null) {
            initializeLambdaClient();
        }
        return lambdaClient.get();
    }
}