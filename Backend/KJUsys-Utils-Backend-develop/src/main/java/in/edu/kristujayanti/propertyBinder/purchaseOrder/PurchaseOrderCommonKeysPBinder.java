package in.edu.kristujayanti.propertyBinder.purchaseOrder;

import in.edu.kristujayanti.propertyBinder.KJUSYSPropertyBinder;
import org.bson.types.ObjectId;

import javax.swing.text.Document;


public enum PurchaseOrderCommonKeysPBinder implements KJUSYSPropertyBinder {

    // define the academic property binders

    //quotation
    QUOTATION_OID("quotationOid_PurchaseOrder_ObjectId","Quotation Oid", ObjectId.class),
    QUOTATION_DATE("quotationDate_PurchaseOrder_Date","Quotation Name",Long.class),
    QUOTATION_REFERENCE_NUMBER("quotationReferenceNumber_PurchaseOrder_Text","Quotation Reference Number",String.class),
    QUOTATION_TAG_ASSET_DEPARTMENT("quotationTagAssetDepartment_PurchaseOrder_Text","Quotation Tag Asset Department",String.class),
    QUOTATION_ITEMS("quotationItems_PurchaseOrder_DocumentArray","Quotation Items", Document.class),
    QUOTATION_ITEM_DESCRIPTION("quotationItemDescription_PurchaseOrder_Text","Quotation Item Description",String.class),
    QUOTATION_ITEM_QUANTITY("quotationItemQuantity_PurchaseOrder_Double","Quotation Item Quantity",Double.class),
    QUOTATION_UNIT_PRICE("quotationUnitPrice_PurchaseOrder_Double","Quotation Unit Price",Double.class),
    QUOTATION_TAX("quotationTax_PurchaseOrder_Double","Quotation Tax",Double.class),
    QUOTATION_AMOUNT("quotationAmount_PurchaseOrder_Double","Quotation Amount",Double.class),
    QUOTATION_STATUS("quotationStatus_PurchaseOrder_Bool","Quotation Status", Boolean.class),


    //terms and conditions
    TERMS_AND_CONDITIONS_OID("termsAndConditionsOid_PurchaseOrder_ObjectId","Terms And Conditions Oid", ObjectId.class),
    TERMS_AND_CONDITIONS("termsAndConditions_PurchaseOrder_TextArray","Terms And Conditions",String.class),
    TERMS_AND_CONDITIONS_TITLE("termsAndConditionsTitle_PurchaseOrder_Text","Terms And Conditions Title", String.class),
    TERMS_AND_CONDITIONS_DETAILS("termsAndConditionsDetails_PurchaseOrder_Text","Terms And Conditions Details",String.class),
    TERMS_AND_CONDITIONS_STATUS("termsAndConditionsStatus_PurchaseOrder_Bool","Terms And Conditions Status", Boolean.class),





    //vendor
    VENDOR_OID("vendorOid_PurchaseOrder_ObjectId","Vendor Oid", ObjectId.class),
    VENDOR_NAME("vendorName_PurchaseOrder_Text","Vendor Name",String.class),
    VENDOR_ADDRESS("vendorAddress_PurchaseOrder_Text","Vendor Address",String.class),
    VENDOR_CONTACT("vendorContact_PurchaseOrder_Long","Vendor Contact",Long.class),
    VENDOR_EMAIL("vendorEmail_PurchaseOrder_Text","Vendor Email",String.class),
    VENDOR_PAN("vendorPan_PurchaseOrder_Text","Vendor Pan No",String.class),
    VENDOR_GST("vendorGst_PurchaseOrder_Text","Vendor Gst No",String.class),
    VENDOR_TAN("vendorTan_PurchaseOrder_Text","Vendor Tan No",String.class),
    VENDOR_TIN("vendorTin_PurchaseOrder_Text","Vendor Tin No",String.class),
    VENDOR_STATUS("vendorStatus_PurchaseOrder_Bool","Vendor Status", Boolean.class),

