package oauthstanding.adapter;

/**
 * Created by marcin on 15.02.17.
 */
public interface Generator {

    String generateAccessTokenValue();
    String generateRefreshTokenValue();
    String generateAuthorizationCode();
}
