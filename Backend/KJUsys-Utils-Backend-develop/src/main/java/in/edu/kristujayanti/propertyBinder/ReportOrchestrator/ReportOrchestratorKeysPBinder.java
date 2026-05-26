package in.edu.kristujayanti.propertyBinder.ReportOrchestrator;

import in.edu.kristujayanti.propertyBinder.KJUSYSPropertyBinder;
import org.bson.Document;

public enum ReportOrchestratorKeysPBinder implements KJUSYSPropertyBinder {

    USER_ID("userId_ReportOrchestrator_Text", "User Id", String.class),
    REPORT_TYPE("reportType_ReportOrchestrator_Text", "Report Type", String.class),
    REPORT_PARAMS("reportParams_ReportOrchestrator_Document", "Report Params", Document.class),
    REPORT_STATUS("reportStatus_ReportOrchestrator_Text", "Report Status", String.class),
    REPORT_STATUS_MESSAGE("reportStatusMessage_ReportOrchestrator_Text", "Report Status Message", String.class),
    JOB_CREATED_ON("jobCreatedOn_ReportOrchestrator_DateTime", "Report Job Created On", Long.class),
    JOB_UPDATED_ON("jobUpdatedOn_ReportOrchestrator_DateTime", "Report Job Updated On", Long.class),
    REPORT_FILE("reportFile_ReportOrchestrator_File", "Report Generated File", String.class),
    REPORT_FILE_SIZE("reportFileSize_ReportOrchestrator_Int", "Report File Size", Integer.class),
    REPORT_FILE_NAME("reportFileName_ReportOrchestrator_Text", "Report File Name", String.class),
    ;

    private final String property;
    private final String label;
    private final Class<?> dataType;
    private final int minLength;
    private final int maxLength;

    private ReportOrchestratorKeysPBinder(String property, String label, Class<?> dataType, int minLength, int maxLength) {
        this.property = property;
        this.label = label;
        this.dataType = dataType;
        this.minLength = minLength;
        this.maxLength = maxLength;
    }

    private ReportOrchestratorKeysPBinder(String property, String label, Class<?> dataType) {
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

    public static String getLabelByPropertyName(String propertyName) {
        for (ReportOrchestratorKeysPBinder binder : ReportOrchestratorKeysPBinder.values()) {
            if (binder.getPropertyName().equals(propertyName)) {
                return binder.getDisplayName();
            }
        }
        return null; // Or throw an exception if needed
    }

    // $FF: synthetic method
    private static ReportOrchestratorKeysPBinder[] $values() {
        return ReportOrchestratorKeysPBinder.class.getEnumConstants();
    }
}