package in.edu.kristujayanti.collectionNames;

public enum ReportOrchestratorCNBinder implements KJUSYSCNBinder {

    REPORT_ORCHESTRATOR_JOBS("report_orchestrator_jobs");


    private final String collectionName;

    private ReportOrchestratorCNBinder(String collectionName) {
        this.collectionName = collectionName;
    }

    public String getCollectionName() {
        return this.collectionName;
    }

    // $FF: synthetic method
    private static ReportOrchestratorCNBinder[] $values() {
        return ReportOrchestratorCNBinder.class.getEnumConstants();
    }


}
