package in.edu.kristujayanti.propertyBinder.EduServ;

import in.edu.kristujayanti.propertyBinder.KJUSYSPropertyBinder;
import org.bson.Document;
import org.bson.types.ObjectId;

import java.util.List;

public enum IdCardKeysPBinders implements KJUSYSPropertyBinder{

    ID_CARD_TEMPLATE_OID("idCardTemplateOid_IdCard_ObjectId","Id Card Template Oid", ObjectId.class),
    ID_CARD_TEMPLATE_NAME("idCardTemplateName_IdCard_Text","Id Card Template Name",String.class),
    ID_CARD_S3_FILE_PATH("idCardS3FilePath_IdCard_Text"," Id Card Template File Path",String.class),
    ID_CARD_TEMPLATE_PLACEHOLDERS("idCardTemplatePlaceholders_IdCard_DocumentArray","Id Card Template Placeholders", Document.class),
    ID_CARD_TEMPLATE_UPDATED_ON("idCardTemplateUpdatedOn_IdCard_DateTime","Id Card Template Updated On",Long.class),
    ID_CARD_TEMPLATE_PLACEHOLDER_KEY("idCardTemplatePlaceholderKey_IdCard_Text","Id Card  Template Placeholder Template Key",String.class),
    ID_CARD_TEMPLATE_PLACEHOLDER_VALUE("idCardTemplatePlaceholderValue_IdCard_Text","Id Card  Template Placeholder Template Value",String.class),
    ID_CARD_TEMPLATE_MAPPING_UPDATED_ON("idCardTemplateMappingUpdatedOn_IdCard_DateTime","Id Card Template Mapping Updated On", Long.class),
    ID_CARD_STATUS("idCardStatus_IdCard_Text","Id Card Status",String.class),
    ID_CARD_PHOTO_FILE_PATH("idCardPhotoFilePath_IdCard_Text"," Id Card Template File Path",String.class),

    IS_PHONE_NUMBER_EDITED("isPhoneNumberEdited_IdCard_Bool","Is Phone Number Edited",Boolean.class),
    IS_BLOOD_GROUP_EDITED("isBloodGroupEdited_IdCard_Bool","Is Blood Group Edited",Boolean.class),
    IS_PRESENT_ADDRESS_SELECTED_FOR_ID_CARD("isPresentAddressSelectedForIdCard_IdCard_Bool","Is Present Address Selected For Id Card",Boolean.class),
    IS_PERMANENT_ADDRESS_SELECTED_FOR_ID_CARD("isPermanentAddressSelectedForIdCard_IdCard_Bool","Is Permanent Address Selected For Id Card",Boolean.class),
    IS_ID_CARD_SAVE_AS_DRAFT("isIdCardSaveAsDraft_IdCard_Bool","Is Id Card Save As Draft",Boolean.class),
    IS_ID_CARD_ISSUED("isIdCardIssued_IdCard_Bool","Is Id Card Issued",Boolean.class),
    ID_CARD_REISSUED_REMARKS("idCardReissuedRemarks_IdCard_Text","Id Card Reissued Remarks",String.class),
    ID_CARD_ISSUED_ON("idCardIssuedOn_IdCard_Date","Id Card Issued On",Long.class),
    ID_CARD_ISSUED_BY("idCardIssuedBy_IdCard_Text","Id Card Issued By",String.class),
    ID_CARD_REISSUED_ON("idCardReissuedOn_IdCard_Date","Id Card Reissued On",Long.class),
    ID_CARD_REISSUED_BY("idCardReissuedBy_IdCard_Text","Id Card Reissued By",String.class),
    // print
    LIST_OF_APPLICATION_NUMBERS("listOfApplicationNumbers_IdCard_TextArray","List Of Application Numbers",String.class),
    ID_CARD_PRINT_ACTION_NAME("idCardPrintActionName_IdCard_Text","Id Card Print Action Name",String.class),
    SELECTED_ID_CARD_REQUEST_ID("selectedIdCardRequestId_IdCard_TextArray","Selected Id Card Request Id",String.class),
    PROGRAM_NAMES("programNames_IdCard_TextArray","Program Names",String.class),

    //Template Mapping
    SELECT_TEMPLATE_NAME("selectTemplateName_IdCard_Text","Select Template Name",String.class),
    INTAKE("intake_IdCard_Text","Intake",String.class),
    MAP_BATCHES("mapBatches_IdCard_TextArray","Map Batches",String.class);

    private final String property;
    private final String label;
    private final Class dataType;
    private final int minLength;
    private final int maxLength;

    private IdCardKeysPBinders(String property, String label, Class dataType, int minLength, int maxLength) {
        this.property = property;
        this.label = label;
        this.dataType = dataType;
        this.minLength = minLength;
        this.maxLength = maxLength;
    }

    private IdCardKeysPBinders(String property, String label, Class dataType) {
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
    private static IdCardKeysPBinders[] $values() {
        return IdCardKeysPBinders.class.getEnumConstants();
    }
}
