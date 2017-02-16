package oauthstanding.endpoint;

import oauthstanding.system.AccessTokenRequest;
import oauthstanding.system.AccessTokenResponse;

/**
 * Created by marcin on 13.02.17.
 */
public interface TokenEndpoint {

    AccessTokenResponse authenticate(AccessTokenRequest request);
}
