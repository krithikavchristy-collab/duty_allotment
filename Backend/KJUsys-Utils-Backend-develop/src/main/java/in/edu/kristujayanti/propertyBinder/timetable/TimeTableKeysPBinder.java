package in.edu.kristujayanti.propertyBinder.timetable;

import in.edu.kristujayanti.propertyBinder.KJUSYSPropertyBinder;
import org.bson.types.ObjectId;

import javax.swing.text.Document;

public enum TimeTableKeysPBinder implements KJUSYSPropertyBinder {

    /* TIME SLOT (time_slot) */
    TIME_SLOT_ID("timeSlotId_TimeTable_ObjectId", "Time Slot Id", ObjectId.class),
    FROM_TIME("fromTime_TimeTable_Text", "From Time", String.class),
    TO_TIME("toTime_TimeTable_Text", "To Time", String.class),
    FROM_MINUTES("fromMinutes_TimeTable_Int", "From Minutes", Integer.class),
    TO_MINUTES("toMinutes_TimeTable_Int", "To Minutes", Integer.class),
    DURATION_MINUTES("durationMinutes_TimeTable_Int", "Duration (Minutes)", Integer.class),

    /* DAY TEMPLATE (day_template) */
    DAY_TEMPLATE_NAME("dayTemplateName_TimeTable_Text", "Template Name", String.class),
    WEEKDAY_SLOTS("weekdaySlots_TimeTable_DocumentArray", "Weekday Slots", Document.class),
    DAY_OF_WEEK("dayOfWeek_TimeTable_Text", "Day Of Week", String.class),
    TIME_SLOT_IDS("timeSlotIds_TimeTable_ObjectIdArray", "Time Slot Ids", ObjectId.class),
    TIME_SLOTS("timeSlots_TimeTable_DocumentArray", "Time Slots Array", Document.class),

    /* BATCH DAY TEMPLATE ASSIGNMENT (batch_day_template_mapping) */
    BATCH_TEMPLATE_ASSIGNMENT_ID("batchTemplateAssignmentId_TimeTable_ObjectId", "Assignment Id", ObjectId.class),
    SEMESTER("semester_TimeTable_Int", "Semester", Integer.class),
    BATCH("batch_TimeTable_Text", "Batch", String.class),
    SECTION("section_TimeTable_Text", "Section", String.class),
    DAY_TEMPLATE_ID("dayTemplateId_TimeTable_ObjectId", "Day Template Id", ObjectId.class),
    IS_MAPPED_ACTIVE("isMappedActive_TimeTable_Bool", "Is Mapped Active", Boolean.class),
    IS_DELETED("isDeleted_TimeTable_Bool", "Is Deleted", Boolean.class),

    SEMESTER_LIST("semesterList_TimeTable_IntArray", "Semester List", Integer.class),
    BATCH_SECTION_LIST("batchSectionList_TimeTable_DocumentArray", "Batch Section List", Document.class),

    AVAILABLE_DAYS("availableDays_TimeTable_TextArray", "Available Days", String.class),
    ASSIGNED_TIME_SLOTS("assignedTimeSlots_TimeTable_TextArray", "Assigned Time slots", String.class),

    /* TIME-TABLE BLUEPRINT (timetable_blueprints) */
    DAYS("days_TimeTable_DocumentArray", "Days", Document.class),
    SLOTS("slots_TimeTable_DocumentArray", "Slots", Document.class),
    SLOT("slot_TimeTable_Document", "Slot", Document.class),
    SLOT_ORDER("slotOrder_TimeTable_Int", "Slot Order", Integer.class),
    SLOT_LABEL("slotLabel_TimeTable_Text", "Slot Label", String.class),
    IS_LOCKED("isLocked_TimeTable_Bool", "Is Locked", Boolean.class),
    VERSION("version_TimeTable_Int", "Version", Integer.class),

    /* ALLOCATION DETAILS (Nested within Slots) */
    ALLOCATIONS("allocations_TimeTable_DocumentArray", "Allocations", Document.class),
    SUBJECT_NAME("subjectName_TimeTable_Text", "Subject Name", String.class),
    ACTIVITY_TYPE("activityType_TimeTable_Text", "Activity Type", String.class),
    TIME_TABLE_REMARKS("timeTableRemarks_TimeTable_Text", "Time Table Remarks", String.class),

    FACULTY_FLAGS("facultyFlags_TimeTable_DocumentArray", "Faculty Flags List", Document.class),
    FLAGS("flags_TimeTable_Document", "Flags Configuration", Document.class),

    FEEDBACK_ENABLED("feedbackEnabled_TimeTable_Bool", "Feedback Enabled", Boolean.class),
    QB_ENABLED("qbEnabled_TimeTable_Bool", "Question Bank Enabled", Boolean.class),
    GRADING_ENABLED("gradingEnabled_TimeTable_Bool", "Grading Enabled", Boolean.class),
    LMS_ENABLED("lmsEnabled_TimeTable_Bool", "Lms Enabled", Boolean.class),

    BATCH_SLOT_ALLOCATIONS("batchSlotAllocations_TimeTable_DocumentArray", "Batch Slot Document", Document.class),
    SELECTED_BATCHES("selectedBatches_TimeTable_DocumentArray", "Selected Batches", Document.class),

    TIME_TABLE_DATE("timeTableDate_TimeTable_Date", "Time Table Date", Long.class),
    IS_MERGED("isMerged_TimeTable_Bool", "Is Merged", Boolean.class),
    NO_CLASS_CONDUCTED("noClassConducted_TimeTable_Bool", "No Class Conducted", Boolean.class),
    NO_CLASS_CONDUCTED_REASON("noClassConductedReason_TimeTable_Text", "No Class Conducted Reason", String.class),
    IS_HOLIDAY("isHoliday_TimeTable_Bool", "Is Holiday", Boolean.class),
    HOLIDAY_REASON("holidayReason_TimeTable_Text", "Holiday Reason", String.class),

    TIME_TABLE_ID("timeTableId_TimeTable_ObjectId", "Timetable Id", ObjectId.class),
    DAYS_OF_WEEK("daysOfWeek_TimeTable_TextArray", "Days of Week", String.class),

    // substitution
    IS_SUBSTITUTION("isSubstitution_TimeTable_Bool", "Is Substitution", Boolean.class),
    SUBSTITUTION_REQUEST_STATUS("substitutionRequestStatus_TimeTable_Text", "Substitution Request Status", String.class),
    SUBSTITUTION_REQUEST_ID("substitutionRequestId_TimeTable_ObjectId", "Substitution Request Id", ObjectId.class),
    SUBSTITUTION_DOCUMENT("substitutionDocument_TimeTable_Document", "Substitution Document", Document.class),
  
    MULTI_SLOT_DETAILS("multiSlotDetails_TimeTable_DocumentArray", "Multi Slot Details", Document.class),
    ALLOCATED_FACULTY_NAME("allocatedFacultyName_TimeTable_Text", "Allocated Faculty Name", String.class)

    ;

    private final String property;
    private final String label;
    private final Class<?> dataType;
    private final int minLength;
    private final int maxLength;

    private TimeTableKeysPBinder(String property, String label, Class<?> dataType, int minLength, int maxLength) {
        this.property = property;
        this.label = label;
        this.dataType = dataType;
        this.minLength = minLength;
        this.maxLength = maxLength;
    }

    private TimeTableKeysPBinder(String property, String label, Class<?> dataType) {
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
    private static TimeTableKeysPBinder[] $values() {
        return TimeTableKeysPBinder.class.getEnumConstants();
    }
}
