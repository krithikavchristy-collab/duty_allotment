package in.edu.kristujayanti.util;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.bson.Document;
import org.bson.json.JsonMode;
import org.bson.json.JsonWriterSettings;

import java.io.IOException;

/**
 * Utility for converting a BSON Document (jobDoc) to JSON for Lambda and back.
 * Uses RELAXED mode to emit standard JSON so numbers (including millis) stay numeric.
 */
public final class AwsLambdaDocumentEventParsingUtil {
    private AwsLambdaDocumentEventParsingUtil() {}

    private static final JsonWriterSettings RELAXED = JsonWriterSettings.builder()
            .outputMode(JsonMode.RELAXED)
            .build();

    private static final ObjectMapper mapper = new ObjectMapper()
            .disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

    public static String toJson(Document jobDoc) {
        // Ensures integers (millis) are written as JSON numbers, not strings or extended JSON
        return jobDoc.toJson(RELAXED);
    }

    // Generic for simple (non-parameterized) types
    public static <T> T fromJson(String json, Class<T> clazz) throws IOException {
        return mapper.readValue(json, clazz);
    }

    // Generic for parameterized types
    public static <T> T fromJson(String json, TypeReference<T> typeRef) throws IOException {
        return mapper.readValue(json, typeRef);
    }
}