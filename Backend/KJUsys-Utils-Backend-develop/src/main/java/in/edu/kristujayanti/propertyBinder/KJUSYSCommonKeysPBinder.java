package in.edu.kristujayanti.propertyBinder;

import org.bson.Document;
import org.bson.types.ObjectId;
import software.amazon.awssdk.services.s3.endpoints.internal.Value;

import java.util.List;

public enum KJUSYSCommonKeysPBinder implements KJUSYSPropertyBinder {

    JWT_EMAIL_CLAIM("email", "User ID", String.class),
    JWT_USER_ROLES_CLAIM("roles", "Roles", String.class),
    OID("oid_KJUSYSCommon_ObjectId", "Object ID", String.class),
    OIDS("oids_KJUSYSCommon_ObjectIdArray", "Object IDs", ObjectId.class),
    CREATED_ON("createdOn_KJUSYSCommon_DateTime", "Created On", Long.class),
    OTP("otp_KJUSYSCommon_Text", "OTP", String.class),
    ENTITY_ID("entityId_KJUSYSCommon_Long", "Entity ID", Long.class),
    PROGRAM_NAME("programName_KJUSYSCommon_Text", "Program Name", String.class),
    START_DAY("startDay_KJUSYSCommon_Int", "Start Day", Integer.class),
    START_MONTH("startMonth_KJUSYSCommon_Text", "Start Month", String.class),
    AWARD("award_KJUSYSCommon_Text", "Award", String.class),
    PROGRAM_CODE("programCode_KJUSYSCommon_Text", "Program Code", String.class),
    PROGRAM_DISPLAY_NAME("programDisplayName_KJUSYSCommon_Text", "Program Display Name", String.class),
    DURATION("duration_KJUSYSCommon_Int", "Duration", Integer.class),
    DURATION_UNIT("durationUnit_KJUSYSCommon_Text", "Duration Unit", String.class),
    EDUCATION_TYPE("educationType_KJUSYSCommon_Text", "Education Type", String.class),
    FEE_CATEGORY("feeCategory_KJUSYSCommon_Text", "Fee Category", String.class),
    INSTALLMENT("installment_KJUSYSCommon_Int", "Installment", Integer.class),
    FEE_HEAD_CODE("feeHeadCode_KJUSYSCommon_Text", "Fee Head Code", String.class),
    START_DATE("startDate_KJUSYSCommon_Date", "Start Date", Long.class),
    FEE_AMOUNT("feeAmount_KJUSYSCommon_Double", "Fee Amount", Double.class),
    CURRENCY("currency_KJUSYSCommon_Text", "Currency", String.class),
    SCHEDULE_TYPE("scheduleType_KJUSYSCommon_Text", "Schedule Type", String.class),
    IS_LATERAL("isLateral_KJUSYSCommon_Text", "Is Lateral", String.class),
    LATE_FEE("lateFee_KJUSYSCommon_Text", "Late Fee", String.class),
    FOR_ADMISSION("forAdmission_KJUSYSCommon_Text", "For Admission", String.class),
    FOR_ENROLLED_STUDENT("forEnrolledStudent_KJUSYSCommon_Text", "For Enrolled Student", String.class),
    PAYMENT_STATUS("paymentStatus_KJUSYSCommon_Bool", "Payment Status", Boolean.class),
    INSTITUTION_NAME("institutionName_KJUSYSCommon_Text", "Institution Name", String.class),
    INSTITUTION_ID("institutionId_KJUSYSCommon_Int", "Institution ID", Integer.class),
    INSTITUTION_STATUS("institutionStatus_KJUSYSCommon_Bool", "Institution Status", Boolean.class),
    EDUCATION_CATEGORY("educationCategory_KJUSYSCommon_DocumentArray", "Education Category", Document.class),
    EDUCATION_TYPE_ID("educationTypeId_KJUSYSCommon_Int", "Education Type ID", Integer.class),
    EDUCATION_TYPE_STATUS("educationTypeStatus_KJUSYSCommon_Bool", "Education Type Status", Boolean.class),

