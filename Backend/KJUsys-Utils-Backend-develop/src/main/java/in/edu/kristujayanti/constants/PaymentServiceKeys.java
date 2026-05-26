package in.edu.kristujayanti.constants;

public interface PaymentServiceKeys {

    String AMOUNT = "amount";
    String CURRENCY = "currency";
    String INR = "INR";
    String RECEIPT = "receipt";
    String PAYMENT_CAPTURE = "payment_capture";
    String NOTES = "notes";
    String RAZORPAY_PAYMENT_ID = "razorpay_payment_id";
    String RAZORPAY_ORDER_ID = "razorpay_order_id";
    String RAZORPAY_SIGNATURE = "razorpay_signature";
    String RAZORPAY_SECRET_KEY = "razorpay_secret";

    String RAZORPAY_WEBHOOK_SECRET_KEY = "razorpay_webhook_secret";
    String ACCOUNT = "account";
    String TRANSFERS="transfers";

    String IN_PROGRESS="IN-PROGRESS";
    String FAILED="FAILED";
    String CANCELLED="CANCELLED";
    String PAID="PAID";
    String USER_CANCELLED="USER-CANCELLED";


    String RAZORPAY="RAZORPAY";
    String EASEBUZZ="EASEBUZZ";
    String MANUAL_COLLECTION="MANUAL_COLLECTION";
    String COLLECTION_AGAINST_REVERSAL="COLLECTION_AGAINST_REVERSAL";

    String TRANSACTION_ID_PREFIX = "TXN";
    String PAYMENT_ID_PREFIX = "KJUSYS_PAY";
    String ORDER_ID_PREFIX = "KJUSYS_ORDER";

    String REDIS_KEY_START_FOR_TRANSACTION_ID="txnId";
    String REDIS_KEY_START_FOR_PAYMENT_ID="paymentId";
    String REDIS_KEY_START_FOR_ORDER_ID="orderId";

    //Razorpay-Webhook Events Subscribed
    String WEBHOOK_PAYMENT_SUCCESS="payment.captured";
    String WEBHOOK_PAYMENT_FAILED="payment.failed";
    String WEBHOOK_SIGNATURE="X-Razorpay-Signature";
    String WEBHOOK_EVENT_ID="X-Razorpay-Event-Id";
}
