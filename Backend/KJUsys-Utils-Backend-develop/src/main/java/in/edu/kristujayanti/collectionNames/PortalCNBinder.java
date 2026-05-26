package in.edu.kristujayanti.collectionNames;

public enum PortalCNBinder implements KJUSYSCNBinder{
    PORTAL_PROGRAMMES_COLLECTION("portal_programmes"),
    PORTAL_COURSES_COLLECTION("portal_courses"),
    PORTAL_EVENTS_COLLECTION("portal_events"),
    PORTAL_REGISTRATIONS_COLLECTION("portal_registrations"),


    ;
    private final String collectionName;
    private PortalCNBinder(String collectionName) {
        this.collectionName = collectionName;
    }

    public String getCollectionName() {
        return this.collectionName;
    }
    private static PortalCNBinder[] $values() {
        return PortalCNBinder.class.getEnumConstants();
    }

}
