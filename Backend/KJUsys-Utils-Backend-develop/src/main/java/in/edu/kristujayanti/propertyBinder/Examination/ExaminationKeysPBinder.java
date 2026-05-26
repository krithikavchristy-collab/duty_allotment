package in.edu.kristujayanti.propertyBinder.Examination;

import in.edu.kristujayanti.propertyBinder.KJUSYSPropertyBinder;
import org.bson.Document;
import org.bson.types.ObjectId;

public enum ExaminationKeysPBinder implements KJUSYSPropertyBinder {

    /// QUESTION PAPER PATTERN
    QUESTION_PAPER_SUB_QUESTION("questionPaperSubQuestion_Examination_text", "Question Paper Sub Question",
            String.class),
    QUESTION_PAPER_HAS_SUB_QUESTION("questionPaperHasSubQuestion_Examination_Bool",
            "Question Paper Has Sub Question",
            Boolean.class),
    QUESTION_NUMBER_HAS_SUB_QUESTION("questionNumberHasSubQuestion_Examination_Bool",
            "Question Number Has Sub Question", Boolean.class),
    QUESTION_PAPER_HAVE_OR_QUESTION("questionPaperHaveOrQuestion_Examination_Bool",
            "Question Paper Have Or Question",
            Boolean.class),
    QUESTION_NUMBER_HAVE_OR_QUESTION("questionNumberHaveOrQuestion_Examination_Bool",
            "Question Number Have Or Question", Boolean.class),
    EVALUATION_TIMESTAMP("evaluationTimestamp_Examination_DateTime", "Evaluation Timestamp", Long.class),

    // mode of valuation
    EXAM_VALUATION_MODE_NAME("examValuationModeName_Examination_Text", "Exam Valuation Mode Name", String.class),
    EXAM_VALUATION_MODE_OID("examValuationModeOid_Examination_ObjectId", "Exam Valuation Mode Oid", ObjectId.class),
    NUMBER_OF_VALUATION_PER_SCRIPT("numberOfValuationPerScript_Examination_Int", "Number Of Valuation Per Script",
            Integer.class),

    NUMBER_OF_VALUATION_SCRIPTS("numberOfValuationScripts_Examination_Int", "Number Of Valuation Scripts",
            Integer.class),

    // exam grading
    OBTAINED_MARKS_FOR_QUESTION_NUMBER("obtainedMarksForQuestionNumber_Examination_Double",
            "Obtained Marks For Question Number", Double.class),
    SUB_QUESTION_OBTAINED_MARKS("subQuestionObtainedMarks_Examination_Double", "Sub Question Obtained Marks",
            Double.class),
    // QUESTION_NUMBER_OBTAINED_MARKS("questionNumberObtainedMarks_Examination_Text","Question
    // Number Obtained Marks", String.class),
    IS_QUESTION_NUMBER_NOT_ATTEMPTED("isQuestionNumberNotAttempted_Examination_Bool",
            "Is Question Number Not Attempted", Boolean.class),

    EVALUATOR_TYPE("evaluatorType_Examination_Text", "Evaluator Type", String.class),
    FEEDBACK_FOR_QUESTION_NUMBER("feedbackForQuestionNumber_Examination_Text", "Feedback For Question Number",
            String.class),
    QUESTION_PAPER_HAVE_MALPRACTICE("questionPaperHaveMalpractice_Examination_Bool",
            "Question Paper Have Malpractice",
            Boolean.class),
    MALPRACTICE_REMARKS("malpracticeRemarks_Examination_Text", "Malpractice Remarks", String.class),

    EXAM_SCRIPT_UNIQUE_ID("examScriptUniqueId_Examination_Text", "Exam Script Unique Id", String.class),
    TOTAL_NUMBER_OF_SCRIPTS("totalNumberOfScripts_Examination_Int", "Total Number Of Scripts", Integer.class),
    EXAM_TYPE("examType_Examination_Text", "Exam Type", String.class),
    EXAM_TYPE_OID("examTypeOid_Examination_Text", "Exam Type Oid", String.class),
    EXAM_TYPE_TEXT_ARRAY("examTypeTextArray_Examination_TextArray", "Exam Type Text Array", String.class),
    MODE_OF_EVALUATION("modeOfEvaluation_Examination_Text", "Mode Of Evaluation", String.class),
    MODE_OF_EVALUATION_OID("modeOfEvaluationOid_Examination_Text", "Mode Of Evaluation Oid", String.class),
    VALUERS_ASSIGNED("valuersAssigned_Examination_DocumentArray", "Valuers Assigned", String.class),
    VALUATION_START_DATE("valuationStartDate_Examination_Date", "Valuation Start Date", Long.class),
    EVALUATORS_EMP_CODE("evaluatorsEmpCode_Examination_Text", "Evaluators Emp Code", String.class),
    EVALUATORS_OID("evaluatorsOid_Examination_ObjectId", "Evaluators Oid", ObjectId.class),
    ALLOTTED_COURSES_FOR_EVALUATION("allottedCoursesForEvaluation_Examination_DocumentArray",
            "Allotted Courses For Evaluation", Document.class),
    TOTAL_SCRIPTS_EVALUATED("totalScriptsEvaluated_Examination_Int", "Total Scripts Evaluated", Integer.class),
    TOTAL_SCRIPTS_REVIEWED("totalScriptsReviewed_Examination_Int", "Total Scripts Reviewed", Integer.class),
    REMAINING_REVIEWED_SCRIPTS("remainingReviewedScripts_Examination_Int", "Remaining Reviewed Scripts",
            Integer.class),
    TOTAL_REVIEW_SCRIPTS("totalReviewScripts_Examination_Int", "Total Review Scripts", Integer.class),
    TOTAL_SCRIPTS_EVALUATED_SELF("totalScriptsEvaluatedSelf_Examination_Int", "Total Scripts Evaluated Self",
            Integer.class),
    REMAINING_SCRIPTS("remainingScripts_Examination_Int", "Remaining Scripts", Integer.class),
    INDIVIDUAL_EVALUATION_AT_MAX_PER_DAY("individualEvaluationAtMaxPerDay_Examination_Int",
            "Individual Evaluation At Max Per Day", Integer.class),
    DAYS_LEFT_FOR_EVALUATION("daysLeftForEvaluation_Examination_Int", "Days Left For Evaluation", Integer.class),
    EVALUATORS_EMAIL("evaluatorsEmail_Examination_Text", "Evaluators Email", String.class),
    QUESTION_PAPER_PATTERN_NAME("questionPaperPatternName_Examination_Text", "Question Paper Pattern Name",
            String.class),
    // QUESTION_PAPER_PATTERN_OID("questionPaperPatternOid_Examination_ObjectId",
    // "Question Paper Pattern Oid", ObjectId.class),
    QUESTION_PAPER_TOTAL_ALLOTTED_MARKS("questionPaperTotalAllottedMarks_Examination_Double",
            "Question Paper Total Allotted Marks", Double.class),
    QUESTION_PAPER_TOTAL_OBTAINED_MARKS("questionPaperTotalObtainedMarks_Examination_Double",
            "Question Paper Total Obtained Marks", Double.class),

