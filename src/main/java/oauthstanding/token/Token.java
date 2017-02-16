package oauthstanding.token;

/**
 * Created by marcin on 13.02.17.
 */
public interface Token {

    String getValue();
    boolean isExpired();
    long getExpirationTime();
    long getTimeToExpire();

    static long getTime() {
        return System.currentTimeMillis();
    }
}
