package in.edu.kristujayanti.propertyBinder.core;

import in.edu.kristujayanti.propertyBinder.KJUSYSCommonKeysPBinder;
import in.edu.kristujayanti.propertyBinder.KJUSYSPropertyBinder;
import org.bson.Document;


public enum PresetAndFilterKeysPBinder implements KJUSYSPropertyBinder {


    OPERATION_TYPE("operationType_PresetAndFilter_Text", "Operation Type", String.class),
    FILTER_FOR_MENU_NAME("filterForMenuName_PresetAndFilter_Text", "Filter For Menu Name", String.class),
    PROJECTION_SECTION_NAME("projectionSectionName_PresetAndFilter_Text", "Projection Section Name", String.class),
    PROJECTION_LABEL_NAME("projectionLabelName_PresetAndFilter_Text", "Projection Label Name", String.class),
    PROJECTION_FIELD_LOCATION("projectionFieldLocation_PresetAndFilter_Text", "Projection Field Name", String.class),
    PROJECTION_FIELD_PROPERTY_NAME("projectionFieldPropertyName_PresetAndFilter_Text", "Projection Field Property Name", String.class),

    //Filter
    FILTER_FIELD_PROPERTY_NAME("filterFieldPropertyName_PresetAndFilter_Text", "Filter Field Property Name", String.class),
    FILTER_FIELD_VALUE("filterFieldValue_PresetAndFilter_Text", "Filter Field Value", String.class),
    FILTER_NAME("filterName_PresetAndFilter_Text", "Filter Name", String.class),
    FILTER_FIELDS("filterFields_PresetAndFilter_DocumentArray", "Filter Fields", Document.class),




    PRESET_NAME("presetName_PresetAndFilter_Text", "Preset Name", String.class),
    PRESET_DESCRIPTION("presetDescription_PresetAndFilter_Text", "Preset Description", String.class),
    PROJECTION_FIELDS("projectionFields_PresetAndFilter_DocumentArray", "Projection Fields", Document.class),
    PROJECTION_FIELD_SORT_ORDER("projectionFieldSortOrder_PresetAndFilter_Int", "Projection Fields Sort Order", Integer.class),


    ;

    private final String property;
    private final String label;
    private final Class<?> dataType;
    private final int minLength;
    private final int maxLength;

    private PresetAndFilterKeysPBinder(String property, String label, Class<?> dataType, int minLength, int maxLength) {
        this.property = property;
        this.label = label;
        this.dataType = dataType;
        this.minLength = minLength;
        this.maxLength = maxLength;
    }

    private PresetAndFilterKeysPBinder(String property, String label, Class<?> dataType) {
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

    // New method to get label by property name
    public static String getLabelByProperty(String propertyName) {
        for (PresetAndFilterKeysPBinder binder : values()) {
            if (binder.property.equals(propertyName)) {
                return binder.label;
            }
        }
        return null;
    }

    // New method to get property name by label
    public static String getPropertyByLabel(String label) {
        for (PresetAndFilterKeysPBinder binder : values()) {
            if (binder.label.equals(label)) {
                return binder.property;
            }
        }
        return null;
    }

    // $FF: synthetic method
    private static KJUSYSCommonKeysPBinder[] $values() {
        return KJUSYSCommonKeysPBinder.class.getEnumConstants();
    }
}