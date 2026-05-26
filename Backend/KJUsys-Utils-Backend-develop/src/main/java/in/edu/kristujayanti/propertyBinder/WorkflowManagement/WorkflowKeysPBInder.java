package in.edu.kristujayanti.propertyBinder.WorkflowManagement;

import in.edu.kristujayanti.propertyBinder.KJUSYSPropertyBinder;
import org.bson.Document;
import org.bson.types.ObjectId;


public enum WorkflowKeysPBInder implements KJUSYSPropertyBinder {

    IN_PROGRESS("inProgress_WorkflowManagement_Bool","In Progress", Boolean.class),
    REVERTED("reverted_WorkflowManagement_Bool","Reverted", Boolean.class),
    WORKFLOW_NAME("workflowName_WorkflowManagement_Text","Workflow Name",String.class),
    IS_QUEUE_MANAGER_INTEGRATION_ENABLED("isQueueManagerIntegrationEnabled_WorkflowManagement_Bool", "Is Queue Manager Integration Enabled",Boolean.class),
    WORKFLOW_ADMINS("workflowAdmins_WorkflowManagement_TextArray","Workflow Admins", String.class),
    WORKFLOW_LEVELS("workflowLevels_WorkflowManagement_DocumentArray","Workflow Levels", Document.class),
    WORKFLOW_LEVEL_NUMBER("workflowLevelNumber_WorkflowManagement_Int","Workflow Level Number",Integer.class),
    WORKFLOW_ENTRY_POINT("workflowEntryPoint_WorkflowManagement_Bool","Workflow Entry Point", Boolean.class),
    WORKFLOW_LEVEL_NAME("workflowLevelName_WorkflowManagement_Text","Workflow Level Name",String.class),
    WORKFLOW_COUNTERS("workflowCounters_WorkflowManagement_DocumentArray","Workflow Counters", Document.class),
    COUNTER_NAME("counterName_WorkflowManagement_Text","Counter Name",String.class),
    COUNTER_ATTENDANT("counterAttendant_WorkflowManagement_Text","Counter Attendant",String.class),
    COUNTER_ATTENDANT_EMAIL_ID("counterAttendantEmailId_WorkflowManagement_Text","Counter Attendant Email Id",String.class),
    COUNTER_NUMBER("counterNumber_WorkflowManagement_Int","Counter Number",Integer.class),
    ATTENDEES_LIST("attendeesList_WorkflowManagement_DocumentArray","Attendees List", Document.class),
    ATTENDEE_UNIQUE_IDENTIFIER("attendeeUniqueIdentifier_WorkflowManagement_Text","Attendee Unique Identifier", String.class),
    ATTENDEE_STATUS("attendeeStatus_WorkflowManagement_Text","Attendee Status",String.class),
    ATTENDANT_REMARKS("attendantRemarks_WorkflowManagement_Text","Attendant Remarks", String.class),
    ATTENDANT_TOKEN_NUMBER("attendantTokenNumber_WorkflowManagement_Int","Attendant Token Number",Integer.class),
    UPDATE_LOG("updateLog_WorkflowManagement_DocumentArray","Update Log",Document.class),
    WORKFLOW_ADMINS_EMAIL("workflowAdminsEmail_WorkflowManagement_TextArray","Workflow Admins Email", String.class),
    WORKFLOW_TIMESTAMP("workflowTimestamp_WorkflowManagement_DateTime","Workflow Timestamp",Long.class),
    WORKFLOW_FROM_DATE("workflowFromDate_WorkflowManagement_Text","Workflow From Date",String.class),
    WORKFLOW_TO_DATE("workflowToDate_WorkflowManagement_Text","Workflow To Date",String.class),
    IS_LAST_LEVEL("isLastLevel_WorkflowManagement_Bool","Is Last Level",Boolean.class),
    IS_THERE_PREVIOUS_LEVEL("isTherePreviousLevel_WorkflowManagement_Bool","Is There Previous Level",Boolean.class),
    IS_ATTENDED_COUNTER_AVAILABLE("isAttendedCounterAvailable_WorkflowManagement_Bool","Is Attended Counter Available",Boolean.class),
    DOMAIN_NAME("domainName_WorkflowManagement_Text","Domain Name",String.class),
    EMAIL_TRIGGER("emailTrigger_WorkflowManagement_Bool","Email Trigger",boolean.class),
    IS_NEXT_LEVEL("isNextLevel_WorkflowManagement_Bool","Is Next Level",Boolean.class),
    IS_LEVEL_BY_PASSABLE("isLevelByPassable_WorkflowManagement_Bool","Is Level By Passable",Boolean.class),

