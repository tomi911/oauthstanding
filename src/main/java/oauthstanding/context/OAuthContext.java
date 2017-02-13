package oauthstanding.context;

import oauthstanding.http.AccessTokenRequest;
import oauthstanding.http.AuthorizationRequest;
import oauthstanding.http.OAuthResponse;

/**
 * Created by marcin on 13.02.17.
 */
public interface OAuthContext {

    OAuthResponse authenticate(AccessTokenRequest request);
    OAuthResponse authorize(AuthorizationRequest request);
    
}
