package in.edu.kristujayanti.propertyBinder.academics;

import in.edu.kristujayanti.propertyBinder.KJUSYSPropertyBinder;
import org.bson.Document;

public enum BlowUpKeysPBinder implements KJUSYSPropertyBinder {


    TEMPLATE_NAME("templateName_BlowUp_Text","Template Name For Course", String.class),
    STEP_ORDER_BLOW_UP_TEMPLATE("stepOrderBlowUpTemplate_BlowUp_TextArray","Step Order BLow Up Template", String.class),
    BLOW_UP_STEPS("blowUpSteps_BlowUp_Document","Blow Up Steps", Document.class),

    COURSE_OBJECT_ID("courseObjectId_BlowUp_ObjectId","Course Object id", Object.class),
    BLOW_UP_STATUS("blowUpStatus_BlowUp_Text","Blow Up Status", String.class),
    BLOW_UP_REVERT_REMARK("blowUpRevertRemark_BLowUp_Text","Blow Up Revert Remark", String.class),
    LAST_ACTION_BY("lastActionBy_BlowUp_Text","Last Action By", String.class),
    LAST_ACTION_AT("lastActionAt_BlowUp_Date","Last Action At", Long.class),
    LAST_ACTION("lastAction_BlowUp_Text","Last Action ", String.class),
    REVERT_COMMENT("revertComment_BlowUp_Text","Last Action ", String.class),

    // COURSE DESCRIPTION
    CROSS_CUTTING_ISSUE_ADDRESSED("crossCuttingIssueAddressed_BlowUp_TextArray", "Cross Cutting Issue Addressed", String.class),
    NEEDS_CATERED_BY_THE_COURSE("needsCateredByTheCourse_BlowUp_TextArray", "Needs Catered By The Course", String.class),
    COURSE_OFFERED_TO("courseOfferedTo_BlowUp_DocumentArray", "Course Offered To", Document.class),
    PREREQUISITE_OR_CONCURRENT_COURSES_IF_ANY("prerequisiteOrConcurrentCoursesIfAny_BlowUp_TextArray", "Prerequisite Or Concurrent Courses If Any", String.class),
    CONCURRENT_COURSES_IF_ANY("concurrentCoursesIfAny_BlowUp_TextArray", "Concurrent Courses If Any", String.class),
    // COURSE OBJECTIVES
    COURSE_OBJECTIVES("courseObjectives_BlowUp_TextArray", "Course Objectives", String.class),

    // COURSE LEARNING OUTCOMES
    COURSE_LEARNING_OUTCOMES("courseLearningOutcomes_BlowUp_DocumentArray", "Course Learning Outcomes", Document.class),
    COURSE_LEARNING_OUTCOME_INDEX("courseLearningOutcomeIndex_BlowUp_Text", "Course Learning Outcome Index", String.class),
    COURSE_LEARNING_OUTCOME("courseLearningOutcome_BlowUp_Text", "Course Learning Outcome", String.class),

    // COURSE CONTENT
    COURSE_CONTENT_UNITS("courseContentUnits_BlowUp_DocumentArray", "Course Content Units", Document.class),
    UNIT_TITLE("unitTitle_BlowUp_Text", "Unit Title", String.class),
    UNIT_CONTENT("unitContent_BlowUp_Text", "Unit Content", String.class),
    UNIT_HOURS("unitHours_BlowUp_Double", "Unit Hours", Double.class),

