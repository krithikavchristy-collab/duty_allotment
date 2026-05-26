package in.edu.kristujayanti.collectionNames;

public enum ExaminationCNBinder implements KJUSYSCNBinder {

    QUESTION_PAPER_TEMPLATE_COLLECTION("examQuestionPaperTemplate"),
    EXAM_DETAILS_COLLECTION("examDetailsCollection"),
    COURSE_DETAILS_COLLECTION("course_details"),
    MODE_OF_EVALUATION_COLLECTION("mode_of_evaluation"),
    EXAM_TYPE_COLLECTION("exam_type_details"),
    EVALUATED_ANSWER_SCRIPTS("evaluatedAnswerScripts"),
    EXAM_PUBLISHED_RESULTS("exam_published_results"),
    QUESTION_BANK_COLLECTION("question_bank"),
    GENERATED_QUESTION_PAPERS_COLLECTION("generated_question_papers"),
    PRINTED_QUESTION_PAPER_HISTORY_COLLECTION("printed_question_paper_history"),
    EXAM_COURSE_MAPPING_COLLECTION("exam_course_mapping"),
    SUB_QUESTION_TEMPLATES_COLLECTION("sub_question_templates"),
    COURSE_QUESTION_PAPER_TEMPLATE_COLLECTION("course_question_paper_template"),
    EXAM_SESSION_MASTER_COLLECTION("exam_session_master")
    ;

    private final String collectionName;

    private ExaminationCNBinder(String collectionName) {
        this.collectionName = collectionName;
    }

    public String getCollectionName() {
        return this.collectionName;
    }

    // $FF: synthetic method
    private static ExaminationCNBinder[] $values() {
        return ExaminationCNBinder.class.getEnumConstants();
    }

}