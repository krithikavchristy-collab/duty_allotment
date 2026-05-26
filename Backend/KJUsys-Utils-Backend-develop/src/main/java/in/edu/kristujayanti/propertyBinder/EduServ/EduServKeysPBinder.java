package in.edu.kristujayanti.propertyBinder.EduServ;

import in.edu.kristujayanti.propertyBinder.KJUSYSPropertyBinder;
import org.bson.Document;
import org.bson.types.ObjectId;

import java.util.List;

public enum EduServKeysPBinder  implements KJUSYSPropertyBinder{


//    EMPLOYEE_OLD_PASSWORD("employeeOldPassword_HRCommon_Text", "Employee Old Password", String.class)

SELECTED_SERVICE_FIELDS_ARRAY("selectedServiceFieldsArray_EduServ_TextArray","selected service fields", String.class),
    EDU_SERV_REQUESTED_SERVICE_NAME_1("eduServRequestedServiceName1_EduServ_Text"," Edu Serv Requested Service 1 Name",String.class),
    EDU_SERV_REQUESTED_SERVICE_NAME_2("eduServRequestedServiceName2_EduServ_Text"," Edu Serv Requested Service 2 Name",String.class),
    EDU_SERV_REQUESTED_SERVICE_NAME_3("eduServRequestedServiceName3_EduServ_Text"," Edu Serv Requested Service 3 Name",String.class),
    EDU_SERV_REQUESTED_SERVICE_NAME_4("eduServRequestedServiceName4_EduServ_Text"," Edu Serv Requested Service 4 Name",String.class),
    SERVICE_REQUEST_LETTER_FILE_UPLOAD("serviceRequestLetterFileUpload_EduServ_File","Service Request Letter File Upload",String.class),
    SERVICE_REQUEST_SPECIFIED_DOCUMENT_1("serviceRequestSpecifiedDocument1_EduServ_File","Service request Specified Document 1", String.class),
    SERVICE_REQUEST_SPECIFIED_DOCUMENT_2("serviceRequestSpecifiedDocument2_EduServ_File","Service request Specified Document 2", String.class),
    SERVICE_REQUEST_SPECIFIED_DOCUMENT_3("serviceRequestSpecifiedDocument3_EduServ_File","Service request Specified Document 3", String.class),
    SERVICE_REQUEST_SPECIFIED_DOCUMENT_4("serviceRequestSpecifiedDocument4_EduServ_File","Service request Specified Document 4", String.class),
    SERVICE_REQUEST_SPECIFIED_DOCUMENT_5("serviceRequestSpecifiedDocument5_EduServ_File","Service request Specified Document 5", String.class),
//    SERVICE_REQUEST_SPECIFIED_DOCUMENT_2_FILE("serviceRequestSpecifiedDocumentFile_EduServ_File","Service request Specified file 2", String.class),
    SERVICE_ID("serviceId_EduServ_Text","Service ID",String.class),
    SERVICE_OID("serviceId_EduServ_ObjectId","Service ID", ObjectId.class), //tbd
    SERVICE_REQUESTED_ON("serviceRequestedOn_EduServ_Datetime","Service requested Date",Long.class),
    SERVICE_CURRENT_STATUS("serviceCurrentStatus_EduServ_Text","Service Current Status",String.class),
    SERVICE_STATUS_UPDATED_ON("serviceStatusUpdatedOn_EduServ_Datetime","Service  Status Updated On ", Long.class),
    SERVICE_COLLECTED_BY("serviceCollectedBy_EduServ_Text","Service Collected By", String.class),
    SERVICE_COLLECTOR_NAME("serviceCollectorName_EduServ_Text","Service Collector Name", String.class),
    SERVICE_COLLECTOR_ID_TYPE("serviceCollectorIdType_EduServ_Text","Service Collector Id Type", String.class),
    SERVICE_COLLECTOR_ID_NUMBER("serviceCollectorIdNumber_EduServ_Text","Service Collector Id Number",String.class),
    SERVICE_SPECIFIED_DOCUMENTS_ARRAY("serviceSpecifiedDocumentsArray_EduServ_DocumentArray","Specified Documents", Document.class),
    SERVICE_COMMENTS("serviceComments_EduServ_Text","Service Comments",String.class),
    SERVICE_COLLECTED_COMMENTS("serviceCollectedComments_EduServ_Text","Service Collected Comments", String.class),
    SERVICE_REQUEST_FROM_DATE("serviceRequestFromDate_EduServ_Text","Service Request From",String.class),
    SERVICE_REQUEST_TO_DATE("serviceRequestToDate_EduServ_Text","Service Request To Date",String.class),


