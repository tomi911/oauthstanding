package oauthstanding.endpoint;

import oauthstanding.credentials.ResourceOwnerCredentials;
import oauthstanding.system.AuthorizationRequest;
import oauthstanding.system.AuthorizationResponse;
import oauthstanding.system.ClientInfo;

import javax.annotation.Resource;

/**
 * Created by marcin on 13.02.17.
 */
public interface AuthorizationEndpoint {

    ClientInfo retrieveClientInformation(AuthorizationRequest request);
    AuthorizationResponse authorize(String state, ResourceOwnerCredentials credentials);
}
