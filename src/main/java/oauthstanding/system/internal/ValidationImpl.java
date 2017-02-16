package oauthstanding.system.internal;

import oauthstanding.system.AccessTokenRequest;
import oauthstanding.system.ErrorType;
import oauthstanding.system.GrantType;
import oauthstanding.system.Validation;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class ValidationImpl implements Validation {

    private boolean valid = true;
    private List<String> invalidFieldsNames = new ArrayList<>();

    @Override
    public boolean validateRequest(AccessTokenRequest request) {

        GrantType grantType = request.getGrantType();
        String clientId = request.getClientId();
        String clientSecret = request.getClientSecret();

        if(grantType == GrantType.UNRECOGNIZED) {
            valid = false;
            invalidFieldsNames.add("grant_type");
        }
        if(StringUtils.isBlank(clientId)) {
            valid = false;
            invalidFieldsNames.add("client_id");
        }
        if(StringUtils.isBlank(clientSecret)) {
            valid = false;
            invalidFieldsNames.add("client_secret");
        }

        return false;
    }

    private boolean validationForCodeGrantType(AccessTokenRequest request) {

        String code = request.getCode();
        String redirectUri = request.getRedirectUri();

        if(StringUtils.isBlank(code)) {
            valid = false;
            invalidFieldsNames.add("code");
        }
        if(StringUtils.isBlank(redirectUri)) {
            valid = false;
            invalidFieldsNames.add("redirect_uri");
        }

        return false;
    }

    private boolean validationForResourceOwnerPasswordCredentialsGrantType(AccessTokenRequest request) {

        String username = request.getUsername();
        String password = request.getPassword();

        if(StringUtils.isBlank(username)) {
            valid = false;
            invalidFieldsNames.add("username");
        }
        if(StringUtils.isBlank(password)) {
            valid = false;
            invalidFieldsNames.add("password");
        }

        return false;
    }
}