    NUMBER_OF_COPIES_EVALUATED_PER_DAY_LOGS("numberOfCopiesEvaluatedPerDayLogs_Examination_DocumentArray",
            "Number Of Copies Evaluated Per Day Logs", Document.class),
    NUMBER_OF_COPIES_EVALUATED("numberOfCopiesEvaluated_Examination_Int", "Number Of Copies Evaluated",
            Integer.class),
    EVALUATION_DATE("evaluationDate_Examination_Date", "Evaluation Date", Long.class),

    // question paper sections
    QUESTION_PAPER_SECTIONS_DOCUMENT_ARRAY("questionPaperSectionsDocumentArray_Examination_DocumentArray",
            "Question Paper Sections Document Array", String.class),
    QUESTION_PAPER_NUMBER_OF_SECTIONS("questionPaperNumberOfSections_Examination_Int",
            "Question Paper Number Of Sections", Integer.class),
    QUESTION_PAPER_SECTION_ID("questionPaperSectionId_Examination_Text", "Question Paper Section Id", String.class),
    QUESTION_PAPER_SECTION_NAME("questionPaperSectionName_Examination_Text", "Question Paper Section Name",
            String.class),

    // question groups
    QUESTION_GROUPS_DOCUMENT_ARRAY("questionGroupsDocumentArray_Examination_DocumentArray",
            "Question Groups Document Array", String.class),
    QUESTION_GROUP_ID("questionGroupId_Examination_Text", "Question Group Id", String.class),
    IS_OR_GROUP("isOrGroup_Examination_Bool", "Is Or Group", Boolean.class),
    MAX_QUESTIONS_TO_ATTEMPT_IN_OR_GROUP("maxQuestionsToAttemptInOrGroup_Examination_Int",
            "Max Questions To Attempt In Or Group", Integer.class),

    // questions
    QUESTIONS_DOCUMENT_ARRAY("questionsDocumentArray_Examination_DocumentArray", "Questions Document Array",
            String.class),
    QUESTION_ID("questionId_Examination_Text", "Question Id", String.class),
    QUESTION_NUMBER_OR_NAME("questionNumberOrName_Examination_Text", "Question Number Or Name", String.class),
    QUESTION_NUMBER_ALLOTTED_MARKS("questionNumberAllottedMarks_Examination_Double",
            "Question Number Allotted Marks",
            Double.class),
    IS_OR_QUESTION_GROUP("IsOrQuestionGroup_Examination_Bool", "Is Or Question Group", Boolean.class),
    OR_QUESTIONS_DOCUMENT_ARRAY("orQuestionsDocumentArray_Examination_DocumentArray", "Or Questions Document Array",
            String.class),
    QUESTION_ATTEMPT_TYPE("questionAttemptType_Examination_Text", "Question Attempt Type", String.class),
    MAX_QUESTIONS_TO_ATTEMPT_IN_SECTION("maxQuestionsToAttemptInSection_Examination_Int",
            "Max Questions To Attempt In Section", Integer.class),
    MAX_MARK_FOR_EACH_QUESTION_IN_SECTION("maxMarkForEachQuestionInSection_Examination_Double",
            "Max Mark For Each Question In Section", Double.class),

    // sub question
    QUESTION_NUMBER_HAVE_SUB_QUESTION("questionNumberHaveSubQuestion_Examination_Bool",
            "Question Number Have Sub Question", Boolean.class),
    QUESTION_NUMBER_SUB_QUESTIONS_DOCUMENT_ARRAY(
            "questionNumberSubQuestionsDocumentArray_Examination_DocumentArray",
            "Question Number Sub Questions Document Array", String.class),
    SUB_QUESTION_ID("subQuestionId_Examination_Text", "Sub Question Id", String.class),
    SUB_QUESTION_NUMBER_OR_NAME("subQuestionNumberOrName_Examination_Text", "Sub Question Number Or Name",
            String.class),
    SUB_QUESTION_ALLOTTED_MARKS("subQuestionAllottedMarks_Examination_Double", "Sub question Allotted Marks",
            Double.class),
    // SUB_QUESTION_OBTAINED_MARKS("subQuestionObtainedMarks_Examination_Double","Sub
    // question Obtained Marks", Double.class),
    QUESTION_NUMBER_COURSE_OUTCOME("questionNumberCourseOutcome_Examination_Text", "Question Number Course Outcome",
            String.class),
    QUESTION_NUMBER_BLOOMS_LEVEL("questionNumberBloomsLevel_Examination_Text", "Question Number Blooms Level",
            String.class),

    QUESTION_PAPER_PATTERN_FROM_DATE("questionPaperPatternFromDate_Examination_Date",
            "Question Paper Pattern From Date", Long.class),
    QUESTION_PAPER_PATTERN_TO_DATE("questionPaperPatternToDate_Examination_Date", "Question Paper Pattern To Date",
            Long.class),
    // QUESTION_PAPER_PATTERN_OID("questionPaperPatternOid_Examination_ObjectId",
    // "Question Paper Pattern Oid", Object.class),
    QUESTION_PAPER_PATTERN_OID("questionPaperPatternOid_Examination_ObjectId", "Question Paper Pattern Oid",
            Object.class),

    // mode of valuation
    VALUATION_MODE_NAME("valuationModeName_Examination_Text", "Valuation Mode Name", String.class),
    NUMBER_OF_VALUATIONS_PER_SCRIPT("numberOfValuationsPerScript_Examination_Int",
            "Number Of Valuations Per Script",
            Integer.class),
    NUMBER_OF_REVIEWS_PER_SCRIPT("numberOfReviewsPerScript_Examination_Int", "Number Of Reviews Per Script",
            Integer.class),
    PERCENTAGE_OF_SCRIPTS_FOR_REVIEW("percentageOfScriptsForReview_Examination_Percentage",
            "Percentage Of Scripts For Review", Double.class),

