package oauthstanding.token;

abstract class AbstractToken implements Token {

    private final String value;
    private final long creationTime;
    private final long expirationTime;

    public AbstractToken(String value, long expirationTime) {
        this.value = value;
        this.creationTime = Token.getTime();
        this.expirationTime = expirationTime;
    }

    @Override
    public String getValue() {
        return value;
    }

    @Override
    public boolean isExpired() {
        return Token.getTime() > expirationTime;
    }

    @Override
    public long getExpirationTime() {
        return expirationTime;
    }

    @Override
    public long getTimeToExpire() {
        return expirationTime - Token.getTime();
    }
}
