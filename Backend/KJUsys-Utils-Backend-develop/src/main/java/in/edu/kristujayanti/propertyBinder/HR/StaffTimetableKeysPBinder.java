package in.edu.kristujayanti.propertyBinder.HR;

import in.edu.kristujayanti.propertyBinder.KJUSYSPropertyBinder;
import org.bson.Document;


public enum StaffTimetableKeysPBinder implements KJUSYSPropertyBinder {

    ACADEMIC_TYPE("academicType_StaffTimeTable_Text","Academic Type",String.class),
    TERM_VALUE("termValue_StaffTimeTable_TextArray","Term Value", String.class),
    ACADEMIC_YEAR("academicYear_StaffTimeTable_Text","Academic Year",String.class),
    LOGGED_IN_USER_NAME("loggedInUserName_StaffTimeTable_Text","Logged In User Name",String.class),
    LOGGED_IN_USER_NAME_ID("loggedInUserNameId_StaffTimeTable_ObjectId","Logged In User Name Id",Object.class),

    STAFF_DEPARTMENT_NAME("staffDepartmentName_StaffTimeTable_Text","Staff Department Name",String.class),
    STARTING_HOUR("startingHour_StaffTimeTable_Text","Starting Hour",String.class),



    NUMBER_OF_THEORY_HOURS("numberOfTheoryHours_StaffTimeTable_Text","Number Of Theory Hours",String.class),
    NUMBER_OF_PRACTICAL_HOURS("numberOfPracticalHours_StaffTimeTable_Text","Number Of Practical Hours",String.class),
    TOTAL_HOURS("totalHours_StaffTimeTable_Text","Total Hours",String.class),
    OTHERS_ALLOCATED_HOURS("othersAllocatedHours_StaffTimeTable_Text","Others Allocated Hours",String.class),


    CLASS_HOUR("classHour_StaffTimeTable_Text","Class Hour", String.class),
    TIME_TABLE_SCHEDULE("timeTableSchedule_StaffTimeTable_DocumentArray","Time Table Schedule", Document.class),
    TIME_TABLE_ENTRIES("timeTableEntries_StaffTimeTable_DocumentArray","Time Table Entries", Document.class),
    TIME_TABLE_DAY("timeTableDay_StaffTimeTable_Text","Time Table Day",String.class),
    TIME_TABLE_CLASS("timeTableClass_StaffTimeTable_Text", "Time Table Class",String.class),
    TIME_TABLE_COURSENAME("timeTableCoursename_StaffTimeTable_Text", "Time Table Coursename",String.class),
    TIME_TABLE_ROOMNUMBER("timeTableRoomnumber_StaffTimeTable_Text", "Time Table Roomnumber",String.class),
    TIME_TABLE_CREATED_AT("timeTableCreatedAt_StaffTimeTable_DateTime","Time Table Created At",Long.class),
    TIME_TABLE_STATUS("timeTableStatus_StaffTimeTable_bool","Time Table Status",Boolean.class),
    TIME_TABLE_EMPLOYEE_ID("timeTableEmployeeId_StaffTimeTable_Text","Time Table Employee Id",String.class),
    TIME_TABLE_HOUR_SCHEDULE("timeTableHourSchedule_StaffTimeTable_Text","Time Table Hour Schedule",String.class),


    ;

    private final String property;
    private final String label;
    private final Class<?> dataType;
    private final int minLength;

    private final int maxLength;

    private StaffTimetableKeysPBinder(String property, String label, Class<?> dataType, int minLength, int maxLength) {
        this.property = property;
        this.label = label;
        this.dataType = dataType;
        this.minLength = minLength;
        this.maxLength = maxLength;
    }

    private StaffTimetableKeysPBinder(String property, String label, Class<?> dataType) {
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

    private static StaffTimetableKeysPBinder[] $values() {
        return StaffTimetableKeysPBinder.class.getEnumConstants();
    }







}
