package in.edu.kristujayanti.util;

import in.edu.kristujayanti.enums.ResponseCode;
import in.edu.kristujayanti.enums.ResponseType;
import in.edu.kristujayanti.enums.StatusCode;
import in.edu.kristujayanti.propertyBinder.HR.WorkShiftKeysPBinder;
import io.vertx.core.http.HttpServerResponse;
import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;
import org.bson.Document;
import org.bson.types.ObjectId;

import java.util.List;
import java.util.function.Function;

public final class ResponseUtil {
    private ResponseUtil() {
    }

    private static void send(HttpServerResponse response, ResponseType type, StatusCode statusCode, Object responseData, String message) {
        JsonObject responseJson = new JsonObject();
        responseJson.put(ResponseCode.STATUS_CODE.getProperty(), statusCode.getStatusCode());
        responseJson.put(ResponseCode.TYPE.getProperty(), type);
        responseJson.put(ResponseCode.MESSAGE.getProperty(), message);
        responseJson.put(ResponseCode.RESPONSE_DATA.getProperty(), responseData);
        response.putHeader("content-type", "application/json").end(responseJson.encodePrettily());
    }
    // CREATED (201)
    public static void created(HttpServerResponse response, JsonObject data, String message) {
        send(response, ResponseType.SUCCESS, StatusCode.CREATED, data, message);
    }

    // SUCCESS (200)
    public static void success(HttpServerResponse response, JsonObject data, String message) {
        send(response, ResponseType.SUCCESS, StatusCode.TWOHUNDRED, data, message);
    }

    // VALIDATION ERROR (400)
    public static void validationError(HttpServerResponse response, JsonArray validationErrors) {
        send(response, ResponseType.VALIDATION, StatusCode.BAD_REQUEST, validationErrors, "Validation failed");
    }

   // INTERNAL SERVER ERROR
    public static void exceptionError(HttpServerResponse response, String error) {
        send(response, ResponseType.ERROR, StatusCode.INTERNAL_SERVER_ERROR, new JsonObject(), error);
    }

    // VALIDATION ERROR
    public static void validationError(HttpServerResponse response, String error) {
        send(response, ResponseType.BAD_REQUEST, StatusCode.BAD_REQUEST, new JsonObject(), error);
    }


    public static void createResponse(HttpServerResponse httpServerResponse, ResponseType responseType, StatusCode statusCode, JsonArray data, JsonArray message) {
        JsonObject response = new JsonObject();
        response.put(ResponseCode.STATUS_CODE.getProperty(), statusCode.getStatusCode());
        response.put(ResponseCode.TYPE.getProperty(), responseType);
        JsonObject responseDataJsonObject = new JsonObject();
        responseDataJsonObject.put(ResponseCode.DATA.getProperty(), data);
        responseDataJsonObject.put(ResponseCode.MESSAGE.getProperty(), message);
        response.put(ResponseCode.RESPONSE_DATA.getProperty(), responseDataJsonObject);
        httpServerResponse
                .putHeader("content-type", "application/json")
                .end(response.encodePrettily());
    }

    public static void createResponse(HttpServerResponse httpServerResponse, ResponseType responseType, StatusCode statusCode, JsonObject data, JsonArray message) {
        JsonObject response = new JsonObject();
        response.put(ResponseCode.STATUS_CODE.getProperty(), statusCode.getStatusCode());
        response.put(ResponseCode.TYPE.getProperty(), responseType);
        JsonObject responseDataJsonObject = new JsonObject();
        responseDataJsonObject.put(ResponseCode.DATA.getProperty(), data);
        responseDataJsonObject.put(ResponseCode.MESSAGE.getProperty(), message);
        response.put(ResponseCode.RESPONSE_DATA.getProperty(), responseDataJsonObject);
        httpServerResponse
                .putHeader("content-type", "application/json")
                .end(response.encodePrettily());
    }

