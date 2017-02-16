package oauthstanding.adapter;

import oauthstanding.credentials.ResourceOwnerCredentials;

/**
 * Created by marcin on 14.02.17.
 */
public interface OAuthResourceOwnerStoreAdapter {

    ResourceOwnerCredentials retrieveResourceOwnerCredentials(String username, String password);
}