    //purchase order
    PURCHASE_ORDER_OID(" purchaseOrderOid_PurchaseOrder_ObjectId","Purchase Order Oid", ObjectId.class),
    PURCHASE_ORDER_QUOTATION_ID("purchaseOrderQuotationId_PurchaseOrder_ObjectIdArray","Purchase Order Quotation Id", ObjectId.class),
    PURCHASE_ORDER_SELECTED_ITEMS("purchaseOrderSelectedItems_PurchaseOrder_DocumentArray","Purchase Order Selected Items",Document.class),
    PURCHASE_ORDER_TERMS_AND_CONDITIONS_ID("purchaseOrderTermsAndConditionsId_PurchaseOrder_ObjectIdArray","Purchase Order Terms And Conditions Id",ObjectId.class),
    PURCHASE_ORDER_TERMS_AND_CONDITIONS("purchaseOrderTermsAndConditions_PurchaseOrder_TextArray","Purchase Order Terms And Conditions",String.class),
    PURCHASE_ORDER_TEMPLATE_NAME("purchaseOrderTemplateName_PurchaseOrder_Text","Purchase Order Template Name",String.class),
    PURCHASE_ORDER_DEPARTMENT_NAME("purchaseOrderDepartmentName_PurchaseOrder_Text","Purchase Order Department Name",String.class),
    PURCHASE_ORDER_SELECT_VENDORS("purchaseOrderSelectVendors_PurchaseOrder_Document","Purchase Order Select Vendors",Document.class),
    PURCHASE_ORDER_TOTAL_AMOUNT("purchaseOrderTotalAmount_PurchaseOrder_Double","Purchase Order Total Amount",Double.class),
    PURCHASE_ORDER_STATUS("purchaseOrderStatus_PurchaseOrder_Bool","Purchase Order Status", Boolean.class),
    PURCHASE_ORDER_REFERENCE("purchaseOrderReference_PurchaseOrder_Text","Purchase Order Reference",String.class),
    PURCHASE_ORDER_SUB_TOTAL("purchaseOrderSubTotal_PurchaseOrder_Double","Purchase Order Sub Total",Double.class),
    PURCHASE_ORDER_GST("purchaseOrderGst_PurchaseOrder_Double","Purchase Order Gst",Double.class ),
    PURCHASE_ORDER_QUOTATION_REFERENCE("purchaseOrderQuotationReference_PurchaseOrder_TextArray","Purchase Order Quotation Reference",String.class),
    PURCHASE_ORDER_CREATED_AT("purchaseOrderCreatedAt_DateTime","Purchase order creation time and date",Long.class),
    PURCHASE_ORDER_CREATED_USER("purchaseOrderUserCreatedUser_PurchaseOrder_Text","Purchase order Creating User ",String.class),
    PURCHASE_ORDER_REFERRED_QUOTATIONS("purchaseOrderReferredQuotations_PurchaseOrder_ObjectIdArray","Purchase order referred quotation ids ",ObjectId.class),
    PURCHASE_ORDER_REFERRED_QUOTATIONS_REFERENCE("purchaseOrderReferenceQuotationsReference_PurchaseOrder_TextArray","Purchase Order referred quotations reference",String.class),
    PURCHASE_ORDER_GST_PERCENTAGE("purchaseOrderGstPercentage_PurchaseOrder_Double","Purchase Order Gst Percentage",Double.class ),
    PURCHASE_ORDER_SUBJECT("PurchaseOrderSubject_PurchaseOrder_Text","Purchase Order Subject",String.class),
    PURCHASE_ORDER_DESCRIPTION("PurchaseOrderDescription_PurchaseOrder_Text","Purchase Order Description",String.class),
    PURCHASE_ORDER_DRAFT("PurchaseOrderDraft_PurchaseOrder_Bool","Purchase Order Draft PurchaseOrder Bool",Boolean.class),
    //Department
    DEPARTMENT_OID("departmentOid_PurchaseOrder_ObjectId","Department Oid",ObjectId.class),
    DEPARTMENT_NAME("departmentName_PurchaseOrder_Text","Department Name",String.class),

    SUB_DEPARTMENTS("subDepartments_PurchaseOrder_TextArray","Sub Departments",String.class),
    SUB_DEPARTMENT_NAME("subDepartmentName_PurchaseOrder_Text","Sub Department Name",String.class),
    QUOTATION_FILEUPLOAD("quotationFileupload_PurchaseOrder_File","Quotation Fileupload", String.class),
    PURCHASE_ORDER_FILEUPLOAD("purchaseOrderFileupload_PurchaseOrder_File","Purchase Order Fileupload", String.class),

    // trust
    PURCHASE_ORDER_TRUST_NAME("purchaseOrderTrustName_PurchaseOrder_Text","Purchase Order Trust Name",String.class)




            ;





    private final String property;
    private final String label;
    private final Class<?> dataType;
    private final int minLength;
    private final int maxLength;

    private PurchaseOrderCommonKeysPBinder(String property, String label, Class<?> dataType, int minLength, int maxLength) {
        this.property = property;
        this.label = label;
        this.dataType = dataType;
        this.minLength = minLength;
        this.maxLength = maxLength;
    }

    private PurchaseOrderCommonKeysPBinder(String property, String label, Class<?> dataType) {
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
    private static in.edu.kristujayanti.propertyBinder.purchaseOrder.PurchaseOrderCommonKeysPBinder[] $values() {
        return in.edu.kristujayanti.propertyBinder.purchaseOrder.PurchaseOrderCommonKeysPBinder.class.getEnumConstants();
    }
}