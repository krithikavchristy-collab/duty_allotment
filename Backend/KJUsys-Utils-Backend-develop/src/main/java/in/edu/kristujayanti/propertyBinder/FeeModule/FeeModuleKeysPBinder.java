
package in.edu.kristujayanti.propertyBinder.FeeModule;

import in.edu.kristujayanti.propertyBinder.KJUSYSPropertyBinder;
import org.bson.types.ObjectId;

import javax.swing.text.Document;

public enum FeeModuleKeysPBinder implements KJUSYSPropertyBinder {

    // Trust
    TRUST_OID("trustOid_FeeModule_ObjectId", "Trust Object Id", Object.class),
    TRUST_NAME("trustName_FeeModule_Text", "Trust Name", String.class),
    TRUST_DESCRIPTION("trustDescription_FeeModule_Text", "Trust Description", String.class),
    TRUST_OTHER_INFO("trustOtherInfo_FeeModule_Text", "Trust Other Info", String.class),
    PAYMENT_CONFIGURATIONS("paymentConfigurations_FeeModule_ObjectIdArray", "Payment Configurations", ObjectId.class),

    // Bank Account
    BANK_ACCOUNT_OID("bankAccountOid_FeeModule_ObjectId", "Bank Account Object ID", Object.class),
    BANK_ACCOUNT_NUMBER("bankAccountNumber_FeeModule_Text", "Bank Account Number", String.class),
    BANK_ACCOUNT_BENEFICIARY_NAME("bankAccountBeneficiaryName_FeeModule_Text", "Bank Account Beneficiary Name", String.class),
    BANK_NAME("bankName_FeeModule_Text", "Bank Name", String.class),
    BANK_IFSC_CODE("bankIfscCode_FeeModule_Text", "Bank IFSC Code", String.class),
    BANK_ACCOUNT_OTHER_INFO("bankAccountOtherInfo_FeeModule_Text", "Bank Account Info", String.class),

    // Fee group
    FEE_GROUP_OID("feeGroupOid_FeeModule_ObjectId", "Fee Group Object ID", Object.class),
    FEE_GROUP_CODE("feeGroupCode_FeeModule_Text", "Fee Group Code", String.class),
    FEE_GROUP_NAME("feeGroupName_FeeModule_Text", "Fee Group Name", String.class),
    FEE_GROUP_DESCRIPTION("feeGroupDescription_FeeModule_Text", "Fee Group Description", String.class),
    FEE_GROUP_OTHER_INFO("feeGroupOtherInfo_FeeModule_Text", "Fee Group Other Info", String.class),
    FEE_GROUP_RECEIPT_TEMPLATE("feeGroupReceiptTemplate_FeeModule_ObjectId", "Fee Group Receipt Template", ObjectId.class),

