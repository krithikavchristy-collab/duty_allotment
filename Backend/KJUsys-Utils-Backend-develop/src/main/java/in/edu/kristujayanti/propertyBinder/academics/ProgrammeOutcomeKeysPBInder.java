package in.edu.kristujayanti.propertyBinder.academics;

import in.edu.kristujayanti.propertyBinder.KJUSYSPropertyBinder;

import javax.swing.text.Document;

public enum ProgrammeOutcomeKeysPBInder implements KJUSYSPropertyBinder {


    //programme-outcome
    PROGRAMME_OUTCOME_CODE("programmeOutcomeCode_ProgrammeOutcome_Text","Programme Outcome Code",String.class),
    PROGRAMME_OUTCOME_DESCRIPTION("programmeOutcomeDescription_ProgrammeOutcome_Text","Programme Outcome Description",String.class),
    PROGRAMME_OUTCOME_DETAILS("programmeOutcomeDetails_ProgrammeOutcome_DocumentArray","Programme Outcome Details",Document.class),
    PROGRAMME_OUTCOME_NUMBER("programmeOutcomeNumber_ProgrammeOutcome_Int","Programme Outcome Number",Integer.class),


    //programme-specific-outcome
    PROGRAMME_SPECIFIC_OUTCOME_CODE("programmeSpecificOutcomeCode_ProgrammeOutcome_Text","Programme Specific Outcome Code",String.class),
    PROGRAMME_SPECIFIC_OUTCOME_DESCRIPTION("programmeSpecificOutcomeDescription_ProgrammeOutcome_Text","Programme Specific Outcome Description",String.class),
    PROGRAMME_SPECIFIC_OUTCOME_DETAILS("programmeSpecificOutcomeDetails_ProgrammeOutcome_DocumentArray","Programme Specific Outcome Details",Document.class),
    PROGRAMME_SPECIFIC_OUTCOME_NUMBER("programmeSpecificOutcomeNumber_ProgrammeOutcome_Int","Programme Specific Outcome Number",Integer.class)

    ;


    private final String property;
    private final String label;
    private final Class<?> dataType;
    private final int minLength;
    private final int maxLength;

    private ProgrammeOutcomeKeysPBInder(String property, String label, Class<?> dataType, int minLength, int maxLength) {
        this.property = property;
        this.label = label;
        this.dataType = dataType;
        this.minLength = minLength;
        this.maxLength = maxLength;
    }

    private ProgrammeOutcomeKeysPBInder(String property, String label, Class<?> dataType) {
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
    private static ProgrammeOutcomeKeysPBInder[] $values() {
        return ProgrammeOutcomeKeysPBInder.class.getEnumConstants();
    }




}
