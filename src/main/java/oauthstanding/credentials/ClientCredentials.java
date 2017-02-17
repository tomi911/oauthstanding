package oauthstanding.credentials;

import oauthstanding.system.GrantType;

import java.util.stream.Stream;

/**
 * Created by marcin on 14.02.17.
 */
public interface ClientCredentials {

    String getClientId();
    String getClientSecret();
    Stream<String> getScopes();
    Stream<GrantType> getGrantTypes();

}
