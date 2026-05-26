package in.edu.kristujayanti.collectionNames;

public enum WorkflowManagementCNBinder {
    WORKFLOW_COLLECTION("workflow_collection"),
    ;





    private final String collectionName;

    private WorkflowManagementCNBinder(String collectionName) {
        this.collectionName = collectionName;
    }

    public String getCollectionName() {
        return this.collectionName;
    }

    // $FF: synthetic method
    private static WorkflowManagementCNBinder[] $values() {
        return WorkflowManagementCNBinder.class.getEnumConstants();
    }



}
