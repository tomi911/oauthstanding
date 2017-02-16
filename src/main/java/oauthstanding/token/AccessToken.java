package oauthstanding.token;

/**
 * Created by marcin on 13.02.17.
 */
public class AccessToken extends AbstractToken {

    public AccessToken(String value, long expirationTime) {
        super(value, expirationTime);
    }
}