    ///
    SERVICE_REQUESTER_STUDENT_EMAIL("serviceRequesterStudentEmail_EduServ_Text", "Service Requester Student Email", String.class),
    SERVICE_REQUESTER_NAME("serviceRequesterName_EduServ_Text", "Service Requester Name", String.class),
    SERVICE_REQUESTER_PROGRAMME_NAME("serviceRequesterProgrammeName_EduServ_Text", "Service Requester Programme Name", String.class),
    SERVICE_REQUESTER_ROLL_NUMBER("serviceRequesterRollNumber_EduServ_Text", "Service Requester Roll Number", String.class),
    SERVICE_REQUESTER_CONTACT_NUMBER("serviceRequesterContactNumber_EduServ_Text", "Service Requester Contact Number", String.class),
    SERVICE_REQUESTER_PERSONAL_EMAIL("serviceRequesterPersonalEmail_EduServ_Text", "Service Requester Personal Email", String.class),
    SERVICE_REQUEST_LETTER_FILE("serviceRequestLetterFile_EduServ_File", "Service Request Letter File", String.class),
    SELECTED_CERTIFICATE_SERVICE_COUNT("selectedCertificateServiceCount_EduServ_Int", "Selected Certificate Service Count", Integer.class),
    SERVICE_REQUESTER_OID("serviceRequesterOid_EduServ_ObjectId", "Service Requester OID", ObjectId.class),
    SERVICE_REQUESTER_BATCH("serviceRequesterBatch_EduServ_Text", "Service Requester Batch", String.class),

    CERTIFICATE_SERVICE_NAME("certificateServiceName_EduServ_Text", "Certificate Service Name", String.class),
    CERTIFICATE_SERVICE_OID("certificateServiceOid_EduServ_ObjectId", "Certificate Service OID", ObjectId.class),
    CERTIFICATE_SERVICE_ID("certificateServiceId_EduServ_Text", "Certificate Service ID", String.class),
    CERTIFICATE_SERVICE_REQUESTED_ON("certificateServiceRequestedOn_EduServ_DateTime", "Certificate Service Requested On", Long.class),
    CERTIFICATE_SERVICE_CURRENT_STATUS("certificateServiceCurrentStatus_EduServ_Text", "Certificate Service Current Status", String.class),
    CERTIFICATE_SERVICE_STATUS_UPDATED_ON("certificateServiceStatusUpdatedOn_EduServ_DateTime", "Certificate Service Status Updated On", Long.class),
    CERTIFICATE_SERVICE_STATUS_UPDATED_BY("certificateServiceStatusUpdatedBy_EduServ_Text", "Certificate Service Status Updated By", String.class),
    CERTIFICATE_SERVICE_CREATED_BY("certificateServiceCreatedBy_EduServ_Text", "Certificate Service Created By", String.class),
    CERTIFICATE_SERVICE_HAVE_SUPPORT_DOCS("certificateServiceHaveSupportDocs_EduServ_Bool", "Certificate Service Have Documents", Boolean.class),
    CERTIFICATE_SERVICE_SUPPORT_DOCS_OID_ARRAY("certificateServiceSupportDocsOidArray_EduServ_ObjectIdArray", "Certificate Service Support Docs Oid",ObjectId.class),
    CERTIFICATE_SERVICE_REQUEST_DOCUMENT_ARRAY("certificateServiceRequestDocumentArray_EduServ_DocumentArray", "Certificate Service Request Document Array", Document.class),
    CERTIFICATE_REQUEST_OID("certificateRequestOid_EduServ_ObjectId", "Certificate Request OID", ObjectId.class),
    CERTIFICATE_REQUEST_FILE("certificateRequestFile_EduServ_File", "Certificate Request File", String.class),

