package in.edu.kristujayanti.propertyBinder.EventBudget;

import in.edu.kristujayanti.propertyBinder.KJUSYSPropertyBinder;
import org.bson.types.ObjectId;
import org.w3c.dom.Document;

public enum EventBudgetActualKeyBinder implements KJUSYSPropertyBinder {

    EVENT_OBJECT_ID("eventObjectId_EventBudgetActual_ObjectId", "Event  ObjectId", ObjectId.class),
    EVENT_NAME("eventName_EventBudgetActual_Text", "Event Name", String.class),
    EVENT_TYPE("eventType_EventBudgetActual_Text", "Event Type", String.class),
    EVENT_CATEGORY("eventCategory_EventBudgetActual_Text", "Event Category", String.class),
    EVENT_DATE("eventDate_EventBudgetActual_Date", "Tentative Event Date", Long.class),
    EVENT_END_DATE("eventEndDate_EventBudgetActual_Date", "Event End Date", Long.class),
    EVENT_TIME_FROM("eventTimeFrom_EventBudgetActual_Text", "Event Time From", String.class),
    EVENT_TIME_TO("eventTimeTo_EventBudgetActual_Text", "Event Time To", String.class),
    ORGANISED_BY("organisedBy_EventBudgetActual_Text", "Event Organised By", String.class),
    DEPARTMENT_OR_CLUB_NAME("departmentOrClubName_EventBudgetActual_Text", "Department / Club Name", String.class),
    DEPARTMENT_OR_CLUB_ID("departmentOrClubId_EventBudgetActual_ObjectId", "Department/ Club Id", ObjectId.class),
    EVENT_BUDGET_CREATED_BY_EMAIL("eventBudgetCreatedByEmail_EventBudgetActual_Text", "Event Budget Created By Email", String.class),
    EVENT_BUDGET_CREATED_BY_NAME("eventBudgetCreatedByName_EventBudgetActual_Text", "Event Budget Created By Name", String.class),

    EVENT_ACTUAL_SUBMISSION_BY_NAME("eventActualSubmissionByName_EventBudgetActual_Text", "Event Actual Submission By Name", String.class),
    EVENT_ACTUAL_SUBMISSION_BY_EMAIL("eventActualSubmissionByEmail_EventBudgetActual_Text", "Event Actual Submission By Email", String.class),

    EVENT_BUDGET_CREATED_AT("eventBudgetCreatedAt_EventBudgetActual_Date", "Event Budget Created At", Long.class),
    EVENT_ACTUAL_CREATED_AT("eventActualCreatedAt_EventBudgetActual_Date", "Event Actual Created At", Long.class),
    LEVEL_ONE_APPROVAL_EMAIL("levelOneApprovalEmail_EventBudgetActual_Text", "Level One Approval Email", String.class),
    LEVEL_ONE_APPROVER_NAME("levelOneApproverName_EventBudgetActual_Text", "Level One Approver Name", String.class),
    LEVEL_TWO_APPROVAL_EMAIL("levelTwoApprovalEmail_EventBudgetActual_Text", "Level Two Approval Email", String.class),
    LEVEL_TWO_APPROVER_NAME("levelTwoApproverName_EventBudgetActual_Text", "Level Two Approver Name", String.class),
    STATUS_LEVEL("statusLevel_EventBudgetActual_Text", "Status Level", String.class),
    BUDGET_PDF_FILE_PATH("budgetPdfFilePath_EventBudgetActual_Text", "Budget PDF File Path", String.class),
    ACTUAL_PDF_FILE_PATH("actualPdfFilePath_EventBudgetActual_Text", "Actual PDF File Path", String.class),

    BUDGET_STATUS("budgetStatus_EventBudgetActual_Text", "Budget Status", String.class),

    EVENT_DURATION("eventDuration_EventBudgetActual_Text", "Event Duration", String.class),

    BUDGET_STATUS_COMMENT("budgetStatusComment_EventBudgetActual_Text", "Budget Status Comment", String.class),

