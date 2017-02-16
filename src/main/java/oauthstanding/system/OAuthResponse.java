package oauthstanding.system;

import java.util.Optional;
import java.util.function.Consumer;

/**
 * Created by marcin on 13.02.17.
 */
public interface OAuthResponse {

    boolean isValid();
    Optional<ErrorResponse> getErrorResponse();
    void ifInvalid(Consumer<ErrorResponse> errorResponseConsumer);

}
