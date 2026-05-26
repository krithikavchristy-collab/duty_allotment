package in.edu.kristujayanti.propertyBinder.academics;

import in.edu.kristujayanti.propertyBinder.KJUSYSPropertyBinder;
import org.bson.types.ObjectId;

public enum BloomsLevelKeysPBInder implements KJUSYSPropertyBinder {

    BLOOMS_LEVEL_OID("bloomsLevelOid_BloomsLevel_ObjectId","Blooms Level OID", ObjectId.class),
    BLOOMS_LEVEL_CODE("bloomsLevelCode_BloomsLevel_Text","Blooms Level Code", String.class),
    BLOOMS_LEVEL_NAME("bloomsLevelName_BloomsLevel_Text","Blooms Level Name", String.class),

    BLOOMS_LEVEL_DESCRIPTION("bloomsLevelDescription_BloomsLevel_Text","Blooms Level Description",String.class),
    BLOOMS_LEVEL_UNIQUE_NUMBER("bloomsLevelUniqueNumber_BloomsLevel_Int","Blooms Level Unique Number",Integer.class),

   // BLOOMS_LEVEL_DESCRIPTION("bloomsLevelDescription_BloomsLevel_Text","Blooms Level Description",String.class),



    ;


    private final String property;
    private final String label;
    private final Class<?> dataType;
    private final int minLength;
    private final int maxLength;

    private BloomsLevelKeysPBInder(String property, String label, Class<?> dataType, int minLength, int maxLength) {
        this.property = property;
        this.label = label;
        this.dataType = dataType;
        this.minLength = minLength;
        this.maxLength = maxLength;
    }

    private BloomsLevelKeysPBInder(String property, String label, Class<?> dataType) {
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
    private static BloomsLevelKeysPBInder[] $values() {
        return BloomsLevelKeysPBInder.class.getEnumConstants();
    }
}
