package in.edu.kristujayanti.util;

import in.edu.kristujayanti.enums.ResponseCode;
import in.edu.kristujayanti.enums.ResponseType;
import in.edu.kristujayanti.enums.StatusCode;
import io.vertx.core.http.ServerWebSocket;
import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;

public class WebsocketResponseUtil {

    /**
     * Sends a structured JSON response through the provided WebSocket connection.
     *
     * The response follows this structure:
     * <pre>
     * {
     *   "statusCode": [status code],
     *   "type": [response type],
     *   "responseData": {
     *     "data": [data array],
     *     "message": [message array]
     *   }
     * }
     * </pre>
     *
     * This method ensures the WebSocket connection is open before sending the message.
     *
     * @param serverWebSocket the WebSocket connection to send the response
     * @param responseType    the type of response (e.g., SUCCESS, ERROR, VALIDATION)
     * @param statusCode      the status code representing the response (e.g., 200, 400, 500)
     * @param data            the data payload of the response
     * @param message         the messages or details associated with the response
     */

    public static void createWebsocketResponse(
            ServerWebSocket serverWebSocket,
            ResponseType responseType,
            StatusCode statusCode,
            JsonArray data,
            JsonArray message
    ) {
        JsonObject response = new JsonObject();
        response.put(ResponseCode.STATUS_CODE.getProperty(), statusCode.getStatusCode());
        response.put(ResponseCode.TYPE.getProperty(), responseType);
        JsonObject responseDataJsonObject = new JsonObject();
        responseDataJsonObject.put(ResponseCode.DATA.getProperty(), data);
        responseDataJsonObject.put(ResponseCode.MESSAGE.getProperty(), message);
        response.put(ResponseCode.RESPONSE_DATA.getProperty(), responseDataJsonObject);
        if (!serverWebSocket.isClosed()) {
            serverWebSocket.writeTextMessage(response.encode());
        }
    }
}
