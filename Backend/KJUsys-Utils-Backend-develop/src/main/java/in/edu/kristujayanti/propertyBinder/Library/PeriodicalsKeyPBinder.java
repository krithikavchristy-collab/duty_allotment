package in.edu.kristujayanti.propertyBinder.Library;

import in.edu.kristujayanti.propertyBinder.KJUSYSPropertyBinder;
import org.bson.Document;

public enum PeriodicalsKeyPBinder implements KJUSYSPropertyBinder {

    PERIODICITY_NAME("periodicityName_Periodicals_Text", "Periodicity Name", String.class),
    PERIODICITY_NUMBER("periodicityNumber_Periodicals_Int","Periodicity Number",String.class),
    PERIODICAL_TYPE("periodicalType_Periodicals_Text", "Periodical Type", String.class),
    PERIODICAL_SUBJECT("periodicalSubject_Periodicals_Text", "Periodical Subject", String.class),
    PERIODICAL_SOURCE("periodicalSource_Periodicals_Text", "Periodical Source", String.class),
    PERIODICAL_DEPARTMENT("periodicalDepartment_Periodicals_Text", "Periodical Department", String.class),
    PERIODICAL_BRANCH("periodicalBranch_Periodicals_Text", "Periodical Branch", String.class),
    PERIODICAL_VENDOR("periodicalVendor_Periodicals_Text", "Periodical Vendor", String.class),


//    PERIODICAL_ID("periodicalId_Periodicals_Text", "Periodical Id", String.class),
//    PERIODICAL_TITLE("periodicalTitle_Periodicals_Text", "Periodical Id", String.class),
//    PERIODICAL_ISSN("periodicalIssn_Periodicals_Text", "Periodical Id", String.class),
//    PERIODICAL_PUBLISHER("periodicalIssn_Periodicals_Text", "Periodical Id", String.class),
//    PERIODICAL_PaUBLISHED_PLACE("periodicalIssn_Periodicals_Text", "Periodical Id", String.class),


    //  PERIODICAL INFORMATION
    PERIODICAL_ID("periodicalId_Periodicals_Text", "Periodical Id", String.class),
    PERIODICAL_TITLE("periodicalTitle_Periodicals_Text", "Periodical Title", String.class),
    PERIODICAL_ISSN("periodicalIssn_Periodicals_Text", "Periodical ISSN", String.class),
    PERIODICAL_PUBLISHER("periodicalPublisher_Periodicals_Text", "Periodical Publisher", String.class),
    PERIODICAL_PUBLISHED_PLACE("periodicalPublishedPlace_Periodicals_Text", "Periodical Published Place", String.class),
    PERIODICAL_HOME_BRANCH("periodicalHomeBranch_Periodicals_Text", "Periodical Home Branch", String.class),
    PERIODICAL_CLASS_NUMBER("periodicalClassNumber_Periodicals_Text", "Periodical Class Number", String.class),
    PERIODICAL_EDITOR("periodicalEditor_Periodicals_Text", "Periodical Editor", String.class),
    PERIODICAL_CALL_NUMBER("periodicalCallNumber_Periodicals_Text", "Periodical Call Number", String.class),
    PERIODICAL_LANGUAGE("periodicalLanguage_Periodicals_Text", "Periodical Language", String.class),
    PERIODICAL_EMAIL_ID("periodicalEmailId_Periodicals_Text", "Email Id", String.class),
    PERIODICAL_URL("periodicalUrl_Periodicals_Text", "Periodical URL", String.class),
    PERIODICAL_PARENT_ORG_ADDRESS("periodicalParentOrgAddress_Periodicals_Text", "Periodical Parent Org Address", String.class),
    PERIODICAL_PHONE("periodicalPhone_Periodicals_Text", "Periodical Phone", String.class),
    PERIODICAL_FAX("periodicalFax_Periodicals_Text", "Periodical Fax", String.class),
    CUSTOM_1("custom1_Periodicals_Text", "Custom1", String.class),
    CUSTOM_2("custom2_Periodicals_Text", "Custom2", String.class),
    CUSTOM_3("custom3_Periodicals_Text", "Custom3", String.class),
    CUSTOM_4("custom4_Periodicals_Text", "Custom4", String.class),

