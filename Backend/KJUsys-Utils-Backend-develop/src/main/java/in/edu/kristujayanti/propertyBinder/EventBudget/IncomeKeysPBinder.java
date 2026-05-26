package in.edu.kristujayanti.propertyBinder.EventBudget;

import in.edu.kristujayanti.propertyBinder.KJUSYSPropertyBinder;
import io.vertx.core.json.JsonArray;
import org.bson.types.ObjectId;

import javax.swing.text.Document;

public enum IncomeKeysPBinder  implements KJUSYSPropertyBinder {



    INCOME_DEPARTMENT("incomeDepartment_EventIncome_Text", "Income Department", String.class),
    INCOME_EVENT_TYPE("incomeEventType_EventIncome_Text","Income Event Type ", String.class),
    INCOME_EVENT_NAME("incomeEventName_EventIncome_Text","Income Event Name", String.class),
    INCOME_PROGRAMME_DATE("incomeProgrammeDate_EventIncome_Date", "Income Programme Date", Long.class),
    INCOME_PROGRAMME_TIME("incomeProgrammeTime_EventIncome_Text", "Income Programme Time", String.class),
    INCOME_CREATED_BY("incomeCreatedBy_EventIncome_Text","Income Event Income Created By", String.class),
    INCOME_EVENT_CREATED_AT("incomeEventCreatedAt_EventIncome_Date","Income Event Created Time",Long.class),
    INCOME_EVENT_CREATED_BY_USER_ID("incomeEventCreatedByUserId_EventIncome_Text", "Income Created User ID", String.class),
    INCOME_EVENTS("incomeEvents_EventIncome_DocumentArray", "Income Events", Document.class),
    INCOME_EXPENSES_EVENTS("incomeExpensesEvents_EventIncome_DocumentArray", "Income Expenses Events", Document.class),
    IS_SAVE_AS_DRAFT("isSaveAsDraft_EventIncome_Bool", "Is Save as Draft", Boolean.class),
    INCOME_UPDATED_AT("incomeUpdatedAt_EventIncome_Date","Income Updated At ",Long.class),
    INCOME_PROGRAMME_COORDINATOR("incomeProgrammeCoordinator_EventIncome_Document", "Income Programme Coordinator",Document .class),
    INCOME_HOD_COORDINATOR("incomeHodCoordinator_EventIncome_Document", "Income HOD Coordinator", Document.class),
    INCOME_DEAN("incomeDean_EventIncome_Document", "Income Dean", Document.class),
    INCOME_FINANCIAL_ADMINISTRATOR("incomeFinancialAdministrator_EventIncome_Document", "Income Financial Administrator",Document.class),
    INCOME_GRAND_TOTAL_INCOME_COUNT("incomeGrandTotalIncomeCount_EventIncome_Int", "Income Grand Total Income Count", Integer.class),
    INCOME_GRAND_TOTAL_EXPENSE_COUNT("incomeGrandTotalExpenseCount_EventIncome_Int", "Income Grand Total Expense Count", Integer.class),
    INCOME_OBJECT_ID("incomeObjectId_EventIncome_ObjectId","Income Object Id",ObjectId .class),

    // For incomeEvents_EventIncome_DocumentArray items
    INCOME_TYPE("incomeType_EventIncome_Text", "Income Type", String.class),
    INCOME_EXPECTED_NO("incomeExpectedNo_EventIncome_Int", "Expected No", Integer.class),
    INCOME_AMOUNT_PER("incomeAmountPer_EventIncome_Int", "Amount Per", Integer.class),
    INCOME_TOTAL_AMOUNT("incomeTotalAmount_EventIncome_Int", "Total Amount", Integer.class),

    // For incomeExpensesEvents_EventIncome_DocumentArray items
    EXPENSE_TYPE("expenseType_EventIncome_Text", "Expense Type", String.class),
    EXPENSE_EXPECTED_NO("expenseExpectedNo_EventIncome_Int", "Expected No", Integer.class),
    EXPENSE_AMOUNT_PER("expenseAmountPer_EventIncome_Int", "Amount Per", Integer.class),
    EXPENSE_TOTAL_AMOUNT("expenseTotalAmount_EventIncome_Int", "Total Amount", Integer.class),

    // Fields inside incomeProgrammeCoordinator_EventIncome_Document
    INCOME_PROGRAMME_COORDINATOR_NAME("incomeProgrammeCoordinatorName_EventIncome_Text", "Programme Coordinator Name", String.class),
    INCOME_PROGRAMME_COORDINATOR_EMAIL("incomeProgrammeCoordinatorEmail_EventIncome_Text", "Programme Coordinator Email", String.class),
    INCOME_PROGRAMME_COORDINATOR_EMP_CODE("incomeProgrammeCoordinatorEmpCode_EventIncome_Text", "Programme Coordinator Code", String.class),

    // Similarly for HOD
    INCOME_HOD_COORDINATOR_NAME("incomeHodCoordinatorName_EventIncome_Text", "HOD Name", String.class),
    INCOME_HOD_COORDINATOR_EMAIL("incomeHodCoordinatorEmail_EventIncome_Text", "HOD Email", String.class),
    INCOME_HOD_COORDINATOR_EMP_CODE("incomeHodCoordinatorEmpCode_EventIncome_Text", "HOD Code", String.class),

    // Dean
    INCOME_DEAN_NAME("incomeDeanName_EventIncome_Text", "Dean Name", String.class),
    INCOME_DEAN_EMAIL("incomeDeanEmail_EventIncome_Text", "Dean Email", String.class),
    INCOME_DEAN_EMP_CODE("incomeDeanEmpCode_EventIncome_Text", "Dean Code", String.class),

    // Financial Administrator
    INCOME_FINANCIAL_ADMINISTRATOR_NAME("incomeFinancialAdministratorName_EventIncome_Text", "Fin Admin Name", String.class),
    INCOME_FINANCIAL_ADMINISTRATOR_EMAIL("incomeFinancialAdministratorEmail_EventIncome_Text", "Fin Admin Email", String.class),
    INCOME_FINANCIAL_ADMINISTRATOR_EMP_CODE("incomeFinancialAdministratorEmpCode_EventIncome_Text", "Fin Admin Code", String.class);

    private final String property;
    private final String label;
    private final Class dataType;
    private final int minLength;
    private final int maxLength;

    private IncomeKeysPBinder(String property, String label, Class dataType, int minLength, int maxLength) {
        this.property = property;
        this.label = label;
        this.dataType = dataType;
        this.minLength = minLength;
        this.maxLength = maxLength;
    }

    private IncomeKeysPBinder(String property, String label, Class dataType) {
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

    // $FF: synthetic method
    private static in.edu.kristujayanti.propertyBinder.EventBudget.IncomeKeysPBinder[] $values() {
        return in.edu.kristujayanti.propertyBinder.EventBudget.IncomeKeysPBinder.class.getEnumConstants();
    }}