    // create exam
    EXAM_CODE("examCode_Examination_Text", "Exam Code", String.class),
    EXAM_OID("examOid_Examination_ObjectId", "Exam Oid", ObjectId.class),
    EXAM_ID("examId_Examination_Text", "Exam Id", String.class),
    DEANERY("deanery_Examination_Text", "Deanery", String.class),
    DEANERY_LIST("deaneryList_Examination_TextArray", "Deanery List", String.class),
    EXAM_CREATED_DATE("examCreatedDate_Examination_Date", "Exam Created Date", Long.class),
    EXAM_CREATED_BY("examCreatedBy_Examination_Text", "Exam Created By", String.class),
    NUMBER_OF_COURSES_IN_EXAM("numberOfCoursesInExam_Examination_Int", "Number Of Courses In Exam", Integer.class),
    EXAM_CUSTODIANS_DOCUMENT_ARRAY("examCustodiansDocumentArray_Examination_DocumentArray",
            "Exam Custodians Document Array", String.class),
    EXAM_CUSTODIAN_EMPLOYEE_CODE("examCustodianEmployeeCode_Examination_Text", "Exam Custodian Employee Code",
            String.class),
    EXAM_CUSTODIAN_NAME("examCustodianName_Examination_Text", "Exam Custodian Name", String.class),
    EXAM_CUSTODIAN_OID("examCustodianOid_Examination_Text", "Exam Custodian Oid", String.class),
    EXAM_CUSTODIAN_EMAIL("examCustodianEmail_Examination_Text", "Exam Custodian Email", String.class),

    // Course code
    COURSE_CODE("courseCode_Examination_Text", "Course Code", String.class),
    COURSE_OID("courseOid_Examination_Text", "Course Oid", String.class),
    COURSE_OBJECT_ID("courseObjectId_Examination_ObjectId", "Course ObjectId", ObjectId.class),
    COURSE_OID_ARRAY("courseOidArray_Examination_TextArray", "Course Oid Array", String.class),
    COURSE_NAME("courseName_Examination_Text", "Course Name", String.class),
    NUMBER_OF_ELIGIBLE_STUDENTS_FOR_EXAM("numberOfEligibleStudentsForExam_Examination_Int",
            "Number Of Eligible Students For Exam", Integer.class),
    PROGRAMME_NAME("programmeName_Examination_Text", "Programme Name", String.class),
    // script upload path

    ANSWER_SCRIPT_OID("answerScriptOid_Examination_ObjectId", "Answer Script Oid", ObjectId.class),
    TOTAL_NUMBER_OF_ANSWER_SCRIPTS("totalNumberOfAnswerScripts_Examination_Int", "Total Number Of Answer Scripts",
            Integer.class),
    QUESTION_PAPER_PDF_FILE("questionPaperPdfFile_Examination_Text", "Question Paper PDF File", String.class),
    ANSWER_KEY_PDF_FILE("answerKeyPdfFile_Examination_Text", "Answer Key PDF File", String.class),
    ANSWER_SCRIPTS_ZIP_FILE("answerScriptsZipFile_Examination_File", "Answer Scripts Zip File", String.class),
    ANSWER_SCRIPT_PDF_FILE("answerScriptPdfFile_Examination_Text", "Answer Script PDF File", String.class),
    MARKS_CAPTURE_RECORD_METHOD("marksCaptureRecordMethod_Examination_Text", "Marks Capture Record Method",
            String.class),

    EXAM_VALUERS_MAP_DOCUMENT_ARRAY("examValuersMapDocumentArray_Examination_DocumentArray",
            "Exam Valuers Map Document Array", String.class),
    EXAM_VALUER_NAME("examValuerName_Examination_Text", "Exam Valuer Name", String.class),
    NO_OF_EXAM_VALUER_ASSIGNED("noOfExamValuerAssigned_Examination_Int", "No Of Exam Valuer Assigned",
            Integer.class),
    EXAM_VALUER_OID("examValuerOid_Examination_Text", "Exam Valuer Oid", String.class),
    EXAM_VALUER_EMAIL("examValuerEmail_Examination_Text", "Exam Valuer Email", String.class),

    IS_VALUER_ASSIGNED_AS_REVIEWER("isValuerAssignedAsReviewer_Examination_Bool", "Is Valuer Assigned As Reviewer",
            Boolean.class),
    EMPLOYEE_EVALUATION_ROLE("employeeEvaluationRole_Examination_Text", "Employee Evaluation Role", String.class),
    SCHOOLS_LIST("schoolsList_Examination_TextArray", "Schools List", String.class),

    // IS_VALUER_ASSIGNED_AS_REVIEWER("isValuerAssignedAsReviewer_Examination_Bool",
    // "Is Valuer Assigned As Reviewer", Boolean.class),

    EVALUATION_START_DATE("evaluationStartDate_Examination_Date", "Evaluation Start Date", Long.class),
    EVALUATION_END_DATE("evaluationEndDate_Examination_Date", "Evaluation End Date", Long.class),
    MAX_PAPERS_PER_DAY_PER_VALUER("maxPapersPerDayPerValuer_Examination_Int", "Max Papers Per Day Per Valuer",
            Integer.class),
    ANSWER_SHEET_BARCODE("answerSheetBarcode_Examination_Text", "Answer Sheet Barcode", String.class),
    ANSWER_SCRIPT_UPLOADED_DATE("answerScriptUploadedDate_Examination_Date", "Answer Script Uploaded Date",
            Long.class),
    ANSWER_SCRIPT_STATUS("answerScriptStatus_Examination_Text", "Answer Script Status", String.class),
    IS_SCRIPT_EVALUATION_COMPLETED("isScriptEvaluationCompleted_Examination_Bool", "Is Script Evaluation Completed",
            Boolean.class),
    IS_SCRIPT_REVIEW_COMPLETED("isScriptReviewCompleted_Examination_Bool", "Is Script Review Completed",
            Boolean.class),
    IS_BEING_REVIEWED("isBeingReviewed_Examination_Bool", "Is Being Reviewed", Boolean.class),
    IS_BEING_EVALUATED("isBeingEvaluated_Examination_Bool", "Is Being Evaluated", Boolean.class),
    IS_BEING_REEVALUATED("isBeingReevaluated_Examination_Bool", "Is Being Reevaluated", Boolean.class),
    IS_DRAFT("isDraft_Examination_Bool", "Is Draft", Boolean.class),
    NUMBER_OF_EVALUATION_COMPLETED("numberOfEvaluationCompleted_Examination_Int", "Number Of Evaluation Completed",
            Integer.class),
    NUMBER_OF_REVIEWS_COMPLETED("numberOfReviewsCompleted_Examination_Int", "Number Of Reviews Completed",
            Integer.class),
    ANSWER_SCRIPT_EVALUATION_TYPE("answerScriptEvaluationType_Examination_Text", "Answer Script Evaluation Type",
            String.class),

