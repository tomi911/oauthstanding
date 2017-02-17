package oauthstanding.system;

import oauthstanding.token.AccessToken;
import oauthstanding.token.AuthorizationCode;
import oauthstanding.token.RefreshToken;

/**
 * Created by marcin on 15.02.17.
 */
public interface TokenGenerator {

    AccessToken generateAccessToken();
    RefreshToken generateRefreshToken();
    AuthorizationCode generateAuthorizationCode();
}
