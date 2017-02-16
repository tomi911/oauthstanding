package oauthstanding.system;

public interface Validation {
    boolean validateRequest(AccessTokenRequest request);
}
