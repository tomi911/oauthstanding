package oauthstanding.context;

/**
 * Created by marcin on 13.02.17.
 */
public interface OAuthContextBuilder {

    OAuthContext newContext(Configuration config);
}
