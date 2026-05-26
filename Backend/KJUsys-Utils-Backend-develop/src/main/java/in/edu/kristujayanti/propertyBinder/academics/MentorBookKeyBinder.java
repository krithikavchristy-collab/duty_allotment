package in.edu.kristujayanti.propertyBinder.academics;

import in.edu.kristujayanti.propertyBinder.KJUSYSPropertyBinder;
import org.bson.Document;
import org.bson.types.ObjectId;
import java.util.List;

public enum MentorBookKeyBinder implements KJUSYSPropertyBinder {
    MENTOR_MEETING_OBJECT_ID("mentorMeetingObjectId_MentorBook_ObjectId", "Mentor Meeting ObjectId", ObjectId.class),
    MENTOR_OBJECT_ID("mentorObjectId_MentorBook_ObjectId", "Mentor  ObjectId", ObjectId.class),
    MEETING_COUNT("meetingCount_MentorBook_Int", "Meeting Count", Integer.class),
    MATTER_OF_DISCUSSION("matterOfDiscussion_MentorBook_Text", "Matter of Discussion", String.class),
    AREAS_OF_IMPROVEMENT("areasOfImprovement_MentorBook_Text", "Areas Of Improvement", String.class),
    VERIFICATION_STATUS("verificationStatus_MentorBook_Text", "Varification Status", String.class),
    MEETING_DATE("meetingDate_MentorBook_Date", "Meeting Date", Long.class),

    OBSERVATIONS("observations_MentorBook_Text", "Observations", String.class),
    MENTOR_NAME("mentorName_MentorBook_Text", "Mentor Name", String.class),
    MENTOR_EMAIL("mentorEmail_MentorBook_Text", "Mentor Name", String.class),
    MENTOR_EMPLOYEE_CODE("mentorEmployeeCode_MentorBook_Text", "Mentor Name", String.class),
    STUDENTS("students_MentorBook_TextArray", "Students RollNumber ", String.class),
    MENTOR_IS_ACTIVE("mentorIsActive_MentorBook_Bool", "Mentor Name", Boolean.class),
    ASSIGNED_STUDENTS("assignedStudents_MentorBook_DocumentArray", "Assigned Students", Document.class),



   

    //Common
    UPDATED_BY("updatedBy_MentorBook_Text", "Updated By", String.class),
    UPDATED_AT("updatedAt_MentorBook_Date", "Updated At", Long.class),
    SEMESTER("semester_MentorBook_Int", "Semester", Integer.class),
    ACADEMIC_ACHIEVEMENTS("academicAchievements_MentorBook_Text", "Academic Achievements", String.class),


    //Basic details
    PERSONAL_DETAILS("personalDetails_MentorBook_Document", "Personal Details", Document.class),
    HOBBIES("hobbies_MentorBook_Text", "Hobbies", String.class),
    AMBITION("ambition_MentorBook_Text", "Ambition", String.class),
    OTHER_ACHIEVEMENTS("otherAchievements_MentorBook_Text", "Other Achievements", String.class),

    //Examination Result Details
    COURSE_NAME("courseName_MentorBook_Text", "Course Name", String.class),
    COURSE_CODE("courseCode_MentorBook_Text", "Course Code", String.class),
    FA_OBTAINED("faObtained_MentorBook_Double", "FA Obtained", Double.class),
    FA_MAX("faMax_MentorBook_Double", "FA Max", Double.class),
    SA_OBTAINED("saObtained_MentorBook_Double", "SA Obtained", Double.class),
    SA_MAX("saMax_MentorBook_Double", "SA Max", Double.class),
    TOTAL_OBTAINED("totalObtained_MentorBook_Double", "Total Obtained", Double.class),
    TOTAL_MAX("totalMax_MentorBook_Double", "Total Max", Double.class),
    GRADE("grade_MentorBook_Text", "Grade", String.class),
    IS_PASS("isPass_MentorBook_Bool", "Is Pass", Boolean.class),
    SL_NO("slNo_MentorBook_Int", "Serial Number", Integer.class),
    COURSE_RESULTS("courseResults_MentorBook_DocumentArray", "Course Results", Document.class),
    COURSES_TO_REAPPEAR("coursesToReappear_MentorBook_DocumentArray", "Courses To Reappear", Document.class),
    SUMMARY("summary_MentorBook_Obj", "Summary", Document.class),
    OVERALL_OBTAINED("overallObtained_MentorBook_Double", "Overall Obtained", Double.class),
    OVERALL_MAXIMUM("overallMaximum_MentorBook_Double", "Overall Maximum", Double.class),
    PERCENTAGE("percentage_MentorBook_Double", "Percentage", Double.class),
    GRADE_RECEIVED("gradeReceived_MentorBook_Text", "Grade Received", String.class),
    ACADEMIC_PERFORMANCE("academicPerformance_MentorBook_Document", "Academic Performance", Document.class),


