package oauthstanding.system;

import java.util.Optional;

public class InternalResponse {

    private boolean success;
    private ErrorType errorType;

    private final static InternalResponse SUCCESS_RESPONSE = new InternalResponse();

    private InternalResponse() {
        success = true;
        errorType = null;
    }

    private InternalResponse(ErrorType errorType) {
        success = false;
        errorType = errorType;
    }

    public static InternalResponse success() {
        return SUCCESS_RESPONSE;
    }

    public static InternalResponse failure(ErrorType errorType) {
        return new InternalResponse(errorType);
    }

    public boolean isSuccess() {
        return success;
    }

    public Optional<ErrorType> getErrorType() {
        return Optional.ofNullable(errorType);
    }
}
