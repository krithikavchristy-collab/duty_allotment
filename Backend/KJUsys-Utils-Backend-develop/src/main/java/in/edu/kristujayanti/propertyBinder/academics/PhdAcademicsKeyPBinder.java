package in.edu.kristujayanti.propertyBinder.academics;

import in.edu.kristujayanti.propertyBinder.KJUSYSPropertyBinder;
import org.bson.Document;
import org.bson.types.ObjectId;
import software.amazon.awssdk.services.s3.endpoints.internal.Value;

public enum PhdAcademicsKeyPBinder implements KJUSYSPropertyBinder {

    // here you can add your property binders
    MEETING_OBJECT_ID("meetingObjectId_PhdAcademics_ObjectId", "Meeting ObjectId", ObjectId.class),
   MEETING_ACTION_POINTS_OBJECT_ID("meetingActionPointsObjectId_PhdAcademics_ObjectId", "Meeting Auth ObjectId", ObjectId.class),
    MEETING_TYPE("meetingType_PhdAcademics_Text", "Meeting Type", String.class),
    MEETING_AGENDA("meetingAgenda_PhdAcademics_Text", "Agenda", String.class),
    MEETING_DATE("meetingDate_PhdAcademics_Date", "Meeting Date", Long.class),
    MEETING_START_TIME("meetingStartTime_PhdAcademics_DateTime", "Meeting Starting Time", Long.class),
    MEETING_END_TIME("meetingEndTime_PhdAcademics_DateTime", "End Time", Long.class),
    MEETING_MODE("meetingMode_PhdAcademics_Text", "Meeting Mode", String.class),
    TEMPLATE_ID("templateId_PhdAcademics_Text", "templateId", String.class),
    RSC_MEETING_COUNT("rscMeetingCount_PhdAcademics_Int", "RSC Meeting No.", Integer.class),
    RSC_MEMBERS_DOCUMENT_ARRAY("rscMembersDocumentArray_PhdAcademics_DocumentArray", "RSC Members", Document.class),
    RSC_MEMBER_EMAIL("rscMemberEmail_PhdAcademics_Text", "RSC Member", String.class),
    RSC_MEMBER_REPORT_STATUS("rscMemberReportStatus_PhdAcademics_Bool", "RSC Member Evaluation Report Status", Boolean.class),
    RSC_FEEDBACK_ATTACHMENT("rscFeedbackAttachment_PhdAcademics_Text", "RSC Feedback Atttachment", String.class),
    PROGRESSION_REPORT_TEMPLATE("progressionReportTemplate_PhdAcademics_Text", "RSC Feedback Atttachment", String.class),
    REBUTTAL_STATUS("rebuttalStatus_PhdAcademics_Text", "Rebuttal Status", String.class),

    //Milestones
    MILESTONE_CODE("milestoneCode_PhdAcademics_Text", "Milestone Code", String.class),
    MILESTONE_NAME("milestoneName_PhdAcademics_Text", "Milestone Name", String.class),
    MILESTONE_DESCRIPTION("milestoneDescription_PhdAcademics_Text", "Milestone Description", String.class),
    MILESTONE_MODE("milestoneMode_PhdAcademics_TextArray", "Milestone Mode", String.class),
    MILESTONE_IS_ACTIVE("milestoneIsActive_PhdAcademics_Bool", "Milestone Status", Boolean.class),
    MILESTONE_MAX_RSC_MEETINGS("milestoneMaxRscMeetings_PhdAcademics_Int", "RSC Maximum Count", Integer.class),
    MILESTONE_MAX_SIP("milestoneMaxSip_PhdAcademics_Int", "SIP Maximum Count", Integer.class),
    MILESTONE_MAX_ICP("milestoneMaxIcp_PhdAcademics_Int", "ICP Maximum Count", Integer.class),
    MILESTONE_MAX_ARC("milestoneMaxArc_PhdAcademics_Int", "Arc Maximum Count", Integer.class),


