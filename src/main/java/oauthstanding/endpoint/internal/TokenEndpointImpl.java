package oauthstanding.endpoint.internal;

import oauthstanding.adapter.Generator;
import oauthstanding.adapter.OAuthClientStoreAdapter;
import oauthstanding.endpoint.TokenEndpoint;
import oauthstanding.policy.AuthenticationPolicy;
import oauthstanding.system.*;
import oauthstanding.token.AccessToken;
import oauthstanding.token.AuthorizationCode;
import oauthstanding.token.RefreshToken;

import java.util.stream.Stream;

public class TokenEndpointImpl implements TokenEndpoint {

    private Stream<GrantType> grantTypes;
    private OAuthClientStoreAdapter clientStore;
    private OAuthErrors errorTypes;
    private AuthenticationPolicy policy;
    private Generator generator;

    @Override
    public AccessTokenResponse authenticate(AccessTokenRequest request) {

        if(request == null)
            throw new IllegalArgumentException();

        if(invalidGrantType(grantTypes, request)) {
            ErrorResponse error = errorTypes.unsupportedGrantType();
            return AccessTokenResponse.ofError(error);
        }

        validateRequest(request);
        authenticateClient(request);

        if(isAuthorizationCodeGrant(request)) {
            validateAuthorizationCode();
            validateRedirectUri();
        }
        else if(isResourceOwnerPasswordCredentialsGrant(request)) {
            authenticateResourceOwner();
        }

        AccessToken accessToken = generateAccessToken();
        RefreshToken refreshToken = generateRefreshToken();

        return AccessTokenResponse.newInstance(accessToken, refreshToken, "Bearer");
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

    private boolean validateRequest(AccessTokenRequest request) {
        return false;
    }

    private boolean authenticateClient(AccessTokenRequest request) {
        return false;
    }

    private AccessToken generateAccessToken() {
        String tokenValue = generator.generateAccessTokenValue();
        long expirationTime = 0;
        return new AccessToken(tokenValue, expirationTime);
    }

    private RefreshToken generateRefreshToken() {
        String tokenValue = generator.generateRefreshTokenValue();
        long expirationTime = 0;
        return new RefreshToken(tokenValue, expirationTime);
    }


}
