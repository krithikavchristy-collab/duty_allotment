package in.edu.kristujayanti.propertyBinder.payment;

import in.edu.kristujayanti.propertyBinder.KJUSYSPropertyBinder;

import javax.swing.text.Document;

public enum PaymentCommonKeysPBinder implements KJUSYSPropertyBinder {

    PAYMENT_ID("paymentId_PaymentCommonKeys_Text", "Payment Id", String.class),
    TRANSACTION_ID("transactionId_PaymentCommonKeys_Text", "Transaction Id", String.class),
    REVERSED_TRANSACTION_ID("reversedTransactionId_PaymentCommonKeys_Text", "Reversed Transaction Id", String.class),
    IS_STUDENT("isStudent_PaymentCommonKeys_Bool", "Is Student", Boolean.class),

    // payment configurations
    PAYMENT_CONFIGURATION_OID("paymentConfigurationOid_PaymentCommonKeys_ObjectId", "Payment Configuration Object Id", Object.class),
    PAYMENT_CONFIGURATION_CODE("paymentConfigurationCode_PaymentCommonKeys_Text","Payment Configuration Code",String.class),
    PAYMENT_GATEWAY_CONFIGURATIONS("paymentGatewayConfigurations_PaymentCommonKeys_DocumentArray", "Payment Gateway Configurations", Document.class),
    PAYMENT_GATEWAY_NAME("paymentGatewayName_PaymentCommonKeys_Text", "Payment Gateway Name", String.class),
    PAYMENT_GATEWAY_ACCOUNT_CONFIG("paymentGatewayAccountConfig_PaymentCommonKeys_Text", "Payment Gateway", String.class),
    IS_ACTIVE_PAYMENT_GATEWAY("isActivePaymentGateway_PaymentCommonKeys_Bool", "Is Active Payment Gateway",Boolean.class),

    PAYEE_IDENTIFICATION_NUMBER("payeeIdentificationNumber_PaymentCommonKeys_Text", "Payee Identification Number",String.class),
    TOTAL_PAYABLE_AMOUNT("totalPayableAmount_PaymentCommonKeys_Double", "Total Payable Amount",Double.class),


    PAYMENT_STATUS("paymentStatus_PaymentCommonKeys_Text", "Payment Status",String.class),
    PAYMENT_COMPLETED_ON("paymentCompletedOn_PaymentCommonKeys_DateTime", "Payment Completed On",Long.class),
    IS_MAIN_ACCOUNT("isMainAccount_PaymentCommonKeys_Bool", "Is Main Account",Boolean.class),


    ORDER_DETAILS("orderDetails_PaymentCommonKeys_Document", "Order Details", Document.class),
    PAYMENT_DETAILS("paymentDetails_PaymentCommonKeys_Document", "Payment Details",Document.class),
    PAYMENT_METHOD("paymentMethod_PaymentCommonKeys_Text", "Payment Method",String.class),
    SELECTED_FEE_HEADS("selectedFeeHeads_PaymentCommonKeys_DocumentArray", "Selected Fee Heads",Document.class),

    PAYMENT_TRANSFER_AMOUNT("paymentTransferAmount_PaymentCommonKeys_Double", "Payment Transfer Amount", Double.class),
    PAYMENT_TRANSFER_DETAILS("paymentTransferDetails_PaymentCommonKeys_DocumentArray", "Payment Transfer Details", Document.class),
    FEE_COLLECTED_AGAINST_REVERSAL("feeCollectedAgainstReversal_PaymentCommonKeys_Bool", "Fee Collected Against Reversal", Boolean.class),

    //Refund
    TOTAL_REFUNDED_AMOUNT("totalRefundedAmount_PaymentCommonKeys_Double", "Total Refunded Amount", Double.class),


    //Webhook
    WEBHOOK_EVENT_ID("webhookEventId_PaymentCommonKeys_Text", "Webhook Event Id", String.class),
    WEBHOOK_EVENT_STATE("webhookEventState_PaymentCommonKeys_Text", "Webhook Event State", String.class),
    WEBHOOK_EVENT_MESSAGE("webhookEventMessage_PaymentCommonKeys_Text", "Webhook Event Message", String.class),

    ;

    private final String property;
    private final String label;
    private final Class<?> dataType;
    private final int minLength;
    private final int maxLength;

    private PaymentCommonKeysPBinder(String property, String label, Class<?> dataType, int minLength, int maxLength) {
        this.property = property;
        this.label = label;
        this.dataType = dataType;
        this.minLength = minLength;
        this.maxLength = maxLength;
    }

    private PaymentCommonKeysPBinder(String property, String label, Class<?> dataType) {
        this.property = property;
        this.label = label;
        this.dataType = dataType;
        this.minLength = -1;
        this.maxLength = -1;
    }

    public String getPropertyName() {
        return this.property;
    }

    public String getDisplayName() {
        return this.label;
    }

    public Class<?> getDataType() {
        return this.dataType;
    }

    public Integer getMinLength() {
        return this.minLength;
    }

    public Integer getMaxLength() {
        return this.maxLength;
    }

    // New method to get label by property name
    public static String getLabelByProperty(String propertyName) {
        for (PaymentCommonKeysPBinder binder : values()) {
            if (binder.property.equals(propertyName)) {
                return binder.label;
            }
        }
        return null;
    }

    // New method to get property name by label
    public static String getPropertyByLabel(String label) {
        for (PaymentCommonKeysPBinder binder : values()) {
            if (binder.label.equals(label)) {
                return binder.property;
            }
        }
        return null;
    }

    // $FF: synthetic method
    private static PaymentCommonKeysPBinder[] $values() {
        return PaymentCommonKeysPBinder.class.getEnumConstants();
    }
}



