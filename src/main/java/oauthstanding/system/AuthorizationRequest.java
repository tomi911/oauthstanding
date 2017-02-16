package oauthstanding.system;

import java.util.Map;

/**
 * Created by marcin on 13.02.17.
 */
public class AuthorizationRequest {

    private final ResponseType responseType;
    private final String clientId, redirectUri,
        scope, state;

    private AuthorizationRequest(Builder builder) {
        this.responseType = builder.responseType;
        this.clientId = builder.clientId;
        this.redirectUri = builder.redirectUri;
        this.scope = builder.scope;
        this.state = builder.state;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {

        private ResponseType responseType;
        private String clientId, redirectUri, scope, state;

        public AuthorizationRequest create() {
            return new AuthorizationRequest(this);
        }

        public AuthorizationRequest create(Map<String, String> parameters) {
            responseType = ResponseType.valueOfString(parameters.get("response_type"));
            clientId = parameters.get("client_id");
            redirectUri = parameters.get("redirect_uri");
            scope = parameters.get("scope");
            state = parameters.get("state");
            return new AuthorizationRequest(this);
        }

        public Builder responseType(ResponseType t) {
            this.responseType = t;
            return this;
        }

        public Builder clientId(String s) {
            this.clientId = s;
            return this;
        }
        public Builder redirectUri(String s) {
            this.redirectUri = s;
            return this;
        }
        public Builder scope(String s) {
            this.scope = s;
            return this;
        }
        public Builder state(String s) {
            this.state = s;
            return this;
        }
    }

    public ResponseType getResponseType() {
        return responseType;
    }

    public String getClientId() {
        return clientId;
    }

    public String getRedirectUri() {
        return redirectUri;
    }

    public String getScope() {
        return scope;
    }

    public String getState() {
        return state;
    }
}
