package oauthstanding.system;

import oauthstanding.token.AuthorizationCode;

import java.util.HashMap;
import java.util.List;
import java.util.function.Function;

public class AuthorizationResponse {

    private String state, redirectUri;
    private AuthorizationCode code;

    private AuthorizationResponse(AuthorizationCode code, String state, String redirectUri) {
        this.code = code;
        this.state = state;
        this.redirectUri = redirectUri;
    }

    public static AuthorizationResponse newInstance(AuthorizationCode code, String state, String redirectUri) {
        return new AuthorizationResponse(code, state, redirectUri);
    }

    public String getState() {
        return state;
    }

    public String getRedirectUri() {
        return redirectUri;
    }

    public AuthorizationCode getCode() {
        return code;
    }

    public <R> R map(Function<? super AuthorizationResponse, R> mapper) {
        return mapper.apply(this);
    }
}
