package in.edu.kristujayanti.enums;

import java.util.Arrays;

public enum ContentType {

    CSV("csv", "text/csv"),
    TXT("txt", "text/plain"),
    JSON("json", "application/json"),
    PDF("pdf", "application/pdf"),
    PNG("png", "image/png"),
    JPG("jpg", "image/jpeg"),
    JPEG("jpeg", "image/jpeg"),
    GIF("gif", "image/gif"),
    SVG("svg", "image/svg+xml"),
    XLSX("xlsx", "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"),
    XLS("xls", "application/vnd.ms-excel"),

    /**
     * Fallback MIME type for unknown extensions
     */
    DEFAULT("*", "application/octet-stream");

    private final String extension;
    private final String mimeType;

    ContentType(String extension, String mimeType) {
        this.extension = extension;
        this.mimeType = mimeType;
    }

    public String getExtension() {
        return extension;
    }

    public String getMimeType() {
        return mimeType;
    }

    /**
     * Resolve a MIME type from a file extension.
     *
     * @param extension File extension (case-insensitive, without dot)
     * @return The matching ContentType enum if known, otherwise DEFAULT
     */
    public static ContentType fromExtension(String extension) {
        if (extension == null || extension.isBlank()) {
            return DEFAULT;
        }

        String ext = extension.toLowerCase();

        return Arrays.stream(values())
                .filter(type -> type.extension.equals(ext))
                .findFirst()
                .orElse(DEFAULT);
    }
}
