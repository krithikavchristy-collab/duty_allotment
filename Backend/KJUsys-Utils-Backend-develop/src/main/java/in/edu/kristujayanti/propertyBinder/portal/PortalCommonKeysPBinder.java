package in.edu.kristujayanti.propertyBinder.portal;

import in.edu.kristujayanti.propertyBinder.KJUSYSPropertyBinder;
import org.bson.Document;
import org.bson.types.ObjectId;

import java.util.List;

public enum PortalCommonKeysPBinder implements KJUSYSPropertyBinder {




    //programme
    PROGRAMME_OID("programmeOid_Portal_ObjectId","Programme Object id",ObjectId.class),
    PROGRAMME_TITLE("programmeTitle_Portal_Text","Title",String.class),
    PROGRAMME_DESCRIPTION("programmeDescription_Portal_Text","Description",String.class),
    PROGRAMME_PRICE("programmePrice_Portal_Double","Price",Double.class),
    PROGRAMME_VENUE("programmeVenue_Portal_Text","Venue",String.class),
    PROGRAMME_DEPARTMENT_NAME("programmeDepartmentName_Portal_Text","Programme Department Name",ObjectId.class),
    PROGRAMME_TYPE("programmeType_Portal_Text","Type",String.class),
    PROGRAMME_EVENT_TYPE("programmeEventType_Portal_Text","Event Type",String.class),
    PROGRAMME_COURSE("programmeCourse_Portal_ObjectId","Course",ObjectId.class),
    PROGRAMME_OPEN_DATE("programmeOpenDate_Portal_DateTime","Open Date",Long.class),
    PROGRAMME_CLOSE_DATE("programmeCloseDate_Portal_DateTime","Close Date",Long.class),
    PROGRAMME_START_DATE("programmeStartDate_Portal_DateTime","Start Date",Long.class),
    PROGRAMME_END_DATE("programmeEndDate_Portal_DateTime","End Date",Long.class),
    PROGRAMME_SCHEDULED_DATES_TO_DISPLAY("programmeScheduledDatesToDisplay_Portal_TextArray",  "Scheduled Dates", String.class),
    PROGRAMME_VISIBLE("programmeVisible_Portal_Bool","Visible ?",Boolean.class),
    PROGRAMME_POOL("programmePool_Portal_Bool","Pool ?",Boolean.class),
    PROGRAMME_MAX_REGISTRATIONS("programmeMaxRegistrations_Portal_Int","Max Registrations",Integer.class),
    PROGRAMME_PERM_ENROLLS("programmePermEnrolls_Portal_Int","Perm Enrolls",Integer.class),
    PROGRAMME_MIN_PARTICIPANTS("programmeMinParticipants_Portal_Int","Min Participants",Integer.class),
    PROGRAMME_MAX_PARTICIPANTS("programmeMaxParticipants_Portal_Int","Max Participants",Integer.class),
    PROGRAMME_COVER_IMAGE("programmeCoverImage_Portal_Image","Cover Image",String.class),
    PROGRAMME_BATCHES("programmeBatches_Portal_DocumentArray","Batches",Document.class),
    PROGRAMME_FORMS("programmeForms_Portal_DocumentArray","Forms",Document.class),
    PROGRAMME_COORDINATORS("programmeCoordinators_Portal_DocumentArray","Coordinators",Document.class),
    PROGRAMME_LIST("programmeList_Portal_DocumentArray","Programme List",Document.class),
    IS_AUTH("isAuth_Portal_Bool","Is Auth",Boolean.class),
    PROGRAMME_MULTIPLE_ENTRY("programmeMultipleEntry_Portal_Bool","Multiple Entry ?",Boolean.class),

    // For E-Form document fields
    FORM_FIELD_TYPE("formFieldType_Portal_Text", "Field Type", String.class),
    FORM_FIELD_LABEL("formFieldLabel_Portal_Text", "Label", String.class),
    FORM_FIELD_PRICE("formFieldPrice_Portal_Double", "Field Price", Double.class),
    FORM_FIELD_DESCRIPTION("formFieldDescription_Portal_Text", "Description", String.class),
    FORM_FIELD_PLACEHOLDER("formFieldPlaceholder_Portal_Text", "Placeholder", String.class),
    FORM_FIELD_REQUIRED("formFieldRequired_Portal_Bool", "Required", Boolean.class),
    FORM_FIELD_DEFAULT_VALUE("formFieldDefaultValue_Portal_Object", "Default Value", Object.class),
    FORM_FIELD_IDENTIFIER("formFieldIdentifier_Portal_Text","Form Field Identifier",String.class),
    FORM_FIELD_OPTIONS("formFieldOptions_Portal_DocumentArray", "Options", Document.class),