    ACTUAL_STATUS("actualStatus_EventBudgetActual_Text", "Actual Status", String.class),
    DEADLINE_FOR_ACTUAL_SUBMISSION("deadlineForActualSubmission_EventBudgetActual_Date", "Deadline For Actual Submission", Long.class),
    ACTUAL_STATUS_COMMENT("actualStatusComment_EventBudgetActual_Text", "Actual Status Comment", String.class),


    EXPENDITURE_PROJECTION("expenditureProjection_EventBudgetActual_DocumentArray", "Expenditure Projection", Document.class),
    INCOME_PROJECTION("incomeProjection_EventBudgetActual_DocumentArray", "Income Projection", Document.class),
    BUDGET_RETURNABLES_REQUIRED("budgetReturnablesRequired_EventBudgetActual_DocumentArray", "Returnables Required", Document.class),



    BUDGET_GROUP_TOTAL("budgetGroupTotal_EventBudgetActual_Double", "Budget Group Total", Double.class),
    BUDGET_PARTICULARS("budgetParticulars_EventBudgetActual_DocumentArray", "Budget Particulars", Document.class),
    BUDGET_PARTICULAR_ITEM("budgetParticularItem_EventBudgetActual_Text", "Budget Particular Item", String.class),
    BUDGET_UNIT_OF_MEASURE("budgetUnitOfMeasure_EventBudgetActual_Text", "Budget Particulars Unit Of Measure", String.class),
    BUDGET_REQ_QUANTITY("budgetReqQuantity_EventBudgetActual_Double", "Budget Particulars Required Quantity", Double.class),
    BUDGET_UNIT_PRICE("budgetUnitPrice_EventBudgetActual_Double", "Budgeted Unit Price", Double.class),
    BUDGET_ENABLE_USER_ENTRY("budgetEnableUserEntry_EventBudgetActual_Bool", "Budget Enable User Entry", Boolean.class),
    BUDGET_TOTAL_AMOUNT("budgetTotalAmount_EventBudgetActual_Double", "Budgeted Total Amount", Double.class),
    BUDGET_TOTAL_INCOME("budgetTotalIncome_EventBudgetActual_Double", "Budgeted Total Income", Double.class),
    BUDGET_TOTAL_INCOME_AMOUNT_IN_TEXT("budgetTotalIncomeAmountInText_EventBudgetActual_Text", "Budgeted Total Income Amount in Words", String.class),
    BUDGET_TOTAL_EXPENDITURE("budgetTotalExpenditure_EventBudgetActual_Double", "Budgeted Total Expenditure (INR)", Double.class),
    BUDGET_TOTAL_EXPENDITURE_AMOUNT_IN_TEXT("budgetTotalExpenditureAmountInText_EventBudgetActual_Text", "Budgeted Total Expenditure in Words", String.class),

    BUDGET_PROFIT_OR_LOSS_AMOUNT("budgetProfitOrLossAmount_EventBudgetActual_Double", "Budget Profit or Loss Amount", Double.class),

    BUDGET_PROFIT_OR_LOSS_AMOUNT_IN_TEXT("budgetProfitOrLossAmountInText_EventBudgetActual_Text", "Budget Profit or Loss Amount in Words", String.class),


    EXPENDITURE_ACTUAL("expenditureActual_EventBudgetActual_DocumentArray", "Expenditure Actual", Document.class),
    INCOME_ACTUAL("incomeActual_EventBudgetActual_DocumentArray", "Income Actual", Document.class),
    RETURNABLES_ACTUAL("returnablesActual_EventBudgetActual_DocumentArray", "Returnables Actual", Document.class),

