package in.edu.kristujayanti.propertyBinder.academics;

import in.edu.kristujayanti.propertyBinder.KJUSYSPropertyBinder;
import org.bson.Document;

public enum AcademicsCommonKeysPBinder implements KJUSYSPropertyBinder {

    // define the academic property binders

    //semester PBInder
    SEMESTER("semester_AcademicsCommon_Int","Semester",Integer.class),
    SEMESTER_DISPLAY_NAME("semesterDisplayName_AcademicsCommon_Text", "Semester Display Name", String.class),
    CASTE_CATEGORY_NAME("casteCategoryName_AcademicsCommon_Text", "caste category", String.class),
    ADMISSION_QUOTA_NAME("admissionQuotaName_AcademicsCommon_Text", "Admission Quota Name", String.class),

    /// Batch class mapping
    BATCH_COORDINATORS_DETAILS_DOCUMENT_ARRAY("batchCoordinatorsDetailsDocumentArray_AcademicsCommon_DocumentArray", "Batch CoordinatorS Details ", Document.class),
    BATCH_COORDINATOR_NAME("batchCoordinatorName_AcademicsCommon_Text", "Batch Coordinator Name", String.class),
    BATCH_COORDINATOR_EMAIL("batchCoordinatorEmail_AcademicsCommon_Text", "Batch Coordinator Email", String.class),
    BATCH_COORDINATOR_DEPARTMENT("batchCoordinatorDepartment_AcademicsCommon_Text", "Batch Coordinator Department", String.class),
    BATCH_COORDINATOR_MOBILE("batchCoordinatorMobile_AcademicsCommon_Text", "Batch Coordinator Mobile", String.class),
    CLASS_ANIMATORS_DETAILS_DOCUMENT_ARRAY("classAnimatorsDetailsDocumentArray_AcademicsCommon_DocumentArray", "Class Animators Details", Document.class),
    CLASS_ANIMATOR_NAME("classAnimatorName_AcademicsCommon_Text", "Class Animator Name", String.class),
    CLASS_ANIMATOR_EMAIL("classAnimatorEmail_AcademicsCommon_Text", "Class Animator Email", String.class),
    CLASS_ANIMATOR_DEPARTMENT("classAnimatorDepartment_AcademicsCommon_Text", "Class Animator Department", String.class),
    CLASS_DIVISION_NAME("classDivisionName_AcademicsCommon_Text", "Class Division Name", String.class),
    PROGRAMME_NAME_PRINTED_IN_ID_CARD("programmeNamePrintedInIdCard_AcademicsCommon_Text", "Programme Name Printed In ID Card", String.class),
    CLASS_DETAILS_DOCUMENT_ARRAY("classDetailsDocumentArray_AcademicsCommon_DocumentArray", "Class Details", Document.class),

    ACADEMIC_YEARS("academicYears_AcademicsCommon_TextArray", "Academic Years", String.class),
    ACADEMIC_BATCH_NAME("academicBatchName_AcademicsCommon_TextArray", "Academic Batch Name", String.class),
    ACADEMIC_CLASS("academicClass_AcademicsCommon_TextArray", "Academic Class", String.class),

    CLASS_ANIMATOR_DOCUMENT_ARRAY("classAnimatorDocumentArray_AcademicsCommon_DocumentArray", "Class Animator Document Array", Document.class),

    ;


    private final String property;
    private final String label;
    private final Class<?> dataType;
    private final int minLength;
    private final int maxLength;

    private AcademicsCommonKeysPBinder(String property, String label, Class<?> dataType, int minLength, int maxLength) {
        this.property = property;
        this.label = label;
        this.dataType = dataType;
        this.minLength = minLength;
        this.maxLength = maxLength;
    }

    private AcademicsCommonKeysPBinder(String property, String label, Class<?> dataType) {
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
    private static AcademicsCommonKeysPBinder[] $values() {
        return AcademicsCommonKeysPBinder.class.getEnumConstants();
    }
}
