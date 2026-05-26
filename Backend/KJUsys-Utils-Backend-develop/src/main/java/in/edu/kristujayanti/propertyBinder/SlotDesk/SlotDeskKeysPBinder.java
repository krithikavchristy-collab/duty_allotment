package in.edu.kristujayanti.propertyBinder.SlotDesk;

import in.edu.kristujayanti.propertyBinder.KJUSYSPropertyBinder;
import org.bson.Document;
import org.bson.types.ObjectId;


public enum SlotDeskKeysPBinder implements KJUSYSPropertyBinder {

    EVENT_TITLE("eventTitle_SlotDesk_Text", "Event Title", String.class),
    EVENT_DESCRIPTION("eventDescription_SlotDesk_Text", "Event Description", String.class),
    EVENT_DETAILS_DOCUMENT_ARRAY("eventDetailsDocumentArray_SlotDesk_DocumentArray", "Event Details Document Array", Document.class),
    EVENT_DATE("eventDate_SlotDesk__StartDate", "Event Date", Long.class),
    IS_EVENT_MAPPED_TO_MODULE("isEventMappedToModule_SlotDesk_Bool", "Is Event Mapped To Module", Boolean.class),
    EVENT_MAPPED_MODULE_NAME("eventMappedModuleName_SlotDesk_Text", "Event Mapped Module Name", String.class),
    EVENT_ATTENDED("eventAttended_SlotDesk_Bool", "Event Attended", Boolean.class),
    EVENT_ATTENDED_COUNT("eventAttendedCount_SlotDesk_Number", "Event Attended Count", Integer.class),


    SLOT_DETAILS_DOCUMENT_ARRAY("slotDetailsDocumentArray_SlotDesk_DocumentArray", "Slot Details Document Array", Document.class),
    SLOT_TITLE("slotTitle_SlotDesk_Text","Slot Title",String.class),
    SLOT_START_TIME("slotStartTime_SlotDesk_Text", "Slot Start Time", String.class),
    SLOT_END_TIME("slotEndTime_SlotDesk_Text", "Slot End Time", String.class),
    SLOT_CAPACITY("slotCapacity_SlotDesk_Int", "Slot Capacity", Integer.class),
    ELIGIBLE_CANDIDATES_OR_USERS_LIST("eligibleCandidatesOrUsersList_SlotDesk_TextArray", "Eligible Candidates or Users List", String.class),
    CAN_SLOT_RESCHEDULE("canSlotReschedule_SlotDesk_Bool", "Can Slot Reschedule", Boolean.class),
    EVENT_OID("eventOid_SlotDesk_ObjectId", "Event OID", ObjectId.class),
    SLOT_OID("slotOid_SlotDesk_ObjectId", "Slot OID", ObjectId.class),



    EVENT_STATUS("eventStatus_SlotDesk_Text", "Event Status", String.class),
    EVENT_TOTAL_CAPACITY("eventTotalCapacity_SlotDesk_Number", "Event Total Capacity", Integer.class),
    EVENT_TOTAL_SLOTS("eventTotalSlots_SlotDesk_Number", "Event Total Slots", Integer.class),
    EVENT_CONFIRMED_COUNT("eventConfirmedCount_SlotDesk_Number", "Event Confirmed Count", Integer.class),
    EVENT_REMAINING_COUNT("eventRemainingCount_SlotDesk_Number", "Event Remaining Count", Integer.class),
    EVENT_FILL_RATE("eventFillRate_SlotDesk_Number", "Event Fill Rate", Double.class),

    // ===== Slot / Date-Time Slot =====
    SLOT_DATE("slotDate_SlotDesk_Date", "Slot Date", java.util.Date.class),
    SLOT_DAY_NAME("slotDayName_SlotDesk_Text", "Slot Day Name", String.class),

    SLOT_BOOKED_COUNT("slotBookedCount_SlotDesk_Number", "Slot Booked Count", Integer.class),
    SLOT_REMAINING_COUNT("slotRemainingCount_SlotDesk_Number", "Slot Remaining Count", Integer.class),
    SLOT_STATUS("slotStatus_SlotDesk_Text", "Slot Status", String.class),
    SLOT_INTAKE_CLOSED("slotIntakeClosed_SlotDesk_Boolean", "Slot Intake Closed", Boolean.class),

    // ===== Booking / Reservation =====
    BOOKING_STATUS("bookingStatus_SlotDesk_Text", "Booking Status", String.class),
    BOOKING_DATE("bookingDate_SlotDesk_Date", "Booking Date", java.util.Date.class),
    BOOKING_TIME("bookingTime_SlotDesk_Text", "Booking Time", String.class),
    BOOKING_CREATED_AT("bookingCreatedAt_SlotDesk_DateTime", "Booking Created At", java.util.Date.class),
    BOOKING_CANCELLED_AT("bookingCancelledAt_SlotDesk_DateTime", "Booking Cancelled At", java.util.Date.class),
    BOOKING_RESCHEDULED_AT("bookingRescheduledAt_SlotDesk_DateTime", "Booking Rescheduled At", java.util.Date.class),

