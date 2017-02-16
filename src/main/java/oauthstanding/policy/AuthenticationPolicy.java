package oauthstanding.policy;

import oauthstanding.system.GrantType;

import java.util.stream.Stream;

/**
 * Created by marcin on 14.02.17.
 */
public interface AuthenticationPolicy {

    long accessTokenDuration();
    long refreshTokenDuration();
    Stream<GrantType> grantTypes();
}
