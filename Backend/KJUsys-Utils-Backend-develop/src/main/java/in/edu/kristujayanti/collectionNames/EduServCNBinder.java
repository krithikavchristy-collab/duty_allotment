package in.edu.kristujayanti.collectionNames;

public enum EduServCNBinder implements KJUSYSCNBinder {

    STUDENT_DOCUMENTS("student_documents"),
    STUDENT_DOCUMENT_GROUPS("student_document_groups"),
    DOCUMENT_COLLECTION_LOGS("document_collection_logs"),
    EDU_SERV_REQUEST_COLLECTION("eduServeRequestCollection"),
    ID_CARD_TEMPLATES_COLLECTION("id_card_templates"),
    ID_CARD_QUEUE_COLLECTION("id_card_queue"),
    TEMPLATE_BATCH_MAPPING_COLLECTION("template_batch_mapping"),
    STUDENT_ID_CARD_DETAILS_COLLECTION("student_id_card_details"),
    CERTIFICATE_REQUEST_USER_PROFILE_COLLECTION("certificate_request_user_profile"),
    CERTIFICATE_REQUESTS_COLLECTION("certificate_requests"),
    SUPPORT_DOCS_COLLECTION("certificate_service_support_docs"),
    CERTIFICATE_SERVICES_COLLECTION("certificate_services")

    ;

    private final String collectionName;

    private EduServCNBinder(String collectionName) {
        this.collectionName = collectionName;
    }

    public String getCollectionName() {
        return this.collectionName;
    }

    // $FF: synthetic method
    private static EduServCNBinder[] $values() {
        return EduServCNBinder.class.getEnumConstants();
    }


}
