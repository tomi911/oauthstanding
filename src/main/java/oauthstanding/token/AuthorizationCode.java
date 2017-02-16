package oauthstanding.token;

/**
 * Created by marcin on 13.02.17.
 */
public class AuthorizationCode extends AbstractToken {

    public AuthorizationCode(String value, long expirationTime) {
        super(value, expirationTime);
    }
}
