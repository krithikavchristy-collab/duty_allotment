

package in.edu.kristujayanti.propertyBinder.KJAnnexe;

import in.edu.kristujayanti.propertyBinder.KJUSYSPropertyBinder;

public enum AnnexePaymentKeysPBinder implements KJUSYSPropertyBinder {

    PAYMENT_ID("paymentId_KJAnnexePayment_Text", "Payment ID", String.class),
    BILL_REF_NUMBER("billRefNumber_KJAnnexePayment_Text", "Bill Reference Number", String.class),
    ACCOMMODATION_CHARGES("accommodationCharges_KJAnnexePayment_Double", "Accommodation Charges", Double.class),
    TOTAL_ACCOMMODATION_CHARGES("totalAccommodationCharges_KJAnnexePayment_Double", "Total Accommodation Charges", Double.class),
    PAYMENT_METHOD("paymentMethod_KJAnnexePayment_Text", "Payment Method", String.class),
    DISCOUNT_AMOUNT("discountAmount_KJAnnexePayment_Double", "Discount Amount", Double.class),
    //  PAYMENT_STATUS("paymentStatus_KJAnnexePayment_Text", "Payment Status", String.class),
    AMOUNT_PAID("amountPaid_KJAnnexePayment_Double", "Amount Paid", Double.class),
    PAYMENT_DATE("paymentDate_KJAnnexePayment_Date", "Payment Date", Long.class),
    PAID_AMOUNT("paidAmount_KJAnnexePayment_Double", "Paid Amount", Double.class),
    BALANCE_DUE_AMOUNT("balanceDueAmount_KJAnnexePayment_Double", "Balance Due Amount", Double.class),
    GST_AMOUNT("gstAmount_KJAnnexePayment_Double","Gst Amount",Double.class),
    IS_GST_INCLUDED("isGstIncluded_KJAnnexePayment_Bool", "Is GST Included",Boolean.class),
    IS_GST_EXCLUDED("isGstExcluded_KJAnnexePayment_Bool", "Is GST Excluded",Boolean.class),
;


    private final String property;
    private final String label;
    private final Class<?> dataType;
    private final int minLength;
    private final int maxLength;

    private AnnexePaymentKeysPBinder(String property, String label, Class<?> dataType, int minLength, int maxLength) {
        this.property = property;
        this.label = label;
        this.dataType = dataType;
        this.minLength = minLength;
        this.maxLength = maxLength;
    }

    private AnnexePaymentKeysPBinder(String property, String label, Class<?> dataType) {
        this(property, label, dataType, -1, -1);
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

    private static AnnexePaymentKeysPBinder[] $values() {
        return AnnexePaymentKeysPBinder.class.getEnumConstants();
    }
}