package in.edu.kristujayanti.propertyBinder.core;

import in.edu.kristujayanti.propertyBinder.KJUSYSPropertyBinder;
import org.bson.Document;
import org.bson.types.ObjectId;

public enum OrganizationKeysPBinder implements KJUSYSPropertyBinder {

    //School
    SCHOOL_NAME("schoolName_Organization_Text", "School Name", String.class),
    DEPARTMENTS("departments_Organization_DocumentArray", "Departments ", Document.class),
    DEAN("dean_Organization_DocumentArray", "Dean", Document.class),
    DESCRIPTION("description_Organization_Text", "Description", String.class),
    SCHOOLS_ID("schoolsId_Organization_ObjectIdArray", "Schools Id", ObjectId.class), //School object id

    //Departments
    DEPARTMENT_NAME("departmentName_Organization_Text", "Department Name", String.class),
    DEPARTMENT_ID("departmentId_Organization_ObjectId", "Department Id", ObjectId.class), //Department object id
    HOD_OF_DEPARTMENT_NAME("hodOfDepartmentName_Organization_DocumentArray", "Head of Department", Document.class),
    PROGRAM_COORDINATOR("programCoordinator_Organization_DocumentArray", "Program Coordinator", Document.class),
    DEPARTMENT_ID_ARRAY("departmentIdArray_Organization_ObjectIdArray", "Department Id Array", ObjectId.class),

    //Campuszz
    CAMPUS_NAME("campusName_Organization_Text", "Campus Name", String.class),
    CAMPUS_ID("campusId_Organization_ObjectId", "Campus Id", ObjectId.class), //Campus object id
    CAMPUS_LOCATION("campusLocation_Organization_Text","Campus Location", String.class),

    //Management
    MANAGEMENT_DESIGNATION("managementDesignation_Organization_Text", "Management Designation", String.class),
    CORE_COMMITTEE("coreCommittee_Organization_DocumentArray", "Core Committee", Document.class),

    //Organization
    ORGANIZATION_NAME("organizationName_Organization_Text", "Organization Name", String.class),
    ORGANIZATION_EMAIL_ADDRESS("organizationEmailAddress_Organization_Text", "Organization Email Address", String.class),
    ORGANIZATION_DOMAIN("organizationDomain_Organization_Text", "Organization Domain", String.class),
    ORGANIZATION_ADDRESS("organizationAddress_Organization_Text", "Organization Domain", String.class),
    ORGANIZATION_ID("organizationId_Organization_ObjectId","Organization Id", ObjectId.class), //Organization object id
    SCHOOL_PREFIX("schoolPrefix_Organization_Text", "School Prefix", String.class),
    SCHOOL_OID("schoolOid_Organization_ObjectId", "School Oid ", ObjectId.class),
    PROGRAM_OID("programOid_Organization_ObjectId", "Program Oid ", ObjectId.class)

    ;

    private final String property;
    private final String label;
    private final Class<?> dataType;
    private final int minLength;
    private final int maxLength;

    private OrganizationKeysPBinder(String property, String label, Class<?> dataType, int minLength, int maxLength) {
        this.property = property;
        this.label = label;
        this.dataType = dataType;
        this.minLength = minLength;
        this.maxLength = maxLength;
    }

    private OrganizationKeysPBinder(String property, String label, Class<?> dataType) {
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
    private static OrganizationKeysPBinder[] $values() {
        return OrganizationKeysPBinder.class.getEnumConstants();
    }
}