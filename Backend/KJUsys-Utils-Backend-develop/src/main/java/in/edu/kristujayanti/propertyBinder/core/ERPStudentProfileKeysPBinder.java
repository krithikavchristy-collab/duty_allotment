package in.edu.kristujayanti.propertyBinder.core;

import in.edu.kristujayanti.propertyBinder.KJUSYSPropertyBinder;
import org.bson.Document;
import org.bson.types.ObjectId;

public enum ERPStudentProfileKeysPBinder implements KJUSYSPropertyBinder {
    // basic details
    STUDENT_EMAIL("studentEmail_ErpStudentProfile_Text", "Student Email", String.class),
    STUDENT_AUTH_OBJECT_ID("studentAuthObjectId_ErpStudentProfile_ObjectId", "Student Auth ObjectId", ObjectId.class),
    STUDENT_NAME("studentName_ErpStudentProfile_Text", "Student Full Name", String.class),
    STUDENT_DATE_OF_BIRTH("studentDateOfBirth_ErpStudentProfile_Date", "Student Date Of Birth", Long.class),
    STUDENT_WHATSAPP_NUMBER("studentWhatsappNumber_ErpStudentProfile_Text", "Student Whatsapp Number", String.class),
    STUDENT_MOBILE_NUMBER_COUNTRY_CODE("studentMobileNumberCountryCode_ErpStudentProfile_Text", "Student Mobile Number Country Code", String.class),
    STUDENT_GENDER("studentGender_ErpStudentProfile_Text", "Student Gender", String.class),
    APPLICATION_NUMBER("applicationNumber_ErpStudentProfile_Text", "Application Number", String.class),
    STUDENT_ROLL_NUMBER("studentRollNumber_ErpStudentProfile_Text", "Student Roll Number", String.class),
    STUDENT_REGISTRATION_NUMBER("studentRegistrationNumber_ErpStudentProfile_Text", "Student Registration Number", String.class),

