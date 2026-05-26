package in.edu.kristujayanti.enums;

public enum ResponseType {
    SUCCESS,
    VALIDATION,
    WARNING,
    INVALID_TOKEN,
    BAD_REQUEST,
    ERROR;

    private ResponseType() {
    }
}