    // RESOURCES
    RESOURCES("resources_BlowUp_Document", "Resources", Document.class),
    REFERENCE_BOOKS("referenceBooks_BlowUp_DocumentArray", "Reference Books", Document.class),
    AUTHOR("author_BlowUp_Text", "Author", String.class),
    TITLE("title_BlowUp_Text", "Title", String.class),
    PUBLISHER("publisher_BlowUp_Text", "Publisher", String.class),
    YEAR("year_BlowUp_Int", "Year", Integer.class),
    SUGGESTED_POLICIES("suggestedPolicies_BlowUp_TextArray", "Suggested Policies", String.class),
    ONLINE_RESOURCES("onlineResources_BlowUp_DocumentArray", "Online Resources", Document.class),
    DESCRIPTION("description_BlowUp_Text", "Description", String.class),
    LINK("link_BlowUp_Text", "Link", String.class),
    IN_HOUSE_RESOURCES_AND_DATABASE("inHouseResourcesAndDatabase_BlowUp_Text", "Inhouse Resources And Database", String.class),
    EDITION("edition_BlowUp_Int", "Edition", Integer.class),


    // PEDAGOGY
    PEDAGOGY_METHODS("pedagogyMethods_BlowUp_TextArray", "Pedagogy Methods", String.class),

    // SKILL SET IDENTIFICATION MATRIX
    SKILL_SET_MATRIX("skillSetMatrix_BlowUp_DocumentArray", "Skill Set Matrix", Document.class),

    BLOOMS_TAXONOMY_LEVEL("bloomsTaxonomyLevel_BlowUp_TextArray", "Blooms Taxonomy Level", String.class),
    GENERIC_GRADUATE_ATTRIBUTES("genericGraduateAttributes_BlowUp_Text", "Generic Graduate Attributes", String.class),
    DISCIPLINE_SPECIFIC("disciplineSpecific_BlowUp_TextArray", "Discipline Specific", String.class),

    // COURSE ASSESSMENT PLAN
    COURSE_ASSESSMENT_PLAN("courseAssessmentPlan_BlowUp_Document", "Course Assessment Plan", Document.class),
    QUESTION_PAPER_PATTERN("questionPaperPattern_BlowUp_DocumentArray", "Question Paper Pattern", Document.class),
    TYPE_OF_ASSESSMENT("typeOfAssessment_BlowUp_Text", "Type Of Assessment", String.class),
    ASSESSMENT_DETAILS("assessmentDetails_BlowUp_DocumentArray", "Assessment Details", Document.class),
    TYPE_OF_EXAM("typeOfExam_BlowUp_Text", "Type Of Exam", String.class),
    MAXIMUM_MARKS("maximumMarks_BlowUp_Double", "Maximum Marks", Double.class),
    MODE_OF_EXAM("modeOfExam_BlowUp_Text", "Mode Of Exam", String.class),
    DURATION("duration_BlowUp_Double", "Duration", Double.class),
    THEORY_PRACTICAL_CERTIFICATION("theoryPracticalCertification_BlowUp_Text","Theory Practical Certification", String.class),
    FORMATIVE_ASSESSMENT_COMPONENTS("formativeAssessmentComponents_BlowUp_Text","Formative Assessment Components", String.class),

    QUESTION_PAPER_BLUE_PRINT_FOR_SA("questionPaperBluePrintForSa_BlowUp_DocumentArray", "Question Paper Blueprint For SA", Document.class),
    SECTION("section_BlowUp_Text", "Section ", String.class),
    QUESTION_AND_DISTRIBUTION_OF_MARKS("questionAndDistributionOfMarks_BlowUp_DocumentArray", "Question And Distribution Of Marks", Document.class),
    CLO_ADDRESSED("closAddressed_BlowUp_TextArray", "CLO Addressed", String.class),
    NO_OF_QUESTIONS("noOfQuestions_BlowUp_Int", "No Of Questions", Integer.class),
    TOTAL_MARKS("totalMarks_BlowUp_Double", "Total Marks", Double.class),
    BLOOMS_TAXONOMY_LEVELS_USED("bloomsTaxonomyLevelsUsed_BlowUp_TextArray", "Blooms Taxonomy Level Used", String.class),
    MAPPING_CLOS_WITH_QUESTIONS("mappingClosWithQuestions_BlowUp_DocumentArray", "Mapping CLOs With Questions", Document.class),
    MAPPING("mapping_BlowUp_DocumentArray", "Mapping", Document.class),
    QUESTION_NUMBER("questionNumber_BlowUp_Text", "Question Number", String.class),

