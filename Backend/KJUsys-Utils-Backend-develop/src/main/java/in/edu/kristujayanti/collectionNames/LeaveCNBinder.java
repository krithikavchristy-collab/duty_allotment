package in.edu.kristujayanti.collectionNames;

public enum LeaveCNBinder implements KJUSYSCNBinder {

    LEAVE_APPLICATIONS_COLLECTION("leaveApplicationCollection")

    ;

    private final String collectionName;

    private LeaveCNBinder(String collectionName) {
        this.collectionName = collectionName;
    }

    public String getCollectionName() {
        return this.collectionName;
    }

    // $FF: synthetic method
    private static LeaveCNBinder[] $values() {
        return LeaveCNBinder.class.getEnumConstants();
    }


}