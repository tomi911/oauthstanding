package oauthstanding.endpoint.internal;

import oauthstanding.system.TokenGenerator;
import oauthstanding.adapter.OAuthClientStoreAdapter;
import oauthstanding.credentials.ResourceOwnerCredentials;
import oauthstanding.endpoint.AuthorizationEndpoint;
import oauthstanding.system.*;
import oauthstanding.token.AuthorizationCode;

import java.util.Map;
import java.util.stream.Stream;

/**
 * Created by marcin on 15.02.17.
 */
public class AuthorizationEndpointImpl implements AuthorizationEndpoint {

    private Stream<ResponseType> responseTypes;
    private OAuthClientStoreAdapter clientStore;
    private OAuthErrors errorTypes;
    private TokenGenerator generator;

    private Map<String, AuthorizationRequest> internalCache;

    @Override
    public ClientInfo retrieveClientInformation(AuthorizationRequest request) {

        if(request == null)
            throw new IllegalArgumentException();

        if(invalidResponseType(responseTypes, request)) {

        }

        validateRequest(request);

        String clientId = request.getClientId();
        ClientInfo clientInfo = clientStore.retrieveClientInformations(clientId);
        if(clientInfo == null) {

        }

        String state = request.getClientId();
        internalCache.put(state, request);

        return clientInfo;
    }

    @Override
    public AuthorizationResponse authorize(String state, ResourceOwnerCredentials credentials) {

        boolean agreement = credentials.resourceOwnerAuthorizationDecision();
        if(!agreement) {
            internalCache.remove(state);
        }

        AuthorizationRequest authorizationRequest = internalCache.get(state);
        if(authorizationRequest == null) {

        }

        String redirectUri = authorizationRequest.getRedirectUri();
        AuthorizationCode authorizationCode = generateAuthorizationCode();

        return AuthorizationResponse.newInstance(authorizationCode, state, redirectUri);
    }

    private boolean invalidResponseType(Stream<ResponseType> responseTypes, AuthorizationRequest request) {
        return false;
    }

    private boolean validateRequest(AuthorizationRequest request) {
        return false;
    }

    private AuthorizationCode generateAuthorizationCode() {
        String codeValue = generator.generateAuthorizationCode();
        long expirationTime = 0;
        return new AuthorizationCode(codeValue, expirationTime);
    }



}
