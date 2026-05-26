package in.edu.kristujayanti.propertyBinder.InventoryManagement;

import in.edu.kristujayanti.propertyBinder.KJUSYSPropertyBinder;
import org.bson.Document;

public enum InventoryManagementKeysPBinder implements KJUSYSPropertyBinder {

    USER_FIRST_NAME("userFirstName_InventoryManagement_Text", "User Name", String.class),
    USER_NAME("userName_InventoryManagement_Document", "Name", Document.class),
    USER_LAST_NAME("userLastName_InventoryManagement_Text", "User Name", String.class),
    USER_PHONE("userPhone_InventoryManagement_Text", "User Name", String.class),
    USER_EMAIL("userEmail_InventoryManagement_Text", "User Email", String.class),

    PRODUCT_SKU("productSku_InventoryManagement_Text", "Product SKU", String.class),
    PRODUCT_NAME("productName_InventoryManagement_Text", "Name", String.class),
    PRODUCT_DESCRIPTION("productDescription_InventoryManagement_Text", "Product Description", String.class),
    PRODUCT_PRICE("productPrice_InventoryManagement_Double", "Product Price", Double.class),
    PRODUCT_STOCK("productStock_InventoryManagement_Int", "Product Stock", Integer.class),
    PRODUCT_IS_ACTIVE("productIsActive_InventoryManagement_Bool", "Product Active", Boolean.class),
    PRODUCT_CATEGORY("productCategory_InventoryManagement_Text", "Product Category", String.class),

    ;
    private final String property;
    private final String label;
    private final Class<?> dataType;
    private final int minLength;
    private final int maxLength;

    private InventoryManagementKeysPBinder(String property, String label, Class<?> dataType) {
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
}