    MILESTONE_ICP_COMPLETED("milestoneIcpCompleted_PhdAcademics_Int", "ICP Completed Count", Integer.class),
    MILESTONE_ARC_COMPLETED("milestoneArcCompleted_PhdAcademics_Int", "ARC Completed Count", Integer.class),
    MILESTONE_RSC_COMPLETED("milestoneRscCompleted_PhdAcademics_Int", "RSC Completed Count", Integer.class),
    MILESTONE_SIP_COMPLETED("milestoneSipCompleted_PhdAcademics_Int", "SIP Completed Count", Integer.class),



    MILESTONE_STAGES("milestoneStages_PhdAcademics_DocumentArray", "Milestone Stages", Document.class),
    MILESTONE_STAGES_STAGE_ID("milestoneStagesStageId_PhdAcademics_Text", "Milestone Stage Id", String.class),
    MILESTONE_STAGES_STAGE_NAME("milestoneStagesStageName_PhdAcademics_Text", "Milestone Stage Name", String.class),
    MILESTONE_STAGES_STAGE_DESCRIPTION("milestoneStagesStageDescription_PhdAcademics_Text", "Milestone Stage Description", String.class),
    MILESTONE_STAGES_STAGE_EXPECTED_COMPLETION_DATE("milestoneStagesStageExpectedCompletionDate_PhdAcademics_Date", "Milestone Stage ExpectedCompletionDate", Long.class),
    MILESTONE_STAGES_STAGE_COMPLETED_COUNT("milestoneStagesStageCompletedCount_PhdAcademics_Int", "Milestone Stage Completed Count", Integer.class),
    IS_FILE_UPLOAD_REQUIRED("isFileUploadRequired_PhdAcademics_Bool", "File Upload Required", Boolean.class),

    // phd guide
    RESEARCH_SUPERVISOR_DOCUMENT("researchSupervisorDocument_PhdAcademics_Document","Research Supervisor details",Document.class),
    RESEARCH_SUPERVISOR_FULL_NAME("researchSupervisorFullName_PhdAcademics_Text","Research Supervisor Full Name",String.class),
    RESEARCH_SUPERVISOR_OFFICIAL_EMAIL_ID("researchSupervisorOfficialEmailId_PhdAcademics_Text","Research Supervisor Official Email id",String.class),
    RESEARCH_SUPERVISOR_EMPLOYEE_CODE("researchSupervisorEmployeeCode_PhdAcademics_Text","Research Supervisor Employee Code",String.class),

    MILESTONE_ID("milestoneId_PhdAcademics_ObjectId", "Milestone Object Id", Object.class),
    STUDENT_ROLL_NUMBER_ARRAY("studentRollNumberArray_PhdAcademics_TextArray", "Student Roll Number Array", String.class),
    FROM_STAGE("fromStage_PhdAcademics_Document", "From Stage Document", Document.class),
    TO_STAGE("toStage_PhdAcademics_Document", "To Stage Document", Document.class),
    FROM_STAGE_ID("fromStageId_PhdAcademics_Text", "From Stage Id", String.class),
    FROM_STAGE_COMPLETION_DATE("fromStageCompletionDate_PhdAcademics_Date", "Stage Completion Date", String.class),
    TO_STAGE_ID("toStageId_PhdAcademics_Text", "To Stage Id", String.class),
    TO_STAGE_EXPECTED_COMPLETION_DATE("toStageExpectedCompletionDate_PhdAcademics_Date", "Stage Expected Completion Date", Long.class),
    TRANSITION_TYPE("transitionType_PhdAcademics_Text", "Transition Type", String.class),
    MILESTONE_CURRENT_STAGE_ID("milestoneCurrentStageId_PhdAcademics_Text", "Milestone Current Stage Id", String.class),
    RESEARCH_SUPERVISOR_EMPLOYEE_NAME("researchSupervisorEmployeeName_PhdAcademics_Text", "Supervisor Name", String.class),
    MEETING_STATUS("meetingStatus_PhdAcademics_Text", "Meeting Status", String.class),
    CREATED_ON("createdOn_PhdAcademics_DateTime", "Created On", String.class),
    GUIDE_FEEDBACK("guideFeedback_PhdAcademics_Text", "Guide Feedback", String.class),
    ATTACHMENT("attachment_PhdAcademics_Text", "Atttachment", String.class),
    MEETING_MINUTES_AND_SUGGESTIONS("meetingMinutesAndSuggestions_PhdAcademics_Text", "Minutes And Suggestion", String.class),
    SCHOLAR_REBUTTAL("scholarRebuttal_PhdAcademics_Text", "Rebuttal", String.class),
    SCHOLAR_NAME("scholarName_PhdAcademics_Text", "Scholar Name", String.class),
    PHD_RESEARCH_TITLE("phdResearchTitle_PhdAcademics_Text", "Research Title", String.class),
    PHD_MEETING_STUDENT_FILE_UPLOAD("phdMeetingStudentFileUpload_PhdAcademics_File","PhD Meeting Student File Upload", String.class),
    PHD_MEETING_YEAR("phdMeetingYear_PhdAcademics_Int", "Meeting Year", Integer.class),
    PHD_MEETING_REBUTTAL("phdMeetingRebuttal_PhdAcademics_Text","Phd Meeting Rebuttal",String.class),
    PHD_STUDENT_MILESTONE_FILE("phdStudentMilestoneFile_PhdAcademics_File","Phd Student Milestone File",String.class),
    HAS_THE_RESEARCH_TITLE_BEEN_CONFIRMED("hasTheResearchTitleBeenConfirmed_PhdAcademics_Bool", "Has the Research Title been Confirmed", Boolean.class),
    //important document
    PHD_IMPORTANT_DOCUMENTS_FILE("phdImportantDocumentsFile_PhdAcademics_File","Phd Important Documents File",String.class),


