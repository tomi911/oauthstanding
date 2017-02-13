package oauthstanding.adapter;

import oauthstanding.token.AccessToken;

/**
 * Created by marcin on 13.02.17.
 */
public interface OAuthStoreAdapter {

    void storeAccessToken(AccessToken token);
    AccessToken retrieveAccessToken();
}
