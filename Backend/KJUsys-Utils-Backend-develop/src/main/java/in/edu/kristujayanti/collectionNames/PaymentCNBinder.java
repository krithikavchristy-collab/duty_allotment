package in.edu.kristujayanti.collectionNames;


public enum PaymentCNBinder implements KJUSYSCNBinder {

    ORDER_DETAILS_COLLECTION("order_details"),
    PAYMENT_DETAILS_COLLECTION("payment_details"),
    PAYMENT_REFUND_COLLECTION("payment_refund"),
    FAILED_PAYMENT_COLLECTION("failedPaymentCollection"),
    TRANSFER_COLLECTION("transferCollection"),
    PAYMENT_MODES_COLLECTION("paymentModeDetails"),
    GYM_ORDER_DETAILS_COLLECTION("gym_order_details"),
    PAYMENT_CONFIGURATION_COLLECTION("paymentConfigurationCollection"),
    PAYMENT_TRANSACTION_COLLECTION("payment_transaction_collection"),
    AUTOMATED_REFUND("automated_refund"),
    RAZORPAY_WEBHOOK_EVENT_COLLECTION("razorpay_webhook_events"),

    // payment receipt
    PAYMENT_RECEIPT_TEMPLATE_PLACEHOLDERS("payment_receipt_template_placeholders"),
    PAYMENT_RECEIPT_TEMPLATES("payment_receipt_templates"),
    PAYMENT_RECEIPTS("payment_receipts"),
    ;
    


    private final String collectionName;

    private PaymentCNBinder(String collectionName) {
        this.collectionName = collectionName;
    }

    public String getCollectionName() {
        return this.collectionName;
    }

    // $FF: synthetic method
    private static AuthCNBinder[] $values() {
        return AuthCNBinder.class.getEnumConstants();
    }


}