    ASSESSMENT_REPORT("assessmentReport_PhdAcademics_DocumentArray","Phd Assessment Report",Document.class),
  RESEARCH_IDENTITY_DOCUMENT_ARRAY("researchIdentityDocumentArray_PhdAcademics_DocumentArray","Phd Assessment Report",Document.class),
    ITEM_NAME("itemName_PhdAcademics_Text", "Item Name", String.class),
    COMPLETION_STAGE("completionStage_PhdAcademics_Text", "Conpletion Stage", String.class),
    COMPLETION_REMARK("completionRemark_PhdAcademics_Text", "Conpletion Remark", String.class),
    PROBLEM_FRAMING_DOCUMENT_ARRAY("problemFramingDocumentArray_PhdAcademics_DocumentArray","Phd Assessment Report",Document.class),
    CONCEPTUAL_GAP_DIAGRAM_OR_MIND_MAP_DOCUMENT_ARRAY("conceptualGapDiagramOrMindMapDocumentArray_PhdAcademics_DocumentArray","Phd Assessment Report",Document.class),
    CONCEPTUAL_FILE_PATH("conceptualFilePath_PhdAcademics_Text", "Conpletion Stage", String.class),
    CONCEPTUAL_REFERENCE("conceptualReference_PhdAcademics_Text", "Conpletion Remark", String.class),
    OBJECTIVES_FRAMEWORK_OR_CONCEPT_MAP_DOCUMENT_ARRAY("objectivesFrameworkOrConceptMapDocumentArray_PhdAcademics_DocumentArray","Phd Assessment Report",Document.class),
    OBJECTIVES_FRAMEWORK_FILE_PATH("objectivesFrameworkFilePath_PhdAcademics_Text", "Conpletion Stage", String.class),
    OBJECTIVES_FRAMEWORK_REFERENCE("objectivesFrameworkReference_PhdAcademics_Text", "Conpletion Stage", String.class),
    METHODOLOGY_DOCUMENT_ARRAY("methodologyDocumentArray_PhdAcademics_DocumentArray","Phd Assessment Report",Document.class),
    METHODOLOGY_FLOW_CHART_OR_RESEARCH_DESIGN_DIAGRAM_DOCUMENT_ARRAY("MethodologyFlowChartOrResearchDesignDiagramDocumentArray_PhdAcademics_DocumentArray","Phd Assessment Report",Document.class),
    METHODOLOGY_FILE_PdateOfMeetingATH("methodologyFilePath_PhdAcademics_Text", "Conpletion Stage", String.class),
    METHODOLOGY_REFERENCE("methodologyReference_PhdAcademics_Text", "Conpletion Stage", String.class),
    SAMPLING_FILE_PATH("samplingFilePath_PhdAcademics_Text", "Conpletion Stage", String.class),
    LITERATURE_FILE_PATH("literatureFilePath_PhdAcademics_Text", "Conpletion Stage", String.class),
    OBJECTIVES_FILE_PATH("objectivesFilePath_PhdAcademics_Text", "Conpletion Stage", String.class),

