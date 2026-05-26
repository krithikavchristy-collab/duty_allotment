package in.edu.kristujayanti.propertyBinder.KJAnnexe;

import in.edu.kristujayanti.propertyBinder.KJUSYSPropertyBinder;
import java.util.List;
import org.bson.Document;
import org.bson.types.ObjectId;

public enum AnnexeRoomKeysPBinder implements KJUSYSPropertyBinder {

    ROOM_ID("roomId_KJAnnexeRoom_ObjectId","Room ID", ObjectId.class),
    ROOM_NUMBER("roomNumber_KJAnnexeRoom_Text", "Room Number", String.class),
    COST_PER_BED("costPerBed_KJAnnexeRoom_Double", "Cost Per Bed", Double.class),
    COST_PER_ROOM("costPerRoom_KJAnnexeRoom_Double", "Cost Per Room", Double.class),
    ROOM_TYPE("roomType_KJAnnexeRoom_Text", "Room Type", String.class),
    MAX_PEOPLE("maxPeople_KJAnnexeRoom_Int", "Max People", Integer.class),
    PHOTO_URL("photoUrl_KJAnnexeRoom_Text", "Photo URL", String.class),
    ROOMS_LIST("roomsList_KJAnnexeRoom_DocumentArray","List of rooms", Document.class),
    ROOMS_PAY_LIST("roomsPayList_KJAnnexeRoom_TextArray","list of to be payed Rooms",String.class),
    ROOM_NAMES_LIST("roomNamesList_KJAnnexeRoom_Text","Name list of selected rooms", String.class),
    BED_INFO("bedInfo_KJAnnexeRoom_DocumentArray","Bed Information", Document.class),
    BED_ID("bedId_KJAnnexeRoom_ObjectId","Bed ID", ObjectId.class),
    BED_NO("bedNo_KJAnnexeRoom_Int","Bed No.",Integer.class),
    ACTIVE_BED_STATUS("activeBedStatus_KJAnnexeRoom_Bool", "Active Bed Status", Boolean.class),
    ROOM_AVAILABILITY_STATUS("roomAvailabilityStatus_KJAnnexeRoom_Bool","Active Room Status",Boolean.class),
    AIR_CONDITIONING("airConditioning_KJAnnexeRoom_Bool", "Air Conditioning", Boolean.class),
    NUMBER_OF_BEDS("numberOfBeds_KJAnnexeRoom_Int", "Number of Beds", Integer.class),
    AMENITIES_INFO("amenitiesInfo_KJAnnexeRoom_DocumentArray", "Amenities Information", List.class),
    AMENITIES_LIST("amenitiesList_KJAnnexeRoom_TextArray", "List of Amenities", String.class), // Changed to String.class with _TextArray
    AMENITY_NAME("amenityName_KJAnnexeRoom_Text", "Amenity Name", String.class),
    AMENITY_STATUS("amenityStatus_KJAnnexeRoom_Bool", "Amenity Status", Boolean.class),

    COLLEGE_PROPERTY("collegeProperty_KJAnnexeRoom_Text","CollegeProperty",String.class);


    private final String property;
    private final String label;
    private final Class<?> dataType;
    private final int minLength;
    private final int maxLength;

    private AnnexeRoomKeysPBinder(String property, String label, Class<?> dataType, int minLength, int maxLength) {
        this.property = property;
        this.label = label;
        this.dataType = dataType;
        this.minLength = minLength;
        this.maxLength = maxLength;
    }

    private AnnexeRoomKeysPBinder(String property, String label, Class<?> dataType) {
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

    private static AnnexeRoomKeysPBinder[] $values() {
        return AnnexeRoomKeysPBinder.class.getEnumConstants();
    }
}

