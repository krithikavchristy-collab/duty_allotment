package in.edu.kristujayanti.collectionNames;

public enum FeeModuleCNBinder implements KJUSYSCNBinder {
    FEE_GROUP_COLLECTION("feeGroupCollection"),
    BANK_ACCOUNT_COLLECTION("bankAccountCollection"),
    FEE_STRUCTURE_COLLECTION("feeStructureCollection"),
    LATE_FEE_RULE_COLLECTION("lateFeeRuleCollection"),
    TRUST_COLLECTION("trustCollection"),
    FEE_CATEGORY_COLLECTION("feeCategoryCollection"),
    FEE_EDIT_LOG_DETAILS("feeEditLogDetails"),
    FEE_COLLECTION_DETAILS("feeCollectionDetails"),
    FEE_STRUCTURE_VERSION_COLLECTION("feeStructureVersion"),

    APPLICANT_FEE_COLLECTION("applicantFeeCollection"),
    STUDENT_FEE_COLLECTION("studentFeeCollection"),

    //Tally Integration
    TALLY_DEMAND_COLLECTION("tally_demand_collection"),
    TALLY_COLLECTIONS_COLLECTION("tally_collections_collection"),
    TALLY_PAYMENTS_COLLECTION("tally_payments_collection"),
    TALLY_ACKNOWLEDGEMENT_COLLECTION("tally_acknowledgement_collection"),

    ;

    private final String collectionName;

    private FeeModuleCNBinder(String collectionName) {
        this.collectionName = collectionName;
    }

    public String getCollectionName() {
        return this.collectionName;
    }

    // $FF: synthetic method
    private static FeeModuleCNBinder[] $values() {
        return FeeModuleCNBinder.class.getEnumConstants();
    }




}