    IS_OR_SUB_QUESTION_GROUP("isOrSubQuestionGroup_Examination_Bool", "Is Or Sub Question Group", Boolean.class),
    OR_SUB_QUESTIONS_DOCUMENT_ARRAY("orSubQuestionsDocumentArray_Examination_DocumentArray",
            "Or Sub Questions Document Array", String.class),

    FINAL_OBTAINED_MARKS("finalObtainedMarks_Examination_Double", "Final Obtained Marks", Double.class),
    GRACE_MARKS("graceMarks_Examination_Double", "Grace Marks", Double.class),
    TOTAL_OBTAINED_MARKS_SECTIONWISE("totalObtainedMarksSectionwise_Examination_Double",
            "Total Obtained Marks Sectionwise", Double.class),

    ANSWER_SHEET_EVALUATION("answerSheetEvaluation_Examination_DocumentArray", "Answer Sheet Evaluation",
            Document.class),

    // OR_SUB_QUESTIONS_DOCUMENT_ARRAY("orSubQuestionsDocumentArray_Examination_DocumentArray",
    // "Or Sub Questions Document Array", String.class),
    NUMBER_OF_REVALUATION_COMPLETED("numberOfRevaluationCompleted_Examination_Int",
            "Number Of Revaluation Completed",
            Integer.class),
    IS_STAFF_REEVALUATOR("isStaffReevaluator_Examination_Bool", "Is Staff Reevaluator", Boolean.class),
    IS_REEVALUATION_DONE("isReevaluationDone_Examination_Bool", "Is Reevaluation Done", Boolean.class),
    IS_ANSWER_SCRIPT_SEND_FOR_REEVALUATION("isAnswerScriptSendForReevaluation_Examination_Bool",
            "Is Answer Script Send For Reevaluation", Boolean.class),
    TOTAL_REEVALUATION_SCRIPTS("totalReevaluationScripts_Examination_Int", "Total Reevaluation Scripts",
            Integer.class),
    REMAINING_REEVALUATION_SCRIPTS("remainingReevaluationScripts_Examination_Int", "Remaining Reevaluation Scripts",
            Integer.class),
    EVALUATED_REEVALUATION_SCRIPTS("evaluatedReevaluationScripts_Examination_Int", "Evaluated Reevaluation Scripts",
            Integer.class),
    TOTAL_OBTAINED_MARKS_PER_VALUATION("totalObtainedMarksPerValuation_Examination_Double",
            "Total Obtained Marks Per Valuation", Double.class),

    // S3 keys

    S3_UPLOAD_ZIP_ID("s3UploadZipId_Examination_Text", "S3 Upload Zip Id", String.class),
    S3_UPLOAD_ZIP_PATH_KEY("s3UploadZipPathKey_Examination_Text", "S3 Upload Zip Path Key", String.class),
    S3_UPLOAD_PART_SIZE_RECOMMENDED("s3UploadPartSizeRecommended_Examination_Long",
            "S3 Upload Part Size Recommended",
            Long.class),
    S3_BUCKET_NAME("s3BucketName_Examination_Text", "S3 Bucket Name", String.class),
    S3_TOTAL_PARTS_UPLOADED("s3TotalPartsUploaded_Examination_Int", "S3 Total Parts Uploaded", Integer.class),
    S3_UPLOAD_FILE_SIZE("s3UploadFileSize_Examination_Long", "S3 Upload File Size", Long.class),
    S3_UPLOAD_FILE_NAME("s3UploadFileName_Examination_Text", "S3 Upload File Name", String.class),

    GRACE_MARKS_REMARKS("graceMarksRemarks_Examination_Text", "Grace Marks Remarks", String.class),
    REVALUATOR_ASSIGNED_BY("revaluatorAssignedBy_Examination_Text", "Revaluator Assigned By", String.class),
    REVALUATOR_UPDATED_ON("revaluatorUpdatedOn_Examination_DateTime", "Revaluator Updated On", Long.class),
    REVALUATION_ASSIGNED_TO_EXAMINATION("revaluationAssignedToExamination_Examination_TextArray",
            "Revaluation Assigned to Examination", String.class),
    EXAM_DATE("examDate_Examination_Date", "Exam Date", Long.class),
    EXAM_SESSION("examSession_Examination_Text", "Exam Session", String.class),
    EXAM_SESSION_UPDATED_BY("examSessionUpdatedBy_Examination_Text", "Exam Session Updated By", String.class),
    EXAM_SESSION_UPDATED_ON("examSessionUpdatedOn_Examination_DateTime", "Exam Session Updated On", Long.class),
    EXAM_CONDUCTED_DETAILS("examConductedDetails_Examination_DocumentArray", "Exam Conducted Details",
            Document.class),
    EXAM_ROOM("examRoom_Examination_Text", "Exam Room", String.class),

