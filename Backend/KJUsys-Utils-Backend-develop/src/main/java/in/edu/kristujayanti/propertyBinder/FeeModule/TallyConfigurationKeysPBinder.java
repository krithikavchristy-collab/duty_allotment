package in.edu.kristujayanti.propertyBinder.FeeModule;

import in.edu.kristujayanti.propertyBinder.KJUSYSPropertyBinder;

public enum TallyConfigurationKeysPBinder implements KJUSYSPropertyBinder {

    TALLY_DEMAND_ID("tallyDemandId_TallyConfiguration_Text", "Tally Demand Id", String.class),
    TALLY_COLLECTION_ID("tallyCollectionId_TallyConfiguration_Text", "Tally Collection Id", String.class),
    TALLY_PAYMENTS_ID("tallyPaymentsId_TallyConfiguration_Text", "Tally Payments Id", String.class),
    IS_SYNCED_WITH_TALLY("isSyncedWithTally_TallyConfiguration_Bool", "Is Synced With Tally", Boolean.class)



    ;


    private final String property;
    private final String label;
    private final Class<?> dataType;
    private final int minLength;
    private final int maxLength;

    private TallyConfigurationKeysPBinder(String property, String label, Class<?> dataType, int minLength, int maxLength) {
        this.property = property;
        this.label = label;
        this.dataType = dataType;
        this.minLength = minLength;
        this.maxLength = maxLength;
    }

    private TallyConfigurationKeysPBinder(String property, String label, Class<?> dataType) {
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

    private static TallyConfigurationKeysPBinder[] $values() {
        return TallyConfigurationKeysPBinder.class.getEnumConstants();
    }
}
