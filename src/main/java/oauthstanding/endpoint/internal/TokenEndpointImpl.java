package oauthstanding.endpoint.internal;

import oauthstanding.system.TokenGenerator;
import oauthstanding.adapter.OAuthClientStoreAdapter;
import oauthstanding.credentials.ClientCredentials;
import oauthstanding.endpoint.TokenEndpoint;
import oauthstanding.policy.AuthenticationPolicy;
import oauthstanding.system.*;
import oauthstanding.token.AccessToken;
import oauthstanding.token.RefreshToken;

import java.util.Collections;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TokenEndpointImpl implements TokenEndpoint {

    private Stream<GrantType> grantTypes;
    private OAuthClientStoreAdapter clientStore;
    private OAuthErrors oAuthErrors;
    private AuthenticationPolicy policy;
    private TokenGenerator generator;
    private Authentication authentication;

    @Override
    public AccessTokenResponse authenticate(AccessTokenRequest request) {

        if(request == null)
            throw new IllegalArgumentException();

        if(invalidGrantType(grantTypes, request)) {
            ErrorResponse error = oAuthErrors.unsupportedGrantType();
            return AccessTokenResponse.ofError(error);
        }

        if(notValid(request)) {
            request.getErrors()
                    .orElse(Collections.emptyList())
                    .stream()
                    .map(e -> {
                        return e;
                    })
                    .collect(Collectors.toList());
        }

        String clientId = request.getClientId();
        String clientSecret = request.getClientSecret();
        GrantType grantType = request.getGrantType();
        String scope = request.getScope();
        ClientCredentials credentials = new SimpleClientCredentials(clientId, clientSecret, grantType, scope);

        InternalResponse response = authentication.authenticateClient(credentials);
        if(notSuccessful(response)) {

        }

        if(isAuthorizationCodeGrant(request))
            response = authorizationCodeGrantType(request);
        else if(isResourceOwnerPasswordCredentialsGrant(request))
            response = resourceOwnerPasswordCredentialsGrantType(request);

        if(notSuccessful(response)) {
            ErrorResponse errorResponse =
                    oAuthErrors.errorResponseFromType(
                    response.getErrorType()
                            .get()
            );
            return AccessTokenResponse.ofError(errorResponse);
        }

        AccessToken accessToken = generator.generateAccessToken();
        RefreshToken refreshToken = generator.generateRefreshToken();

        return AccessTokenResponse.newInstance(accessToken, refreshToken, "Bearer");
    }

    private static class SimpleClientCredentials implements ClientCredentials {

        private final String clientId;
        private final String clientSecret;
        private final GrantType grantType;
        private final String scope;

        public SimpleClientCredentials(String clientId, String clientSecret, GrantType grantType, String scope) {
            this.clientId = clientId;
            this.clientSecret = clientSecret;
            this.grantType = grantType;
            this.scope = scope;
        }

        @Override
        public String getClientId() {
            return clientId;
        }

        @Override
        public String getClientSecret() {
            return clientSecret;
        }

        @Override
        public Stream<String> getScopes() {
            return Stream.of(scope);
        }

        @Override
        public Stream<GrantType> getGrantTypes() {
            return Stream.of(grantType);
        }
    }

    private static boolean notSuccessful(InternalResponse response) {
        if(response == null)
            return true;
        return ! response.isSuccess();
    }

    private static boolean notValid(OAuthRequest request) {
        return ! request.isValid();
    }

    private InternalResponse authorizationCodeGrantType(AccessTokenRequest request) {
        String code = request.getCode();
        InternalResponse response = authentication.validateAuthorizationCode(code);
        if(notSuccessful(response))
            return response;

        String redirectUri = request.getRedirectUri();
        return authentication.validateRedirectUri(code, redirectUri);
    }

    private InternalResponse resourceOwnerPasswordCredentialsGrantType(AccessTokenRequest request) {
        return authentication.authenticateResourceOwner(null);
    }

    private static boolean invalidGrantType(Stream<GrantType> grants, AccessTokenRequest request) {
        return grants.noneMatch( g -> g.equals(request.getGrantType()));
    }

    private static boolean isAuthorizationCodeGrant(AccessTokenRequest request) {
        return request.getGrantType().equals(GrantType.AUTHORIZATION_CODE);
    }

    private static boolean isResourceOwnerPasswordCredentialsGrant(AccessTokenRequest request) {
        return request.getGrantType().equals(GrantType.RESOURCE_OWNER_PASSWORD_CREDENTIALS);
    }

}
