package in.edu.kristujayanti.collectionNames;

public enum GymCNBinder implements  KJUSYSCNBinder {

    GYM_SERVICES_COLLECTION("gym_services"),
    GYM_ADDONS_COLLECTION("gym_addons"),
    GYM_ATTENDANCE_COLLECTION("gym_attendance"),
    GYM_USERS_COLLECTION("gym_users"),
    GYM_ORDER_DETAILS_COLLECTION("gym_order_details"),
    GYM_PAYMENT_DETAILS("gym_payment_details")

    ;




    private final String collectionName;

    private GymCNBinder(String collectionName) {
        this.collectionName = collectionName;
    }

    public String getCollectionName() {
        return this.collectionName;
    }

    // $FF: synthetic method
    private static GymCNBinder[] $values() {
        return GymCNBinder.class.getEnumConstants();
    }


}