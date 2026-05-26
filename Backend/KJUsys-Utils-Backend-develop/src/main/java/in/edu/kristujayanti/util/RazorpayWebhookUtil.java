package in.edu.kristujayanti.util;

import com.mongodb.client.ClientSession;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.UpdateOptions;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;
import com.razorpay.Utils;
import in.edu.kristujayanti.collectionNames.PaymentCNBinder;
import in.edu.kristujayanti.constants.PaymentServiceKeys;
import in.edu.kristujayanti.dbaccess.MongoDataAccess;
import in.edu.kristujayanti.propertyBinder.payment.PaymentCommonKeysPBinder;
import io.vertx.core.Future;
import io.vertx.core.MultiMap;
import io.vertx.core.json.JsonObject;
import io.vertx.redis.client.RedisAPI;
import org.bson.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RazorpayWebhookUtil extends MongoDataAccess {
    
    private RazorpayClient razorpayClient;
    private final MongoDatabase mongoDatabase;
    private final MongoClient mongoClient;
    private final Logger LOGGER = LoggerFactory.getLogger(RazorpayWebhookUtil.class);


    private static final String EVENT = "event";
    private static final String PAYMENT_OBJ = "payment";


    private final String WEBHOOK_EVENT_COLLECTION = PaymentCNBinder.RAZORPAY_WEBHOOK_EVENT_COLLECTION.getCollectionName();

    public RazorpayWebhookUtil(RazorpayClient razorpayClient, MongoDatabase mongoDatabase, MongoClient mongoClient){
        this.razorpayClient = razorpayClient;
        this.mongoDatabase = mongoDatabase;
        this.mongoClient = mongoClient;
    }

    public static boolean verifyWebhookSignature(JsonObject payload, MultiMap headers, String secret) throws RazorpayException {
        String stringPayload = payload.toString();
        String payloadSignature = retrieveEventHeaders(headers, PaymentServiceKeys.WEBHOOK_SIGNATURE);
        return Utils.verifyWebhookSignature(stringPayload, payloadSignature, secret);
    }


    public enum WebhookEventState {
        PAID,
        NO_EFFECT,
        FAILED
    }

    public boolean updateStateFromWebhookEvent(Document payload, String eventId, String eventState, String message, String transactionId){
        try(ClientSession clientSession = getMongoDbSession(mongoClient)){
            startTransaction(clientSession);

            Document updateDoc = new Document()
                    .append("$set", new Document(payload)
                            .append(PaymentCommonKeysPBinder.WEBHOOK_EVENT_ID.getPropertyName(), eventId)
                            .append(PaymentCommonKeysPBinder.WEBHOOK_EVENT_STATE.getPropertyName(), eventState)
                            .append(PaymentCommonKeysPBinder.WEBHOOK_EVENT_MESSAGE.getPropertyName(), message)
                            .append(PaymentCommonKeysPBinder.TRANSACTION_ID.getPropertyName(), transactionId)
                    );

            boolean updateState = updateDocument(WEBHOOK_EVENT_COLLECTION, Filters.eq(PaymentCommonKeysPBinder.WEBHOOK_EVENT_ID.getPropertyName(), eventId), updateDoc, new UpdateOptions().upsert(true), clientSession, mongoDatabase);

            if(updateState){
                commitTransaction(clientSession);
                return true;
            }else{
                abortTransaction(clientSession);
                return false;
            }

        }catch (Exception e){
            LOGGER.error("Failed to update state of Webhook Event: {}", e.getMessage());
            return false;
        }
    }

    public static String retrieveEventType(Document payload){
        return payload.getString(EVENT);
    }

    public static String retrieveEventHeaders(MultiMap headers, String header){
        return headers.get(header);

    }

    public static String retrieveWebhookSecret(){

        return System.getenv(PaymentServiceKeys.RAZORPAY_WEBHOOK_SECRET_KEY);
    }




}
