package in.edu.kristujayanti.collectionNames;

public enum LibraryCNBinder implements KJUSYSCNBinder {
    PERIODICITY_COLLECTION("periodicity"),
    PERIODICAL_TYPE_COLLECTION("periodical_type"),
    PERIODICAL_SUBJECT("periodical_subject"),
    PERIODICAL_SOURCE_COLLECTION("periodicalSource"),
    PERIODICAL_DEPARTMENT_COLLECTION("periodicalDepartment"),
    PERIODICAL_BRANCH_COLLECTION("periodicalBranch"),
    PERIODICAL_VENDOR_COLLECTION("periodicalVendor"),
    PERIODICAL_INFORMATION_COLLECTION("periodicalInformation")

    ;

    private final String collectionName;

    private LibraryCNBinder(String collectionName) {
        this.collectionName = collectionName;
    }

    public String getCollectionName() {
        return this.collectionName;
    }

    // $FF: synthetic method
    private static LibraryCNBinder[] $values() {
        return LibraryCNBinder.class.getEnumConstants();
    }




}
