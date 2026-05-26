package in.edu.kristujayanti.propertyBinder.Eform.Applicant;

import in.edu.kristujayanti.propertyBinder.KJUSYSPropertyBinder;
import org.bson.Document;
import org.bson.types.ObjectId;

public enum AdmissionDashboardPBinder implements KJUSYSPropertyBinder {

    PROGRAMME_GROUP_FILTER_CRITERIA_NAME("programmeGroupFilterCriteriaName_AdmissionDashboardKeys_Text", "Programme Group Filter Criteria Name", String.class),
    PROGRAMME_GROUP_FILTER_CRITERIA_ACADEMIC_YEAR("programmeGroupFilterCriteriaAcademicYear_AdmissionDashboardKeys_Text", "Programme Group Filter Criteria Academic Year", String.class),
    PROGRAMME_GROUP_FILTER_CRITERIA_PROGRAMMES_LIST("programmeGroupFilterCriteriaProgrammesList_AdmissionDashboardKeys_DocumentArray", "Programme Group Filter Criteria Programme List", Document.class),
    PARENT_PROGRAMME_GROUP_FILTER_CRITERIA_NAME("parentProgrammeGroupFilterCriteriaName_AdmissionDashboardKeys_Text", "Programme Group Filter Criteria Name", String.class),
    PARENT_PROGRAMME_GROUP_FILTER_CRITERIA_ACADEMIC_YEAR("parentProgrammeGroupFilterCriteriaAcademicYear_AdmissionDashboardKeys_Text", "Programme Group Filter Criteria Academic Year", String.class),


    PARENT_PROGRAMME_GROUP_FILTER_CRITERIA_PROGRAMME_GROUP_LIST("parentProgrammeGroupFilterCriteriaProgrammeGroupList_AdmissionDashboardKeys_ObjectIdArray", "Programme Group Filter Criteria Academic Year", ObjectId.class),

    APPLICANT_STUDIED_COUNTRY_LIST("applicantStudiedCountryList_AdmissionDashboardKeys_TextArray", "Applicant Studied Country List", String.class),

    APPLICANT_STUDIED_STATE_LIST("applicantStudiedStateList_AdmissionDashboardKeys_TextArray", "Applicant Studied State List", String.class),


    ;


    private final String property;
    private final String label;
    private final Class dataType;
    private final int minLength;
    private final int maxLength;

    private AdmissionDashboardPBinder(String property, String label, Class dataType, int minLength, int maxLength) {
        this.property = property;
        this.label = label;
        this.dataType = dataType;
        this.minLength = minLength;
        this.maxLength = maxLength;
    }

    private AdmissionDashboardPBinder(String property, String label, Class dataType) {
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
    private static AdmissionDashboardPBinder[] $values() {
        return AdmissionDashboardPBinder.class.getEnumConstants();
    }
}
