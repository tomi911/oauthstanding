package oauthstanding.system;

/**
 * Created by marcin on 15.02.17.
 */
public class OAuthErrors {

    private ErrorResponse unsupportedGrantType;

    public ErrorResponse unsupportedGrantType() {
        return unsupportedGrantType;
    }

    public ErrorResponse errorResponseFromType(ErrorType errorType) {
        return null;
    }

}