    // SUBSCRIPTION ENTRY
    PERIODICAL_SUBSCRIPTION("periodicalSubscription_Periodicals_DocumentArray","Periodical Subscription", Document.class),
        PERIODICAL_UNIQUE_NUMBER("periodicalUniqueNumber_Periodicals_Int","Periodical Unique Number",Integer.class),
    LIBRARY_SUBSCRIPTION_NUMBER("librarySubscriptionNumber_Periodicals_Text", "Library Subscription Number", String.class),
    PERIODICAL_SUBSCRIPTION_NUMBER("periodicalSubscriptionNumber_Periodicals_Text", "Periodical Subscription Number", String.class),
    SUBSCRIPTION_FROM_DATE("subscriptionFromDate_Periodicals_Date", "Subscription From Date", Long.class),
    SUBSCRIPTION_TO_DATE("subscriptionToDate_Periodicals_Date", "Subscription To Date", Long.class),
    PRE_TERMINATION_DATE("preTerminationDate_Periodicals_Date", "Pre-Termination Date", Long.class),
    ORDER_DATE("orderDate_Periodicals_Date", "Order Date", Long.class),
    COPIES("copies_Periodicals_Long", "Copies", Long.class),
    PURCHASE_ORDER_NUMBER("purchaseOrderNumber_Periodicals_Text", "Purchase Order Number", String.class),
    BILL_NUMBER("billNumber_Periodicals_Text", "Bill Number", String.class),
    BILL_DATE("billDate_Periodicals_Date", "Bill Date", Long.class),
    CURRENCY("currency_Periodicals_Text", "Currency", String.class),
    RATE("rate_Periodicals_Double", "Rate", Double.class),
    PRICE("price_Periodicals_Double", "Price", Double.class),
    COST_INR("costInr_Periodicals_Double", "Cost(INR)", Double.class),
    DISCOUNT("discount_Periodicals_Double", "Discount(%)", Double.class),
    NET_COST_INR("netCostInr_Periodicals_Double", "Net Cost(INR)", Double.class),
    COST_IN_RS("costInRs_Periodicals_Double", "Cost In Rs", Double.class),
    REMARKS("remarks_Periodicals_Text", "Remarks", String.class),



    DIFFERENCE("difference_Periodicals_Int","Difference",Integer.class),
    NUMBER_OF_ISSUES_IN_THIS_VOLUME("numberOfIssuesInThisVolume_Periodicals_Int","Number Of Issues In This Volume", Integer.class),
    FIRST_VOLUME_NUMBER("firstVolumeNumber_Periodicals_Int","First Volume Number",Integer.class),
    FIRST_ISSUE_NUMBER("firstIssueNumber_Periodicals_Int","First Issue Number",Integer.class),
    FIRST_ISSUE_DATE("firstIssueDate_Periodicals_Date", "First Issue Date", Long.class),
    AMOUNT("amount_Periodicals_Double","Amount",Double.class),
    PERIODICAL_GENERATION("periodicalGeneration_Periodicals_DocumentArray","Periodical Generation", Document.class),
    EXPECTED_RECEIVED_DATE("expectedReceivedDate_Periodical_Date","Expected Received Date",Long.class),
    LOOSE_ACCESSION_NUMBER("looseAccessionNumber_Periodical_Text","Loose Accession Number", String.class),
    ISSUE_DATE("issueDate_Periodicals_Date","Issue Date",Long.class)

    ;


    private final String property;
    private final String label;
    private final Class<?> dataType;
    private final int minLength;
    private final int maxLength;

    private PeriodicalsKeyPBinder(String property, String label, Class<?> dataType, int minLength, int maxLength) {
        this.property = property;
        this.label = label;
        this.dataType = dataType;
        this.minLength = minLength;
        this.maxLength = maxLength;
    }

    private PeriodicalsKeyPBinder(String property, String label, Class<?> dataType) {
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

    public Class getDataType() {
        return this.dataType;
    }

    public Integer getMinLength() {
        return this.minLength;
    }

    public Integer getMaxLength() {
        return this.maxLength;
    }

    // $FF: synthetic method
    private static PeriodicalsKeyPBinder[] $values() {
        return PeriodicalsKeyPBinder.class.getEnumConstants();
    }
}