    //d)WEIGHTAGE OF MARKS

    WEIGHTAGE_OF_MARKS("weightageOfMarks_BlowUp_Document", "Weightage Of Marks", Document.class),
    WEIGHTAGE_OF_MARKS_ARRAY("weightageOfMarksArray_BlowUp_DocumentArray", "Weightage Of Marks Array", Document.class),
    MTE1_FA("mte1_Fa_BlowUp_Double", "MTE 1 FA", Double.class),
    MTE2_FA("mte2_Fa_BlowUp_Double", "MTE 2 FA", Double.class),
    ACTIVITY_FA("activityFa_BlowUp_Double", "Activity FA", Double.class),
    TOTAL_MARKS_SA("totalMarksSa_BlowUp_Double", "Total Marks SA", Double.class),
    TOTAL_MARKS_END_SEMESTER("totalMarksEndSemester_BlowUp_Double", "Total Marks End Semester", Double.class),
    ACTIVITY_DESCRIPTION("activityDescription_BlowUp_Text", "Activity Description", String.class),

    // COURSE ARTICULATION MATRIX
    COURSE_ARTICULATION_MATRIX("courseArticulationMatrix_BlowUp_DocumentArray", "Course Articulation Matrix", Document.class),
    PROGRAMME_OUTCOME_INDEX("programmeOutcomeIndex_BlowUp_Text", "Programme Outcome Index", String.class),

    // PREPARED BY
    PREPARED_BY_COURSE_TEACHER("preparedByCourseTeacher_BlowUp_Document", "Prepared By Course Teacher", Document.class),

    // VERIFIED BY
    VERIFIED_BY_DOMAIN_EXPERT("verifiedByDomainExpert_BlowUp_Document", "Verified By", Document.class),

    // APPROVED BY
    APPROVED_BY_HOD("approvedByHod_BlowUp_Document", "Approved By HOD", Document.class),
    APPROVED_BY_DEAN("approvedByDean_BlowUp_Document", "Approved By Dean", Document.class),

    THEORY_OR_PRACTICAL("theoryOrPractical_BlowUp_Text","Theory Or Practical", String.class),
 //   ASSESSMENT_MODE("assessmentMode_BlowUp_Text","Assessment Mode",String.class),
    ASSESSMENT_MARKS("assessmentMarks_BlowUp_Double","Assessment Marks", Double.class),
    SECTION_WISE_QP_PATTERN("sectionWiseQPPattern_BlowUp_DocumentArray","Section Wise QP Pattern",Document.class),
    NUMBER_OF_QUESTIONS_TO_ANSWER("numberOfQuestionsToAnswer_BlowUp_Double","Number Of Questions To Answer ", Double.class),
    MARKS_PER_QUESTION("marksPerQuestion_BlowUp_Double","Marks Per Questions", Double.class),
    TOTAL_QUESTION_GIVEN("totalQuestionsGiven_BlowUp_Double","Total Questions Given", Double.class),
    QP_OUTLINE("qpOutline_BlowUp_Text","QP Outline", String.class),
    QP_TEMPLATE_NAME("qpTemplateName_BlowUp_Text","QP Template Name", String.class)


    ;


    private final String property;
    private final String label;
    private final Class<?> dataType;
    private final int minLength;
    private final int maxLength;

    private BlowUpKeysPBinder(String property, String label, Class<?> dataType, int minLength, int maxLength) {
        this.property = property;
        this.label = label;
        this.dataType = dataType;
        this.minLength = minLength;
        this.maxLength = maxLength;
    }

    private BlowUpKeysPBinder(String property, String label, Class<?> dataType) {
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
    private static BlowUpKeysPBinder[] $values() {
        return BlowUpKeysPBinder.class.getEnumConstants();
    }
}


