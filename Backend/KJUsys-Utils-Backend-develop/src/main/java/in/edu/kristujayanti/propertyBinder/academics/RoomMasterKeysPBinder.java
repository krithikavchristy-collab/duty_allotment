package in.edu.kristujayanti.propertyBinder.academics;

import in.edu.kristujayanti.propertyBinder.KJUSYSPropertyBinder;

public enum RoomMasterKeysPBinder implements KJUSYSPropertyBinder {


    ROOM_ID("roomId_RoomMaster_Text", "Room Id", String.class),
    ROOM_NAME("roomName_RoomMaster_Text", "Room Name", String.class),
    ROOM_CAMPUS("roomCampus_RoomMaster_Text", "Campus", String.class),
    ROOM_BLOCK("roomBlock_RoomMaster_Text", "Block", String.class),
    ROOM_FLOOR("roomFloor_RoomMaster_Int", "Floor", Integer.class),
    SEATING_CAPACITY("seatingCapacity_RoomMaster_Int", "Seating Capacity", Integer.class),
    IS_FOR_EXAM("isForExam_RoomMaster_Bool", "Is For Exam", Boolean.class),
    ;


    private final String property;
    private final String label;
    private final Class<?> dataType;
    private final int minLength;
    private final int maxLength;

    private RoomMasterKeysPBinder(String property, String label, Class<?> dataType, int minLength, int maxLength) {
        this.property = property;
        this.label = label;
        this.dataType = dataType;
        this.minLength = minLength;
        this.maxLength = maxLength;
    }

    private RoomMasterKeysPBinder(String property, String label, Class<?> dataType) {
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
    private static RoomMasterKeysPBinder[] $values() {
        return RoomMasterKeysPBinder.class.getEnumConstants();
    }
}
