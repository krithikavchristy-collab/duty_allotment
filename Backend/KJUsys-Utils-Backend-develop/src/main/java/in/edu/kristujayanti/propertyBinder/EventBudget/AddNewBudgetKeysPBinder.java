package in.edu.kristujayanti.propertyBinder.EventBudget;
import in.edu.kristujayanti.propertyBinder.KJUSYSPropertyBinder;
import org.bson.types.ObjectId;
import javax.swing.text.Document;

public enum AddNewBudgetKeysPBinder implements KJUSYSPropertyBinder {

    DEPARTMENT("department_EventBudget_Text", "Department", String.class),
    EVENT_TYPE("eventType_EventBudget_Text","Event Type ", String.class),
    EVENT_NAME("eventName_EventBudget_Text","Event Name", String.class),
    PROGRAMME_DATE("programmeDate_EventBudget_Date", "Programme Date", Long.class),
    PROGRAMME_TIME("programmeTime_EventBudget_Text", "Programme Time", String.class),
    EVENT_BUDGET_CREATED_BY("eventBudgetCreatedBy_EventBudget_Text","Event Budget Created By", String.class),
    EVENT_CREATED_AT("eventCreatedAt_EventBudget_Date","Event Created At",Long.class),
    EVENT_BUDGET_CREATED_BY_USER_ID("eventBudgetCreatedByUserId_EventBudget_Text", "Event Budget Created By User Id", String.class),
    INCOME_EVENTS("incomeEvents_EventBudget_DocumentArray", "Income Events", Document.class),
    EXPENSE_EVENTS("expenseEvents_EventBudget_DocumentArray", "Expenses Events", Document.class),
    PROGRAMME_COORDINATOR("programmeCoordinator_EventBudget_Document", "Programme Coordinator", Document.class),
    HOD_COORDINATOR("hodCoordinator_EventBudget_Document", "HOD Coordinator", Document.class),
    DEAN("dean_EventBudget_Document", "Dean", Document.class),
    FINANCIAL_ADMINISTRATOR("financialAdministrator_EventBudget_Document", "Financial Administrator",Document.class),
    IS_SAVE_AS_DRAFT("isSaveAsDraft_EventBudget_Bool", "Is Save as Draft", Boolean.class),
    GRAND_TOTAL_INCOME_COUNT("grandTotalIncomeCount_EventBudget_Int", "Grand Total Income Count", Integer.class),
    GRAND_TOTAL_EXPENSE_COUNT("grandTotalExpenseCount_EventBudget_Int", "Grand Total Expense Count", Integer.class),
    OBJECT_ID("objectId_EventBudget_ObjectId","Object Id",ObjectId .class),
    EVENT_UPDATED_AT("eventUpdatedAt_EventBudget_Date","Event Updated At ",Long.class),


    // For income_EventBudget_DocumentArray items
    INCOME_TYPE("incomeType_EventBudget_Text", "Income Type", String.class),
    EXPECTED_NO("expectedNo_EventBudget_Int", "Expected No", Integer.class),
    AMOUNT_PER("amountPer_EventBudget_Int", "Amount Per", Integer.class),
    TOTAL_AMOUNT("totalAmount_EventBudget_Int", "Total Amount", Integer.class),

    // For expenses_EventBudget_DocumentArray items
    EXPENSE_TYPES("expenseTypes_EventBudget_Text", "Expense Type", String.class),
    EXPENSE_EXPECTED_NO("expenseExpectedNo_EventBudget_Int", "Expected No", Integer.class),
    EXPENSE_AMOUNT_PER("expenseAmountPer_EventBudget_Int", "Amount Per", Integer.class),
    EXPENSE_TOTAL_AMOUNT("expenseTotalAmount_EventBudget_Int", "Total Amount", Integer.class),

    // Fields inside programmeCoordinator_EventBudget_Document
    PROGRAMME_COORDINATOR_NAME("programmeCoordinatorName_EventBudget_Text", "Programme Coordinator Name", String.class),
    PROGRAMME_COORDINATOR_EMAIL("programmeCoordinatorEmail_EventBudget_Text", "Programme Coordinator Email", String.class),
    PROGRAMME_COORDINATOR_EMP_CODE("programmeCoordinatorEmpCode_EventBudget_Text", "Programme Coordinator Code", String.class),

    // Fields inside hodCoordinator_EventBudget_Document
    HOD_COORDINATOR_NAME("hodCoordinatorName_EventBudget_Text", "HOD Name", String.class),
    HOD_COORDINATOR_EMAIL("hodCoordinatorEmail_EventBudget_Text", "HOD Email", String.class),
    HOD_COORDINATOR_EMP_CODE("hodCoordinatorEmpCode_EventBudget_Text", "HOD Code", String.class),

    // Fields inside dean_EventBudget_Document
    DEAN_NAME("deanName_EventBudget_Text", "Dean Name", String.class),
    DEAN_EMAIL("deanEmail_EventBudget_Text", "Dean Email", String.class),
    DEAN_EMP_CODE("deanEmpCode_EventBudget_Text", "Dean Code", String.class),

    // Fields inside financialAdministrator_EventBudget_Document
    FINANCIAL_ADMINISTRATOR_NAME("financialAdministratorName_EventBudget_Text", "Financial Admin Name", String.class),
    FINANCIAL_ADMINISTRATOR_EMAIL("financialAdministratorEmail_EventBudget_Text", "Financial Admin Email", String.class),
    FINANCIAL_ADMINISTRATOR_EMP_CODE("financialAdministratorEmpCode_EventBudget_Text", "Financial Admin Code", String.class);






    private final String property;
    private final String label;
    private final Class<?> dataType;
    private final int minLength;

    private final int maxLength;

    private AddNewBudgetKeysPBinder(String property, String label, Class<?> dataType, int minLength, int maxLength) {
        this.property = property;
        this.label = label;
        this.dataType = dataType;
        this.minLength = minLength;
        this.maxLength = maxLength;
    }

    private AddNewBudgetKeysPBinder(String property, String label, Class<?> dataType) {
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

    private static in.edu.kristujayanti.propertyBinder.EventBudget.AddNewBudgetKeysPBinder[] $values() {
        return in.edu.kristujayanti.propertyBinder.EventBudget.AddNewBudgetKeysPBinder.class.getEnumConstants();
    }
}