    CERTIFICATE_SERVICE_COLLECTED_BY("certificateServiceCollectedBy_EduServ_Text", "Certificate Service Collected By", String.class),
    CERTIFICATE_SERVICE_COLLECTOR_NAME("certificateServiceCollectorName_EduServ_Text", "Certificate Service Collector Name", String.class),
    CERTIFICATE_SERVICE_COLLECTOR_ID_TYPE("certificateServiceCollectorIdType_EduServ_Text", "Certificate Service Collector ID Type", String.class),
    CERTIFICATE_SERVICE_COLLECTOR_ID_NUMBER("certificateServiceCollectorIdNumber_EduServ_Text", "Certificate Service Collector ID Number", String.class),
    CERTIFICATE_SERVICE_SPECIFIED_DOCUMENTS_ARRAY("certificateServiceSpecifiedDocumentsArray_EduServ_DocumentArray", "Certificate Service Specified Documents", Document.class),
    CERTIFICATE_SERVICE_COMMENTS("certificateServiceComments_EduServ_Text", "Certificate Service Comments", String.class),
    CERTIFICATE_SERVICE_COLLECTED_COMMENTS("certificateServiceCollectedComments_EduServ_Text", "Certificate Service Collected Comments", String.class),
    CERTIFICATE_SERVICE_REQUEST_FROM_DATE("certificateServiceRequestFromDate_EduServ_Text", "Certificate Service Request From", String.class),
    CERTIFICATE_SERVICE_REQUEST_TO_DATE("certificateServiceRequestToDate_EduServ_Text", "Certificate Service Request To Date", String.class),
    CERTIFICATE_SERVICE_RESOLVED_ON("certificateServiceResolvedOn_EduServ_DateTime", "Certificate Service Resolved On", Long.class),
    CERTIFICATE_SERVICE_REMARK("certificateServiceRemark_EduServ_Text", "Certificate Service Remark", String.class),
    CERTIFICATE_SERVICE_COLLECTED_UPDATED_AT("certificateServiceCollectedUpdatedAt_EduServ_DateTime", "Certificate Service Collected Updated At", Long.class),
    CERTIFICATE_SERVICE_COLLECTED_UPDATED_BY("certificateServiceCollectedUpdatedBy_EduServ_Text", "Certificate Service Collected Updated By", String.class),



//    supportDocument
    SUPPORT_DOC_FILE("supportDocFile_EduServ_File", "Support Document File", String.class),
    SUPPORT_DOC_NAME("supportDocName_EduServ_Text", "Support Document Name", String.class),
    SUPPORT_DOC_OID("supportDocOid_EduServ_ObjectId", "Support Document OID", ObjectId.class),
    SUPPORT_DOC_ID("supportDocId_EduServ_Text", "Support Document ID", String.class),
    SUPPORT_DOC_CREATED_ON("supportDocCreatedOn_EduServ_DateTime", "Support Document Created On", Long.class),
    SUPPORT_DOC_CREATED_BY("supportDocCreatedBy_EduServ_Text", "Support Document Created By", String.class),
    SUPPORT_DOC_UPDATED_ON("supportDocUpdatedOn_EduServ_DateTime", "Support Document Updated On", Long.class),
    SUPPORT_DOC_UPDATED_BY("supportDocUpdatedBy_EduServ_Text", "Support Document Updated By", String.class),
    PARENT_SERVICE_REQUEST_ID("parentServiceRequestId_EduServ_Text", "Parent Service Request ID", String.class),
    CHILD_SERVICE_REQUEST_ID("childServiceRequestId_EduServ_Text", "Child Service Request ID", String.class),







    ;

    private final String property;
    private final String label;
    private final Class dataType;
    private final int minLength;
    private final int maxLength;

    private EduServKeysPBinder(String property, String label, Class dataType, int minLength, int maxLength) {
        this.property = property;
        this.label = label;
        this.dataType = dataType;
        this.minLength = minLength;
        this.maxLength = maxLength;
    }

    private EduServKeysPBinder(String property, String label, Class dataType) {
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
    private static in.edu.kristujayanti.propertyBinder.EduServ.EduServKeysPBinder[] $values() {
        return in.edu.kristujayanti.propertyBinder.EduServ.EduServKeysPBinder.class.getEnumConstants();
    }
}
