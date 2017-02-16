package oauthstanding.system;

import java.util.Map;

/**
 * Created by marcin on 13.02.17.
 */
public class AccessTokenRequest {

    private final GrantType grantType;

    private final String clientId, clientSecret, code, redirectUri, username, password, scope;

    private AccessTokenRequest(Builder builder) {
        this.grantType = builder.grantType;
        this.clientId = builder.clientId;
        this.clientSecret = builder.clientSecret;
        this.code = builder.code;
        this.redirectUri = builder.redirectUri;
        this.username = builder.username;
        this.password = builder.password;
        this.scope = builder.scope;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {

        private GrantType grantType;
        private String clientId, clientSecret, code, redirectUri, username, password, scope;

        public AccessTokenRequest create() {
            return new AccessTokenRequest(this);
        }

        public AccessTokenRequest create(Map<String, String> parameters) {
            grantType = GrantType.valueOfString(parameters.get("grant_type"));
            clientId = parameters.get("client_id");
            clientSecret = parameters.get("client_secret");
            code = parameters.get("code");
            redirectUri = parameters.get("redirect_uri");
            username = parameters.get("username");
            password = parameters.get("password");
            scope = parameters.get("scope");
            return new AccessTokenRequest(this);
        }

        public Builder grantType(GrantType t) {
            this.grantType = t;
            return this;
        }
        public Builder clientId(String s) {
            this.clientId = s;
            return this;
        }
        public Builder clientSecret(String s) {
            this.clientSecret = s;
            return this;
        }
        public Builder code(String s) {
            this.code = s;
            return this;
        }
        public Builder redirectUri(String s) {
            this.redirectUri = s;
            return this;
        }
        public Builder username(String s) {
            this.username = s;
            return this;
        }
        public Builder password(String s) {
            this.password = s;
            return this;
        }
        public Builder scope(String s) {
            this.scope = s;
            return this;
        }
    }

    public GrantType getGrantType() {
        return grantType;
    }

    public String getClientId() {
        return clientId;
    }

    public String getClientSecret() {
        return clientSecret;
    }

    public String getCode() {
        return code;
    }

    public String getRedirectUri() {
        return redirectUri;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getScope() {
        return scope;
    }

}
