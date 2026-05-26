package in.edu.kristujayanti.propertyBinder.EduServ;

import in.edu.kristujayanti.propertyBinder.KJUSYSPropertyBinder;
import org.bson.Document;
import org.bson.types.ObjectId;

public enum DocumentCollectionKeysPBinder implements KJUSYSPropertyBinder {

    STUDENT_DOCUMENTS("studentDocuments_DocumentCollection_DocumentArray", "Student Documents", Document.class),
    DOCUMENT_GROUP_ID("documentGroupId_DocumentCollection_ObjectId", "Document Group Id", ObjectId.class),

    // DOCUMENT DETAILS
    DOCUMENT_ID("documentId_DocumentCollection_Text", "Document Id", String.class),
    DOCUMENT_ORDER_INDEX("documentOrderIndex_DocumentCollection_Int", "Document Order Index", Integer.class),
    DOCUMENT_NAME("documentName_DocumentCollection_Text", "Document Name", String.class),
    DOCUMENT_EXTENSION("documentExtension_DocumentCollection_Text", "Document Extension", String.class),
    IS_EFORM_DOCUMENT("isEformDocument_DocumentCollection_Bool", "Is Eform Document", Boolean.class),
    EFORM_STORAGE_KEY("eformStorageKey_DocumentCollection_Text", "Eform Storage Key", String.class),
    DOCUMENT_IS_MANDATORY("documentIsMandatory_DocumentCollection_Bool", "Document Is Mandatory", boolean.class),
    DOCUMENT_NOT_APPLICABLE("documentNotApplicable_DocumentCollection_Bool", "Document Not Applicable", boolean.class),
    DOCUMENT_IS_COLLECTED("documentIsCollected_DocumentCollection_Bool", "Document Is Collected", boolean.class),
    DOCUMENT_COLLECTED_BY("documentCollectedBy_DocumentCollection_Text", "Document Collected By", String.class),
    DOCUMENT_ISSUED_BY("documentIssuedBy_DocumentCollection_Text", "Document Issued By", String.class),
    DOCUMENT_RETURNED_BY("documentReturnedBy_DocumentCollection_Text", "Document Returned By", String.class),
    IS_ADDITIONAL_DOCUMENT("isAdditionalDocument_DocumentCollection_Bool", "Is Additional Document", boolean.class),
    IS_EFORM_UPDATED("isEformUpdated_DocumentCollection_Bool", "Is Eform Updated", boolean.class),
    CREATED_AT("createdAt_DocumentCollection_DateTime", "Created At", Long.class),
    DOCUMENT_REMARK("documentRemark_DocumentCollection_Text", "Document Remark", String.class),
    UPLOADED_DOCUMENT("uploadedDocument_DocumentCollection_File", "Uploaded Document", String.class),
    IS_DOCUMENT_VERIFIED("isDocumentVerified_DocumentCollection_Bool", "Is Document Verified", Boolean.class),
    IS_DOCUMENT_ISSUED("isDocumentIssued_DocumentCollection_Bool", "Is Document Issued", Boolean.class),
    DOCUMENT_ISSUED_TIMESTAMP("documentIssuedTimestamp_DocumentCollection_DateTime", "Document Issued Timestamp", Long.class),
    DOCUMENT_RETURNED_TIMESTAMP("documentReturnedTimestamp_DocumentCollection_DateTime", "Document Returned Timestamp", Long.class),
    DOCUMENT_COLLECTED_TIMESTAMP("documentCollectedTimestamp_DocumentCollection_DateTime", "Document Collected Timestamp", Long.class),
    DOCUMENT_RETURN_DATE("documentReturnDate_DocumentCollection_Date", "Document Return Date", Long.class),
    DOCUMENT_RETURNED_AFTER_APPROVAL("documentReturnedAfterApproval_DocumentCollection_Bool", "Document Returned After Approval", boolean.class),
    DOCUMENT_RETURNED_AFTER_APPROVAL_DATE("documentReturnedAfterApprovalDate_DocumentCollection_Date", "Document Returned After Approval Date", long.class),

    // DOCUMENT GROUPS
    DOCUMENT_GROUP_NAME("documentGroupName_DocumentCollection_Text", "Document Group Name", String.class),
    LAST_SUBMISSION_DATE("lastSubmissionDate_DocumentCollection_Date", "Last Submission Date", Long.class),
    ADMISSION_QUOTA_LIST("admissionQuotaList_DocumentCollection_TextArray", "Admission Quota List", String.class),
    EDUCATION_BATCH_LIST("educationBatchList_DocumentCollection_TextArray", "Education Batch List", String.class),
    EDUCATION_SESSION_LIST("educationSessionList_DocumentCollection_IntArray", "Education Session List", Integer.class),
    CASTE_CATEGORY_LIST("casteCategoryList_DocumentCollection_TextArray", "Caste Category List", String.class),
    SUB_CASTE_CATEGORY_LIST("subCasteCategoryList_DocumentCollection_TextArray", "Sub Caste Category List", String.class),
    FEE_CATEGORY_LIST("feeCategoryList_DocumentCollection_TextArray", "Fee Category List", String.class),
    DOCUMENT_LIST("documentList_DocumentCollection_DocumentArray", "Document List", Document.class),

    // DOCUMENT COLLECTION STATUS
    IS_DOCUMENT_COLLECTION_COMPLETE("isDocumentCollectionComplete_DocumentCollection_Bool", "Is Document Collection Complete", Boolean.class),
    DOCUMENT_COLLECTION_STATUS("documentCollectionStatus_DocumentCollection_Text", "Document Collection Status", String.class),

    // DIGI_LOCKER DOCUMENT
    IS_EQUIVALENCY_DOCUMENT_ALLOWED("isEquivalencyDocumentAllowed_DocumentCollection_Bool", "Is Equivalency Document Allowed", Boolean.class),
    IS_EQUIVALENCY_DOCUMENT("isEquivalencyDocument_DocumentCollection_Bool", "Is Equivalency Document", Boolean.class),

    // ADDITIONAL DOCUMENTS
    ADDITIONAL_DOCUMENTS("additionalDocuments_DocumentCollection_DocumentArray", "Additional Documents", Document.class),

    // REPORT FILTERS
    CANDIDATE_ACADEMIC_YEARS("candidateAcademicYears_DocumentCollection_TextArray", "Candidate Academic Years", String.class),
    CANDIDATE_BATCHES("candidateBatches_DocumentCollection_TextArray", "Candidate Batches", String.class),
    CANDIDATE_DOCUMENTS("candidateDocuments_DocumentCollection_TextArray", "Candidate Documents", String.class),
    ;


    private final String property;
    private final String label;
    private final Class<?> dataType;
    private final int minLength;
    private final int maxLength;

    private DocumentCollectionKeysPBinder(String property, String label, Class<?> dataType, int minLength, int maxLength) {
        this.property = property;
        this.label = label;
        this.dataType = dataType;
        this.minLength = minLength;
        this.maxLength = maxLength;
    }

    private DocumentCollectionKeysPBinder(String property, String label, Class<?> dataType) {
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

    private static DocumentCollectionKeysPBinder[] $values() {
        return (DocumentCollectionKeysPBinder[]) DocumentCollectionKeysPBinder.class.getEnumConstants();
    }


}
