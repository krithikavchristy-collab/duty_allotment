package in.edu.kristujayanti.propertyBinder.timetable;

import in.edu.kristujayanti.propertyBinder.KJUSYSPropertyBinder;



public enum LeaveTypeKeysPBinder implements KJUSYSPropertyBinder {
    TO_MINUTES("toMinutes_TimeTable_Int", "To Minutes", Integer.class),

    LEAVE_NAME("leaveName_LeaveType_Text","Leave Name",String.class),
    LEAVE_DESCRIPTION("leaveDescription_LeaveType_Text", "Leave Description", String.class),
    LEAVE_START_RANGE("leaveStartRange_LeaveType_StartDate","Leave Start range",Long.class),
    LEAVE_END_RANGE("leaveEndRange_LeaveType_EndDate","Leave End Date",Long.class),
    LEAVE_TYPE_CODE("leaveTypeCode_LeaveType_Text","Leave Type Code",String.class),
    IS_LEAVE_OVERWRITE_PRESENT("isLeaveOverwritePresent_LeaveType_Bool","Is Leave Overwrite Present", Boolean.class),
    IS_LEAVE_OVERWRITE_ABSENT("isLeaveOverwriteAbsent_LeaveType_Bool","Is Leave Overwrite Absent", Boolean.class),
    IS_LEAVE_CONSIDERED_FOR_ATTENDANCE_CALCULATION("isLeaveConsideredForAttendanceCalculation_LeaveType_Bool","Is Leave Considered For Attendance Calculation", Boolean.class),
    IS_LEAVE_CONSIDERED_FOR_DOCUMENT_UPLOAD("isLeaveConsideredForDocumentUpload_LeaveType_Bool","Is Leave Considered For Document Upload",Boolean.class),
    CAN_FACULTY_ASSIGN_LEAVE("canFacultyAssignLeave_LeaveType_Bool","Can Faculty Assign Leave",Boolean.class),
    CAN_STUDENT_APPLY_LEAVE("canStudentApplyLeave_LeaveType_Bool","Can student Apply Leave",Boolean.class),
    CAN_LEAVE_CONSIDER_FOR_SUSPENSION("canLeaveConsiderForSuspension_LeaveType_Bool","Can Leave Considered For Suspension",Boolean.class),
    HIDE_LEAVE_WORKFLOW("hideLeaveWorkflow_LeaveType_Bool","Hide Leave WorkFlow", Boolean.class),
    IS_LEAVE_APPLICABLE_FOR_ALL_DEPARTMENTS("isLeaveApplicableForAllDepartments_LeaveType_Bool","Is Leave Applicable For All Departments",Boolean.class),
    IS_LEAVE_APPLICABLE_FOR_TIME_TABLE("isLeaveApplicableForTimeTable_LeaveType_Bool","Is Leave Applicable For Time Table",Boolean.class)

    ;

    private final String property;
    private final String label;
    private final Class<?> dataType;
    private final int minLength;
    private final int maxLength;

    private LeaveTypeKeysPBinder(String property, String label, Class<?> dataType, int minLength, int maxLength) {
        this.property = property;
        this.label = label;
        this.dataType = dataType;
        this.minLength = minLength;
        this.maxLength = maxLength;
    }

    private LeaveTypeKeysPBinder(String property, String label, Class<?> dataType) {
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
    private static LeaveTypeKeysPBinder[] $values() {
        return LeaveTypeKeysPBinder.class.getEnumConstants();
    }
}