    STUDENT_ALLOTTED_BATCH_CODE("studentAllottedBatchCode_ErpStudentProfile_Text", "Student Allotted Batch Code", String.class),
    STUDENT_ALLOTTED_PROGRAM_NAME("studentAllottedProgramName_ErpStudentProfile_Text", "Student Allotted Program Name", String.class),
    STUDENT_ADMISSION_QUOTA("studentAdmissionQuota_ErpStudentProfile_Text", "Student Admission Quota", String.class),
    STUDENT_FEE_CATEGORY("studentFeeCategory_ErpStudentProfile_Text", "Student Fee Category", String.class),
    STUDENT_ALLOTTED_BATCH_NAME("studentAllottedBatchName_ErpStudentProfile_Text", "Student Allotted Batch Name", String.class),
    STUDENT_SEMESTER("studentSemester_ErpStudentProfile_Int", "Student Semester", Integer.class),
    STUDENT_SEMESTER_TYPE("studentSemesterType_ErpStudentProfile_Text", "Student Semester Type", String.class),
    STUDENT_CLASS("studentClass_ErpStudentProfile_Text", "Student Class", String.class),
    STUDENT_COLLEGE_EMAIL("studentCollegeEmail_ErpStudentProfile_Text", "Student College Email", String.class),
    STUDENT_DATE_OF_ADMISSION("studentDateOfAdmission_ErpStudentProfile_Date", "Student College Email", Long.class),
    STUDENT_DEPARTMENT("studentDepartment_ErpStudentProfile_Text","Student Department", String.class),
    // personal info
    STUDENT_RELIGION("studentReligion_ErpStudentProfile_Text", "Student Religion", String.class),
    STUDENT_NATIONALITY("studentNationality_ErpStudentProfile_Text", "Student Nationality", String.class),
    STUDENT_CASTE_CATEGORY("studentCasteCategory_ErpStudentProfile_Text", "Student Caste Category", String.class),
    STUDENT_SUB_CASTE_CATEGORY("studentSubCasteCategory_ErpStudentProfile_Text", "Student Sub Caste Category", String.class),
    STUDENT_BIRTH_COUNTRY("studentBirthCountry_ErpStudentProfile_Text", "Student Birth Country", String.class),
    STUDENT_BIRTH_STATE("studentBirthState_ErpStudentProfile_Text", "Student Birth State", String.class),
    STUDENT_BIRTH_DISTRICT("studentBirthDistrict_ErpStudentProfile_Text", "Student Birth District", String.class),
    STUDENT_MOTHER_TONGUE("studentMotherTongue_ErpStudentProfile_Text", "Student Mother Tongue", String.class),
    ALTERNATE_PHONE_NUMBER("studentAlternatePhoneNumber_ErpStudentProfile_Text", "Student Alternate Phone Number", String.class),
    STUDENT_ALT_PHONE_NUMBER_COUNTRY_CODE("studentAltPhoneNumberCountryCode_ApplicantForms_Text", "Student Alternate Phone Number Country Code", String.class),
    STUDENT_BLOOD_GROUP("studentBloodGroup_ErpStudentProfile_Text", "Student Blood Group", String.class),
    STUDENT_MARITAL_STATUS("studentMaritalStatus_ApplicantForms_Text", "Student Marital Status", String.class),
    STUDENT_PHYSICALLY_CHALLENGED("studentPhysicallyChallenged_ErpStudentProfile_Bool", "Physically Challenged", Boolean.class),
    STUDENT_PHYSICALLY_CHALLENGED_DESCRIPTION("studentPhysicallyChallengedDescription_ErpStudentProfile_File", "Physically Challenged Description", String.class),
    STUDENT_AADHAAR_NUMBER("studentAadhaarNumber_ErpStudentProfile_Long", "Student Aadhaar Number", Long.class),
    STUDENT_PHOTO("studentPhoto_ErpStudentProfile_File", "Student Photo", String.class),
    STUDENT_ID_CARD_PHOTO("studentIdCardPhoto_ErpStudentProfile_File", "Student Id Card Photo", String.class),
    STUDENT_PASSPORT_NUMBER("studentPassportNumber_ErpStudentProfile_Text", "Student Passport Number", String.class),
    // sections
    STUDENT_PERSONAL_DETAILS("studentPersonalDetails_ErpStudentProfile_Document", "Student Personal Details", Document.class),
    STUDENT_ADDRESS_DETAILS("studentAddressDetails_ErpStudentProfile_Document", "Student Address Details", Document.class),
    STUDENT_FATHER_DETAILS("studentFatherDetails_ErpStudentProfile_Document", "Student Father Details", Document.class),
    STUDENT_MOTHER_DETAILS("studentMotherDetails_ErpStudentProfile_Document", "Student Mother Details", Document.class),
    STUDENT_GUARDIAN_DETAILS("studentGuardianDetails_ErpStudentProfile_Document", "Student Guardian Details", Document.class),
    // permanent address
    STUDENT_PERMANENT_ADDRESS("studentPermanentAddress_ErpStudentProfile_Text", "Student Permanent Address", String.class),
    STUDENT_PERMANENT_ADDRESS_COUNTRY("studentPermanentAddressCountry_ErpStudentProfile_Text", "Student Permanent Address Country", String.class),
    STUDENT_PERMANENT_ADDRESS_STATE("studentPermanentAddressState_ErpStudentProfile_Text", "Student Permanent Address State", String.class),
    STUDENT_PERMANENT_ADDRESS_DISTRICT("studentPermanentAddressDistrict_ErpStudentProfile_Text", "Student Permanent Address District", String.class),
    STUDENT_PERMANENT_ADDRESS_PIN_CODE("studentPermanentAddressPinCode_ErpStudentProfile_Int", "Student Permanent Address Pin Code", Integer.class),
    // present address
    STUDENT_PRESENT_ADDRESS("studentPresentAddress_ErpStudentProfile_Text", "Student Present Address", String.class),
    STUDENT_PRESENT_ADDRESS_COUNTRY("studentPresentAddressCountry_ErpStudentProfile_Text", "Student Present Address Country", String.class),
    STUDENT_PRESENT_ADDRESS_STATE("studentPresentAddressState_ErpStudentProfile_Text", "Student Present Address State", String.class),
    STUDENT_PRESENT_ADDRESS_DISTRICT("studentPresentAddressDistrict_ErpStudentProfile_Text", "Student Present Address District", String.class),
    STUDENT_PRESENT_ADDRESS_PIN_CODE("studentPresentAddressPinCode_ErpStudentProfile_Int", "Student Present Address Pin Code", Integer.class),
    // father details
    FATHER_SALUTATION("fatherSalutation_ErpStudentProfile_Text", "Father's Salutation", String.class),
    FATHER_NAME("fatherName_ErpStudentProfile_Text", "Father's Name", String.class),
    FATHER_AGE("fatherAge_ErpStudentProfile_Int", "Father's Age", Integer.class),
    FATHER_EMAIL("fatherEmail_ErpStudentProfile_Text", "Father's Email", String.class),
    FATHER_MOBILE_NUMBER("fatherMobileNumber_ErpStudentProfile_Text", "Father's Mobile Number", String.class),
    FATHER_MOBILE_NUMBER_COUNTRY_CODE("fatherMobileNumberCountryCode_ErpStudentProfile_Text", "Father's Mobile Number Country Code", String.class),
    FATHER_EDUCATION("fatherEducation_ErpStudentProfile_Text", "Father's Education", String.class),
    FATHER_CASTE("fatherCaste_ErpStudentProfile_Text", "Father's Caste", String.class),
    FATHER_OCCUPATION("fatherOccupation_ErpStudentProfile_Text", "Father's Occupation", String.class),
    FATHER_EMPLOYER_DETAIL("fatherEmployerDetail_ErpStudentProfile_Text", "Father's Employer", String.class),
    FATHER_ANNUAL_INCOME("fatherAnnualIncome_ErpStudentProfile_Text", "Father's Annual Income", String.class),
    FATHER_PAN_NUMBER("fatherPanNumber_ErpStudentProfile_Text", "Father's PAN Number", String.class),
    // guardian details
    GUARDIAN_SALUTATION("guardianSalutation_ErpStudentProfile_Text", "Guardian's Salutation", String.class),
    GUARDIAN_NAME("guardianName_ErpStudentProfile_Text", "Guardian's Name", String.class),
    GUARDIAN_AGE("guardianAge_ErpStudentProfile_Int", "Guardian's Age", Integer.class),
    GUARDIAN_EMAIL("guardianEmail_ErpStudentProfile_Text", "Guardian's Email", String.class),
    GUARDIAN_MOBILE_NUMBER("guardianMobileNumber_ErpStudentProfile_Text", "Guardian's Mobile Number", String.class),
    GUARDIAN_MOBILE_NUMBER_COUNTRY_CODE("guardianMobileNumberCountryCode_ErpStudentProfile_Text", "Guardian's Mobile Number Country Code", String.class),
    GUARDIAN_EDUCATION("guardianEducation_ErpStudentProfile_Text", "Guardian's Education", String.class),
    GUARDIAN_CASTE("guardianCaste_ErpStudentProfile_Text", "Guardian's Caste", String.class),
    GUARDIAN_OCCUPATION("guardianOccupation_ErpStudentProfile_Text", "Guardian's Occupation", String.class),
    GUARDIAN_EMPLOYER_DETAIL("guardianEmployerDetail_ErpStudentProfile_Text", "Guardian's Employer", String.class),
    GUARDIAN_ANNUAL_INCOME("guardianAnnualIncome_ErpStudentProfile_Text", "Guardian's Annual Income", String.class),
    GUARDIAN_PAN_NUMBER("guardianPanNumber_ErpStudentProfile_Text", "Guardian's PAN Number", String.class),
    GUARDIAN_RELATIONSHIP_DETAIL("guardianRelationshipDetail_ErpStudentProfile_Text", "Guardian's Relationship To Student", String.class),
    // mother details
    MOTHER_SALUTATION("motherSalutation_ErpStudentProfile_Text", "Mother's Salutation", String.class),
    MOTHER_NAME("motherName_ErpStudentProfile_Text", "Mother's Name", String.class),
    MOTHER_AGE("motherAge_ErpStudentProfile_Int", "Mother's Age", Integer.class),
    MOTHER_EMAIL("motherEmail_ErpStudentProfile_Text", "Mother's Email", String.class),
    MOTHER_MOBILE_NUMBER("motherMobileNumber_ErpStudentProfile_Text", "Mother's Mobile Number", String.class),
    MOTHER_MOBILE_NUMBER_COUNTRY_CODE("motherMobileNumberCountryCode_ErpStudentProfile_Text", "Mother's Mobile Number Country Code", String.class),
    MOTHER_EDUCATION("motherEducation_ErpStudentProfile_Text", "Mother's Education", String.class),
    MOTHER_CASTE("motherCaste_ErpStudentProfile_Text", "Mother's Caste", String.class),
    MOTHER_OCCUPATION("motherOccupation_ErpStudentProfile_Text", "Mother's Occupation", String.class),
    MOTHER_EMPLOYER_DETAIL("motherEmployerDetail_ErpStudentProfile_Text", "Mother's Employer", String.class),
    MOTHER_ANNUAL_INCOME("motherAnnualIncome_ErpStudentProfile_Text", "Mother's Annual Income", String.class),
    MOTHER_PAN_NUMBER("motherPanNumber_ErpStudentProfile_Text", "Mother's PAN Number", String.class),