    // dispatch summary
    EXAM_ATTENDANCE_STATUS("examAttendanceStatus_Examination_Bool", "Exam Attendance Status", Boolean.class),
    EXAM_SCRIPT_PACKET_REFERENCE_NUMBER("examScriptPacketReferenceNumber_Examination_Text",
            "Exam Script Packet Reference Number", String.class),
    PACKET_ROLL_NUMBER_RANGE("packetRollNumberRange_Examination_Text", "Packet Roll Number Range", String.class),
    EXAM_ROOM_NUMBERS("examRoomNumbers_Examination_TextArray", "Exam Room Numbers", String.class),
    TOTAL_NUMBER_OF_SCRIPTS_PER_PACKET("totalNumberOfScriptsPerPacket_Examination_Int",
            "Total Number Of Scripts Per Packet", Integer.class),
    FULL_PACKETS_NUMBER("fullPacketsNumber_Examination_Int", "Full Packets Number", Integer.class),
    PARTIAL_PACKETS_NUMBER("partialPacketsNumber_Examination_Int", "Partial Packets Number", Integer.class),
    PARTIAL_PACKET_SCRIPTS_COUNT("partialPacketScriptsCount_Examination_Int", "Partial Packet Scripts Count",
            Integer.class),
    TOTAL_NUMBER_OF_SCRIPTS_IN_COURSE("totalNumberOfScriptsInCourse_Examination_Int",
            "Total Number Of Scripts In Course", Integer.class),
    PACKETS_DISPATCHED_DOCUMENT_ARRAY("packetsDispatchedDocumentArray_Examination_DocumentArray",
            "Packets Dispatched Document Array", Document.class),
    COURSES_DISPATCH_SUMMARY_DOCUMENT_ARRAY("coursesDocumentArray_Examination_DocumentArray",
            "Courses Document Array",
            Document.class),
    EXAM_DISPATCH_SUMMARY_GENERATED_ON("examDispatchSummaryGeneratedOn_Examination_DateTime",
            "Exam Dispatch Summary Generated On", Long.class),
    PACKET_ROLL_NUMBER_RANGE_DOCUMENT_ARRAY("packetRollNumberRangeDocumentArray_Examination_DocumentArray",
            "Packet Roll Number Range Document Array", Document.class),
    PACKET_ROLL_NUMBER_FROM("packetRollNumberFrom_Examination_Text", "Packet Roll Number From", String.class),
    PACKET_ROLL_NUMBER_TO("packetRollNumberTo_Examination_Text", "Packet Roll Number To", String.class),
    SUBJECT_TYPE("subjectType_Examination_Text", "Subject Type", String.class),
    SUBJECT_CODE("subjectCode_Examination_Text", "Subject Code", String.class),
    SUBJECT_NAME("subjectName_Examination_Text", "Subject Name", String.class),
    OBTAINED_MARKS("obtainedMarks_Examination_Double", "Obtained Marks", Double.class),
    MAXIMUM_MARKS("maximumMarks_Examination_Double", "Maximum Marks", Double.class),
    OBTAINED_GRADE("obtainedGrade_Examination_Text", "Obtained Grade", String.class),
    IS_BACKLOG("isBacklog_Examination_Bool", "Is Backlog", Boolean.class),
    IS_PASS("isPass_Examination_Bool", "Is Pass", Boolean.class),

    // restrict ip
    RESTRICTED_SERVICE_NAME("restrictedServiceName_Examination_Text", "Restricted Service Name", String.class),
    WHITELISTED_CIDR_DETAILS("whitelistedCidrDetails_Examination_DocumentArray", "Whitelisted Cidr Details",
            Document.class),
    WHITELISTED_CIDR("whitelistedCidr_Examination_Text", "Whitelisted Cidr", String.class),
    CIDR_DESCRIPTION("cidrDescription_Examination_Text", "Cidr Description", String.class),

    IS_EVALUATOR_PASSED_QC("isEvaluatorPassedQc_Examination_Bool", "Is Evaluator Passed QC", Boolean.class),
    IS_EVALUATOR_PENDING_QC("isEvaluatorPendingQc_Examination_Bool", "Is Evaluator Pending Qc", Boolean.class),
    EVALUATION_QC_REVIEWED_BY("evaluationQcReviewedBy_Examination_Text", "Qc reviewed By", String.class),
    EVALUATION_QC_REVIEWED_ON("evaluationQcReviewedOn_Examination_DateTime", "Qc Reviwed On", Long.class),
    EVALUATION_QC_REVIEWER_EMAIL("evaluationQcReviewerEmail_Examination_Text", "Evaluation Qc Reviewer Email",
            String.class),
    NUMBER_OF_QC_COMPLETED_SCRIPTS("numberOfQcCompletedScripts_Examination_Int", "Number of QC completed Scripts",
            Integer.class),
    SCRIPT_QC_THRESHOLD("scriptQcThreshold_Examination_Int", " Script QC Threshold", Integer.class),
    IS_SCRIPT_QC_PASSED("isScriptQcPassed_Examination_Bool", "Is script QC passed", Boolean.class),
    SCRIPT_QC_REVIEWED_BY("scriptQcReviewedBy_Examination_Text", "Script QC Reviewed By", String.class),
    DIGITAL_VALUATION_ASSIGNED_MODE("digitalValuationAssignedMode_Examination_Text",
            "Digital valuation Assigned mode", String.class),
    SCRIPT_QC_MODE("scriptQcMode_Examination_Text", "Script QC mode", String.class),

    ASSIGNED_QUALITY_REVIEWER_EMAIL("assignedQualityReviewerEmail_Examination_Text",
            "Assigned Quality Reviewer Email", String.class),
    ASSIGNED_QUALITY_REVIEWER_NAME("assignedQualityReviewerName_Examination_Text", "Assigned Quality Reviewer Name",
            String.class),
    IS_EVALUATOR_BLOCKED_FOR_QC("isEvaluatorBlockedForQc_Examination_Bool", "Is Evaluator Blocked For Qc",
            Boolean.class),
    SCRIPT_PAUSED_MESSAGE("scriptPausedMessage_Examination_Text", "Script Paused Message", String.class),
    VALUATION_REMAINING_DAYS("valuationRemainingDays_Examination_Int", "Valuation Remaining Days", Integer.class),
    QUALITY_CHECK_REMAINING_DAYS("qualityCheckRemainingDays_Examination_Int", "Quality Check Remaining Days",
            Integer.class),

    // QC related fields
    QUALITY_CHECK_REMAINING_SCRIPTS("qualityCheckRemainingScripts_Examination_Int",
            "Quality Check Remaining Scripts", Integer.class),
    QUALITY_CHECK_STATUS("qualityCheckStatus_Examination_Text", "Quality Check Status", String.class),
    QUALITY_CHECK_STATUS_MESSAGE("qualityCheckStatusMessage_Examination_Text", "Quality Check Status Message",
            String.class),
    IS_QUALITY_CHECK_PENDING("isQualityCheckPending_Examination_Bool", "Is Quality Check Pending", Boolean.class),
    IS_QUALITY_CHECK_PASSED("isQualityCheckPassed_Examination_Bool", "Is Quality Check Passed", Boolean.class),
    IS_BLOCKED_FOR_QUALITY_CHECK("isBlockedForQualityCheck_Examination_Bool", "Is Blocked For Quality Check",
            Boolean.class),
    QUALITY_CHECK_REQUIRED_ACTION("qualityCheckRequiredAction_Examination_Text", "Quality Check Required Action",
            String.class),
    QUALITY_CHECK_COMPLETION_PERCENTAGE("qualityCheckCompletionPercentage_Examination_Double",
            "Quality Check Completion Percentage", Double.class),
    EVALUATOR__QC_SUBMISSION_PROGRESS_PERCENTAGE("evaluatorQcSubmissionProgressPercentage_Examination_Double",
            "Evaluator Qc Submission Progress Percentage", Double.class),