    SAMPLING_FRAMEWORK_TABLE_OR_STUDY_SITE_MAP_DOCUMENT_ARRAY("samplingFrameworkTableOrStudySiteMapDocumentArray_PhdAcademics_DocumentArray","Phd Assessment Report",Document.class),
    SAMPLING_FRAMEWORK_TABLE_STUDY_SITE_MAP_DOCUMENT_ARRAY("samplingFrameworkTableStudySiteMapDocumentArray_PhdAcademics_Document","Phd Assessment Report",Document.class),
    SAMPLING_FRAMEWORK_TABLE_STUDY_SITE_MAP_FILE_PATH("samplingFrameworkTableStudySiteMapFilePath_PhdAcademics_Text", "Conpletion Stage", String.class),
    SAMPLING_FRAMEWORK_TABLE_STUDY_SITE_MAP_REFERENCE("samplingFrameworkTableStudySiteMapReference_PhdAcademics_Text", "Conpletion Stage", String.class),


    LITERATURE_SUMMARY_TABLE_OR_PRISMA_FLOW_DOCUMENT_ARRAY("literatureSummaryTableOrPrismaFlowDocumentArray_PhdAcademics_DocumentArray","Phd Assessment Report",Document.class),
    LITERATURE_SUMMARY_TABLE_PRISMA_FLOW_DOCUMENT_ARRAY("literatureSummaryTablePrismaFlowDocumentArray_PhdAcademics_Document","Phd Assessment Report",Document.class),
    LITERATURE_SUMMARY_TABLE_PRISMA_FLOW_FILE_PATH("literatureSummaryTablePrismaFlowFilePath_PhdAcademics_Text", "Conpletion Stage", String.class),
    LITERATURE_SUMMARY_TABLE_PRISMA_FLOW_REFERENCE("literatureSummaryTablePrismaFlowReference_PhdAcademics_Text", "Conpletion Stage", String.class),


    SUPERVISOR_ENGAGEMENT_DOCUMENT_ARRAY("supervisorEngagementDocumentArray_PhdAcademics_DocumentArray","Phd Assessment Report",Document.class),
    SKILLS_AND_KNOWLEDGE_ACQUIRED_DURING_THE_PERIOD_DOCUMENT_ARRAY("skillsAndKnowledgeAcquiredDuringThePeriodDocumentArray_PhdAcademics_DocumentArray","Phd Assessment Report",Document.class),
    SKILLS_AND_KNOWLEDGE_SELECTED_AREA("skillsAndKnowledgeSelectedArea_PhdAcademics_Text", "Conpletion Stage", String.class),
    SKILLS_AND_KNOWLEDGE_SELECTED_AREA_DESCRIPTION("skillsAndKnowledgeSelectedAreaDescription_PhdAcademics_Text", "Conpletion Stage", String.class),
SKILLS_AND_KNOWLEDGE_SELECTED_AREA_OTHERS("skillsAndKnowledgeSelectedAreaOthers_PhdAcademics_Text", "Conpletion Stage", String.class),
    SKILLS_AND_KNOWLEDGE_SELECTED_AREA_OTHERS_DESCRIPTION("skillsAndKnowledgeSelectedAreaOthersDescription_PhdAcademics_Text", "Conpletion Stage", String.class),

