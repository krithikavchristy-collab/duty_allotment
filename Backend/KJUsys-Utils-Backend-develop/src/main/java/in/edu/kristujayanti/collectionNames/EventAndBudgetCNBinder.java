package in.edu.kristujayanti.collectionNames;

public enum EventAndBudgetCNBinder implements KJUSYSCNBinder {
    EVENT_BUDGET_ACTUAL_COLLECTION("event_budget_actual_details"),
    INVENTORY_AND_PARTICULARS_COLLECTION("inventory_and_particulars"),
    EVENT_CLASSIFICATIONS_COLLECTION("event_classifications"),
    GROUP_HEADS_COLLECTION("particulars_group_heads"),
    BUDGET_AND_IE_LOGS("budget_and_ie_logs"),
    ;


    private final String collectionName;

    private EventAndBudgetCNBinder(String collectionName) {
        this.collectionName = collectionName;
    }

    public String getCollectionName() {
        return this.collectionName;
    }

    // $FF: synthetic method
    private static EventAndBudgetCNBinder[] $values() {
        return EventAndBudgetCNBinder.class.getEnumConstants();
    }


}
