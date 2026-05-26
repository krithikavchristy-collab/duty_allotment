package in.edu.kristujayanti.propertyBinder.academics;

import in.edu.kristujayanti.propertyBinder.KJUSYSPropertyBinder;
import org.bson.Document;

import java.util.List;

public enum StudentGroupKeysPBinder implements KJUSYSPropertyBinder {

    /*  STUDENT GROUP MASTER (student_groups)  */
    GROUP_ID("groupId_StudentGroup_Text", "Group Id", String.class),
    GROUP_NAME("groupName_StudentGroup_Text", "Group Name", String.class),

    /* STUDENT GROUP ASSIGNMENT (student_group_assignments)  */
    ASSIGNMENT_ID("assignmentId_StudentGroup_Text", "Assignment Id", String.class),
    BATCH_SECTION("batchSection_StudentGroup_Text", "Batch & Section", String.class),
    STUDENT_ROLL_NUMBERS("studentRollNumbers_StudentGroup_TextArray", "Student List", String.class),
    GROUP_DETAILS("groupDetails_StudentGroup_DocumentArray", "Student Group", Document.class),
    SELECT_ALL_STUDENTS("selectAllStudents_StudentGroup_Bool", "Select All Students", Boolean.class),
    STUDENT_FILTERS("studentFilters_StudentGroup_Document", "Filter Students", Document.class),

    BATCH_NAMES("batchNames_StudentGroup_TextArray", "Batch Names", String.class),
    BATCH_CODES("batchCodes_StudentGroup_TextArray", "Batch Codes", String.class),
    SECTIONS("sections_StudentGroup_TextArray", "Sections", String.class),
    ACADEMIC_YEARS("academicYears_StudentGroup_TextArray", "Academic Years", String.class),
    SEMESTERS("semesters_StudentGroup_IntArray", "Semesters", Integer.class),
    GROUP_IDS("groupIds_StudentGroup_TextArray", "Group Ids", String.class),


    ;
    
    private final String property;
    private final String label;
    private final Class<?> dataType;
    private final int minLength;
    private final int maxLength;

    private StudentGroupKeysPBinder(String property, String label, Class<?> dataType, int minLength, int maxLength) {
        this.property = property;
        this.label = label;
        this.dataType = dataType;
        this.minLength = minLength;
        this.maxLength = maxLength;
    }

    private StudentGroupKeysPBinder(String property, String label, Class<?> dataType) {
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
    private static StudentGroupKeysPBinder[] $values() {
        return StudentGroupKeysPBinder.class.getEnumConstants();
    }
}