    ACTUAL_GROUP_TOTAL("actualGroupTotal_EventBudgetActual_Double", "Actual Group Total", Double.class),
    ACTUAL_PARTICULARS("actualParticulars_EventBudgetActual_DocumentArray", "Actual Particulars", Document.class),
    ACTUAL_PARTICULAR_ITEM("actualParticularItem_EventBudgetActual_Text", "Actual Particular Item", String.class),
    ACTUAL_UNIT_OF_MEASURE("actualUnitOfMeasure_EventBudgetActual_Text", "Actual Particulars Unit", String.class),
    ACTUAL_ENABLE_USER_ENTRY("actualEnableUserEntry_EventBudgetActual_Bool", "Actual Enable User Entry", Boolean.class),
    ACTUAL_REQ_QUANTITY("actualReqQuantity_EventBudgetActual_Double", "Actual Particulars Count", Double.class),
    ACTUAL_UNIT_PRICE("actualUnitPrice_EventBudgetActual_Double", "Actual Unit Price", Double.class),
    ACTUAL_TOTAL_AMOUNT("actualTotalAmount_EventBudgetActual_Double", "Actual Total Amount", Double.class),

    ACTUAL_TOTAL_INCOME("actualTotalIncome_EventBudgetActual_Double", "Actual Total Income", Double.class),
    ACTUAL_TOTAL_INCOME_AMOUNT_IN_TEXT("actualTotalIncomeAmountInText_EventBudgetActual_Text", "Actual Total Income in Words", String.class),
    ACTUAL_TOTAL_EXPENDITURE("actualTotalExpenditure_EventBudgetActual_Double", "Actual Total Expenditure (INR)", Double.class),
    ACTUAL_TOTAL_EXPENDITURE_AMOUNT_IN_TEXT("actualTotalExpenditureAmountInText_EventBudgetActual_Text", "Actual Total Expenditure in Words", String.class),


    ACTUAL_PROFIT_OR_LOSS_AMOUNT("actualProfitOrLossAmount_EventBudgetActual_Double", "Actual Profit or Loss Amount", Double.class),
    ACTUAL_PROFIT_OR_LOSS_AMOUNT_IN_TEXT("actualProfitOrLossAmountInText_EventBudgetActual_Text", "Actual Profit or Loss Amount in Words", String.class),

    VARIANCE("variance_EventBudgetActual_Double", "Variance From Budgeted", Double.class),

    ADDITIONAL_EXPENSE_SUPPORTING_DOCUMENT("additionalExpenseSupportingDocument_EventBudgetActual_File", "Additional Expense Supporting Document", String.class),





    //Inventory And Particulars
    ENTRY_TYPE("entryType_EventBudgetActual_Text", "Entry Type", String.class), //Income or Expense or Returnable
    GROUP_HEAD_NAME("groupHeadName_EventBudgetActual_Text", "Group Head Name", String.class),
    GROUP_HEAD_OID("groupHeadOid_EventBudgetActual_ObjectId", "Group Head Oid", ObjectId.class),
    ITEM_NAME("itemName_EventBudgetActual_Text", "Item Name", String.class),

    UNIT_OF_MEASURE("unitOfMeasure_EventBudgetActual_Text", "Unit Of Measure", String.class),
    UNIT_PRICE("unitPrice_EventBudgetActual_Double", "Unit Price", Double.class),
    ITEM_QUANTITY("itemQuantity_EventBudgetActual_Text", "Item Quantity", Double.class),

    TANGIBLE_PROPERTY("tangibleProperty_EventBudgetActual_Bool", "Tangible Property", Boolean.class),
    ENABLE_USER_ENTRY_FOR_AMOUNT("enableUserEntryForAmount_EventBudgetActual_Bool", "Enable User Entry For Amount", Boolean.class),


    //Office And Centres, Category, Type
    CLASSIFICATION_TYPE("classificationType_EventBudgetActual_Text", "Classification Type", String.class),
    FIELD_VALUE("fieldValue_EventBudgetActual_Text", "Field Value", String.class),
    FIELD_VALUE_CATEGORY("fieldValueCategory_EventBudgetActual_Text", "Field Value Category", String.class),






    ;


    private final String property;
    private final String label;
    private final Class<?> dataType;
    private final int minLength;
    private final int maxLength;


    EventBudgetActualKeyBinder(String property, String label, Class<?> dataType) {
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

    private static in.edu.kristujayanti.propertyBinder.EventBudget.EventBudgetActualKeyBinder[] $values() {
        return in.edu.kristujayanti.propertyBinder.EventBudget.EventBudgetActualKeyBinder.class.getEnumConstants();
    }
}


