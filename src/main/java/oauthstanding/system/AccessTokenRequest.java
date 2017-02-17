package oauthstanding.system;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * Created by marcin on 13.02.17.
 */
public class AccessTokenRequest implements OAuthRequest {

    private final GrantType grantType;

    private final String clientId, clientSecret, code, redirectUri, username, password, scope;

    private boolean valid = true;
    private List<ErrorCause> errors = new ArrayList<>();

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

    @Override
    public boolean isValid() {

        if(grantType == GrantType.UNRECOGNIZED) {
            valid = false;
        }
        if(StringUtils.isBlank(clientId)) {
            valid = false;
        }
        if(StringUtils.isBlank(clientSecret)) {
            valid = false;
        }

        return valid;
    }

    @Override
    public Optional<List<ErrorCause>> getErrors() {
        return Optional.ofNullable(errors);
    }

    private boolean validationForCodeGrantType(AccessTokenRequest request) {

        String code = request.getCode();
        String redirectUri = request.getRedirectUri();

        if(StringUtils.isBlank(code)) {
            valid = false;
        }
        if(StringUtils.isBlank(redirectUri)) {
            valid = false;
        }

        return false;
    }

    private boolean validationForResourceOwnerPasswordCredentialsGrantType(AccessTokenRequest request) {

        String username = request.getUsername();
        String password = request.getPassword();

        if(StringUtils.isBlank(username)) {
            valid = false;
        }
        if(StringUtils.isBlank(password)) {
            valid = false;
        }

        return false;
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