    SELF_ASSESSMENT_OF_PROGRESS_DOCUMENT_ARRAY("selfAssessmentOfProgressDocumentArray_PhdAcademics_DocumentArray","Phd Assessment Report",Document.class),
    ASPECT_DOCUMENT_ARRAY("aspectDocumentArray_PhdAcademics_DocumentArray","Phd Assessment Report",Document.class),
    ASPECT("aspect_PhdAcademics_Text","Phd Assessment Report",String.class),
    ASPECT_RATE("aspectRate_PhdAcademics_Text","Phd Assessment Report",String.class),
    SELF_ASSESSMENT_OF_PROGRESS_QUESTIONS_DOCUMENT_ARRAY("selfAssessmentOfProgressQuestionsDocumentArray_PhdAcademics_DocumentArray","Phd Assessment Report",Document.class),
    QUESTION("question_PhdAcademics_Text","Phd Assessment Report",String.class),
    ANSWER("answer_PhdAcademics_Text","Phd Assessment Report",String.class),
    PLAN_FOR_THE_NEXT_THREE_MONTHS_DOCUMENT_ARRAY("PlanForTheNextThreeMonthsDocumentArray_PhdAcademics_DocumentArray","Phd Assessment Report",Document.class),
    NUMBER("number_PhdAcademics_Text","Phd Assessment Report",String.class),
    TARGET("target_PhdAcademics_Text","Phd Assessment Report",String.class),
    EXPECTED_BY("expectedBy_PhdAcademics_Text","Phd Assessment Report",String.class),
    STATUS_AT_NEXT_RAC("statusAtNextRac_PhdAcademics_Text","Phd Assessment Report",String.class),
    REPORT_STATUS("reportStatus_PhdAcademics_Text", "Progress Report Status", String.class),
    MEETING_OR_REPORT("meetingOrReport_PhdAcademics_Text", "Progress Report Status", String.class),
    FEEDBACK_REQ_OR_NOT("feedbackReqOrNot_PhdAcademics_Bool", "Progress Report Status", Boolean.class),
    REPORT_SUBMISSION_DATE("reportSubmissionDate_PhdAcademics_Date", "Report Submission Date", Long.class),
    EXPERT_SIGNATURE_DATE("expertSignatureDate_PhdAcademics_Date", "Report Submission Date", Long.class),
    RSC_CHAIRPERSONS_SIGNATURE_DATE("rscChairpersonsSignatureDate_PhdAcademics_Date", "Report Submission Date", Long.class),

//    RSC Member Evaluation
RSC_MEMBER_EVALUATION_ID("rscMemeberEvaluationId_PhdAcademics_ObjectId", "RSC Evaluation Object Id", Object.class),
    RSC_MEMBER_EVALUATION_DOCUMENT_ARRAY("rscMemberEvaluationDocumentArray_PhdAcademics_DocumentArray","Phd RSC Member Evaluation Document Report",Document.class),
    EVALUATION_OF_RESEARCH_PROPOSAL_FRAMING_DOCUMENT_ARRAY("evaluationOfResearchProposalFramingDocumentArray_PhdAcademics_DocumentArray","Evaluation of Research Proposal Framing",Document.class),

    EVALUATION_CRITERION("evaluationCriterion_PhdAcademics_Text","Evaluation of Research Proposal Framing",String.class),
    RATE("rate_PhdAcademics_Text","Rate",String.class),
    OBSERVATIONS_AND_DIRECTIONS_DOCUMENT("observationsAndDirectionsDocument_PhdAcademics_Document","Observations and Directions",Document.class),
    RAC_RECOMMENDATION_DOCUMENT("racRecommendationDocument_PhdAcademics_Document","RAC Recommendation Document",Document.class),