    //Updated
    LAST_UPDATED("lastUpdated_ErpStudentProfile_DateTime", "last Updated ", Long.class),
    LAST_UPDATED_BY("lastUpdatedBy_ErpStudentProfile_Text", "last Updated By", String.class),

    // Separated date
    STUDENT_SEPARATED_DATE("studentSeparatedDate_ErpStudentProfile_Date", "Student Separated Date", Long.class),


    // new keys for PhD students
    // parent/spouse details
    STUDENT_PARENT_OR_SPOUSE_DETAILS("studentParentOrSpouseDetails_ErpStudentProfile_Document", "Student Parent Or Spouse Details", Document.class),
    PARENT_OR_SPOUSE_RELATIONSHIP("parentOrSpouseRelationship_ErpStudentProfile_Text", "Relationship to Student (Father or Mother or Spouse)", String.class),
    PARENT_OR_SPOUSE_SALUTATION("parentOrSpouseSalutation_ErpStudentProfile_Text", "Salutation to parent or spouse", String.class),
    PARENT_OR_SPOUSE_NAME("parentOrSpouseName_ErpStudentProfile_Text", "Full Name of Parent or Spouse", String.class),
    PARENT_OR_SPOUSE_OCCUPATION("parentOrSpouseOccupation_ErpStudentProfile_Text", "Occupation of Parent or Spouse", String.class),
    PARENT_OR_SPOUSE_EDUCATION("parentOrSpouseEducation_ErpStudentProfile_Text", "Highest Educational Qualification of Parent or Spouse", String.class),
    PARENT_OR_SPOUSE_EMPLOYER_DETAIL("parentOrSpouseEmployerDetail_ErpStudentProfile_Text", "Employer or Organization Details", String.class),
    PARENT_OR_SPOUSE_ANNUAL_INCOME("parentOrSpouseAnnualIncome_ErpStudentProfile_Int", "Annual Income (in INR) of Parent or Spouse", Integer.class),
    PARENT_OR_SPOUSE_AGE("parentOrSpouseAge_ErpStudentProfile_Int", "Age (in years) of Parent or Spouse", Integer.class),
    PARENT_OR_SPOUSE_CASTE("parentOrSpouseCaste_ErpStudentProfile_Text", "Caste Category of Parent or Spouse ", String.class),
    PARENT_OR_SPOUSE_EMAIL("parentOrSpouseEmail_ErpStudentProfile_Text", "Email of Parent or Spouse", String.class),
    PARENT_OR_SPOUSE_MOBILE_NUMBER("parentOrSpouseMobileNumber_ErpStudentProfile_Text", "Mobile Number of Parent or Spouse", String.class),
    PARENT_OR_SPOUSE_MOBILE_NUMBER_COUNTRY_CODE("parentOrSpouseMobileNumberCountryCode_ErpStudentProfile_Text", "Mobile Number Country Code of Parent or Spouse", String.class),
    PARENT_OR_SPOUSE_PAN_NUMBER("parentOrSpousePanNumber_ErpStudentProfile_Text", "PAN Number of Parent or Spouse", String.class),

