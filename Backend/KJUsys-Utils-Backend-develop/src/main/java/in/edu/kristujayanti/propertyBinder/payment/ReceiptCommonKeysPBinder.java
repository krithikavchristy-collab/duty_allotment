package in.edu.kristujayanti.propertyBinder.payment;

import in.edu.kristujayanti.propertyBinder.KJUSYSPropertyBinder;
import org.bson.Document;
import org.bson.types.ObjectId;

public enum ReceiptCommonKeysPBinder implements KJUSYSPropertyBinder {

    // template placeholders
    TEMPLATE_PLACEHOLDER_TITLE("templatePlaceholderTitle_ReceiptCommon_Text", "Template Placeholder Title", String.class),
    TEMPLATE_PLACEHOLDER_VALUE("templatePlaceholderValue_ReceiptCommon_Text", "Template Placeholder Value", String.class),
    TEMPLATE_PLACEHOLDER_DATA_LOCATION("templatePlaceholderDataLocation_ReceiptCommon_Text", "Template Placeholder Data Location", String.class),

    // receipt
    RECEIPT_NUMBER("receiptNumber_ReceiptCommon_Text", "Receipt Number", String.class),
    RECEIPT_DATE("receiptDate_ReceiptCommon_Date", "Receipt Date", Long.class),

    // payee details
    PAYEE_NAME("payeeName_ReceiptCommon_Text", "Payee Name", String.class),
    PAYEE_EMAIL("payeeEmail_ReceiptCommon_Text", "Payee Email", String.class),
    PAYEE_GENDER("payeeGender_ReceiptCommon_Text", "Payee Gender", String.class),
    PAYEE_WHATSAPP_NUMBER("payeeWhatsappNumber_ReceiptCommon_Text", "Payee Whatsapp Number", String.class),
    PAYEE_PHOTO("payeePhoto_ReceiptCommon_File", "Payee Photo", String.class),
    PAYEE_BATCH("payeeBatch_ReceiptCommon_Text", "Payee Batch", String.class),
    PAYEE_BATCH_CODE("payeeBatchCode_ReceiptCommon_Text", "Payee Batch Code", String.class),
    PAYEE_PROGRAM_NAME("payeeProgramName_ReceiptCommon_Text", "Payee Program Name", String.class),
    PAYEE_ADMISSION_QUOTA("payeeAdmissionQuota_ReceiptCommon_Text", "Payee Admission Quota", String.class),
    PAYEE_FEE_CATEGORY("payeeFeeCategory_ReceiptCommon_Text", "Payee Fee Category", String.class),
    PAYEE_CASTE_CATEGORY("payeeCasteCategory_ReceiptCommon_Text", "Payee Caste Category", String.class),
    PAYEE_ROLL_NUMBER("payeeRollNumber_ReceiptCommon_Text", "Payee Roll Number", String.class),
    PAYEE_APPLICATION_NUMBER("payeeApplicationNumber_ReceiptCommon_Text", "Payee Application Number", String.class),
    PAYEE_SESSION("payeeSession_ReceiptCommon_Int", "Payee Session", Integer.class),
    PAYEE_PARENT_NAME("payeeParentName_ReceiptCommon_Text", "Payee Parent Name", String.class),
    PAYEE_PRESENT_ADDRESS("payeePresentAddress_ReceiptCommon_Text", "Payee Present Address", String.class),
    PAYEE_PERMANENT_ADDRESS("payeePermanentAddress_ReceiptCommon_Text", "Payee Permanent Address", String.class),

    // payment details
    PAYMENT_DETAILS("paymentDetails_ReceiptCommon_DocumentArray", "Payment Details", Document.class),
    SELECTED_FEE_HEAD_OIDS("selectedFeeHeadOids_ReceiptCommon_ObjectIdArray", "Selected Fee Head Oids", ObjectId.class),
    SCHEDULED_AMOUNT("scheduledAmount_ReceiptCommon_Double", "Scheduled Amount", Double.class),
    DUE_AMOUNT("dueAmount_ReceiptCommon_Double", "Due Amount", Double.class),
    AMOUNT_PAID("amountPaid_ReceiptCommon_Double", "Amount Paid", Double.class),
    AMOUNT_RECEIVED("amountReceived_ReceiptCommon_Double", "Amount Received", Double.class),
    AMOUNT_IN_WORDS("amountInWords_ReceiptCommon_Text", "Amount In Words", String.class),

    // transaction summary
    TRANSACTION_REFERENCE_NUMBER("transactionReferenceNumber_ReceiptCommon_Text", "Transaction Reference Number", String.class),
    PAYMENT_MODE("paymentMode_ReceiptCommon_Text", "Payment Mode", String.class),
    BANK_AND_BRANCH("bankAndBranch_ReceiptCommon_Text", "Bank and Branch", String.class),
    INSTRUMENT_DATE("instrumentDate_ReceiptCommon_Date", "Instrument Date", Long.class),
    BALANCE_DUE_AMOUNT("balanceDueAmount_ReceiptCommon_Double", "Balance Due Amount", Double.class),
    RECEIPT_PREPARED_BY("receiptPreparedBy_ReceiptCommon_Text", "Receipt Prepared By", String.class),

    RECEIPT_STATUS("receiptStatus_ReceiptCommon_Text", "Receipt Status", String.class),
    RECEIPT_FILE_PATH("receiptFilePath_ReceiptCommon_Text", "Receipt File Path", String.class),

    // receipt template
    TEMPLATE_NAME("templateName_ReceiptCommon_Text", "Template Name", String.class),
    TEMPLATE_HTML_BODY("templateHtmlBody_ReceiptCommon_Text", "Template Html Body", String.class),
    TEMPLATE_PLACEHOLDERS("templatePlaceholders_ReceiptCommon_DocumentArray", "Template Placeholders", Document.class),

    ;

    private final String property;
    private final String label;
    private final Class<?> dataType;
    private final int minLength;
    private final int maxLength;

    private ReceiptCommonKeysPBinder(String property, String label, Class<?> dataType, int minLength, int maxLength) {
        this.property = property;
        this.label = label;
        this.dataType = dataType;
        this.minLength = minLength;
        this.maxLength = maxLength;
    }

    private ReceiptCommonKeysPBinder(String property, String label, Class<?> dataType) {
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
        for (ReceiptCommonKeysPBinder binder : values()) {
            if (binder.property.equals(propertyName)) {
                return binder.label;
            }
        }
        return null;
    }

    // New method to get property name by label
    public static String getPropertyByLabel(String label) {
        for (ReceiptCommonKeysPBinder binder : values()) {
            if (binder.label.equals(label)) {
                return binder.property;
            }
        }
        return null;
    }

    // $FF: synthetic method
    private static ReceiptCommonKeysPBinder[] $values() {
        return ReceiptCommonKeysPBinder.class.getEnumConstants();
    }
}