    public static void createResponse(HttpServerResponse httpServerResponse, ResponseType responseType, Integer statusCode, JsonArray data, JsonArray message) {
        JsonObject response = new JsonObject();
        response.put(ResponseCode.STATUS_CODE.getProperty(), StatusCode.validateStatusCode(statusCode));
        response.put(ResponseCode.TYPE.getProperty(), responseType);
        JsonObject responseDataJsonObject = new JsonObject();
        responseDataJsonObject.put(ResponseCode.DATA.getProperty(), data);
        responseDataJsonObject.put(ResponseCode.MESSAGE.getProperty(), message);
        response.put(ResponseCode.RESPONSE_DATA.getProperty(), responseDataJsonObject);
        httpServerResponse
                .putHeader("content-type", "application/json")
                .end(response.encodePrettily());
    }

    /**
     * Processes the given MongoDB Document by identifying specific key patterns and updating their values accordingly.
     * <p>
     * The method performs the following operations:
     * - Converts fields with suffixes "_Time", "_Date", and "_DateTime" from millisecond values to formatted strings.
     * - Converts fields with suffix "_ObjectId" or "_id" from ObjectId to String representation.
     * - Converts fields with suffix "_ObjectIdArray" from a list of ObjectIds to a list of Strings.
     * - Recursively processes nested documents for fields with suffix "_Document".
     * - Recursively processes arrays of nested documents for fields with suffix "_DocumentArray".
     *
     * @param doc the MongoDB Document to process. This document is modified in-place.
     */
    public static void processResponseDocument(Document doc) {
        processResponseDocument(doc, false);
    }

    /**
     * Processes the given MongoDB Document by identifying specific key patterns and updating their values accordingly.
     * <p>
     * The method performs the following operations:
     * - Converts fields with suffixes "_Time", "_Date", and "_DateTime" from millisecond values to formatted strings.
     * - Converts fields with suffix "_ObjectId" or "_id" from ObjectId to String representation.
     * - Converts fields with suffix "_ObjectIdArray" from a list of ObjectIds to a list of Strings.
     * - Recursively processes nested documents for fields with suffix "_Document".
     * - Recursively processes arrays of nested documents for fields with suffix "_DocumentArray".
     *
     * @param doc the MongoDB Document to process. This document is modified in-place.
     * @param removeNullKeys if true, removes keys with null values
     */
        public static void processResponseDocument(Document doc, boolean removeNullKeys) {
            // Handle keys ending with "_Time"
            updateKeys(doc, "_Text", String.class, s -> s, removeNullKeys);

            // Handle keys ending with "_Time"
            updateKeys(doc, "_Time", Long.class, DateUtils::convertTimeMillisToTimeString, removeNullKeys);

            // Handle keys ending with "_Date"
            updateKeys(doc, "_Date", Long.class, DateUtils::convertMillisToDateString, removeNullKeys);

            // Handle keys ending with "_DateTime"
            updateKeys(doc, "_DateTime", Long.class, DateUtils::convertMillisToDateTimeStringAsia, removeNullKeys);

            updateKeys(doc, "_StartDate", Long.class, DateUtils::convertMillisToDateString, removeNullKeys);
            updateKeys(doc, "_EndDate", Long.class, DateUtils::convertMillisToDateString, removeNullKeys);

            // Handle ObjectId conversion for "_ObjectId" and "_id"
            updateKeys(doc, "_ObjectId", ObjectId.class, ObjectIdUtil::convertObjectIdToString, removeNullKeys);
            updateKeys(doc, "_id", ObjectId.class, ObjectIdUtil::convertObjectIdToString, removeNullKeys);

            // Handle ObjectId arrays
            doc.keySet().stream()
                    .filter(key -> key.endsWith("_ObjectIdArray"))
                    .forEach(key -> {
                        List<ObjectId> objectIdList = doc.getList(key, ObjectId.class);
                        if (objectIdList != null) {
                            doc.put(key, ObjectIdUtil.convertObjectIdListToStringList(objectIdList));
                        }
                    });

            // Handle nested documents
            doc.keySet().stream()
                    .filter(key -> key.endsWith("_Document"))
                    .forEach(key -> {
                        Document nestedDoc = doc.get(key, Document.class);
                        if (nestedDoc != null) {
                            processResponseDocument(nestedDoc, removeNullKeys);
                        }
                    });

            // Handle arrays of nested documents
            doc.keySet().stream()
                    .filter(key -> key.endsWith("_DocumentArray"))
                    .forEach(key -> {
                        List<Document> nestedDocs = doc.getList(key, Document.class);
                        if (nestedDocs != null) {
                            nestedDocs.forEach(document -> ResponseUtil.processResponseDocument(document, removeNullKeys));
                        }
                    });
        }