    STRENGTHS_OBSERVED("strengthsObserved_PhdAcademics_Text","Strengths observed",String.class),
    AREAS_REQUIRING_IMPROVEMENT("areasRequiringImprovement_PhdAcademics_Text","Areas requiring improvement",String.class),
    SPECIFIC_ACTION_ITEMS_OR_DIRECTIONS("specificActionItemsOrDirections_PhdAcademics_TextArray","Specific action items or directions to the scholar",String.class),
    PROGRESS_SATISFACTORY("progressSatisfactory_PhdAcademics_Bool", "RAC Recommendation  Progress Satisfactory", Boolean.class),
    SATISFACTORY_WITH_REVISIONS("satisfactoryWithRevisions_PhdAcademics_Bool", "RAC Recommendation  Satisfactory with revisions", Boolean.class),
    UNSATISFACTORY("unsatisfactory_PhdAcademics_Bool", "RAC Recommendation  Unsatisfactory", Boolean.class),
    IS_SUPERVISOR("isSupervisor_PhdAcademics_Bool", "Is Supervisor", Boolean.class),
    TARGET_FOCUS_AREAS_FOR_NEXT_REVIEW("targetFocusAreasForNextReview_PhdAcademics_Text", "RAC Recommendation  Unsatisfactory", String.class),
    RSC_MEMBER_EVALUATION_STATUS("rscMemberEvaluationStatus_PhdAcademics_Text","RSC Member",String.class),
    RSC_SUPERVISOR_ACTIONS_DOCUMENT_ARRAY("rscSupervisorActionsDocumentArray_PhdAcademics_DocumentArray","RSC Supervisor Actions ",Document.class),
    ACTION_POINT("actionPoint_PhdAcademics_Text", "RAC Action point", String.class),
    ACTION_POINT_ID("actionPointId_PhdAcademics_Int", "RAC Action Id", Integer.class),
    PRIORITY("priority_PhdAcademics_Text", "Priority", String.class),
    RSC_MEMBER_OBJECT_ID("rscMemberObjectId_PhdAcademics_ObjectId", "RSC Member ObjectId", ObjectId.class),
    RSC_MEMBER_ACTION_POINTS_DOCUMENT_ARRAY("rscMemberActionPointsDocumentArray_PhdAcademics_DocumentArray","RSC Member Action Points ",Document.class),
    RSC_MEMBER_EMAIL_1("rscMemberEmail1_PhdAcademics_Text", "RSC Member 1", String.class),
    RSC_MEMBER_EMAIL_2("rscMemberEmail2_PhdAcademics_Text", "RSC Member 2", String.class),
    RSC_MEMBER_EMAIL_3("rscMemberEmail3_PhdAcademics_Text", "RSC Member 3", String.class),
    RSC_MEMBER_EMAIL_4("rscMemberEmail4_PhdAcademics_Text", "RSC Member 4", String.class),
    IS_PROGRESS_REPORT_LOCKED("isProgressReportLocked_PhdAcademics_Bool", "Is Progress Report Locked", Boolean.class),
    CONTEXT_TYPE("contextType_PhdAcademics_Text", "Is Progress Report Locked", String.class),
    CONTEXT_OBJECT_ID("contextObjectId_PhdAcademics_ObjectId", "Context ObjectId", ObjectId.class),
    PROGRESS_REPORT_REQUEST_OBJECT_ID("progressReportRequestObjectId_PhdAcademics_ObjectId", "Progress Report ObjectId", ObjectId.class),
    PROGRESS_REPORT_REQUEST_STATUS("progressReportRequestStatus_PhdAcademics_Text", "Progress Report Request Status", String.class),
    MARK_AS_COMPLETED_DATE("markAsCompletedDate_PhdAcademics_Date", "Meeting Completed  Date", Long.class),
    SELECTED_MONTH("selectedMonth_PhdAcademics_Int","Selected Month",Integer.class),
    SELECTED_YEAR("selectedYear_PhdAcademics_Int", "Selected Year", Integer.class),
    ACTION_POINT_OR_FEEDBACK("actionPointOrFeedback_PhdAcademics_Text", "Action Point or Feedback", String.class),




    ;



























    private final String property;
    private final String label;
    private final Class<?> dataType;
    private final int minLength;
    private final int maxLength;

    private PhdAcademicsKeyPBinder(String property, String label, Class<?> dataType, int minLength, int maxLength) {
        this.property = property;
        this.label = label;
        this.dataType = dataType;
        this.minLength = minLength;
        this.maxLength = maxLength;
    }

    private PhdAcademicsKeyPBinder(String property, String label, Class<?> dataType) {
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
    private static PhdAcademicsKeyPBinder[] $values() {
        return PhdAcademicsKeyPBinder.class.getEnumConstants();
    }
}
