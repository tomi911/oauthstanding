package oauthstanding.system;

/**
 * Created by marcin on 13.02.17.
 */
public enum GrantType {

    UNRECOGNIZED,
    AUTHORIZATION_CODE,
    IMPLICIT,
    RESOURCE_OWNER_PASSWORD_CREDENTIALS,
    CLIENT_CREDENTIALS;

    public static GrantType valueOfString(String s) {
        return null;
    }
}
