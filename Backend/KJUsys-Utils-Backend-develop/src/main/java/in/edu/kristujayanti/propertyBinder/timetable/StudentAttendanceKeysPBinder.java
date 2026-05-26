package in.edu.kristujayanti.propertyBinder.timetable;

import in.edu.kristujayanti.propertyBinder.KJUSYSPropertyBinder;

import javax.swing.text.Document;

public enum StudentAttendanceKeysPBinder implements KJUSYSPropertyBinder {

    STATUS("status_StudentAttendance_Text", "Student Attendance Status", String.class),
    MARKED_ON("markedOn_StudentAttendance_Date", "Marked On Date", Long.class),
    MARKED_BY_EMAIL("markedByEmail_StudentAttendance_Text", "Marked By", String.class),
    ATTENDANCE_LIST("attendanceList_StudentAttendance_DocumentArray", "Student list", Document.class),

    MONTH("month_StudentAttendance_Text", "Month", String.class),
    TOTAL_LECTURES("totalLectures_StudentAttendance_Int", "Total Lectures", Integer.class),
    PRESENT("present_StudentAttendance_Int", "Present", Integer.class),
    ABSENT("absent_StudentAttendance_Int", "Absent", Integer.class),
    ON_DUTY("onDuty_StudentAttendance_Int", "On Duty", Integer.class),
    MEDICAL_LEAVE("medicalLeave_StudentAttendance_Int", "Medical Leave", Integer.class),
    ATTENDANCE_PERCENTAGE("attendancePercentage_StudentAttendance_Double", "Attendance Percentage", Double.class),
    UPDATED_AT("updatedAt_StudentAttendance_Date", "Updated At", Long.class),

    PERIODS("periods_StudentAttendance_Document", "Periods", Document.class),
    TOTAL_PRESENT("totalPresent_StudentAttendance_Int", "Hourly Present", Integer.class),
    TOTAL_ABSENT("totalAbsent_StudentAttendance_Int", "Hourly Absent", Integer.class),
    TOTAL_PERCENTAGE("totalPercentage_StudentAttendance_Long", "Total Percentage", Long.class),



    ;




    private final String property;
    private final String label;
    private final Class<?> dataType;
    private final int minLength;
    private final int maxLength;

    private StudentAttendanceKeysPBinder(String property, String label, Class<?> dataType, int minLength, int maxLength) {
        this.property = property;
        this.label = label;
        this.dataType = dataType;
        this.minLength = minLength;
        this.maxLength = maxLength;
    }

    private StudentAttendanceKeysPBinder(String property, String label, Class<?> dataType) {
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

    private static StudentAttendanceKeysPBinder[] $values() {
        return StudentAttendanceKeysPBinder.class.getEnumConstants();
    }
}