    // fee head
    FEE_HEADS("feeHeads_FeeModule_DocumentArray", "Fee Heads", Document.class),
    FEE_HEAD_CODE("feeHeadCode_FeeModule_Text", "Fee Head Code ", String.class),
    FEE_HEAD_NAME("feeHeadName_FeeModule_Text", "Fee Head Name", String.class),
    FEE_HEAD_DESCRIPTION("feeHeadDescription_FeeModule_Text", "Fee Head Description", String.class),
    FEE_HEAD_INDEPENDENT_PAYMENT_ALLOWED("feeHeadIndependentPaymentAllowed_FeeModule_Bool", "Fee Head Independent Payment Allowed ", Boolean.class),
    FEE_HEAD_OTHER_INFO("feeHeadOtherInfo_FeeModule_Text", "Fee Head Other Info", String.class),
    IS_REGISTRATION_FEE_FEE_HEAD("isRegistrationFeeFeeHead_FeeModule_Bool", "Is Registration Fee Fee Head", Boolean.class),
    IS_LATE_FEE_FEE_HEAD("isLateFeeFeeHead_FeeModule_Bool", "Is Late Fee Fee Head", Boolean.class),
    FEE_HEAD_PAYMENT_STATUS("feeHeadPaymentStatus_FeeModule_Text", "Fee Head Payment Status", String.class),
    FEE_HEAD_START_DATE("feeHeadStartDate_FeeModule_Date", "Fee Head Start Date", Long.class),
    FEE_HEAD_END_DATE("feeHeadEndDate_FeeModule_Date", "Fee Head End Date", Long.class),
    FEE_HEAD_EXTENSION_START_DATE("feeHeadExtensionStartDate_FeeModule_Date", "Fee Head Extension Start Date", Long.class),
    FEE_HEAD_EXTENSION_END_DATE("feeHeadExtensionEndDate_FeeModule_Date", "Fee Head Extension End Date", Long.class),
    IS_LATE_FEE_GENERATED("isLateFeeGenerated_FeeModule_Bool", "Is Late Fee Generated", Boolean.class),
    IS_FEE_HEAD_PAYABLE("isFeeHeadPayable_FeeModule_Bool", "Is Fee Head Payable", Boolean.class),
    FEE_HEAD_UPDATE_REMARK("feeHeadUpdateRemark_FeeModule_Text", "Fee Head Update Remark", String.class),
    IS_FEE_HEAD_SPLIT_ALLOWED("isFeeHeadSplitAllowed_FeeModule_Bool", "Is Fee Head Split Allowed", Boolean.class),
    FEE_EDIT_OPERATION_REMARK("feeEditOperationRemark_FeeModule_Text", "Fee Edit Operation Remark", String.class),
    EDITED_FEE_HEAD_OID("editedFeeHeadOid_FeeModule_ObjectId", "Edited Fee Head Oid", ObjectId.class),
    FEE_HEAD_CODE_ARRAY("feeHeadCodeArray_FeeModule_TextArray", "Fee Head Code Array", String.class),
    FEE_HEAD_PAYMENT_STATUS_ARRAY("feeHeadPaymentStatusArray_FeeModule_TextArray", "Fee Head Payment Status Array", String.class),

    // fee structure
    FEE_STRUCTURE_OID("feeStructureOid_FeeModule_ObjectId", "Fee Structure Object ID", Object.class),
    FEE_STRUCTURE_CODE("feeStructureCode_FeeModule_Text", "Fee Structure Code", String.class),
    FEE_STRUCTURE_NAME("feeStructureName_FeeModule_Text", "Fee Structure Name", String.class),
    FEE_STRUCTURE_DESCRIPTION("feeStructureDescription_FeeModule_Text", "Fee Structure Description", String.class),
    FEE_STRUCTURE_APPLICABILITY("feeStructureApplicability_FeeModule_Document", "Fee Structure Applicability", Document.class),
    FEE_STRUCTURE_CURRENCY("feeStructureCurrency_FeeModule_Text", "Fee Structure Currency", String.class),
    IS_FEE_STRUCTURE_FOR_ADMISSION("isFeeStructureForAdmission_FeeModule_Bool", "Is Fee Structure For Admission", Boolean.class),
    APPLIED_FEE_STRUCTURES("appliedFeeStructures_FeeModule_DocumentArray", "Applied Fee Structures", Document.class),
    FEE_STRUCTURE_ACADEMIC_YEAR("feeStructureAcademicYear_FeeModule_TextArray", "Fee Structure Academic Year", String.class),
    APPLIED_FEE_HEAD_DOC("appliedFeeHeadDoc_FeeModule_DocumentArray", "Applied Fee Head Doc", Document.class),


