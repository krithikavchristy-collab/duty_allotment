package in.edu.kristujayanti.util;


import java.util.HashMap;
import java.util.Map;

public class UppercasePolicyManager {

    public enum UppercasePolicy {
        UPPERCASE,
        PRESERVE_CASE
    }

    private static final Map<String, UppercasePolicy> policyMap = new HashMap<>();

    static {
        // Initialize the map with default policies
        policyMap.put("applicantPassword", UppercasePolicy.PRESERVE_CASE);
        policyMap.put("applicantOldPassword", UppercasePolicy.PRESERVE_CASE);
        policyMap.put("password", UppercasePolicy.PRESERVE_CASE);
        policyMap.put("oldPassword", UppercasePolicy.PRESERVE_CASE);
        policyMap.put("newPassword", UppercasePolicy.PRESERVE_CASE);
        policyMap.put("confirmPassword", UppercasePolicy.PRESERVE_CASE);
        policyMap.put("userPassword", UppercasePolicy.PRESERVE_CASE);
        policyMap.put("uploadedFilePath", UppercasePolicy.PRESERVE_CASE);
        policyMap.put("programmePreference2", UppercasePolicy.PRESERVE_CASE);
        policyMap.put("programmePreference3", UppercasePolicy.PRESERVE_CASE);
        policyMap.put("programName", UppercasePolicy.PRESERVE_CASE);
        policyMap.put("programDisplayName", UppercasePolicy.PRESERVE_CASE);
        policyMap.put("menuGroupIcon", UppercasePolicy.PRESERVE_CASE);
        policyMap.put("studentProfileImageFilePath", UppercasePolicy.PRESERVE_CASE);
        policyMap.put("employeeIdPhotoPath", UppercasePolicy.PRESERVE_CASE);
        policyMap.put("employeeOldPassword", UppercasePolicy.PRESERVE_CASE);
        policyMap.put("employeeQualificationCertificate", UppercasePolicy.PRESERVE_CASE);
        policyMap.put("tenthPdf", UppercasePolicy.PRESERVE_CASE);
        policyMap.put("bankAccountRazorpayId", UppercasePolicy.PRESERVE_CASE);
        policyMap.put("razorpayPaymentId", UppercasePolicy.PRESERVE_CASE);
        policyMap.put("applicantFeeDescription", UppercasePolicy.PRESERVE_CASE);


        //SIM
        policyMap.put("remarksModeOfEducation", UppercasePolicy.PRESERVE_CASE);
        policyMap.put("remarksSecondLanguage", UppercasePolicy.PRESERVE_CASE);
        policyMap.put("remarksCoCurricularActivities", UppercasePolicy.PRESERVE_CASE);
        policyMap.put("remarksSubjectKnowledge", UppercasePolicy.PRESERVE_CASE);
        policyMap.put("remarksAttitude", UppercasePolicy.PRESERVE_CASE);
        policyMap.put("remarksCommunication", UppercasePolicy.PRESERVE_CASE);
        policyMap.put("remarksRemark", UppercasePolicy.PRESERVE_CASE);
        policyMap.put("applicantPhoto", UppercasePolicy.PRESERVE_CASE);
        policyMap.put("applicantPhysicallyChallengedDescription", UppercasePolicy.PRESERVE_CASE);
        policyMap.put("eleventhPdf", UppercasePolicy.PRESERVE_CASE);
        policyMap.put("twelfthPdf", UppercasePolicy.PRESERVE_CASE);
        policyMap.put("s1MarksDocumentUpload", UppercasePolicy.PRESERVE_CASE);
        policyMap.put("s2MarksDocumentUpload", UppercasePolicy.PRESERVE_CASE);
        policyMap.put("s3MarksDocumentUpload", UppercasePolicy.PRESERVE_CASE);
        policyMap.put("s4MarksDocumentUpload", UppercasePolicy.PRESERVE_CASE);
        policyMap.put("s5MarksDocumentUpload", UppercasePolicy.PRESERVE_CASE);
        policyMap.put("s6MarksDocumentUpload", UppercasePolicy.PRESERVE_CASE);
        policyMap.put("s7MarksDocumentUpload", UppercasePolicy.PRESERVE_CASE);
        policyMap.put("s8MarksDocumentUpload", UppercasePolicy.PRESERVE_CASE);
        policyMap.put("s9MarksDocumentUpload", UppercasePolicy.PRESERVE_CASE);
        policyMap.put("s10MarksDocumentUpload", UppercasePolicy.PRESERVE_CASE);

        // DocumentCollection
        policyMap.put("eformStorageKey", UppercasePolicy.PRESERVE_CASE);
        policyMap.put("uploadedDocument", UppercasePolicy.PRESERVE_CASE);
        policyMap.put("refundReferencePaymentId", UppercasePolicy.PRESERVE_CASE);

        policyMap.put("paymentGatewayAccountConfig", UppercasePolicy.PRESERVE_CASE);

        // payment receipt
        policyMap.put("templatePlaceholderValue", UppercasePolicy.PRESERVE_CASE);
        policyMap.put("templatePlaceholderDataLocation", UppercasePolicy.PRESERVE_CASE);
        policyMap.put("templateHtmlBody", UppercasePolicy.PRESERVE_CASE);

        policyMap.put("paymentId", UppercasePolicy.PRESERVE_CASE);
        policyMap.put("purchaseOrderFileupload", UppercasePolicy.PRESERVE_CASE);
        policyMap.put("PurchaseOrderDescription", UppercasePolicy.PRESERVE_CASE);
        policyMap.put("PurchaseOrderSubject", UppercasePolicy.PRESERVE_CASE);
        policyMap.put("termsAndConditionsTitle", UppercasePolicy.PRESERVE_CASE);
        policyMap.put("purchaseOrderReference", UppercasePolicy.PRESERVE_CASE);
        policyMap.put("vendorName", UppercasePolicy.PRESERVE_CASE);
        policyMap.put("vendorAddress", UppercasePolicy.PRESERVE_CASE);
        policyMap.put("termsAndConditions", UppercasePolicy.PRESERVE_CASE);


        policyMap.put("attendantRemarks", UppercasePolicy.PRESERVE_CASE);
        policyMap.put("idCardTemplatePlaceholderValue", UppercasePolicy.PRESERVE_CASE);

        policyMap.put("employeeTeachingExperienceCertificate", UppercasePolicy.PRESERVE_CASE);
        policyMap.put("employeeIndustryExperienceCertificate", UppercasePolicy.PRESERVE_CASE);
        policyMap.put("employeeResearchExperienceCertificate", UppercasePolicy.PRESERVE_CASE);
        policyMap.put("employeeFullTimePhdCertificate", UppercasePolicy.PRESERVE_CASE);
        policyMap.put("employeePostdocCertificate", UppercasePolicy.PRESERVE_CASE);
        policyMap.put("todoDescription", UppercasePolicy.PRESERVE_CASE);
        policyMap.put("todoTitle", UppercasePolicy.PRESERVE_CASE);
        policyMap.put("staffCircularTitle", UppercasePolicy.PRESERVE_CASE);
        policyMap.put("staffEventTitle", UppercasePolicy.PRESERVE_CASE);
        policyMap.put("certificateServiceComments", UppercasePolicy.PRESERVE_CASE);
        policyMap.put("photoUrl", UppercasePolicy.PRESERVE_CASE);

        //eduServ
        policyMap.put("supportDocFile", UppercasePolicy.PRESERVE_CASE);
        policyMap.put("serviceRequestLetterFileUpload", UppercasePolicy.PRESERVE_CASE);

        //eform phd
        policyMap.put("phdQualifyingDegreeCertificateFile", UppercasePolicy.PRESERVE_CASE);
        policyMap.put("phdApplicantResearchProposalPdfUpload", UppercasePolicy.PRESERVE_CASE);
        policyMap.put("phdApplicantStatementOfPurposePdfUpload", UppercasePolicy.PRESERVE_CASE);
        policyMap.put("phdApplicantRecommendationLetter", UppercasePolicy.PRESERVE_CASE);
        policyMap.put("phdApplicantNocCertificateFile", UppercasePolicy.PRESERVE_CASE);
        policyMap.put("phdApplicantExperienceCertificateFile", UppercasePolicy.PRESERVE_CASE);

        //Jayantian Scholar
        policyMap.put("journalArticleAbstractSummary",UppercasePolicy.PRESERVE_CASE);
        policyMap.put("fullPaperInAConferenceProceedingsAbstractSummary",UppercasePolicy.PRESERVE_CASE);
        policyMap.put("chapterInABookSeriesAbstractSummary",UppercasePolicy.PRESERVE_CASE);
        policyMap.put("chapterInAnEditedBookAbstractSummary",UppercasePolicy.PRESERVE_CASE);
        policyMap.put("phdApplicantCompetitiveExamCertificateFile",UppercasePolicy.PRESERVE_CASE);


        policyMap.put("journalArticleTitle",UppercasePolicy.PRESERVE_CASE);
        policyMap.put("chapterInABookSeriesTitle",UppercasePolicy.PRESERVE_CASE);
        policyMap.put("fullPaperInAConferenceProceedingsTitle",UppercasePolicy.PRESERVE_CASE);
        policyMap.put("chapterInAnEditedBookTitle",UppercasePolicy.PRESERVE_CASE);
        policyMap.put("authoredBookTitle",UppercasePolicy.PRESERVE_CASE);
        policyMap.put("editedBookTitle",UppercasePolicy.PRESERVE_CASE);
        policyMap.put("journalArticleDoi",UppercasePolicy.PRESERVE_CASE);
        policyMap.put("fullPaperInAConferenceProceedingsDoi",UppercasePolicy.PRESERVE_CASE);
        policyMap.put("chapterInABookSeriesDoi",UppercasePolicy.PRESERVE_CASE);
        policyMap.put("chapterInAnEditedBookDoi",UppercasePolicy.PRESERVE_CASE);
        policyMap.put("authoredBookDoi",UppercasePolicy.PRESERVE_CASE);
        policyMap.put("editedBookDoi",UppercasePolicy.PRESERVE_CASE);
        policyMap.put("answerKeyPdfFile",UppercasePolicy.PRESERVE_CASE);
        policyMap.put("questionPaperPdfFile",UppercasePolicy.PRESERVE_CASE);

        policyMap.put("patentTitle",UppercasePolicy.PRESERVE_CASE);
        policyMap.put("patentAbstract",UppercasePolicy.PRESERVE_CASE);
        policyMap.put("conferenceTitleOfPresentation",UppercasePolicy.PRESERVE_CASE);
        policyMap.put("conferenceTitle",UppercasePolicy.PRESERVE_CASE);
        policyMap.put("uploadCertificate",UppercasePolicy.PRESERVE_CASE);
        policyMap.put("proofOfPatent",UppercasePolicy.PRESERVE_CASE);
        policyMap.put("proofOfPaymentReceipt",UppercasePolicy.PRESERVE_CASE);


        policyMap.put("vcRemarks",UppercasePolicy.PRESERVE_CASE);
        policyMap.put("deanRemarks",UppercasePolicy.PRESERVE_CASE);
        policyMap.put("eventCoverImage",UppercasePolicy.PRESERVE_CASE);
        policyMap.put("programmeCoverImage",UppercasePolicy.PRESERVE_CASE);
        policyMap.put("programmeTitle",UppercasePolicy.PRESERVE_CASE);
        policyMap.put("programmeDescription",UppercasePolicy.PRESERVE_CASE);
        policyMap.put("eventTitle",UppercasePolicy.PRESERVE_CASE);
        policyMap.put("eventDescription",UppercasePolicy.PRESERVE_CASE);
        policyMap.put("courseSyllabusPdf",UppercasePolicy.PRESERVE_CASE);
        policyMap.put("formFieldDescription",UppercasePolicy.PRESERVE_CASE);
        policyMap.put("formFieldPlaceholder",UppercasePolicy.PRESERVE_CASE);
        policyMap.put("courseDescription",UppercasePolicy.PRESERVE_CASE);
        policyMap.put("quotationFileupload",UppercasePolicy.PRESERVE_CASE);
        policyMap.put("phdApplicantPaperPublicationDoi",UppercasePolicy.PRESERVE_CASE);
        policyMap.put("eventEmailContent",UppercasePolicy.PRESERVE_CASE);

        policyMap.put("mouDocument",UppercasePolicy.PRESERVE_CASE);
        policyMap.put("institutionImage",UppercasePolicy.PRESERVE_CASE);
        policyMap.put("delegateImage",UppercasePolicy.PRESERVE_CASE);


        //Preset And Filter
        policyMap.put("projectionSectionName",UppercasePolicy.PRESERVE_CASE);
        policyMap.put("projectionLabelName",UppercasePolicy.PRESERVE_CASE);
        policyMap.put("projectionFieldLocation",UppercasePolicy.PRESERVE_CASE);
        policyMap.put("presetName",UppercasePolicy.PRESERVE_CASE);
        policyMap.put("presetDescription",UppercasePolicy.PRESERVE_CASE);
        policyMap.put("projectionFieldPropertyName",UppercasePolicy.PRESERVE_CASE);

        policyMap.put("filterFieldPropertyName",UppercasePolicy.PRESERVE_CASE);
        policyMap.put("filterFieldValue",UppercasePolicy.PRESERVE_CASE);
        policyMap.put("filterName",UppercasePolicy.PRESERVE_CASE);


        policyMap.put("reportFile", UppercasePolicy.PRESERVE_CASE);
        policyMap.put("questionText", UppercasePolicy.PRESERVE_CASE);
        policyMap.put("subQuestionText", UppercasePolicy.PRESERVE_CASE);

        //Razorpay Webhook
        policyMap.put("webhookEventId", UppercasePolicy.PRESERVE_CASE);
        policyMap.put("webhookEventState", UppercasePolicy.PRESERVE_CASE);
        policyMap.put("webhookEventMessage", UppercasePolicy.PRESERVE_CASE);
        policyMap.put("automatedRefundId", UppercasePolicy.PRESERVE_CASE);
        policyMap.put("phdMeetingStudentFileUpload", UppercasePolicy.PRESERVE_CASE);
        policyMap.put("phdStudentMilestoneFile", UppercasePolicy.PRESERVE_CASE);
        policyMap.put("attachment", UppercasePolicy.PRESERVE_CASE);
        policyMap.put("intakeCode_", UppercasePolicy.PRESERVE_CASE);

        //Academics
        policyMap.put("webhookEventId", UppercasePolicy.PRESERVE_CASE);

        //Academics - Blow Up
        policyMap.put("courseLearningOutcomeIndex", UppercasePolicy.PRESERVE_CASE);
        policyMap.put("courseLearningOutcome", UppercasePolicy.PRESERVE_CASE);

        policyMap.put("unitTitle", UppercasePolicy.PRESERVE_CASE);
        policyMap.put("unitContent", UppercasePolicy.PRESERVE_CASE);
        policyMap.put("unitHours", UppercasePolicy.PRESERVE_CASE);
        policyMap.put("author", UppercasePolicy.PRESERVE_CASE);
        policyMap.put("title", UppercasePolicy.PRESERVE_CASE);
        policyMap.put("publisher", UppercasePolicy.PRESERVE_CASE);
        policyMap.put("description", UppercasePolicy.PRESERVE_CASE);
        policyMap.put("link", UppercasePolicy.PRESERVE_CASE);
        policyMap.put("inHouseResourcesAndDatabase", UppercasePolicy.PRESERVE_CASE);
        policyMap.put("bloomsTaxonomyLevel", UppercasePolicy.PRESERVE_CASE);
        policyMap.put("genericGraduateAttributes", UppercasePolicy.PRESERVE_CASE);
        policyMap.put("typeOfAssessment", UppercasePolicy.PRESERVE_CASE);
        policyMap.put("typeOfExam", UppercasePolicy.PRESERVE_CASE);
        policyMap.put("modeOfExam", UppercasePolicy.PRESERVE_CASE);
        policyMap.put("sectionName", UppercasePolicy.PRESERVE_CASE);
        policyMap.put("cloAddressed", UppercasePolicy.PRESERVE_CASE);
        policyMap.put("questionNumber", UppercasePolicy.PRESERVE_CASE);
        policyMap.put("programmeOutcomeIndex", UppercasePolicy.PRESERVE_CASE);
        policyMap.put("programmeOutcomeDescription", UppercasePolicy.PRESERVE_CASE);
        policyMap.put("programmeSpecificOutcomeDescription", UppercasePolicy.PRESERVE_CASE);


        //academics
        policyMap.put("courseTitle",UppercasePolicy.PRESERVE_CASE);
        policyMap.put("programmeName",UppercasePolicy.PRESERVE_CASE);
       // policyMap.put("programmeCode",UppercasePolicy.PRESERVE_CASE);

        //Events And Budget
        policyMap.put("itemName", UppercasePolicy.PRESERVE_CASE);
        policyMap.put("groupHeadName", UppercasePolicy.PRESERVE_CASE);
        policyMap.put("unitOfMeasure", UppercasePolicy.PRESERVE_CASE);
        policyMap.put("departmentOrClubName", UppercasePolicy.PRESERVE_CASE);
        policyMap.put("eventName", UppercasePolicy.PRESERVE_CASE);
        policyMap.put("budgetParticularItem", UppercasePolicy.PRESERVE_CASE);
        policyMap.put("budgetUnitOfMeasure", UppercasePolicy.PRESERVE_CASE);
        policyMap.put("eventType", UppercasePolicy.PRESERVE_CASE);
        policyMap.put("organisedBy", UppercasePolicy.PRESERVE_CASE);
        policyMap.put("actualParticularItem", UppercasePolicy.PRESERVE_CASE);
        policyMap.put("actualUnitOfMeasure", UppercasePolicy.PRESERVE_CASE);
        policyMap.put("actualPdfFilePath", UppercasePolicy.PRESERVE_CASE);
        policyMap.put("budgetPdfFilePath", UppercasePolicy.PRESERVE_CASE);
        policyMap.put("eventCategory", UppercasePolicy.PRESERVE_CASE);
        policyMap.put("rscFeedbackAttachment", UppercasePolicy.PRESERVE_CASE);
        policyMap.put("conceptualFilePath", UppercasePolicy.PRESERVE_CASE);
        policyMap.put("objectivesFilePath", UppercasePolicy.PRESERVE_CASE);
        policyMap.put("methodologyFilePath", UppercasePolicy.PRESERVE_CASE);
        policyMap.put("samplingFilePath", UppercasePolicy.PRESERVE_CASE);
        policyMap.put("literatureFilePath", UppercasePolicy.PRESERVE_CASE);
        policyMap.put("fieldValue", UppercasePolicy.PRESERVE_CASE);



        //workflow-template
        policyMap.put("workflowTemplateName", UppercasePolicy.PRESERVE_CASE);
        policyMap.put("workflowTemplateHeading", UppercasePolicy.PRESERVE_CASE);
        policyMap.put("workflowTemplateSubheading", UppercasePolicy.PRESERVE_CASE);
        policyMap.put("workflowTemplateDescription", UppercasePolicy.PRESERVE_CASE);
        policyMap.put("workflowTemplateFile", UppercasePolicy.PRESERVE_CASE);

        //slotDesk
        policyMap.put("slotTitle", UppercasePolicy.PRESERVE_CASE);
        //phd dashboard
        policyMap.put("completionRemark", UppercasePolicy.PRESERVE_CASE);
        policyMap.put("answer", UppercasePolicy.PRESERVE_CASE);
        policyMap.put("target", UppercasePolicy.PRESERVE_CASE);
        policyMap.put("skillsAndKnowledgeSelectedAreaDescription", UppercasePolicy.PRESERVE_CASE);
        policyMap.put("skillsAndKnowledgeSelectedAreaOthersDescription", UppercasePolicy.PRESERVE_CASE);







    }

    /**
     * Get the uppercase policy for a given property name.
     *
     * @param propertyName The name of the property to check.
     * @return The UppercasePolicy for the given property. If no specific policy is set, returns UPPERCASE.
     */
    public static UppercasePolicy getPolicy(String propertyName) {
        return policyMap.getOrDefault(propertyName, UppercasePolicy.UPPERCASE);
    }

    /**
     * Set a specific uppercase policy for a property.
     *
     * @param propertyName The name of the property.
     * @param policy       The UppercasePolicy to set for this property.
     */
    public static void setPolicy(String propertyName, UppercasePolicy policy) {
        policyMap.put(propertyName, policy);
    }

    /**
     * Remove the specific policy for a property, reverting it to the default (UPPERCASE).
     *
     * @param propertyName The name of the property to remove the specific policy for.
     */
    public static void removePolicy(String propertyName) {
        policyMap.remove(propertyName);
    }

    /**
     * Clear all specific policies, reverting all properties to the default (UPPERCASE).
     */
    public static void clearAllPolicies() {
        policyMap.clear();
    }
}