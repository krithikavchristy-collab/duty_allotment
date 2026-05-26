package in.edu.kristujayanti.propertyBinder.GlobalRelations;

import in.edu.kristujayanti.propertyBinder.KJUSYSPropertyBinder;

import javax.swing.text.Document;

public enum GlobalRelationsKeysPBinder implements KJUSYSPropertyBinder {


    // Institution-details
    NAME_OF_INSTITUTION("nameOfInstitution_GlobalRelation_Text","Name Of Institution",String.class),
    INSTITUTION_TYPE("institutionType_GlobalRelation_Text","Institution Type",String.class),
    INSTITUTION_CATEGORY("institutionCategory_GlobalRelation_Text","Institution Category",String.class),
    INSTITUTION_REGION("institutionRegion_GlobalRelation_Text","Institution Region",String.class),
    INSTITUTION_LOCATION("institutionLocation_GlobalRelation_Text","Institution Location",String.class),
    INSTITUTION_RELATIONSHIP("institutionRelationship_GlobalRelation_Text","Institution Relationship",String.class),
    REFERRED_BY_DEPARTMENT("referredByDepartment_GlobalRelation_Text","Referred By Department",String.class),
    REFERRED_BY_WHO("referredByWho_GlobalRelation_Text","Referred By Who",String.class),
    MOU_DOCUMENT("mouDocument_GlobalRelation_Text","Mou Document",String.class),
    INSTITUTION_IMAGE("institutionImage_GlobalRelation_Text","Institution Image Upload",String.class),
    MOU_DETAILS("mouDetails_GlobalRelation_DocumentArray","Mou Details",Document.class),
    MOU_START_DATE("mouStartDate_GlobalRelation_Date","Mou Start Date",Long.class),
    MOU_END_DATE("mouEndDate_GlobalRelation_Date","Mou End Date",Long.class),
    MOU_NUMBER("mouNumber_GlobalRelation_Int","Mou Number", Integer.class),
    //IS_LATEST_MOU("isLatestMou_GlobalRelation_Bool","Is Latest Mou",Boolean.class),


    //Delegate-details
    DELEGATE_CATEGORY("delegateCategory_GlobalRelation_Text","Delegate Category",String.class),
    DELEGATE_REGION("delegateRegion_GlobalRelation_Text","Delegate Region",String.class),
    DELEGATE_LOCATION("delegateLocation_GlobalRelation_Text","Delegate Location",String.class),
    DELEGATE_NAME("delegateName_GlobalRelation_Text","Delegate Name",String.class),
    DELEGATE_DESIGNATION("delegateDesignation_GlobalRelation_Text","Delegate Designation",String.class),
    DELEGATE_EMAIL("delegateEmail_GlobalRelation_Text","Delegate Email",String.class),
    DELEGATE_PHONE("delegatePhone_GlobalRelation_Text","Delegate Phone",String.class),
    DELEGATE_EXPERTISE("delegateExpertise_GlobalRelation_TextArray","Delegate Expertise",String.class),
    DELEGATE_PURPOSE_OF_VISIT("delegatePurposeOfVisit_GlobalRelation_Text","Delegate Purpose Of Visit",String.class),
    DELEGATE_IMAGE("delegateImage_GlobalRelation_Text","Delegate Image",String.class),
    DELEGATE_ORGANISATION("delegateOrganisation_GlobalRelation_Text","Delegate Organization",String.class),
    DELEGATE_VISIT_FROM_DATE("delegateVisitFromDate_GlobalRelation_Date","Delegate Visit From Date", Long.class),
    DELEGATE_VISIT_TO_DATE("delegateVisitToDate_GlobalRelation_Date","Delegate Visit To Date", Long.class),
    DELEGATE_VISIT_DETAILS("delegateVisitDetails_GlobalRelation_DocumentArray","Delegate Visit Details",Document.class),
    DELEGATE_TOTAL_NUMBER_OF_VISIT("delegateTotalNumberOfVisit_GlobalRelation_Int","Delegate Total Number Of Visit", Integer.class),
    DELEGATE_VISIT_NUMBER("delegateVisitNumber_GlobalRelation_Int","Delegate Visit Number",Integer.class),
    COUNTRY_CODE("countryCode_GlobalRelation_Text","Country Code",String.class),

    //ExchangeProgrammes
    EXCHANGE_PROGRAMME_VISIT_TYPE("exchangeProgrammeVisitType_GlobalRelation_Text","Exchange Programme Visit Type",String.class),
    EXCHANGE_PROGRAMME_PARTICIPANT_TYPE("exchangeProgrammeParticipantType_GlobalRelation_Text","Exchange Programme Participant Type", String.class),
    EXCHANGE_PROGRAMME_PARTICIPANT_ID("exchangeProgrammeParticipantId_GlobalRelation_Text","Exchange Programme Participant Id", String.class),
    EXCHANGE_PROGRAMME_PARTICIPANT_NAME("exchangeProgrammeParticipantName_GlobalRelation_Text","Exchange Programme Participant Name", String.class),
    EXCHANGE_PROGRAMME_PARTICIPANT_DEPARTMENT("exchangeProgrammeParticipantDepartment_GlobalRelation_Text","Exchange Programme Participant Department", String.class),
    EXCHANGE_PROGRAMME_PARTICIPANT_INSTITUTION("exchangeProgrammeParticipantInstitution_GlobalRelation_Text","Exchange Programme Participant Institution", String.class),
    EXCHANGE_PROGRAMME_START_DATE("exchangeProgrammeStartDate_GlobalRelation_Date","Exchange Programme Start Date", Long.class),
    EXCHANGE_PROGRAMME_END_DATE("exchangeProgrammeEndDate_GlobalRelation_Date","Exchange Programme End Date", Long.class),
    EXCHANGE_PROGRAMME_PARTICIPANT_ACADEMIC_TERM("exchangeProgrammeParticipantAcademicTerm_GlobalRelation_Text","Exchange Programme Participant Academic Term", String.class),
    EXCHANGE_PROGRAMME_PARTICIPANT_REMARKS("exchangeProgrammeParticipantRemarks_GlobalRelation_Text","Exchange Programme Participant Remarks", String.class),







    ;


    private final String property;
    private final String label;
    private final Class dataType;
    private final int minLength;
    private final int maxLength;

    private GlobalRelationsKeysPBinder(String property, String label, Class dataType, int minLength, int maxLength) {
        this.property = property;
        this.label = label;
        this.dataType = dataType;
        this.minLength = minLength;
        this.maxLength = maxLength;
    }

    private GlobalRelationsKeysPBinder(String property, String label, Class dataType) {
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

    // $FF: synthetic method
    private static GlobalRelationsKeysPBinder[] $values() {
        return GlobalRelationsKeysPBinder.class.getEnumConstants();
    }




}