    // fee structure applicability fields
    FEE_STRUCTURE_QUOTA("feeStructureQuota_FeeModule_TextArray", "Fee Structure Quota", String.class),
    FEE_STRUCTURE_BATCH("feeStructureBatch_FeeModule_TextArray", "Fee Structure Batch", String.class),
    FEE_STRUCTURE_SESSION("feeStructureSession_FeeModule_IntArray", "Fee Structure Session", Integer.class),
    FEE_STRUCTURE_CATEGORY("feeStructureCategory_FeeModule_TextArray", "Fee Structure Category", String.class),
    FEE_STRUCTURE_CASTE("feeStructureCaste_FeeModule_TextArray", "Fee Structure Caste", String.class),
    FEE_STRUCTURE_ADDITIONAL_APPLICABILITY("feeStructureAdditionalApplicability_FeeModule_TextArray", "Fee Structure Additional Applicability", String.class),

    //fee category
    FEE_CATEGORY_CODE("feeCategoryCode_FeeModule_Text", "Fee Category Code", String.class),
    FEE_CATEGORY_NAME("feeCategoryName_FeeModule_Text", "Fee Category Name", String.class),
    FEE_CATEGORY_DESCRIPTION("feeCategoryDescription_FeeModule_Text", "Fee Category Description", String.class),

    // common
    ADVANCE_AMOUNT("advanceAmount_FeeModule_Long", "Advance Amount", Long.class),
    PAYABLE_AMOUNT("payableAmount_FeeModule_Double", "Payable Amount", Double.class),
    FEE_PAYMENT_MODE("feePaymentMode_FeeModule_Text", "Fee Payment Mode", String.class),

    // late fee rule
    LATE_FEE_RULE_OID("lateFeeRuleOid_FeeModule_ObjectId", "Late Fee Rule Object ID", Object.class),
    LATE_FEE_RULE_CODE("lateFeeRuleCode_FeeModule_Text", "Late Fee Rule Code", String.class),
    LATE_FEE_RULE_NAME("lateFeeRuleName_FeeModule_Text", "Late Fee Rule Name", String.class),
    LATE_FEE_RULE_DESCRIPTION("lateFeeRuleDescription_FeeModule_Text", "Late Fee Rule Description", String.class),
    LATE_FEE_RULE_DURATION("lateFeeRuleDuration_FeeModule_Int", "Late Fee Rule Duration", Integer.class),
    LATE_FEE_RULE_TYPE("lateFeeRuleType_FeeModule_Text", "Late Fee Rule Type", String.class),
    LATE_FEE_FEE_HEADS("lateFeeFeeHeads_FeeModule_DocumentArray", "Late Fee Fee Heads", Document.class),
    LATE_FEE_RULE_SCHEDULES("lateFeeRuleSchedules_FeeModule_DocumentArray", "Late Fee Rule Schedules", Document.class),
    LATE_FEE_RULE_SCHEDULE("lateFeeRuleSchedule_FeeModule_Int", "Late Fee Rule Schedule", Integer.class),
    LATE_FEE_RULE_SCHEDULE_UNIT_OF_TIME("lateFeeRuleScheduleUnitOfTime_FeeModule_Text", "Late Fee Rule Schedule Unit Of Time", String.class),
    LATE_FEE_RULE_SCHEDULE_VALUE_TYPE("lateFeeRuleScheduleValueType_FeeModule_Text", "Late Fee Rule Schedule Value Type", String.class),
    LATE_FEE_RULE_SCHEDULE_VALUE("lateFeeRuleScheduleValue_FeeModule_Int", "Late Fee Rule Schedule Value", Integer.class),
    DISABLE_ASSOCIATED_FEE_HEAD_AFTER_END_DATE("disableAssociatedFeeHeadAfterEndDate_FeeModule_Bool", "Disable Associated Fee Head After End Date", Boolean.class),
    PARENT_FEE_HEADS("parentFeeHeads_FeeModule_DocumentArray", "Parent Fee Heads", Document.class),
    PARENT_FEE_HEAD_CODE("parentFeeHeadCode_FeeModule_Text", "Parent Fee Head Code", String.class),
    PARENT_FEE_HEAD_NAME("parentFeeHeadName_FeeModule_Text", "Parent Fee Head Name", String.class),

