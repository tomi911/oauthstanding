package oauthstanding.system;

import java.util.List;
import java.util.Optional;

public interface OAuthRequest {

    boolean isValid();
    Optional<List<ErrorCause>> getErrors();
}