    FORM_FIELD_OPTION_FIELD_NAME("formFieldOptionFieldName_Portal_Text", "Option Field Name", String.class),
    FORM_FIELD_OPTION_FIELD_PRICE("formFieldOptionFieldPrice_Portal_Double", "Option Field Price", Double.class),

    EVENT_FORM_RESPONSES("eventFormResponses_Portal_Document","Event Responses",Document.class),
    //event
    EVENT_OID("eventOid_Portal_ObjectId","Event Object id",ObjectId.class),
    EVENT_TITLE("eventTitle_Portal_Text","Title",String.class),
    EVENT_DESCRIPTION("eventDescription_Portal_Text","Description",String.class),
    EVENT_PRICE("eventPrice_Portal_Double","Price",Double.class),
    EVENT_VENUE("eventVenue_Portal_Text","Venue",String.class),
    EVENT_DEPARTMENT_NAME("eventDepartmentName_Portal_Text","Event Department Name",ObjectId.class),
    EVENT_COURSE("eventCourse_Portal_ObjectId","Course",ObjectId.class),
    EVENT_VISIBLE("eventVisible_Portal_Bool","Visible ?",Boolean.class),
    EVENT_OPEN_DATE("eventOpenDate_Portal_DateTime","Open Date",Long.class),
    EVENT_CLOSE_DATE("eventCloseDate_Portal_DateTime","Close Date",Long.class),
    EVENT_START_DATE("eventStartDate_Portal_DateTime","Start Date",Long.class),
    EVENT_END_DATE("eventEndDate_Portal_DateTime","End Date",Long.class),
    EVENT_MAX_REGISTRATIONS("eventMaxRegistrations_Portal_Int","Max Registrations",Integer.class),
    EVENT_MAX_TEAMS("eventMaxTeams_Portal_Int","Max Teams",Integer.class),
    EVENT_MIN_PARTICIPANTS("eventMinParticipants_Portal_Int","Min Participants",Integer.class),
    EVENT_MAX_PARTICIPANTS("eventMaxParticipants_Portal_Int","Max Participants",Integer.class),
    EVENT_COVER_IMAGE("eventCoverImage_Portal_Image","Cover Image",String.class),
    EVENT_EMAIL_CONTENT("eventEmailContent_Portal_Text","Email Content",String.class),
    EVENT_BATCHES("eventBatches_Portal_DocumentArray","Event Batches",Document.class),
    EVENT_FORMS("eventForms_Portal_DocumentArray","Forms",Document.class),
    EVENT_COORDINATORS("eventCoordinators_Portal_DocumentArray","Event Coordinators",Document.class),
    EVENT_LIST("eventList_Portal_DocumentArray","Event List",Document.class),

    EVENT_REGISTERED_OID("eventRegisteredOid_Portal_ObjectId","Event Registered id",ObjectId.class),
    EVENT_STATUS("eventStatus_Portal_Text","Event Status",String.class),
    EVENT_REGISTERED_BY("eventRegisteredBy_Portal_Text","Event Registered By",String.class),
    EVENT_REGISTERED_EMAIL("eventRegisteredEmail_Portal_Text","Registered Email",String.class),
    EVENT_REGISTERED_COUNT("eventRegisteredCount_Portal_Int","Event Registered Count",Integer.class),
    //course
    COURSE_CODE("courseCode_Portal_Text","Course Code",String.class),
    COURSE_TITLE("courseTitle_Portal_Text","Course Title",String.class),
    COURSE_DESCRIPTION("courseDescription_Portal_Text","Description",String.class),
    COURSE_DEANERY("courseDeanery_Portal_ObjectId","Deanery",ObjectId.class),
    COURSE_SYLLABUS_PDF("courseSyllabusPdf_Portal_File","Course Syllabus PDF",String.class),
    IS_ACTIVE("isActive_Portal_Bool","Status of Active and inactive",Boolean.class),
    CREATION_DATE("creationDate_Portal_Text","Course Creation Date",String.class);

    private final String property;
    private final String label;
    private final Class<?> dataType;
    private final int minLength;
    private final int maxLength;



    private PortalCommonKeysPBinder(String property, String label, Class<?> dataType, int minLength, int maxLength) {
        this.property = property;
        this.label = label;
        this.dataType = dataType;
        this.minLength = minLength;
        this.maxLength = maxLength;
    }

    private PortalCommonKeysPBinder(String property, String label, Class<?> dataType) {
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
    private static PortalCommonKeysPBinder[] $values() {
        return PortalCommonKeysPBinder.class.getEnumConstants();
    }
}
