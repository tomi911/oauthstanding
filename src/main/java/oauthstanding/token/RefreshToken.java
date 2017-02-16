package oauthstanding.token;

/**
 * Created by marcin on 13.02.17.
 */
public class RefreshToken extends AccessToken {
    public RefreshToken(String value, long expirationTime) {
        super(value, expirationTime);
    }
}
