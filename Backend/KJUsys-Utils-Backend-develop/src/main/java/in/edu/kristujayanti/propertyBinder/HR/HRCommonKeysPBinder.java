package in.edu.kristujayanti.propertyBinder.HR;

import in.edu.kristujayanti.propertyBinder.KJUSYSPropertyBinder;
import org.bson.Document;
import org.bson.types.ObjectId;

public enum HRCommonKeysPBinder implements KJUSYSPropertyBinder {

    EMPLOYEE_OLD_PASSWORD("employeeOldPassword_HRCommon_Text", "Employee Old Password", String.class),
    /// staff circular
    STAFF_CIRCULAR_RECIPIENT_CATEGORY("staffCircularRecipientCategory_HRCommon_Text","Staff Circular Recipient Category",String.class),
    STAFF_CIRCULAR_TITLE("staffCircularTitle_HRCommon_Text", "Staff Circular Title", String.class),
    STAFF_CIRCULAR_CREATED_DATE("staffCircularCreatedDate_HRCommon_Date", "Staff Circular Created Date", Long.class),
    STAFF_CIRCULAR_FILE_UPLOAD_PATH("staffCircularFileUploadPath_HRCommon_Text", "Staff Circular File Upload Path", String.class),
    STAFF_CIRCULAR_CREATED_BY("staffCircularCreatedBy_HRCommon_Text", "Staff Circular Created By", String.class),
    STAFF_CIRCULAR_CREATED_AT("staffCircularCreatedAt_HRCommon_Date", "Staff Circular Created At", Long.class),
    STAFF_CIRCULAR_FILE_UPLOAD("staffCircularFileUpload_HRCommon_Text", "Staff Circular File Upload", String.class),
    CIRCULAR_FROM_DATE("circularFromDate_HRCommon_Date", "Circular From Date", Long.class),
    CIRCULAR_TO_DATE("circularToDate_HRCommon_Date", "Circular To Date", Long.class),
    CIRCULAR_OID("circularOID_HRCommon_ObjectId", "Circular OID", ObjectId.class),
    STAFF_CIRCULAR_SELECTED_DEPARTMENTS("staffCircularSelectedDepartments_HRCommon_TextArray", "Staff Circular Selected Departments", String.class),
    STAFF_CIRCULAR_SELECTED_EMPLOYEE_CODES("staffCircularSelectedEmployeeCodes_HRCommon_TextArray", "Staff Circular Selected Employee Codes ", String.class),
    STAFF_CIRCULAR_SELECTED_EMPLOYEES_CODES("staffCircularSelectedEmployeesCodes_HRCommon_DocumentArray", "Staff Circular Selected Employees Codes ", Document.class),
    NOTIFICATION_TYPE("notificationType_HRCommon_Text", "Notification Type", String.class),
    CIRCULAR_ID("circularId_HRCommon_Text", "Circular ID", String.class),

   /// Staff event
    STAFF_EVENT_TITLE("staffEventTitle_HRCommon_Text", "Staff Event Title", String.class),
    STAFF_EVENT_DATES_ARRAY("staffEventDatesArray_HRCommon_TextArray", "Staff Event Dates Array",String.class),
    STAFF_EVENT_START_TIME("staffEventStartTime_HRCommon_Text", "Staff Event Start Time", String.class),
    STAFF_EVENT_END_TIME("staffEventEndTime_HRCommon_Text", "Staff Event End Time", String.class),
    STAFF_EVENT_SELECTED_DEPARTMENTS("staffEventSelectedDepartments_HRCommon_TextArray", "Staff Event Selected Departments", String.class),
    STAFF_EVENT_SELECTED_EMPLOYEE_CODES("staffEventSelectedEmployeeCodes_HRCommon_DocumentArray", "Staff Event Selected Employee Codes", Document.class),
    STAFF_EVENT_SELECTED_EMPLOYEES_CODES("staffEventSelectedEmployeesCodes_HRCommon_TextArray", "Staff Event Selected Employees Codes", String.class),
    STAFF_EVENT_CREATED_BY ("staffEventCreatedBy_HRCommon_Text", "Staff Event Created By", String.class),
    STAFF_EVENT_CREATED_AT("staffEventCreatedAt_HRCommon_Date", "Staff Event Created At", Long.class),
    STAFF_EVENT_ON_DATE("staffEventOnDate_HRCommon_Date", "Staff Event On Date", Long.class),
    EVENT_OID("eventOID_HRCommon_ObjectId", "Event OID", ObjectId.class),
    EVENT_FROM_DATE("eventFromDate_HRCommon_Date", "Event From Date", Long.class),
    EVENT_TO_DATE("eventToDate_HRCommon_Date", "Event To Date", Long.class),
    EVENT_HOSTED_BY("eventHostedBy_HRCommon_Text", "Event Hosted By", String.class),
    EVENT_VENUE("eventVenue_HRCommon_Text", "Event Venue", String.class),