    //Academic Records
    SEMESTER_RECORD("semesterRecord_MentorBook_Document", "Semester Record", Document.class),
    SEMESTER_RECORDS("semesterRecords_MentorBook_DocumentArray", "Semester Record", Document.class),
    ADD_ON_VAC("addOnVac_MentorBook_TextArray", "Add-on VAC Courses", String.class),
    ONLINE_COURSES("onlineCourses_MentorBook_TextArray", "Online Courses", String.class),
    WORKSHOPS("workshops_MentorBook_TextArray", "Workshops", String.class),
    VOLUNTEERING("volunteering_MentorBook_Text", "Volunteering", String.class),
    POSITIONS_HELD("positionsHeld_MentorBook_Text", "Positions Held", String.class),
    CO_CURRICULAR_PARTICIPATION("coCurricularParticipation_MentorBook_Document", "Co-curricular Participation", Document.class),
    ACTIVITIES_PARTICIPATED("activitiesParticipated_MentorBook_Document", "Activities Participated", Document.class),

    NSS("nss_MentorBook_Int", "NSS Participation", Integer.class),
    CSA("csa_MentorBook_Int", "CSA Participation", Integer.class),
    NCC("ncc_MentorBook_Int", "NCC Participation", Integer.class),
    SPORTS("sports_MentorBook_Int", "Sports Participation", Integer.class),
    FESTS("fests_MentorBook_Int", "Fests Participation", Integer.class),
    UBA("uba_MentorBook_Int", "UBA Participation", Integer.class),
    RED_CROSS("redCross_MentorBook_Int", "Red Cross Participation", Integer.class),
    KCDC("kcdc_MentorBook_Int", "KCDC Participation", Integer.class),

    FEST_ACHIEVEMENTS("festAchievements_MentorBook_TextArray", "Fest Achievements", String.class),
    EXTRACURRICULAR_ACHIEVEMENTS("extracurricularAchievements_MentorBook_TextArray", "Extracurricular Achievements", String.class),

    //Final Evaluation
    FINAL_EVALUATION("finalEvaluation_MentorBook_Document", "Final Evaluation", Document.class),
    YEAR_OF_COMPLETION("yearOfCompletion_MentorBook_Int", "Year Of Completion", Integer.class),
    IS_ALL_COURSES_COMPLETED("isAllCoursesCompleted_MentorBook_Bool", "All Courses Completed", Boolean.class),
    PLACEMENT_DETAILS("placementDetails_MentorBook_Text", "Placement Details", String.class),
    MODE_OF_PLACEMENT("modeOfPlacement_MentorBook_Text", "Mode Of Placement", String.class),
    FUTURE_PLAN("futurePlan_MentorBook_Text", "Future Plan", String.class),
    OVERALL_COMMENT("overallComment_MentorBook_Text", "Overall Comment", String.class),
    OTHER_DETAILS("otherDetails_MentorBook_Text", "Other Details", String.class),

    SIBLINGS("siblings_MentorBook_DocumentArray", "Siblings", Document.class),
    SIBLING_NAME("siblingName_MentorBook_Text", "Sibling Name", String.class),
    SIBLING_OCCUPATION("siblingOccupation_MentorBook_Text", "Sibling Occupation", String.class),
    SIBLING_AGE("siblingAge_MentorBook_Int", "Sibling Age", Integer.class),
    SIBLING_CONTACT("siblingContact_MentorBook_Text", "Sibling Contact", String.class),

    BASIC_DETAILS("basicDetails_MentorBook_Document", "Basic Details", Document.class),
    PARENT_DETAILS("parentDetails_MentorBook_Document", "Parent Details", Document.class),
    PRIOR_EDUCATION("priorEducation_MentorBook_Document", "Prior Education", Document.class),


    PARENT_ADDRESS("parentAddress_MentorBook_Text", "Parent Details", String.class);




















    private final String property;
    private final String label;
    private final Class<?> dataType;
    private final int minLength;
    private final int maxLength;

    private MentorBookKeyBinder(String property, String label, Class<?> dataType, int minLength, int maxLength) {
        this.property = property;
        this.label = label;
        this.dataType = dataType;
        this.minLength = minLength;
        this.maxLength = maxLength;
    }

    private MentorBookKeyBinder(String property, String label, Class<?> dataType) {
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
    private static MentorBookKeyBinder[] $values() {
        return MentorBookKeyBinder.class.getEnumConstants();
    }
}