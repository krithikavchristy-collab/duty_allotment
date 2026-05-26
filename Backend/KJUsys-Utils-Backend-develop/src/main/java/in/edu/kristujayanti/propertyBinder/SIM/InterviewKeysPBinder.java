package in.edu.kristujayanti.propertyBinder.SIM;

import in.edu.kristujayanti.propertyBinder.KJUSYSPropertyBinder;
import org.bson.Document;
import org.bson.types.ObjectId;

public enum InterviewKeysPBinder implements KJUSYSPropertyBinder {
    // INTERVIEW
    INTERVIEW_NAME("interviewName_InterviewKeys_Text", "Interview Name", String.class),
    INTERVIEW_DATE("interviewDate_InterviewKeys_Date", "Interview Date", Long.class),
    INTERVIEW_PROGRAMME_GROUPS("interviewProgrammeGroups_InterviewKeys_ObjectIdArray", "Interview Program Groups", ObjectId.class),
    INTERVIEW_PANELS("interviewPanels_InterviewKeys_DocumentArray", "Interview Panels", Document.class),
    INTERVIEW_STATUS("interviewStatus_InterviewKeys_Text", "Interview Status", String.class),
    INTERVIEW_MAX_ALLOCATION_COUNT("interviewMaxAllocationCount_InterviewKeys_Int", "Interview Max Allocation Count", Integer.class),
    INTERVIEW_RESCHEDULE_ENABLED("interviewRescheduleEnabled_InterviewKeys_Bool", "Interview Reschedule Enabled", Boolean.class),
    INTERVIEW_RESCHEDULE_VISIBILITY_END_DATE("interviewRescheduleVisibilityEndDate_InterviewKeys_Date", "Interview Reschedule Visibility End Date", Long.class),
    INTERVIEW_HAS_AVAILABLE_SLOT("interviewHasAvailableSlot_InterviewKeys_Bool", "Interview Has Available Slot", Boolean.class),
    INTERVIEW_CURRENT_ALLOCATION_COUNT("interviewCurrentAllocationCount_InterviewKeys_Int", "Interview Current Allocation Count", Integer.class),

    // PANEL

    PANEL_NAME("panelName_InterviewKeys_Text","Panel Name", String.class),
    PANEL_COURSES_HANDLED("panelCoursesHandled_InterviewKeys_DocumentArray","Panel Courses Handled", Document.class),
    PANEL_PROGRAMME_GROUPS("panelProgrammeGroups_InterviewKeys_ObjectIdArray","Panel Programme Groups", Document.class),
    PANEL_TYPE("panelType_InterviewKeys_Text","Panel Type", String.class),
    PANEL_PANELISTS("panelPanelists_InterviewKeys_DocumentArray","Panel Panelists", Document.class),
    PANEL_CANDIDATES("panelCandidates_InterviewKeys_DocumentArray","Panel Candidates", Document.class),
    PANEL_CANDIDATES_APPLICATION_NUMBERS("panelCandidatesApplicationNumbers_InterviewKeys_TextArray","Panel Candidates Application Numbers", String.class),
    PANEL_CANDIDATE_INTERVIEW_STATUS("panelCandidateInterviewStatus_InterviewKeys_Text","Panel Candidate Interview Status", String.class),
    PANEL_CANDIDATE_TOKEN_NUMBER("panelCandidateTokenNumber_InterviewKeys_Int","Panel Candidate Token Number", Integer.class),


    PANEL_CURRENTLY_ATTENDING_CANDIDATE("panelCurrentlyAttendingCandidate_InterviewKeys_Text", "Panel currently attending candidate", String.class),
    PANEL_PANELIST_ACTION_COUNT("panelPanelistActionCount_InterviewKeys_Int", "Panel Panelists Action Count", Integer.class),
    PANEL_PANELIST_ACTION_DESCRIPTION("panelPanelistActionDescription_InterviewKeys_TextArray", "Panel panelist Action Description", String.class),
    PANEL_COMPLETED_CANDIDATES("panelCompletedCandidates_InterviewKeys_DocumentArray", "Panel Completed Candidates", Document.class),
    PANEL_SEND_TOKEN_STATUS_EMAIL("panelSendTokenStatusEmail_InterviewKeys_Bool", "Panel Send Token Status Email", Boolean.class),

    PANEL_LAST_ISSUED_TOKEN_NUMBER("panelLastIssuedTokenNumber_InterviewKeys_Int", "Panel Last Issued Token Number", Integer.class),


    // PROGRAMME GROUP
    PROGRAMME_GROUP_NAME("programmeGroupName_InterviewKeys_Text", "Programme Group Name", String.class),
    PROGRAMME_GROUP_ACADEMIC_YEAR("programmeGroupAcademicYear_InterviewKeys_Text", "Programme Group Academic Year", String.class),
    PROGRAMME_GROUP_PROGRAMMES("programmeGroupProgrammes_InterviewKeys_DocumentArray", "Programme Group Programmes", Document.class),

