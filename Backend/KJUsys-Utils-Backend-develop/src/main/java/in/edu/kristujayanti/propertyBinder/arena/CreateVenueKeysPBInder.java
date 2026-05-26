package in.edu.kristujayanti.propertyBinder.arena;

import in.edu.kristujayanti.propertyBinder.KJUSYSPropertyBinder;
import in.edu.kristujayanti.propertyBinder.Library.LibraryCommonKeysPBinder;
import java.util.List;
import org.bson.types.ObjectId;

public enum CreateVenueKeysPBInder implements KJUSYSPropertyBinder {
    ARENA_VENUE_ID("arenaVenueId_VenueCreation_Text", "Arena Venue Id", String.class),
    ARENA_VENUE_NAME("arenaVenueName_VenueCreation_Text", "Arena Venue Name", String.class),
    ARENA_BLOCK_NAME("arenaBlockName_VenueCreation_Text", "Arena Block Name", String.class),
    ARENA_SEATING_CAPACITY_OF_VENUE("arenaSeatingCapacityOfVenue_VenueCreation_Int", "Arena Seating Capacity Of Venue", Integer.class),
    ARENA_IS_VENUE_AIR_CONDITIONED_OR_NOT("arenaIsVenueAirConditionedOrNot_VenueCreation_Text", "Arena Is Venue Air Conditioned Or Not", String.class),
    ARENA_IS_PERMISSION_REQUIRED_FOR_AUDITORIUM("arenaIsPermissionRequiredForAuditorium_VenueCreation_Text", "Arena Is Permission Required For Auditorium", String.class),
    ARENA_VENUE_LOCATION("arenaVenueLocation_VenueCreation_Text", "Arena Venue Location", String.class),
    ARENA_TYPE_OF_VENUE("arenaTypeOfVenue_VenueCreation_Text", "Arena Type Of Venue", String.class),
    ARENA_INTERVAL_TIMING("arenaIntervalTiming_VenueCreation_Bool", "Arena Interval Timing", Boolean.class),
    ARENA_TIMESLOTS("arenaTimeslots_VenueCreation_Array", "Arena Timeslots", List.class),
    ARENA_VENUE_CREATION_TIME_STAMP("arenaVenueCreationTimeStamp_VenueCreation_DateTime", "Arena Venue Creation Time Stamp", Long.class),
    ARENA_VENUE_IMAGE("arenaVenueImage_VenueCreation_Image", "Arena Venue Image", String.class),
    ARENA_VENUE_STATUS("arenaVenueStatus_VenueCreation_Bool", "Arena Venue Status", String.class),
    ARENA_VENUE_OBJECT_ID("arenaVenueObjectId_VenueCreation_ObjectId", "Arena Venue Object Id", ObjectId.class);

    private final String property;
    private final String label;
    private final Class<?> dataType;
    private final int minLength;
    private final int maxLength;

    private CreateVenueKeysPBInder(String property, String label, Class<?> dataType, int minLength, int maxLength) {
        this.property = property;
        this.label = label;
        this.dataType = dataType;
        this.minLength = minLength;
        this.maxLength = maxLength;
    }

    private CreateVenueKeysPBInder(String property, String label, Class<?> dataType) {
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

    private static LibraryCommonKeysPBinder[] $values() {
        return (LibraryCommonKeysPBinder[])LibraryCommonKeysPBinder.class.getEnumConstants();
    }
}






