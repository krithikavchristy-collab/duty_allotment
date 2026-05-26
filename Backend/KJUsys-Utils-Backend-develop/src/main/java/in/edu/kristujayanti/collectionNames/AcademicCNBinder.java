package in.edu.kristujayanti.collectionNames;

public enum AcademicCNBinder implements KJUSYSCNBinder {
    ACADEMIC_BATCH_DETAILS_COLLECTION("academicBatchDetails"),
    SESSION_DETAILS_COLLECTION("sessionDetails"),
    PHD_MEETINGS_COLLECTION("phd_meeting"),
    LEARNING_STUDENTS("learningStudent"),

    PHD_MEETING("phd_meeting"),
    PHD_MILESTONE("phd_milestones"),
    PHD_SCHOLAR_MILESTONE_PROGRESS("phd_milestone_progress"),
    SETTING_COUNTER("setting_counters"),

    ROOM_MASTER("room_masters"),
    STUDENT_GROUP("student_groups"),
    STUDENT_GROUP_MAPPING("student_group_assignments"),

    COURSE("course"),
    PHD_IMPORTANT_DOCUMENT("phd_important_document"),
    AWARDS_COLLECTION("academic_awards"),
    ACADEMIC_YEAR_COLLECTION("academic_year"),
    PROGRAMMES_COLLECTION("academic_programmes"),
    BATCHES_COLLECTION("batch_details"),

    PHD_RESEARCH_PROPOSAL_PROGRESS_ASSESSMET_COLLECTION("phd_reserach_proposal_progress_assessment"),
    PHD_RSC_MEMBER_EVALUATION_COLLECTION("phd_rsc_member_evaluation"),
    PHD_RSC_SUPERVISOR_ACTION_COLLECTION("phd_rsc_supervisor_action"),
    PHD_RSC_MEMBERS_COLLECTION("phd_rsc_members"),

    // timetable
    TIME_SLOTS("time_slots"),
    BATCH_SUBJECT_FACULTY_FLAGS("batch_subject_faculty_flags"),
    DAY_TEMPLATES("day_templates"),
    BATCH_TEMPLATE_ASSIGNMENTS("batch_day_template_assignments"),
    TIME_TABLE_BLUEPRINT("time_table_blueprints"),
    ACADEMIC_LEAVE_TYPES("academic_leave_types"),

    STUDENT_ATTENDANCE("student_attendances"),
    GENERATED_ACADEMIC_TIMETABLES("generated_academic_timetables"),

    ACADEMIC_TIMETABLE_SLOT_MODIFICATION_REQUESTS("academic_timetable_slot_modification_requests"),
    STUDENT_SUBJECT_SUMMARY("student_subject_summaries"),
    STUDENT_MONTHLY_SUMMARY("student_monthly_summaries"),
    MENTOR_BOOK_COLLECTION("mentor_book"),
    MENTOR_DETAILS_COLLECTION("mentor_details"),
    CLASS_CONFIGURATION_COLLECTION("class_configuration"),

    STUDENT_MENTORING_PROFILES("student_mentoring_profiles"),
    STREAMS_COLLECTION("streams")

    ;

    private final String collectionName;

    private AcademicCNBinder(String collectionName) {
        this.collectionName = collectionName;
    }

    public String getCollectionName() {
        return this.collectionName;
    }

    // $FF: synthetic method
    private static AcademicCNBinder[] $values() {
        return AcademicCNBinder.class.getEnumConstants();
    }
}
