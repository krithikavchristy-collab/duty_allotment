package in.edu.kristujayanti.propertyBinder.WorkDiary;

import in.edu.kristujayanti.propertyBinder.KJUSYSPropertyBinder;

import javax.swing.text.Document;


public enum WorkDiaryKeysPBinder implements KJUSYSPropertyBinder{

    VC_STATUS("vcStatus_WorkDiary_Text","Vc Status", String.class),
    DEAN_STATUS("deanStatus_WorkDiary_Text","Dean Status",String.class),
    COMPLETION_STATUS("completionStatus_WorkDiary_Text","Completion Status",String.class),
    WORK_DIARY_MONTH("workDiaryMonth_WorkDiary_Text","Work Diary Month",String.class),
    WORK_DIARY_YEAR("workDiaryYear_WorkDiary_Text","Work Diary Year",String.class),
    MONTHLY_WORK_DONE_DETAILS("monthlyWorkDoneDetails_WorkDiary_DocumentArray","Monthly Work Done Details", Document.class),
    STAFF_CLASS("staffClass_WorkDiary_Text","Staff Class",String.class),
    TIME_SLOTS("timeSlots_WorkDiary_DocumentArray","Time Slots",Document.class),
    TOPICS_COVERED("topicsCovered_WorkDiary_Text","Topics Covered", String.class),
    USER_COMPLETION_STATUS("userCompletionStatus_WorkDiary_Text","User Completion Status",String.class),
    CREATED_AT_TIMESTAMP("createdAtTimestamp_WorkDiary_DateTime","Created At Timestamp",Long.class),
    MONTHLY_ACTIVITY_DETAILS("monthlyActivityDetails_WorkDiary_DocumentArray","Monthly Activity Details", Document.class),
    MONTHLY_ACTIVITY_DATE("monthlyActivityDate_WorkDiary_Text","Monthly Activity Date",String.class),
    MONTHLY_ACTIVITY_TYPE("monthlyActivityType_WorkDiary_Text","Monthy Activity Type",String.class),
    VC_REMARKS("vcRemarks_WorkDiary_Text","Vc Remarks",String.class),
    DEAN_REMARKS("deanRemarks_WorkDiary_Text","Dean Remarks",String.class)





;
    private final String property;
    private final String label;
    private final Class<?> dataType;
    private final int minLength;

    private final int maxLength;

    private WorkDiaryKeysPBinder(String property, String label, Class<?> dataType, int minLength, int maxLength) {
        this.property = property;
        this.label = label;
        this.dataType = dataType;
        this.minLength = minLength;
        this.maxLength = maxLength;
    }

    private WorkDiaryKeysPBinder(String property, String label, Class<?> dataType) {
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

    private static in.edu.kristujayanti.propertyBinder.WorkDiary.WorkDiaryKeysPBinder[] $values() {
        return in.edu.kristujayanti.propertyBinder.WorkDiary.WorkDiaryKeysPBinder.class.getEnumConstants();
    }

}