    FACULTY_SCRIPT_EVALUATION_MENU("facultyScriptEvaluationMenu_Examination_Text", "Faculty Script Evaluation Menu",
            String.class),

    /// / question bank

    APPLICABLE_EXAMS_OID_FOR_QUESTION("applicableExamsOidForQuestion_Examination_TextArray", "Applicable Exams Oid For Question", String.class),
    UNIT_NUMBER_FOR_QUESTION("unitNumberForQuestion_Examination_Text", "Unit Number For Question", String.class),
    UNIT_NUMBERS_FOR_QUESTION("unitNumbersForQuestion_Examination_TextArray", "Unit Numbers For Question", String.class),
    QUESTION_OID("questionOid_Examination_ObjectId", "Question Oid", ObjectId.class),
    QUESTION_TEXT("questionText_Examination_JsonObject", "Question Text", Document.class),
    SUB_QUESTION_TEXT("subQuestionText_Examination_JsonObject", "Sub Question Text", String.class),
    ANSWER_SCRIPT_SCHEME("answerScriptScheme_Examination_JsonObject", "Answer Script Scheme", Document.class),
    SUB_QUESTION_ANSWER_SCRIPT_SCHEME("subQuestionAnswerScriptScheme_Examination_JsonObject", "Sub Question Answer Script Scheme", Document.class),
    IS_QUESTION_THEORY("isQuestionTheory_Examination_Bool", "Is Question Theory", Boolean.class),
    QUESTION_ANSWER_KEY("questionAnswerKey_Examination_JsonObject", "Question Answer Key", Document.class),
    SUB_QUESTION_ANSWER_KEY("subQuestionAnswerKey_Examination_JsonObject", "Sub Question Answer Key",
            Document.class),
    TOTAL_MARKS_FOR_QUESTION("totalMarksForQuestion_Examination_Double", "Total Marks For Question", Double.class),
    MARKS_ALLOTTED_FOR_SUB_QUESTION("marksAllottedForSubQuestion_Examination_Double",
            "Marks Allotted For Sub Question",
            Double.class),

    /// faculty dashboard for question bank

    TOTAL_QUESTIONS_CONTRIBUTED("totalQuestionsContributed_Examination_Int", "Total Questions Contributed", Integer.class),
    TOTAL_QUESTIONS_CONTRIBUTED_FOR_APPROVAL("totalQuestionsContributedForApproval_Examination_Int", "Total Questions Contributed For Approval", Integer.class),
    TOTAL_QUESTIONS_APPROVED_FROM_CONTRIBUTED("totalQuestionsApprovedFromContributed_Examination_Int", "Total Questions Approved From Contributed", Integer.class),
    TOTAL_QUESTIONS_REVERTED_FROM_CONTRIBUTED("totalQuestionsRevertedFromContributed_Examination_Int", "Total Questions Reverted From Contributed", Integer.class),
    TOTAL_QUESTIONS_CONTRIBUTED_PER_MONTH("totalQuestionsContributedPerMonth_Examination_Int", "Total Questions Contributed Per Month", Integer.class),
    QUESTION_CONTRIBUTED_MONTH("questionContributedMonth_Examination_Text", "Question Contributed Month", String.class),
    QUESTION_CONTRIBUTED_WEEK("questionContributedWeek_Examination_Text", "Question Contributed Week", String.class),
    QUESTION_CONTRIBUTED_DATE("questionContributedDate_Examination_Date", "Question Contributed Date", Long.class),
    TOTAL_QUESTIONS_UNDER_REVIEW("totalQuestionsUnderReview_Examination_Int", "Total Questions Under Review", Integer.class),
    QUESTION_APPROVAL_STATUS("questionApprovalStatus_Examination_Text", "Question Approval Status", String.class),
    QUESTION_REVIEW_REMARKS("questionReviewRemarks_Examination_Text", "Question Review Remarks", String.class),
    QUESTION_APPROVED_BY("questionApprovedBy_Examination_Text", "Question Approved By", String.class),
    QUESTION_APPROVED_ON("questionApprovedOn_Examination_DateTime", "Question Approved On", Long.class),

        MANDATORY_QUESTIONS_COUNT("mandatoryQuestionsCount_Examination_Int", "Mandatory Questions Count",
                        Integer.class),
        MANDATORY_QUESTIONS_COUNT_FOR_LEVEL_EASY("mandatoryQuestionsCountForLevelEasy_Examination_Int",
                        "Mandatory Questions Count For Level Easy", Integer.class),
        MANDATORY_QUESTIONS_COUNT_FOR_LEVEL_MEDIUM("mandatoryQuestionsCountForLevelMedium_Examination_Int",
                        "Mandatory Questions Count For Level Medium", Integer.class),
        MANDATORY_QUESTIONS_COUNT_FOR_LEVEL_DIFFICULT("mandatoryQuestionsCountForLevelDifficult_Examination_Int",
                        "Mandatory Questions Count For Level Difficult", Integer.class),
        ANSWER_KEY_TEXT("answerKeyText_Examination_Text", "Answer Key Text", String.class),
        APPLICABLE_EXAMS_OID_ARRAY("applicableExamsOidArray_Examination_TextArray", "Applicable Exams Oid Array",
                        String.class),
        APPLICABLE_EXAM_DOCUMENT_ARRAY("applicableExamDocumentArray_Examination_DocumentArray",
                        "Applicable Exam Document Array", Document.class),
        APPLICABLE_EXAM_GROUP_OID("applicableExamGroupOid_Examination_ObjectId", "Applicable Exam Group Oid",
                        ObjectId.class),
        EXAM_CATEGORY_NAMES("examCategoryNames_Examination_TextArray", "Exam Category Names", String.class),
        DIFFICULTY_LEVEL("difficultyLevel_Examination_Text", "Difficulty Level", String.class),
        COURSE_LEARNING_OUTCOME("courseLearningOutcome_Examination_Text", "Course Learning Outcome", String.class),
        COURSE_LEARNING_OUTCOMES("courseLearningOutcomes_Examination_TextArray", "Course Learning Outcomes", String.class),
        SUB_QUESTION_DOCUMENT_ARRAY("subQuestionDocumentArray_Examination_DocumentArray", "Sub Question Document Array",
                        String.class),
        QUESTION_CONTRIBUTED_BY("questionContributedBy_Examination_Text", "Question Contributed By", String.class),
        QUESTION_PAPER_IMAGE("questionPaperImage_Examination_File", "Question Paper Image", String.class),
        BLOOMS_LEVEL_DOCUMENT("bloomsLevelDocument_Examination_Document", "Blooms Level Document", Document.class),
        BLOOMS_LEVEL_OID("bloomsLevelOid_Examination_ObjectId", "Blooms Level Oid", ObjectId.class),

