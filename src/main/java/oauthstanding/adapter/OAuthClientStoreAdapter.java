package oauthstanding.adapter;

import oauthstanding.credentials.ClientCredentials;
import oauthstanding.system.ClientInfo;

/**
 * Created by marcin on 14.02.17.
 */
public interface OAuthClientStoreAdapter {

    ClientCredentials retrieveClientCredentials(String clientId, String clientSecret);
    ClientInfo retrieveClientInformations(String clientId);
}
