package in.edu.kristujayanti.propertyBinder.academics;

import in.edu.kristujayanti.propertyBinder.KJUSYSPropertyBinder;
import org.bson.Document;
import org.bson.types.ObjectId;

public enum MatrixKeysPBInder implements KJUSYSPropertyBinder{

    COURSE_TYPE("courseType_Matrix_Text","Course Type",String.class),
    COURSE_TYPE_DESCRIPTION("courseTypeDescription_Matrix_Text","Course Type Description",String.class),
    COURSE_CODE("courseCode_Matrix_Text","course code",String.class),
    PROGRAMME_CODE("programmeCode_Matrix_Text","Programme Code",String.class),
    COURSE_TITLE("courseTitle_Matrix_Text","Course Title",String.class),
    COURSE_TOTAL_HOURS("courseTotalHours_Matrix_Double","Course Total Hours", Double.class),
    COURSE_HOURS_PER_WEEK("courseHoursPerWeek_Matrix_Double","Course Hours Per Week", Double.class),
    COURSE_HOURS_DISTRIBUTION("courseHoursDistribution_Matrix_Document","Course Hours Distribution", Document.class),
    LECTURE_HOURS("lectureHours_Matrix_Double","Lecture Hours", Double.class),
    THEORY_HOURS("theoryHours_Matrix_Double","Theory Hours",Double.class),
    PRACTICAL_HOURS("practicalHours_Matrix_Double","Practical Hours",Double.class),



    LECTURE_HOURS_CREDIT("lectureHoursCredit_Matrix_Double","Lecture Hours Credit", Double.class),
    THEORY_HOURS_CREDIT("theoryHoursCredit_Matrix_Double","Theory Hours Credit",Double.class),
    PRACTICAL_HOURS_CREDIT("practicalHoursCredit_Matrix_Double","Practical Hours Credit",Double.class),



    COURSE_CREDITS("courseCredits_Matrix_Double","Course Credits",Double.class),
    COURSE_CREDIT_DISTRIBUTION("courseCreditDistribution_Matrix_Document","Course Credit Distribution", Document.class),
    FORMATIVE_ASSESSMENT_MAXIMUM_MARKS("formativeAssessmentMaximumMarks_Matrix_Double","Formative Assessment Maximum Marks",Double.class),
    SUMMATIVE_ASSESSMENT_MAXIMUM_MARKS("summativeAssessmentMaximumMarks_Matrix_Double","Summative Assessment Maximum Marks",Double.class),
    TOTAL_MARKS("totalMarks_Matrix_Double","Total Marks",Double.class),
    COURSE_TEMPLATE_OID("courseTemplateOid_Matrix_ObjectId","Course Template Oid", ObjectId.class),
    COURSE_MATRIX("courseMatrix_Matrix_DocumentArray","Course Matrix",Document.class),
    COURSE_GROUP("courseGroup_Matrix_TextArray","Course Group",String.class),
    COURSE_GROUPING("courseGrouping_Matrix_Document","Course Grouping",Document.class),
    COURSE_GROUP_NAME("courseGroupName_Matrix_Text","Course Group Name",String.class),

    COURSE_PREREQUISITES("coursePrerequisites_Matrix_TextArray","Course Prerequisites",String.class),
    COURSE_GROUP_NUMBER("courseGroupNumber_Matrix_Int","Course Group Number", Integer.class),
    GROUP_LEVEL_RULE("groupLevelRule_Matrix_DocumentArray","Group Level Rule", Document.class),
    GROUP_LEVEL_GROUPING("groupLevelGrouping_Matrix_ObjectIdArray","Group Level Grouping", ObjectId.class),
    MATRIX_STATUS("matrixStatus_Matrix_Text","Matrix Status", String.class),
    //MATRIX_DEAN_STATUS("matrixDeanStatus_Matrix_Bool","Matrix Dean Status",Boolean.class),
    REMARKS("remarks_Matrix_Text","Remarks", String.class),
    PREREQUISITES("prerequisites_Matrix_Text","Prerequisites",String.class),





    //Master-rule-keys
    RULE_NAME("ruleName_Matrix_Text","Rule Name", String.class),
    MANDATORY_ENROLMENT("mandatoryEnrolment_Matrix_Int","Mandatory Enrolment", Integer.class),
    TOTAL_ENROLMENT("totalEnrolment_Matrix_Int","Total Enrolment", Integer.class),

    RULE_NAME_OID("ruleNameOid_Matrix_ObjectId","Rule Name Oid", ObjectId.class),
    RULE_DESCRIPTION("ruleDescription_Matrix_Text","Rule Description",String.class),




    //Group-master-keys
    GROUP_NAME("groupName_Matrix_Text","Group Name",String.class),
    GROUP_DESCRIPTION("groupDescription_Matrix_Text","Group Description",String.class),
    COURSE_MASTER_GROUP("courseMasterGroup_Matrix_DocumentArray","Course Master Group",Document.class),
    COURSE_UNIQUE_NUMBER("courseUniqueNumber_Matrix_Int","Course Unique Number", Integer.class),

    ENROLMENT_RULES("enrolmentRules_Matrix_DocumentArray","Enrolment Rules",Document.class),
    PREREQUISITES_FOR_GROUP_ENROLMENT("prerequisitesForGroupEnrolment_Matrix_TextArray","Prerequisites For Group Enrolment",String.class)
    ;


    private final String property;
    private final String label;
    private final Class<?> dataType;
    private final int minLength;
    private final int maxLength;

    private MatrixKeysPBInder(String property, String label, Class<?> dataType, int minLength, int maxLength) {
        this.property = property;
        this.label = label;
        this.dataType = dataType;
        this.minLength = minLength;
        this.maxLength = maxLength;
    }

    private MatrixKeysPBInder(String property, String label, Class<?> dataType) {
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
    private static MatrixKeysPBInder[] $values() {
        return MatrixKeysPBInder.class.getEnumConstants();
    }
}


