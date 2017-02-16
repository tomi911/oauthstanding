package oauthstanding.adapter;

import oauthstanding.token.AccessToken;
import oauthstanding.token.RefreshToken;

/**
 * Created by marcin on 14.02.17.
 */
public interface OAuthTokenStoreAdapter {

    void storeAccessToken(AccessToken token);
    AccessToken retrieveAccessToken(String value);

    void storeRefreshToken(RefreshToken token);
    RefreshToken retrieveRefreshToken(String value);
}