        EXAM_PASSING_MARK("examPassingMark_Examination_Double", "Exam Passing Mark", Double.class),

        EVALUATION_TIME_DURATION("evaluationTimeDuration_Examination_Text", "evaluation time duration", String.class),
        EVALUATION_LAST_UPDATED_ON("evaluationLastUpdatedOn_Examination_DateTime", "Evaluation Last Updated On",
                        Long.class),

    /// script evaluation quality check
    EVALUATED_SCRIPT_QC_REVIEW_STATUS("evaluatedScriptQcReviewStatus_Examination_Text",
            "evaluated Script QC review status", String.class),
    EVALUATED_SCRIPT_QC_REVIEW_REMARK("evaluatedScriptQcReviewRemark_Examination_Text",
            "Evaluated Script QC Remark", String.class),
    QUALITY_CHECK_REVIEWED_BY("qualityCheckReviewedBy_Examination_Text", "Quality Check Reviewed By", String.class),
    IS_SCRIPT_ASSIGNED_FOR_QC_REVIEW("isScriptAssignedForQcReview_Examination_Bool",
            "Is Script Assigned For QC Review", Boolean.class),
    IS_SCRIPT_PENDING_FOR_QC_REVIEW("isScriptPendingForQcReview_Examination_Bool",
            "Is Script Pending For QC Review", Boolean.class),
    IS_SCRIPT_PASSED_QC_REVIEW("isScriptPassedQcReview_Examination_Bool", "Is Script Passed QC Review",
            Boolean.class),
    SCRIPTS_DETAILS_FOR_QC_REVIEW_DOCUMENT_ARRAY("scriptsDetailsForQcReviewDocumentArray_Examination_DocumentArray",
            "Evaluated Scripts Details For QC Review Document Array", Document.class),
    EVALUATOR_QC_REVIEW_STATUS("evaluatorQcReviewStatus_Examination_Text", "Evaluator QC Review Status",
            String.class),
    IS_VALUATION_DISCARDED("isValuationDiscarded_Examination_Bool", "Is  Valuation Discarded", Boolean.class),
    VALUATION_DISCARDED_REASON("valuationDiscardedReason_Examination_Text", "Valuation Discarded Reason",
            String.class),
    VALUATION_DISCARDED_ON("valuationDiscardedOn_Examination_DateTime", "Valuation Discarded On", Long.class),
    VALUATION_DISCARDED_BY("valuationDiscardedBy_Examination_Text", "Valuation Discarded By", String.class),

    // Generated Question Paper
    GENERATED_PAPER_ID("generatedPaperId_Examination_Text", "Generated Paper Id", String.class),
    GENERATED_SETS_DOCUMENT_ARRAY("generatedSetsDocumentArray_Examination_DocumentArray",
            "Generated Sets Document Array", Document.class),
    TEMPLATE_SNAPSHOT_DOCUMENT("templateSnapshotDocument_Examination_Document", "Template Snapshot Document",
            Document.class),
    GENERATED_BY_USER_ID("generatedByUserId_Examination_Text", "Generated By User Id", String.class),
    GENERATED_ON_DATE("generatedOnDate_Examination_DateTime", "Generated On Date", Long.class),
    QUESTIONS_LIST_DOCUMENT_ARRAY("questionsListDocumentArray_Examination_DocumentArray",
            "Questions List Document Array", Document.class),
    IS_USED_EXAMINATION_BOOL("isUsed_Examination_Bool", "Is Used Examination Bool", Boolean.class),
    USED_COUNT_EXAMINATION_INTEGER("usedCount_Examination_Integer", "Used Count Examination Integer",
            Integer.class),
    IS_PRINTED_EXAMINATION_BOOL("isPrinted_Examination_Bool", "Is Printed Examination Bool", Boolean.class),
    PRINTED_BY_USER_ID_EXAMINATION_TEXT("printedByUserId_Examination_Text", "Printed By User Id", String.class),
    PRINTED_ON_DATE_EXAMINATION_DATE("printedOnDate_Examination_Date", "Printed On Date", Long.class),
    PRINTED_SET_NAME_EXAMINATION_TEXT("printedSetName_Examination_Text", "Printed Set Name", String.class),
    EXTRA_SETS_EXAMINATION_INTEGER("extraSets_Examination_Integer", "Extra Sets", Integer.class),

    QUESTION_BANK_MODERATOR("questionBankModerator_Examination_DocumentArray", "Question Bank Moderator", Document.class),
    QUESTION_PAPER_SCRUTINY_STAFF("questionPaperScrutinyStaff_Examination_DocumentArray",
            "Question Paper Scrutiny Staff", Document.class),
    EXAM_CATEGORY("examCategory_Examination_Text", "Exam Category", String.class),
    IS_QUESTION_PAPER_USED_FOR_EXAM("isQuestionPaperUsedForExam_Examination_Bool","Is Question paper used for exam",Boolean.class),
    IS_QUESTION_PAPER_USED_MARKED_BY("isQuestionPaperUsedMarkedBy_Examination_Text","is Question paper used marked by",String.class),