    ATTENDEE_TIMER("attendeeTimer_WorkflowManagement_Text","Attendee Timer",String.class),
    IS_VISIBLE("isVisible_WorkflowManagement_Bool","Is Visible",boolean.class),
    ATTENDEE_LIST_NUMBER("attendeeListNumber_WorkflowManagement_Int","Attendee List Number",Integer.class),
    REMARKS_WORKFLOW("remarksWorkflow_WorkflowManagement_DocumentArray","Remarks Workflow",Document.class),




    //template
    WORKFLOW_TEMPLATE_HEADING("workflowTemplateHeading_WorkflowManagement_Text","Workflow Template Heading",String.class),
    WORKFLOW_TEMPLATE_SUBHEADING("workflowTemplateSubheading_WorkflowManagement_Text","Workflow Template Subheading",String.class),
    WORKFLOW_TEMPLATE_DESCRIPTION("workflowTemplateDescription_WorkflowManagement_Text","Workflow Template Description",String.class),
    WORKFLOW_TEMPLATE_NAME("workflowTemplateName_WorkflowManagement_Text","Workflow Template Name",String.class),
    WORKFLOW_TEMPLATE_FILE("workflowTemplateFile_WorkflowManagement_Text","Workflow Template File", String.class),
    WORKFLOW_LABEL_NAME("workflowLabelName_WorkflowManagement_Text","Workflow Label Name",String.class),
    WORKFLOW_TYPE_NAME("workflowTypeName_WorkflowManagement_Text","Workflow Type Name",String.class),
    WORKFLOW_IS_MAIN_KEY("workflowIsMainKey_WorkflowManagement_Bool","Workflow Label Name",boolean.class),
    WORKFLOW_UNIQUE_ID("workflowUniqueId_WorkflowManagement_Int","Workflow Unique Id",Integer.class),
    WORKFLOW_DROPDOWN_VALUES("workflowDropdownValues_WorkflowManagement_TextArray","Workflow Dropdown Values",String.class),
WORKFLOW_TEMPLATE_DOCUMENT("workflowTemplateDocument_WorkflowManagement_DocumentArray","Workflow Template Document",Document.class),
WORKFLOW_TEMPLATE_OID("WorkflowTemplateOid_WorkflowManagement_ObjectId","Workflow Template Oid", ObjectId.class),
WORKFLOW_LEAD("WorkflowLead_WorkflowManagement_Bool","Workflow Lead",boolean.class),
WORKFLOW_INPUT_FIELD_DESCRIPTION("workflowInputFieldDescription_WorkflowManagement_Text","Workflow Input Field Description", String.class),
   WORKFLOW_DISPLAY_TOKEN("workflowDisplayToken_WorkflowManagement_Text","Workflow Display Token",String.class),
    WORKFLOW_PREFIX("workflowPrefix_WorkflowManagement_Text","Workflow Prefix",String.class)
    ;

    private final String property;
    private final String label;
    private final Class<?> dataType;
    private final int minLength;
    private final int maxLength;

    private WorkflowKeysPBInder(String property, String label, Class<?> dataType, int minLength, int maxLength) {
        this.property = property;
        this.label = label;
        this.dataType = dataType;
        this.minLength = minLength;
        this.maxLength = maxLength;
    }

    private WorkflowKeysPBInder(String property, String label, Class<?> dataType) {
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

    private static WorkflowKeysPBInder[] $values() {
        return (WorkflowKeysPBInder[])WorkflowKeysPBInder.class.getEnumConstants();
    }









}
