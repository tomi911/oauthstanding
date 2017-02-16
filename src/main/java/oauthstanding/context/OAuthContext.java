package oauthstanding.context;

import oauthstanding.endpoint.AuthorizationEndpoint;
import oauthstanding.endpoint.TokenEndpoint;
import oauthstanding.system.AccessTokenRequest;
import oauthstanding.system.AuthorizationRequest;
import oauthstanding.system.OAuthResponse;
import oauthstanding.token.AccessToken;
import oauthstanding.token.RefreshToken;

/**
 * Created by marcin on 13.02.17.
 */
public interface OAuthContext extends TokenEndpoint, AuthorizationEndpoint {




}