    //tcs exam  result upload keys
    BATCH_ACADEMIC_YEAR_TCS("batchAcademicYearTcs_Examination_Text", "Batch Academic Year", String.class),
    SESSION_NAME_TCS("sessionNameTcs_Examination_Text", "Session Name", String.class),
    REGISTRATION_NUMBER_TCS("registrationNumberTcs_Examination_Text", "Registration Number", String.class),
    SUBJECT_CODE_TCS("subjectCodeTcs_Examination_Text", "Subject Code", String.class),
    SUBJECT_NAME_TCS("subjectNameTcs_Examination_Text", "Subject Name", String.class),
    EXAM_RESULT_EXCEL_KEY_TCS("examResultExcelKeyTcs_Examination_Text", "Key", String.class),
    VALUER_1_GIVEN_MARKS("valuer1GivenMarks_Examination_Double", "Valuer 1", Double.class),
    VALUER_2_GIVEN_MARKS("valuer2GivenMarks_Examination_Double", "Valuer 2", Double.class),
    AVERAGE_MARKS("averageMarks_Examination_Double", "Avg", Double.class),
    MAXIMUM_MARKS_TCS("maximumMarksTcs_Examination_Double", "Maximum Marks", Double.class),
    STUDENT_ROLL_NUMBER_TCS("studentRollNumberTcs_Examination_Text", "Roll Number", String.class),


    //Examination Module
    // EXAM SESSION MASTER

    SESSION_MASTER_CODE("sessionMasterCode_Examination_Text", "Session Master Code", String.class),
    SESSION_MASTER_NAME("sessionMasterName_Examination_Text", "Session Master Name", String.class),
    SESSION_MASTER_DESCRIPTION("sessionMasterDescription_Examination_Text", "Session Master Description", String.class),
    SESSION_MASTER_ACADEMIC_YEAR("sessionMasterAcademicYear_Examination_Text", "Session Master Academic Year", String.class),
   // SESSION_MASTER_ACADEMIC_YEAR_OID("sessionMasterAcademicYearOid_Examination_ObjectId", "Session Master Academic Year Oid", ObjectId.class),

    SESSION_MASTER_FLEXI_ATTRIBUTE_1("sessionMasterFlexiAttribute1_Examination_Text", "Session Master Flexi Attribute 1", String.class),
    SESSION_MASTER_FLEXI_ATTRIBUTE_2("sessionMasterFlexiAttribute2_Examination_Text", "Session Master Flexi Attribute 2", String.class),
    SESSION_MASTER_FLEXI_ATTRIBUTE_3("sessionMasterFlexiAttribute3_Examination_Text", "Session Master Flexi Attribute 3", String.class),

    SESSION_MASTER_PACKET_SIZE("sessionMasterPacketSize_Examination_Int", "Session Master Packet Size", Integer.class),
    SESSION_MASTER_FOIL_PACKET_START_SEQUENCE("sessionMasterFoilPacketStartSequence_Examination_Int", "Session Master Foil Packet Start Sequence", Integer.class),
 //   SESSION_MASTER_SEQUENCE("sessionMasterSequence_Examination_Int", "Session Master Sequence", Integer.class),

    SESSION_MASTER_FUTURE_EXAM_SESSION("sessionMasterFutureExamSession_Examination_Bool", "Session Master Is Future Exam Session", Boolean.class),
    SESSION_MASTER_IS_ACTIVE("sessionMasterIsActive_Examination_Bool", "Session Master Is Active", Boolean.class),
    SESSION_MASTER_IS_OPEN_FOR_REMUNERATION("sessionMasterIsOpenForRemuneration_Examination_Bool", "Session Master Is Open For Remuneration", Boolean.class),
    SESSION_MASTER_IS_APPLICABLE_FOR_ACADEMICS("sessionMasterIsApplicableForAcademics_Examination_Bool", "Session Master Is Applicable For Academics", Boolean.class),
    SESSION_MASTER_IS_APPLICABLE_FOR_EXAM("sessionMasterIsApplicableForExam_Examination_Bool", "Session Master Is Applicable For Exam", Boolean.class),

  //  SESSION_MASTER_PARENT_SESSION_OID("sessionMasterParentSessionOid_Examination_ObjectId", "Session Master Parent Session Oid", ObjectId.class),
    SESSION_MASTER_PARENT_EXAM_SESSION("sessionMasterParentExamSession_Examination_Bool", "Session Master Parent Exam Session Name", Boolean.class),
  //  SESSION_MASTER_PARENT_SESSION_CODE("sessionMasterParentSessionCode_Examination_Text", "Session Master Parent Session Code", String.class),

    // Award Mapping - Document Array
    SESSION_MASTER_AWARD_MAPPING_DOCUMENT_ARRAY("sessionMasterAwardMappingDocumentArray_Examination_DocumentArray", "Session Master Award Mapping Document Array", Document.class),
   // SESSION_MASTER_AWARD_OID("sessionMasterAwardOid_Examination_ObjectId", "Session Master Award Oid", ObjectId.class),
    SESSION_MASTER_AWARD_NAME("sessionMasterAwardName_Examination_Text", "Session Master Award Name", String.class),
    SESSION_MASTER_AWARD_APPLICABLE_SUBJECT_SEMESTERS("sessionMasterAwardApplicableSubjectSemesters_Examination_TextArray", "Session Master Award Applicable Subject Semesters", String.class),
    SESSION_MASTER_AWARD_IS_OPEN_FOR_DATA_TRACKING("sessionMasterAwardIsOpenForDataTracking_Examination_Bool", "Session Master Award Is Open For Data Tracking", Boolean.class),
    SESSION_MASTER_AWARD_IS_LATEST_FOR_ENROLLMENT("sessionMasterAwardIsLatestForEnrollment_Examination_Bool", "Session Master Award Is Latest For Enrollment", Boolean.class);

    // Metadata
//    SESSION_MASTER_CREATED_BY("sessionMasterCreatedBy_Examination_Text", "Session Master Created By", String.class),
//    SESSION_MASTER_CREATED_ON("sessionMasterCreatedOn_Examination_DateTime", "Session Master Created On", Long.class),
//    SESSION_MASTER_UPDATED_BY("sessionMasterUpdatedBy_Examination_Text", "Session Master Updated By", String.class),
//    SESSION_MASTER_UPDATED_ON("sessionMasterUpdatedOn_Examination_DateTime", "Session Master Updated On", Long.class),

    private final String property;
    private final String label;
    private final Class<?> dataType;
    private final int minLength;
    private final int maxLength;

    private ExaminationKeysPBinder(String property, String label, Class<?> dataType, int minLength, int maxLength) {
        this.property = property;
        this.label = label;
        this.dataType = dataType;
        this.minLength = minLength;
        this.maxLength = maxLength;
    }

    private ExaminationKeysPBinder(String property, String label, Class<?> dataType) {
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

    private static ExaminationKeysPBinder[] $values() {
        return (ExaminationKeysPBinder[]) ExaminationKeysPBinder.class.getEnumConstants();
    }
}
