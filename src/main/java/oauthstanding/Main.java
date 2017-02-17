package oauthstanding;

import oauthstanding.context.Configuration;
import oauthstanding.context.OAuthContext;
import oauthstanding.credentials.UsernameAndPassword;
import oauthstanding.endpoint.TokenEndpoint;
import oauthstanding.system.*;
import oauthstanding.token.AccessToken;
import spark.Response;
import spark.Route;

import java.util.Comparator;
import java.util.HashMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by marcin on 13.02.17.
 */
public class Main {

    public static void main(String... args) {

        Configuration config = null;

        OAuthContext oauth = null; //OAuth.newContext(config);

        AccessTokenRequest request1 = AccessTokenRequest.builder()
                .create(new HashMap<>());

        AccessTokenRequest request2 = AccessTokenRequest.builder()
            .grantType(GrantType.RESOURCE_OWNER_PASSWORD_CREDENTIALS)
            .clientId("")
            .clientSecret("")
            .username("")
            .password("")
            .create();


        AccessTokenResponse response1 = oauth.authenticate(request1);
        response1.getAccessToken();
        response1.getRefreshToken();
        response1.getTokenType();
        response1.isValid();

        AuthorizationRequest request3 = AuthorizationRequest.builder()
                .clientId("")
                .redirectUri("")
                .responseType(ResponseType.CODE)
                .scope("")
                .state("")
                .create();

        AuthorizationRequest request4 = AuthorizationRequest.builder()
                .create(new HashMap<>());

        ClientInfo client = oauth.retrieveClientInformation(request4);
        AuthorizationResponse response2 = oauth.authorize("xyz", new UsernameAndPassword("login", "pass", true));
        response2.getCode();
        response2.getRedirectUri();
        response2.getState();

        ResponseVO vo = response2.map(r -> {
            return new ResponseVO();
        });

    }

}