    // late fee rule schedules
    LATE_FEE_RULE_SCHEDULE_RECORD("lateFeeRuleScheduleRecord_FeeModule_DocumentArray", "Late Fee Rule Schedule Record", Document.class),
    LATE_FEE_RULE_SCHEDULE_DAY("lateFeeRuleScheduleDay_FeeModule_Int", "Late Fee Rule Schedule Day", Integer.class),
    LATE_FEE_RULE_SCHEDULE_TYPE("lateFeeRuleScheduleType_FeeModule_Text", "Late Fee Rule Schedule Type", String.class),
    LATE_FEE_RULE_SCHEDULE_AMOUNT("lateFeeRuleScheduleAmount_FeeModule_Long", "Late Fee Rule Schedule Amount", Long.class),
    LATE_FEE_APPLIED_SCHEDULES("lateFeeAppliedSchedules_FeeModule_TextArray", "Late Fee Applied Schedules", String.class),
    LATE_FEE_APPLIED_DOCS("lateFeeAppliedDocs_FeeModule_DocumentArray", "Late Fee Applied Docs", Document.class),

    //Fee Collection
    FEE_COLLECTION_META_DATA("feeCollectionMetaData_FeeModule_Document", "Fee Collection Meta Data", Document.class),
    FEE_COLLECTED_DATE("feeCollectedDate_FeeModule_Date", "Fee Collected Date", Long.class),
    FEE_COLLECTION_REMARK("feeCollectionRemark_FeeModule_Text", "Fee Collection Remark", String.class),
    FEE_COLLECTED_BY_OID("feeCollectedByOid_FeeModule_ObjectId", "Fee Collected By Oid", ObjectId.class),
    FEE_COLLECTED_BY_NAME("feeCollectedByName_FeeModule_Text", "Fee Collected By Name", String.class),
    MODE_OF_FEE_COLLECTION("modeOfFeeCollection_FeeModule_Text", "Mode Of Fee Collection", String.class),
    FEE_COLLECTION_INSTRUMENT_DETAILS("feeCollectionInstrumentDetails_FeeModule_DocumentArray", "Fee Collection Instrument Details", Document.class),

    FEE_COLLECTED_FROM_BANK_NAME("feeCollectedFromBankName_FeeModule_Text", "Fee Collected From Bank Name", String.class),
    FEE_COLLECTION_MICR_NUMBER("feeCollectionMicrNumber_FeeModule_Text", "Fee Collection MICR Number", String.class),
    FEE_COLLECTED_INSTRUMENT_NUMBER("feeCollectedInstrumentNumber_FeeModule_Text", "Fee Collected Instrument Number", String.class),
    FEE_COLLECTED_INSTRUMENT_DATE("feeCollectedInstrumentDate_FeeModule_Date", "Fee Collected Instrument Date", Long.class),
    FEE_COLLECTED_AMOUNT("feeCollectedAmount_FeeModule_Double", "Fee Collected Amount", Double.class),

    //Fee Edit Search Keys
    FEE_EDIT_SEARCH_CRITERIA("feeEditSearchCriteria_FeeModule_Text", "Fee Edit Search Criteria", String.class),
    FEE_EDIT_SEARCH_VALUE("feeEditSearchValue_FeeModule_Text", "Fee Edit Search Value", String.class),


    //Fee Reversal
    FEE_PAYMENT_REVERSAL_REMARK("feePaymentReversalRemark_FeeModule_Text", "Fee Payment Reversal Remark", String.class),
    FEE_PAYMENT_REVERSED_DATE("feePaymentReversedDate_FeeModule_DateTime", "Fee Payment Reversed Date", Long.class),
    FEE_REVERSAL_TRIGGERED_BY("feeReversalTriggeredBy_FeeModule_ObjectId", "Fee Payment Reversal Triggered By", ObjectId.class),
    FEE_REVERSAL_TRIGGERED_BY_NAME("feeReversalTriggeredByName_FeeModule_Text", "Fee Reversal Triggered By Name", String.class),
    FEE_REVERSAL_TRIGGERED_BY_EMAIL("feeReversalTriggeredByEmail_FeeModule_Text", "Fee Reversal Triggered By Email", String.class),


