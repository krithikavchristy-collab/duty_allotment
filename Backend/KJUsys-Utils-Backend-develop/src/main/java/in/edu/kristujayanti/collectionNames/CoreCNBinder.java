package in.edu.kristujayanti.collectionNames;

public enum CoreCNBinder implements KJUSYSCNBinder {

    ERP_STAFF_USER_PROFILE("erp_staff_user_profile"),
    ERP_STUDENT_PROFILE("erp_student_profile"),
    UI_MENUS("ui_menus"),
    UI_MENU_GROUPS("ui_menu_groups"),
    ORG_SCHOOLS("org_schools"),
    ORG_DEPARTMENTS("org_departments"),
    ORG_CAMPUS("org_campus"),
    ORG_ORGANIZATIONS("org_organizations"),
    PRESETS_AND_FILTERS("presets_and_filters"),
    PRESETS_AND_FILTER_FIELDS("presets_and_filter_fields")
    ;

    private final String collectionName;

    private CoreCNBinder(String collectionName) {
        this.collectionName = collectionName;
    }

    public String getCollectionName() {
        return this.collectionName;
    }

    // $FF: synthetic method
    private static CoreCNBinder[] $values() {
        return CoreCNBinder.class.getEnumConstants();
    }
}
