package oauthstanding.system;

import oauthstanding.credentials.ClientCredentials;
import oauthstanding.credentials.ResourceOwnerCredentials;

public interface Authentication {

    InternalResponse authenticateClient(ClientCredentials credentials);
    InternalResponse authenticateResourceOwner(ResourceOwnerCredentials credentials);
    InternalResponse validateAuthorizationCode(String code);
    InternalResponse validateRedirectUri(String code, String redirectUri);
    InternalResponse validateScope(String scope, String clientId);

}