    // mode of study
    PHD_MODE_OF_STUDY("phdModeOfStudy_ErpStudentProfile_Text", "PhD Mode Of Study", String.class),

    // research proposal
    STUDENT_PHD_RESEARCH_PROPOSAL_DETAILS("studentPhdResearchProposalDetails_ErpStudentProfile_Document", "Student PhD Research Proposal Details", Document.class),
    PHD_RESEARCH_PROPOSAL_TITLE("phdResearchProposalTitle_ErpStudentProfile_Text", "PhD Research Proposal Title", String.class),
    PHD_RESEARCH_PROPOSAL_PDF_UPLOAD("phdResearchProposalPdfUpload_ErpStudentProfile_File", "PhD Research Proposal Pdf Upload", String.class),
    PHD_STATEMENT_OF_PURPOSE_PDF_UPLOAD("phdStatementOfPurposePdfUpload_ErpStudentProfile_File", "PhD Statement Of Purpose Pdf Upload", String.class),
    PHD_BROAD_RESEARCH_AREA_PREFERENCE("phdBroadResearchAreaPreference_ErpStudentProfile_Text", "PhD Broad  Research Area Preference", String.class),
    PHD_SUB_BROAD_RESEARCH_AREA_PREFERENCE("phdSubBroadResearchAreaPreference_ErpStudentProfile_Text", "PhD Sub Broad Research Area Preference", String.class),

    DISCIPLINE("discipline_ErpStudentProfile_Text", "Discipline", String.class),

    SECTION("section_ErpStudentProfile_Text", "Student Section", String.class)
    ;


    private final String property;
    private final String label;
    private final Class dataType;
    private final int minLength;
    private final int maxLength;

    private ERPStudentProfileKeysPBinder(String property, String label, Class<?> dataType, int minLength, int maxLength) {
        this.property = property;
        this.label = label;
        this.dataType = dataType;
        this.minLength = minLength;
        this.maxLength = maxLength;
    }

    private ERPStudentProfileKeysPBinder(String property, String label, Class<?> dataType) {
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
    private static ERPStudentProfileKeysPBinder[] $values() {
        return ERPStudentProfileKeysPBinder.class.getEnumConstants();
    }
}


