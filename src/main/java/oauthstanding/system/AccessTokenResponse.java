package oauthstanding.system;

import oauthstanding.token.AccessToken;
import oauthstanding.token.RefreshToken;

import java.util.NoSuchElementException;

/**
 * Created by marcin on 13.02.17.
 */
public class AccessTokenResponse extends AbstractOAuthResponse {

    private final AccessToken accessToken;
    private final RefreshToken refreshToken;
    private final String tokenType;

    private AccessTokenResponse(AccessToken accessToken, RefreshToken refreshToken, String tokenType) {
        super();
        this.accessToken = accessToken;
        this.refreshToken = refreshToken;
        this.tokenType = tokenType;
    }

    private AccessTokenResponse(ErrorResponse errorResponse) {
        super(errorResponse);
        accessToken = null;
        refreshToken = null;
        tokenType = null;
    }

    public static AccessTokenResponse newInstance(AccessToken accessToken, RefreshToken refreshToken, String tokenType) {
        return new AccessTokenResponse(accessToken, refreshToken, tokenType);
    }

    public static AccessTokenResponse ofError(ErrorResponse errorResponse) {
        return new AccessTokenResponse(errorResponse);
    }

    public AccessToken getAccessToken() {
        if(accessToken == null)
            throw new NoSuchElementException();
        return accessToken;
    }

    public RefreshToken getRefreshToken() {
        if(refreshToken == null)
            throw new NoSuchElementException();
        return refreshToken;
    }

    public String getTokenType() {
        if(tokenType == null)
            throw new NoSuchElementException();
        return tokenType;
    }

}
