package in.edu.kristujayanti.collectionNames;

public enum PurchaseOrderCNBinder
{
  VENDOR_DETAILS_COLLECTION("vendorDetails"),
    QUOTATION_DETAILS_COLLECTION("quotationDetails"),
    TERMS_AND_CONDITIONS_COLLECTION("termsAndConditionsDetails"),
    DEPARTMENT_DETAILS_COLLECTION("departmentCollection"),
    PURCHASE_ORDER_COLLECTION("purchaseOrderCollection")
;



    private final String collectionName;

    private PurchaseOrderCNBinder(String collectionName) {
        this.collectionName = collectionName;
    }

    public String getCollectionName() {
        return this.collectionName;
    }

    // $FF: synthetic method
    private static PurchaseOrderCNBinder[] $values() {
        return PurchaseOrderCNBinder.class.getEnumConstants();
    }

}
