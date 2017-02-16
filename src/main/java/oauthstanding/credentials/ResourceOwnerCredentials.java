package oauthstanding.credentials;

/**
 * Created by marcin on 14.02.17.
 */
public interface ResourceOwnerCredentials<T> {

    T getCredentials();
    boolean resourceOwnerAuthorizationDecision();
}