    BATCH_CODE("batchCode_KJUSYSCommon_Text", "Batch Code", String.class),
    BATCH_NAME("batchName_KJUSYSCommon_Text", "Batch Name", String.class),
    ACADEMIC_YEAR("academicYear_KJUSYSCommon_Text", "Academic Year", String.class),
    BATCH_IS_ASSIGNED("batchIsAssigned_KJUSYSCommon_Bool", "Is Assigned", Boolean.class),

    END_DATE("endDate_KJUSYSCommon_Date", "End Date", Long.class),
    IS_ACTIVE("isActive_KJUSYSCommon_Bool", "Is Active ", Boolean.class),

    // ADMIN DB UPDATE ACTIVITY LOGS
    TIMESTAMP("timestamp_KJUSYSCommon_DateTime", "Timestamp", Long.class),
    PERFORMED_BY("performedBy_KJUSYSCommon_Text", "Performed By", String.class),
    UPDATED_ENTITY("updatedEntity_KJUSYSCommon_Text", "Updated Entity", String.class),
    UPDATED_FIELD("updatedField_KJUSYSCommon_Text", "Updated Field", String.class),
    UPDATED_FIELDS("updatedFields_KJUSYSCommon_Document", "Updated Fields", Document.class),
    OPERATION_TYPE("operationType_KJUSYSCommon_Text", "Operation Type", String.class),
    OLD_VALUE("oldValue_KJUSYSCommon_Text", "Old Value", String.class),
    NEW_VALUE("newValue_KJUSYSCommon_Text", "New Value", String.class),

    UPLOADED_FILE_PATH("uploadedFilePath_KJUSYSCommon_Text", "Uploaded File Path", String.class),
    SECTION_NAME("sectionName_KJUSYSCommon_Text", "Section Name", String.class),
    ADMISSION_QUOTA("admissionQuota_KJUSYSCommon_Text", "Admission Quota", String.class),

    SEMESTER("semester_KJUSYSCommon_Int", "Semester", Integer.class),

    SEAT_AVAILABILITY("seatAvailability_KJUSYSCommon_Int", "Seats", Integer.class),


    LIST_OF_APPLICANTS("listOfApplicants_KJUSYSCommon_DocumentArray", "List Of Applicants", Document.class),

    EMPLOYEES_LIST("employeesList_KJUSYSCommon_TextArray", "Employees List", String.class),

    UPDATED_ON("updatedOn_KJUSYSCommon_DateTime", "Updated On", Long.class),
    VERSION_NUMBER("versionNumber_KJUSYSCommon_Int", "Version Number", Integer.class),
    CREATED_BY("createdBy_KJUSYSCommon_Text", "Created By", String.class),
        UPDATED_BY("updatedBy_KJUSYSCommon_Text", "Updated By", String.class),
    UPDATED_AT("updatedAt_KJUSYSCommon_DateTime", "Updated At", Long.class),
    MODIFIED_AT("modifiedAt_KJUSYSCommon_DateTime", "Modified At", Long.class),
    LAST_MODIFIED_AT("lastModifiedAt_KJUSYSCommon_DateTime", "Last Modified At", Long.class),
    MODIFIED_TO("modifiedTo_KJUSYSCommon_Text", "Modified To", String.class),
    MODIFIED_BY("modifiedBy_KJUSYSCommon_Text", "Modified By", String.class),
    MODIFIED_USER_INFO("modifiedUserInfo_KJUSYSCommon_Text", "Modified User Info", String.class),
    FROM_DATE("fromDate_KJUSYSCommon_Text", "From Date", String.class),
    TO_DATE("toDate_KJUSYSCommon_Text", "To Date", String.class),
    DISCOUNT_GIVEN("discountGiven_KJUSYSCommon_Double", "Discount Given", Double.class),
    LAST_UPDATED_ON("lastUpdatedOn_KJUSYSCommon_DateTime", "Last Updated On", Long.class),
    LAST_UPDATED_BY("lastUpdatedBy_KJUSYSCommon_Text", "Last Updated By", String.class),
    NOTIFY_WITH_EMAIL("notifyWithEmail_KJUSYSCommon_Bool", "Notify With Email", Boolean.class),
    AUTH_OBJECT_ID("authObjectId_KJUSYSCommon_ObjectId", "Auth Object Id", ObjectId.class),