    // ===== Student / User =====
    STUDENT_NAME("studentName_SlotDesk_Text", "Student Name", String.class),
    STUDENT_EMAIL("studentEmail_SlotDesk_Text", "Student Email", String.class),
    STUDENT_CONTACT("studentContact_SlotDesk_Text", "Student Contact", String.class),
    STUDENT_APPLICATION_NO("studentApplicationNo_SlotDesk_Text", "Student Application No", String.class),
    STUDENT_ROLE("studentRole_SlotDesk_Text", "Student Role", String.class),
    STUDENT_STATUS("studentStatus_SlotDesk_Text", "Student Status", String.class),

    // ===== Programme =====
    PROGRAMME_CODE("programmeCode_SlotDesk_Text", "Programme Code", String.class),
    PROGRAMME_TITLE("programmeTitle_SlotDesk_Text", "Programme Title", String.class),
    PROGRAMME_BATCH("programmeBatch_SlotDesk_Text", "Programme Batch", String.class),
    PROGRAMME_STATUS("programmeStatus_SlotDesk_Text", "Programme Status", String.class),

    // ===== Common / UI Labels =====
    CREATE_NEW_EVENT_TITLE("createNewEventTitle_SlotDesk_Text", "Create New Event Title", String.class),
    MY_BOOKINGS_TITLE("myBookingsTitle_SlotDesk_Text", "My Bookings Title", String.class),
    ALL_EVENTS_TITLE("allEventsTitle_SlotDesk_Text", "All Events Title", String.class),
    CONFIRM_BOOKING_TITLE("confirmBookingTitle_SlotDesk_Text", "Confirm Booking Title", String.class),
    RESCHEDULE_TITLE("rescheduleTitle_SlotDesk_Text", "Reschedule Title", String.class),
    BOOK_SLOT_TITLE("bookSlotTitle_SlotDesk_Text", "Book Slot Title", String.class),
    CURRENT_BOOKING_DETAILS_TITLE("currentBookingDetailsTitle_SlotDesk_Text", "Current Booking Details Title", String.class),

    // ===== Dashboard / Stats =====
    TOTAL_EVENTS_COUNT("totalEventsCount_SlotDesk_Number", "Total Events Count", Integer.class),
    ACTIVE_EVENTS_COUNT("activeEventsCount_SlotDesk_Number", "Active Events Count", Integer.class),
    DISABLED_EVENTS_COUNT("disabledEventsCount_SlotDesk_Number", "Disabled Events Count", Integer.class),
    TOTAL_SLOTS_COUNT("totalSlotsCount_SlotDesk_Number", "Total Slots Count", Integer.class),
    CONFIRMED_STUDENTS_COUNT("confirmedStudentsCount_SlotDesk_Number", "Confirmed Students Count", Integer.class),
    SEARCH_QUERY("searchQuery_SlotDesk_Text", "Search Query", String.class),
    FILTER_VALUE("filterValue_SlotDesk_Text", "Filter Value", String.class),
    EVENT_ACTIVE_SLOTS_COUNT("eventActiveSlotsCount_SlotDesk_Number", "Event Active Slots Count", Integer.class),
    EVENT_TOTAL_SLOTS_COUNT("eventTotalSlotsCount_SlotDesk_Number", "Event Total Slots Count", Integer.class),
    USER_ID("userId_SlotDesk_ObjectId", "User ID", ObjectId.class),
    BOOKED_AT("bookedAt_SlotDesk_DateTime", "Booked At", Long.class),
    CANCELLED_AT("cancelledAt_SlotDesk_DateTime", "Cancelled At", Long.class),
    RESCHEDULED_FROM_SLOT_OID("rescheduledFromSlotOid_SlotDesk_ObjectId", "Rescheduled From Slot ID", ObjectId.class),
    SLOT_BOOKING_LOG("slotBookingLog_SlotDesk_DocumentArray", "Slot Booking Log", Document.class),


    ;

    private final String property;
    private final String label;
    private final Class<?> dataType;
    private final int minLength;
    private final int maxLength;

    private SlotDeskKeysPBinder(String property, String label, Class<?> dataType, int minLength, int maxLength) {
        this.property = property;
        this.label = label;
        this.dataType = dataType;
        this.minLength = minLength;
        this.maxLength = maxLength;
    }

    private SlotDeskKeysPBinder(String property, String label, Class<?> dataType) {
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

    // New method to get label by property name
    public static String getLabelByProperty(String propertyName) {
        for (SlotDeskKeysPBinder binder : values()) {
            if (binder.property.equals(propertyName)) {
                return binder.label;
            }
        }
        return null;
    }

    // New method to get property name by label
    public static String getPropertyByLabel(String label) {
        for (SlotDeskKeysPBinder binder : values()) {
            if (binder.label.equals(label)) {
                return binder.property;
            }
        }
        return null;
    }

    // $FF: synthetic method
    private static SlotDeskKeysPBinder[] $values() {
        return SlotDeskKeysPBinder.class.getEnumConstants();
    }
}




