package in.edu.kristujayanti.propertyBinder.arena;

import in.edu.kristujayanti.propertyBinder.KJUSYSPropertyBinder;
import in.edu.kristujayanti.propertyBinder.Library.LibraryCommonKeysPBinder;
import org.bson.types.ObjectId;

import java.util.List;

public enum UserBookingKeysPBInder implements KJUSYSPropertyBinder {
    ARENA_EVENT_NAME("arenaEventName_UserBooking_Text", "Arena Event Name", String.class),
    ARENA_RESOURCE_PERSON("arenaResourcePerson_UserBooking_Text", "Arena Resource Person", String.class),
    ARENA_DEPARTMENT_NAME("arenaDepartmentName_UserBooking_Text", "Arena Department Name", String.class),
    ARENA_EVENT_TYPE("arenaEventType_UserBooking_Text", "Arena Event Type", String.class),
    ARENA_ADDITIONAL_REQUIREMENTS("arenaAdditionalRequirements_UserBooking_TextArray", "Arena Additional Requirements", String.class),
    ARENA_EXTRA_REQUIREMENTS("arenaExtraRequirements_UserBooking_Text", "Arena Extra Requirements", String.class),
    ARENA_IS_SCHEDULED_AS_PER_ACADEMIC_CALENDAR("arenaIsScheduledAsPerAcademicCalendar_UserBooking_Bool", "Arena Is Scheduled As Per Academic Calendar", Boolean.class),
    ARENA_MODE_OF_EVENT("arenaModeOfEvent_UserBooking_Text", "Arena Mode Of Event", String.class),
    ARENA_EVENT_DATE("arenaEventDate_UserBooking_Date", "Arena Event Date", Long.class),
    ARENA_MEMENTO_QUANTITY("arenaMementoQuantity_UserBooking_Int", "Arena Memento Quantity", Integer.class),
    ARENA_LAPTOP_QUANTITY("arenaLaptopQuantity_UserBooking_Int", "Arena Laptop Quantity", Integer.class),
    ARENA_SAPLINGS_QUANTITY("arenaSaplingsQuantity_UserBooking_Int", "Arena Saplings Quantity", Integer.class),
    ARENA_BOOKED_SLOTS("arenaBookedSlots_UserBooking_TextArray", "Arena Booked Slots", String.class),
    ARENA_BOOKING_ID("arenaBookingId_UserBooking_Text", "Arena Booking Id", String.class),
    ARENA_STATUS("arenaStatus_UserBooking_Text", "Arena Status", String.class),
    ARENA_BOOKING_DATE_AND_TIME("arenaBookingDateAndTime_UserBooking_DateTime", "Arena Booking Date And Time", Long.class),


    ARENA_BOOKED_BY_USER_NAME("arenaBookedByUserName_UserBooking_Text", "Arena Booked By User Name", String.class),
    ARENA_BOOKED_BY_USER_ID("arenaBookedByUserId_UserBooking_ObjectId", "Arena Booked By User Id", ObjectId.class),
    ARENA_BOOKED_TO_USER_NAME("arenaBookedToUserName_UserBooking_Text", "Arena Booked To User Name", String.class),
    ARENA_BOOKED_TO_USER_ID("arenaBookedToUserId_UserBooking_ObjectId", "Arena Booked To User Id", ObjectId.class),



    ARENA_BOOKING_COUNTER_VARIABLE("arenaBookingCounterVariable_UserBooking_Int", "Arena Booking Counter Variable", Integer.class),
    ARENA_BOOKING_COUNTER_VARIABLE_CONSTANT("arenaBookingCounterVariableConstant_UserBooking_Int", "Arena Booking Counter Variable Constant", Integer.class),
    ARENA_SPOT_NAME("arenaSpotName_UserBooking_Text", "Arena Spot Name", String.class),
    ARENA_VENUE_SPOT("arenaVenueSpot_UserBooking_Text", "Arena Venue Spot", String.class),
    ARENA_VENUE_ID_COUNTER("arenaVenueIdCounter_UserBooking_Text", "Arena Venue Id Counter", String.class),
    ARENA_VENUE_TYPE("arenaVenueType_UserBooking_Text", "Arena Venue Type", String.class),
    ARENA_OBJECT_ID("arenaObjectId_UserBooking_ObjectId", "Arena Object Id", ObjectId.class),


    ARENA_CANCELLED_BY("arenaCancelledBy_UserBooking_Text", "Arena Cancelled By", String.class),
    ARENA_CANCELLED_BY_ID("arenaCancelledById_UserBooking_ObjectId", "Arena Cancelled By Id", ObjectId.class),
    ARENA_CANCELLED_BOOKING_REASON("arenaCancelledBookingReason_UserBooking_Text", "Arena Cancelled Booking Reason", String.class),
    ARENA_CANCELLED_BOOKING_TIMESTAMP("arenaCancelledBookingTimestamp_UserBooking_DateTime", "Arena Cancelled Booking Timestamp", Long.class),
    ARENA_CANCELLED_SLOTS("arenaCancelledSlots_UserBooking_TextArray", "Arena Cancelled Slots", String.class),
    ARENA_BOOKING_ID_FOR_CANCELLATION("arenaBookingIdForCancellation_UserBooking_Text", "Arena Booking Id For Cancellation", String.class),
    ARENA_USER_EMAIL("arenaUserEmail_UserBooking_Text", "Arena User Email", String.class),
    ARENA_USER_PHONE_NUMBER("arenaUserPhoneNumber_UserBooking_Long", "Arena User Phone Number", Long.class);






    private final String property;
    private final String label;
    private final Class<?> dataType;
    private final int minLength;
    private final int maxLength;

    private UserBookingKeysPBInder(String property, String label, Class<?> dataType, int minLength, int maxLength) {
        this.property = property;
        this.label = label;
        this.dataType = dataType;
        this.minLength = minLength;
        this.maxLength = maxLength;
    }

    private UserBookingKeysPBInder(String property, String label, Class<?> dataType) {
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

