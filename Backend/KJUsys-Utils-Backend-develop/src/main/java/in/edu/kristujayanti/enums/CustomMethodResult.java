package in.edu.kristujayanti.enums;

public final class CustomMethodResult {

    public static final CustomMethodResult SUCCESS =
            new CustomMethodResult("SUCCESS", 0, "Operation successful", null, null, null);
    public static final CustomMethodResult FAILURE =
            new CustomMethodResult("FAILURE", 1, "Operation failed", null, null, null);

    private static final CustomMethodResult[] $VALUES = new CustomMethodResult[]{SUCCESS, FAILURE};

    private final String name;
    private final int ordinal;

    private final String defaultMessage;
    private final Object defaultData;

    // Immutable per-usage overrides
    private final String customMessage;
    private final Object customData;

    private CustomMethodResult(
            String name,
            int ordinal,
            String defaultMessage,
            Object defaultData,
            String customMessage,
            Object customData
    ) {
        this.name = name;
        this.ordinal = ordinal;
        this.defaultMessage = defaultMessage;
        this.defaultData = defaultData;
        this.customMessage = customMessage;
        this.customData = customData;
    }

    public String getMessage() {
        return customMessage != null ? customMessage : defaultMessage;
    }

    public Object getData() {
        return customData != null ? customData : defaultData;
    }

    // Return NEW immutable instances (no mutation of shared constants)
    public CustomMethodResult withMessage(String customMessage) {
        return new CustomMethodResult(this.name, this.ordinal, this.defaultMessage, this.defaultData, customMessage, null);
    }

    public CustomMethodResult withData(Object customData) {
        return new CustomMethodResult(this.name, this.ordinal, this.defaultMessage, this.defaultData, null, customData);
    }

    public CustomMethodResult withFields(String customMessage, Object customData) {
        return new CustomMethodResult(this.name, this.ordinal, this.defaultMessage, this.defaultData, customMessage, customData);
    }

    // Enum-like helpers
    public static CustomMethodResult[] values() {
        return $VALUES.clone();
    }

    public static CustomMethodResult valueOf(String name) {
        for (CustomMethodResult v : $VALUES) {
            if (v.name.equals(name)) {
                return v;
            }
        }
        throw new IllegalArgumentException("No constant CustomMethodResult." + name);
    }

    public String name() {
        return name;
    }

    public int ordinal() {
        return ordinal;
    }

    // Equality based on base constant identity so comparisons like result.equals(SUCCESS) work.
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        // Equal to the shared constant of the same name/ordinal
        if (obj == SUCCESS || obj == FAILURE) {
            return this.name.equals(((CustomMethodResult) obj).name) && this.ordinal == ((CustomMethodResult) obj).ordinal;
        }
        if (obj instanceof CustomMethodResult) {
            CustomMethodResult other = (CustomMethodResult) obj;
            return this.name.equals(other.name) && this.ordinal == other.ordinal;
        }
        return false;
    }

    @Override
    public int hashCode() {
        // Hash only on base identity to be consistent with equals
        int result = name.hashCode();
        result = 31 * result + ordinal;
        return result;
    }

    @Override
    public String toString() {
        return name;
    }
}