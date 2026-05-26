package in.edu.kristujayanti.propertyBinder.academics;



import in.edu.kristujayanti.propertyBinder.KJUSYSPropertyBinder;



public enum CourseKeysPBInder implements KJUSYSPropertyBinder{


    PROGRAMME_NAME("programmeName_Course_Text","Programme Name",String.class),
    BATCH_NAME("batchName_Course_Text","Batch Name",String.class),
    ACADEMIC_TERM("academicTerm_Course_Text","Academic Term",String.class),
    CURRICULUM_COORDINATOR("curriculumCoordinator_Course_Text","Curriculum Coordinator",String.class),
    CURRICULUM_COORDINATOR_EMAIL("curriculumCoordinatorEmail_Course_Text","Curriculum Coordinator Email",String.class),
    HOD("hod_Course_Text","Hod", String.class),
    HOD_EMAIL("hodEmail_Course_Text","Hod Email",String.class),
    DEAN("dean_Course_Text","Name Of Dean",String.class),
    DEAN_EMAIL("deanEmail_Course_Text","Email Of Dean",String.class),
    SUBMISSION_DATE("submissionDate_Course_EndDate","Submission Date", Long.class),
    COURSE_TEACHER("courseTeacher_Course_Text","Course Teacher",String.class),
    COURSE_TEACHER_EMAIL("courseTeacherEmail_Course_Text","Course Teacher Email",String.class),
    DOMAIN_EXPERT("domainExpert_Course_Text","Domain Expert",String.class),
    DOMAIN_EXPERT_EMAIL("domainExpertEmail_Course_Text","Domain Expert Email",String.class),

    COURSE_DEADLINE("courseDeadline_Course_EndDate","Course Deadline",Long.class),
    BLOWUP_DEADLINE("blowupDeadline_Course_EndDate","Blowup Deadline",Long.class)








    ;


    private final String property;
    private final String label;
    private final Class<?> dataType;
    private final int minLength;
    private final int maxLength;

    private CourseKeysPBInder(String property, String label, Class<?> dataType, int minLength, int maxLength) {
        this.property = property;
        this.label = label;
        this.dataType = dataType;
        this.minLength = minLength;
        this.maxLength = maxLength;
    }

    private CourseKeysPBInder(String property, String label, Class<?> dataType) {
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
    private static CourseKeysPBInder[] $values() {
        return CourseKeysPBInder.class.getEnumConstants();
    }
}