    // PANELIST REMARKS
    REMARKS_PANELIST_NAME("remarksPanelistName_InterviewKeys_Text", "Panelist Name", String.class),
    REMARKS_PANELIST_EMAIL("remarksPanelistEmail_InterviewKeys_Text", "Panelist Email", String.class),
    REMARKS_MODE_OF_EDUCATION("remarksModeOfEducation_InterviewKeys_Text", " Mode Of Education", String.class),
    REMARKS_SECOND_LANGUAGE("remarksSecondLanguage_InterviewKeys_Text", "Second Language", String.class),
    REMARKS_CO_CURRICULAR_ACTIVITIES("remarksCoCurricularActivities_InterviewKeys_Text", "Co Curricular Activities", String.class),
    REMARKS_SUBJECT_KNOWLEDGE("remarksSubjectKnowledge_InterviewKeys_Text", "Subject Knowledge", String.class),
    REMARKS_ATTITUDE("remarksAttitude_InterviewKeys_Text", "Attitude", String.class),
    REMARKS_COMMUNICATION("remarksCommunication_InterviewKeys_Text", "Communication", String.class),
    REMARKS_REMARK("remarksRemark_InterviewKeys_Text", "Remark", String.class),
    REMARKS_INTERVIEW_SCORE("remarksInterviewScore_InterviewKeys_Int", "Interview Score", Integer.class),
    REMARKS_ACTIVITY_SCORE("remarksActivityScore_InterviewKeys_Int", "Activity Score", Integer.class),
    REMARKS_GENERAL_AWARENESS_AND_APTITUDE("remarksGeneralAwarenessAndAptitude_InterviewKeys_Text", "Remarks General Awareness And Aptitude", String.class),
    REMARKS_TECHNICAL_KNOWLEDGE("remarksTechnicalKnowledge_InterviewKeys_Text", "Remarks Technical Knowledge", String.class),
    REMARKS_CRITICAL_THINKING_ABILITY("remarksCriticalThinkingAbility_InterviewKeys_Text", "Remarks Critical Thinking Ability", String.class),
    REMARKS_MOTIVATION_LEVEL("remarksMotivationLevel_InterviewKeys_Text", "Remarks Motivation Level", String.class),
    REMARKS_ALIGNMENT_WITH_INSTITUTIONAL_VALUES("remarksAlignmentWithInstitutionalValues_InterviewKeys_Text", "Remarks Alignment With Institutional Values", String.class),
    TEACHING_EXPERIENCE("teachingExperience_InterviewKeys_Double", "Teaching Experience", Double.class),
    RESEARCH_EXPERIENCE("researchExperience_InterviewKeys_Double", "Research Experience", Double.class),
    DETAILS_OF_PG_LEVEL_RESEARCH_PROJECT("detailsOfPgLevelResearchProject_InterviewKeys_Text", "Details Of Pg Level Research Project", String.class),
    DETAILS_OF_TEACHING_EXPERIENCE("detailsOfTeachingExperience_InterviewKeys_Text", "Details Of Teaching Experience", String.class),
    DETAILS_OF_RESEARCH_EXPERIENCE("detailsOfResearchExperience_InterviewKeys_Text", "Details Of Research Experience", String.class),
    ANY_RELEVANT_INFORMATION("anyRelevantInformation_InterviewKeys_Text", "Any Relevant Information", String.class),
    PANEL_CHAIRS("panelChairs_InterviewKeys_DocumentArray", "Panel Chairs", Document.class),
    PHD_ENTRANCE_PART_A_SCORE("phdEntrancePartAScore_InterviewKeys_Double", "PhD Entrance Part A Score", Double.class),
    PHD_ENTRANCE_PART_B_SCORE("phdEntrancePartBScore_InterviewKeys_Double", "PhD Entrance Part B Score", Double.class),
    PHD_ENTRANCE_SCORE_UPDATED_BY("phdEntranceScoreUpdatedBy_InterviewKeys_Text", "PhD Entrance Score Updated By", String.class),
    PHD_ENTRANCE_SCORE_UPDATED_ON("phdEntranceScoreUpdatedOn_InterviewKeys_Date", "PhD Entrance Score Updated On", Long.class),
    ABILITY_TO_SUBMIT_THESIS_WITHIN_TIMEFRAME("abilityToSubmitThesisWithinTimeframe_InterviewKeys_Text", "Ability To Submit Thesis Within Timeframe", String.class),
    CANDIDATE_INTERVIEW_REMARKS("candidateInterviewRemarks_InterviewKeys_DocumentArray", "Candidate Interview Remarks", Document.class);

    private final String property;
    private final String label;
    private final Class<?> dataType;
    private final int minLength;
    private final int maxLength;

    private InterviewKeysPBinder(String property, String label, Class<?> dataType, int minLength, int maxLength) {
        this.property = property;
        this.label = label;
        this.dataType = dataType;
        this.minLength = minLength;
        this.maxLength = maxLength;
    }

    private InterviewKeysPBinder(String property, String label, Class<?> dataType) {
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

    private static InterviewKeysPBinder[] $values() {
        return InterviewKeysPBinder.class.getEnumConstants();
    }

}