    /// staff Reminder
    STAFF_REMINDER_TITLE("staffReminderTitle_HRCommon_Text", "Staff Reminder Title", String.class),
    STAFF_REMINDER_DATES_ARRAY("staffReminderDatesArray_HRCommon_TextArray", "Staff Reminder Dates Array", String.class),
    STAFF_REMINDER_START_TIME("staffReminderStartTime_HRCommon_Text", "Staff Reminder Start Time", String.class),
    STAFF_REMINDER_END_TIME("staffReminderEndTime_HRCommon_Text", "Staff Reminder End Time", String.class),
    STAFF_REMINDER_CREATED_BY("staffEventCreatedBy_HRCommon_Text", "Staff Event Created By", String.class),
    STAFF_REMINDER_CREATED_AT("staffEventCreatedAt_HRCommon_Date", "Staff Event Created At", Long.class),
    STAFF_REMINDER_ON_DATE("staffReminderOnDate_HRCommon_Date", "Staff Reminder On Date", Long.class),
    STAFF_REMINDER_FROM_DATE("staffReminderFromDate_HRCommon_Date", "Staff Reminder From Date", Long.class),
    STAFF_REMINDER_TO_DATE("staffReminderToDate_HRCommon_Date", "Staff Reminder To Date", Long.class),

    /// calender Event
    CALENDAR_EVENT_FROM_DATE("calendarEventFromDate_HRCommon_Date", "Calendar Event From Date", Long.class),
    CALENDAR_EVENT_TO_DATE("calendarEventToDate_HRCommon_Date", "Calendar Event To Date", Long.class),

    /// todo
    TODO_TITLE("todoTitle_HRCommon_Text", "ToDo Title", String.class),
    TODO_DESCRIPTION("todoDescription_HRCommon_Text", "ToDo Description", String.class),
    TODO_STATUS("todoStatus_HRCommon_Text", "ToDo Status", String.class),
    TODO_CREATED_BY("todoCreatedBy_HRCommon_Text", "ToDo Created By", String.class),
    TODO_CREATED_AT("todoCreatedAt_HRCommon_Date", "ToDo Created At", Long.class),
    TODO_FROM_DATE("todoFromDate_HRCommon_Date", "ToDo From Date", Long.class),
    TODO_TO_DATE("todoToDate_HRCommon_Date", "ToDo To Date", Long.class),
    TODO_OID("todoOid_HRCommon_ObjectId", "ToDo OID", ObjectId.class),
    TODO_ORDER("todoOrder_HRCommon_Int", "ToDo Order", Integer.class),
    TODO_ID("todoId_HRCommon_Text", "ToDo ID", String.class),
    TODO_UPDATE_DOCUMENT_ARRAY("todoUpdateDocumentArray_HRCommon_DocumentArray", "ToDo Update Document", Document.class),







    //student circular
    STUDENT_CIRCULAR_TITLE("studentCircularTitle_HRCommon_Text","Student Circular Title",String.class),
    STUDENT_CIRCULAR_DATE("studentCircularDate_HRCommon_Date","Student Circular Date",Long.class),
    STUDENT_CIRCULAR_FILE_UPLOAD_PATH("studentCircularFileUploadPath_HRCommon_Text", "Student Circular File Upload Path", String.class),
    STUDENT_CIRCULAR_CREATED_BY("studentCircularCreatedBy_HRCommon_Text", "Student Circular Created By", String.class),
    STUDENT_CIRCULAR_CREATED_AT("studentCircularCreatedAt_HRCommon_Date", "Student Circular Created At", Long.class),
    STUDENT_CIRCULAR_SELECTED_BATCHES("studentCircularSelectedBatches_HRCommon_TextArray", "Student Circular Selected Batches", String.class),



    //student events
    STUDENT_EVENT_TITLE("studentEventTitle_HRCommon_Text", "Student Event Title", String.class),
    STUDENT_EVENT_DATES_ARRAY("studentEventDatesArray_HRCommon_TextArray", "Student Event Dates Array",String.class),
    STUDENT_EVENT_START_TIME("studentEventStartTime_HRCommon_Text", "Student Event Start Time", String.class),
    STUDENT_EVENT_END_TIME("studentEventEndTime_HRCommon_Text", "Student Event End Time", String.class),
    STUDENT_EVENT_SELECTED_BATCHES("studentEventSelectedBatches_HRCommon_TextArray", "Student Event Selected Departments", String.class),
    STUDENT_EVENT_CREATED_BY ("studentEventCreatedBy_HRCommon_Text", "Student Event Created By", String.class),
    STUDENT_EVENT_CREATED_AT("studentEventCreatedAt_HRCommon_Date", "Student Event Created At", Long.class),
    STUDENT_EVENT_ON_DATE("studentEventOnDate_HRCommon_Date", "Student Event On Date", Long.class),












    ;



    private final String property;
    private final String label;
    private final Class dataType;
    private final int minLength;
    private final int maxLength;

    private HRCommonKeysPBinder(String property, String label, Class dataType, int minLength, int maxLength) {
        this.property = property;
        this.label = label;
        this.dataType = dataType;
        this.minLength = minLength;
        this.maxLength = maxLength;
    }

    private HRCommonKeysPBinder(String property, String label, Class dataType) {
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
    private static HRCommonKeysPBinder[] $values() {
        return HRCommonKeysPBinder.class.getEnumConstants();
    }
}
