package oauthstanding.utils;

import oauthstanding.system.AccessTokenResponse;

import java.util.function.Function;

@FunctionalInterface
public interface Formatter<Input, Output> {
    Output format(Input o);
}
