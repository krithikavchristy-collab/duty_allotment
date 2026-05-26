package in.edu.kristujayanti.collectionNames;

public enum EformCNBinder implements KJUSYSCNBinder{

    APPLICANT_PROFILE_COLLECTION("applicant"),
    APPLICATION_NUMBER_COLLECTION("applicationNumber"),
    FORM_BUILDER_COLLECTION("formBuilder"),
    ADMISSION_DASHBOARD_SNAPSHOT_COLLECTION("admissionDashboardSnapshotCollection"),
    BATCH_DETAILS_COLLECTION("batch_details"),
    INSTITUTIONAL_DETAILS("institutional_details"),
    PROGRAMME_CATEGORIES("programme_categories"),
    SCRUTINY_STAFF_LOG("scrutinyStaffLog"),
    QUOTA_DETAILS_COLLECTION("quotaDetails"),
    APPLICATION_SEQUENCE_COLLECTION("applicationSequenceNumberCollection"),
    CATEGORY_DETAILS_COLLECTION("categoryDetails"),
    PROGRAMME_GROUPS_FILTERS_COLLECTION("programmeGroupsFiltersCollection"),
    PARENT_PROGRAMME_GROUPS_FILTERS_COLLECTION("parentProgrammeGroupsFiltersCollection"),
    CASTE_DETAILS_COLLECTION("casteDetails"),
    FEE_EXTENSION_REQUEST_COLLECTION("feeExtensionRequestsDetails"),
    PHD_ENTRANCE_EXAM_COLLECTION("phdEntranceExamCollection");

    ;



    private final String collectionName;

    private EformCNBinder(String collectionName) {
        this.collectionName = collectionName;
    }

    public String getCollectionName() {
        return this.collectionName;
    }

    // $FF: synthetic method
    private static EformCNBinder[] $values() {
        return EformCNBinder.class.getEnumConstants();
    }




}
