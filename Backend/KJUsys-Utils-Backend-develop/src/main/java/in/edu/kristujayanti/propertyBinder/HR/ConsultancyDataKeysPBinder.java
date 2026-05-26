package in.edu.kristujayanti.propertyBinder.HR;

import in.edu.kristujayanti.propertyBinder.KJUSYSPropertyBinder;

import javax.swing.text.Document;

public enum ConsultancyDataKeysPBinder implements KJUSYSPropertyBinder {


    CONSULTANCY_AND_PROJECT_MONTH("consultancyAndProjectMonth_ConsultancyAndProject_Text","Consultancy And Project Month", String.class),
    CONSULTANCY_AND_PROJECT_YEAR("consultancyAndProjectYear_ConsultancyAndProject_Text","Consultancy And Project Year", String.class),
    IS_APPLIED_EXTERNAL_PROJECT("isAppliedExternalProject_ConsultancyAndProject_Bool","Is Applied External Project", Boolean.class),
    IS_ENGAGED_IN_CONSULTANCY_WORK("isEngagedInConsultancyWork_ConsultancyAndProject_Bool","Is Engaged In Consultancy Work", Boolean.class),

    EXTERNAL_PROJECT_INFORMATION("externalProjectInformation_ConsultancyAndProject_Document","External Project Information", Document.class),
    EXTERNAL_PROJECT_NAME("externalProjectName_ConsultancyAndProject_Text","External Project Name", String.class),
    EXTERNAL_PROJECT_BUDGET("externalProjectBudget_ConsultancyAndProject_Text","External Project Budget", String.class),
    EXTERNAL_PROJECT_AGENCY_NAME("externalProjectAgencyName_ConsultancyAndProject_Text","External Project Agency Name", String.class),
    EXTERNAL_PROJECT_FILEUPLOAD("externalProjectFileupload_ConsultancyAndProject_File","External Project Fileupload", String.class),

    CONSULTANCY_WORK_INFORMATION("consultancyWorkInformation_ConsultancyAndProject_Document","Consultancy Work Information", Document.class),
   CONSULTANCY_TYPE("consultancyType_ConsultancyAndProject_Text","Consultancy Type", String.class),
    CONSULTANCY_PROJECT_NAME("consultancyProjectName_ConsultancyAndProject_Text","Consultancy Project Name", String.class),
    CONSULTING_AGENCY_CONTACT_DETAILS("consultingAgencyContactDetails_ConsultancyAndProject_Text","Consulting Agency Contact Details",String.class),
    TOTAL_AMOUNT("totalAmount_ConsultancyAndProject_Double","Total Amount",Double.class),
    AMOUNT_REMITTED_TO_KJU("amountRemittedToKju_ConsultancyAndProject_Double","Amount Remitted To Kju",Double.class),
    START_DATE("startDate_ConsultancyAndProject_Date","Start Date",Long.class),
    END_DATE("endDate_ConsultancyAndProject_Date","End Date",Long.class),
    TYPE_OF_PROOF("typeOfProof_ConsultancyAndProject_Bool","Type Of Proof",Boolean.class),
    CONSULTANCY_FILEUPLOAD("consultancyFileupload_ConsultancyAndProject_File","Consultancy Fileupload", String.class),





    ;

    private final String property;
    private final String label;
    private final Class<?> dataType;
    private final int minLength;

    private final int maxLength;

    private ConsultancyDataKeysPBinder(String property, String label, Class<?> dataType, int minLength, int maxLength) {
        this.property = property;
        this.label = label;
        this.dataType = dataType;
        this.minLength = minLength;
        this.maxLength = maxLength;
    }

    private ConsultancyDataKeysPBinder(String property, String label, Class<?> dataType) {
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

    private static ConsultancyDataKeysPBinder[] $values() {
        return ConsultancyDataKeysPBinder.class.getEnumConstants();
    }

}