        /**
     * Updates all keys in the given MongoDB Document that match the specified suffix by applying a conversion function
     * to their values.
     * <p>
     * This helper method filters keys in the document that end with the given suffix, retrieves their values of the
     * specified type, and updates the key with the result of the conversion function. Only non-null values are processed,
     * unless removeNull is true, in which case keys with null values are removed.
     *
     * @param <T>        the type of the values to be retrieved and converted
     * @param doc        the MongoDB Document containing the keys to update. This document is modified in-place
     * @param suffix     the suffix to match against the keys in the document
     * @param type       the expected type of the key's value to process
     * @param converter  the conversion function to apply to the key's value
     * @param removeNull if true, keys with null values will be removed from the document
     */
    private static <T> void updateKeys(Document doc, String suffix, Class<T> type, Function<T, Object> converter, boolean removeNull) {
        List<String> keys = doc.keySet().stream()
                .filter(key -> key.endsWith(suffix))
                .toList();
        for (String key : keys) {
            T value = doc.get(key, type);
            if (value != null) {
                doc.put(key, converter.apply(value));
            } else if (removeNull) {
                // remove key if value null
                doc.remove(key);
            }
        }
    }

    public static void processResponseDocumentWithoutZone(Document doc) {
        // Handle keys ending with "_Time"
        updateKeys(doc, "_Time", Long.class, DateUtils::convertTimeMillisToTimeString, false);

        // Handle keys ending with "_Date"
        updateKeys(doc, "_Date", Long.class, DateUtils::convertMillisToDateString, false);

        // Handle keys ending with "_DateTime"
        updateKeys(doc, "_DateTime", Long.class, DateUtils::convertMillisToDateTimeStringAsiaWithoutZone, false);

        // Handle ObjectId conversion for "_ObjectId" and "_id"
        updateKeys(doc, "_ObjectId", ObjectId.class, ObjectIdUtil::convertObjectIdToString, false);
        updateKeys(doc, "_id", ObjectId.class, ObjectIdUtil::convertObjectIdToString, false);

        // Handle ObjectId arrays
        doc.keySet().stream()
                .filter(key -> key.endsWith("_ObjectIdArray"))
                .forEach(key -> {
                    List<ObjectId> objectIdList = doc.getList(key, ObjectId.class);
                    if (objectIdList != null) {
                        doc.put(key, ObjectIdUtil.convertObjectIdListToStringList(objectIdList));
                    }
                });

        // Handle nested documents
        doc.keySet().stream()
                .filter(key -> key.endsWith("_Document"))
                .forEach(key -> {
                    Document nestedDoc = doc.get(key, Document.class);
                    if (nestedDoc != null) {
                        processResponseDocument(nestedDoc);
                    }
                });

        // Handle all arrays of nested documents
        doc.keySet().stream()
                .filter(key -> doc.get(key) instanceof List)
                .forEach(key -> {
                    Object value = doc.get(key);
                    if (value instanceof List && !((List<?>) value).isEmpty() && ((List<?>) value).get(0) instanceof Document) {
                        List<Document> nestedDocs = doc.getList(key, Document.class);
                        if (nestedDocs != null) {
                            nestedDocs.forEach(ResponseUtil::processResponseDocumentWithoutZone);
                        }
                    }
                });
    }

}