    // academic setting
    AWARD_OID("awardOid_KJUSYSCommon_ObjectId", "Academic OID", String.class),
    PROGRAMMES("programmes_KJUSYSCommon_DocumentArray", "Programmes", Document.class),
    INTAKE("intake_KJUSYSCommon_Text", "Intake", String.class),
    INTAKE_CODE("intakeCode_KJUSYSCommon_Text", "Intake Code", String.class),
    INTAKE_DATE("intakeDate_KJUSYSCommon_Date", "Intake Date", Long.class),
    INTAKES("intakes_KJUSYSCommon_DocumentArray", "Intakes", Document.class),
    BATCH_TYPE("batchType_KJUSYSCommon_Text", "Batch Type", String.class),

    EXECUTION_PATTERN("executionPattern_KJUSYSCommon_Text", "Execution Pattern", String.class),
    NO_OF_SESSION("noOfSession_KJUSYSCommon_Int", "No Of Session", Integer.class),
    DURATION_TYPE("durationType_KJUSYSCommon_Text", "Duration Type", String.class),
    NO_OF_CLASSES("noOfClasses_KJUSYSCommon_Int", "No Of Classes", Integer.class),
    YEAR_OF_INTRODUCTION("yearOfIntroduction_KJUSYSCommon_Text", "Duration Type", String.class),

    CLASSES("classes_KJUSYSCommon_TextArray", "Classes", String.class),

    IS_EDITABLE("isEditable_KJUSYSCommon_Bool", "Is Editable", Boolean.class),
    REMARKS("remarks_KJUSYSCommon_Text","Remarks", String.class),
    ID("id_KJUSYSCommon_Text","Id",String.class),
    TYPE("type_KJUSYSCommon_Text","Type",String.class),

    STREAM("stream_KJUSYSCommon_TextArray", "Stream", String.class),
    STREAM_TYPE("streamType_KJUSYSCommon_Text", "Stream Type", String.class),
    STREAM_NAME("streamName_KJUSYSCommon_Text", "Stream Name", String.class),
    STREAM_OIDS("streamOids_KJUSYSCommon_ObjectIdArray", "Stream Oids", ObjectId.class),
    STREAM_ID("streamId_KJUSYSCommon_ObjectId", "Stream Id", ObjectId.class)

    ;


    private final String property;
    private final String label;
    private final Class<?> dataType;
    private final int minLength;
    private final int maxLength;

    private KJUSYSCommonKeysPBinder(String property, String label, Class<?> dataType, int minLength, int maxLength) {
        this.property = property;
        this.label = label;
        this.dataType = dataType;
        this.minLength = minLength;
        this.maxLength = maxLength;
    }

    private KJUSYSCommonKeysPBinder(String property, String label, Class<?> dataType) {
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

    // New method to get label by property name
    public static String getLabelByProperty(String propertyName) {
        for (KJUSYSCommonKeysPBinder binder : values()) {
            if (binder.property.equals(propertyName)) {
                return binder.label;
            }
        }
        return null;
    }

    // New method to get property name by label
    public static String getPropertyByLabel(String label) {
        for (KJUSYSCommonKeysPBinder binder : values()) {
            if (binder.label.equals(label)) {
                return binder.property;
            }
        }
        return null;
    }

    // $FF: synthetic method
    private static KJUSYSCommonKeysPBinder[] $values() {
        return KJUSYSCommonKeysPBinder.class.getEnumConstants();
    }
}