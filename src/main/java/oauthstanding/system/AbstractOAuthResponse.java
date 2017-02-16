package oauthstanding.system;

import java.util.Optional;
import java.util.function.Consumer;

/**
 * Created by marcin on 14.02.17.
 */
public abstract class AbstractOAuthResponse implements OAuthResponse {

    private final ErrorResponse errorResponse;

    public AbstractOAuthResponse() {
        this.errorResponse = null;
    }

    public AbstractOAuthResponse(ErrorResponse errorResponse) {
        this.errorResponse = errorResponse;
    }

    @Override
    public boolean isValid() {
        return errorResponse == null;
    }

    @Override
    public Optional<ErrorResponse> getErrorResponse() {
        return Optional.ofNullable(errorResponse);
    }

    @Override
    public void ifInvalid(Consumer<ErrorResponse> errorResponseConsumer) {
        Optional
                .ofNullable(errorResponse)
                .ifPresent(errorResponseConsumer);
    }
}
