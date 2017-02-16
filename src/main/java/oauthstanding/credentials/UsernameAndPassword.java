package oauthstanding.credentials;

/**
 * Created by marcin on 16.02.17.
 */
public class UsernameAndPassword implements ResourceOwnerCredentials {

    private final String username;
    private final String password;
    private final boolean authorizationDecision;

    public UsernameAndPassword(String username, String password, boolean authorizationDecision) {
        this.username = username;
        this.password = password;
        this.authorizationDecision = authorizationDecision;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public boolean resourceOwnerAuthorizationDecision() {
        return authorizationDecision;
    }
}