    //Fee refund
    REFUND_REFERENCE_PAYMENT_ID("refundReferencePaymentId_FeeModule_Text", "Refund Reference Payment Id", String.class),

    REFUND_REFERENCE_TRANSACTION_ID("refundReferenceTransactionId_FeeModule_Text", "Refund Reference Transaction Id", String.class),
    LIST_OF_REFUNDED_FEE_HEADS("listOfRefundedFeeHeads_FeeModule_DocumentArray", "List of Refunded Fee Heads", Document.class),
    FEE_HEAD_REFUNDED_AMOUNT("feeHeadRefundedAmount_FeeModule_Double", "Fee Head Refunded Amount", Double.class),
    REFUND_REMARK("refundRemark_FeeModule_Text", "Refund Remark", String.class),
    FEE_REFUNDED_DATE("feeRefundedDate_FeeModule_DateTime", "Fee Refunded Date", Long.class),
    LIST_OF_INSTRUMENTS_USED_FOR_REFUND("listOfInstrumentsUsedForRefund_FeeModule_DocumentArray", "List of Instruments Used for refund", Document.class),
    REFUND_INSTRUMENT_DATE("refundInstrumentDate_FeeModule_Date", "Refund Instrument Date", Long.class),
    REFUND_INSTRUMENT_TYPE("refundInstrumentType_FeeModule_Text", "Refund Instrument Type", String.class),
    REFUND_INSTRUMENT_NUMBER("refundInstrumentNumber_FeeModule_Text", "Refund Instrument Number", String.class),
    REFUND_INSTRUMENT_AMOUNT("refundInstrumentAmount_FeeModule_Double", "Refund Instrument Number", Double.class),
    REFUND_INSTRUMENT_OTHER_DETAILS("refundInstrumentOtherDetails_FeeModule_Text", "Refund Instrument Other Details", String.class),
    REFUND_RECEIPT_NUMBER("refundReceiptNumber_FeeModule_Text", "Refund Receipt Number", String.class),
    FEE_REFUND_TRIGGERED_BY("feeRefundTriggeredBy_FeeModule_ObjectId", "Fee Refund Triggered By", ObjectId.class),
    FEE_REFUND_TRIGGERED_BY_NAME("feeRefundTriggeredByName_FeeModule_Text", "Fee Refund Triggered By Name", String.class),
    FEE_REFUND_TRIGGERED_BY_EMAIL("feeRefundTriggeredByEmail_FeeModule_Text", "Fee Refund Triggered By Email", String.class),

    AUTOMATED_REFUND_DETAILS("automatedRefundDetails_FeeModule_Document", "Automated Refund Details", Document.class),
    AUTOMATED_REFUND_ID("automatedRefundId_FeeModule_Text", "Automated Refund Id", String.class),


    //Keys for migration
    MIGRATED_FEE_HEAD_OID("migratedFeeHeadOid_FeeModule_ObjectId", "Migrated Fee Head Oid", ObjectId.class),
    MIGRATED_FEE_HEAD_RECORD_POSITION("migratedFeeHeadRecordPosition_FeeModule_Int", "Migrated Fee Head Record Position", Integer.class),


    ;


    private final String property;
    private final String label;
    private final Class dataType;
    private final int minLength;
    private final int maxLength;

    private FeeModuleKeysPBinder(String property, String label, Class dataType, int minLength, int maxLength) {
        this.property = property;
        this.label = label;
        this.dataType = dataType;
        this.minLength = minLength;
        this.maxLength = maxLength;
    }

    private FeeModuleKeysPBinder(String property, String label, Class dataType) {
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

    // $FF: synthetic method
    private static FeeModuleKeysPBinder[] $values() {
        return FeeModuleKeysPBinder.class.getEnumConstants();
    }
}
