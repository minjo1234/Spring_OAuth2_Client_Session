package com.example.spring_oauth2_client_session.oauth2;

import ch.qos.logback.core.net.server.Client;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.core.AuthorizationGrantType;
import org.springframework.security.oauth2.core.oidc.IdTokenClaimNames;
import org.springframework.stereotype.Component;

@Component
public class SocialClientRegistration {

    public ClientRegistration naverClientRegistration() {

        return ClientRegistration.withRegistrationId("naver")
                .clientId("FpEs81yrLaMfoElttq2y")
                .clientSecret("2vhZc7Vv57")
                .redirectUri("http://localhost:8080/login/oauth2/code/naver")
                .authorizationGrantType(AuthorizationGrantType.AUTHORIZATION_CODE)
                .scope("name", "email")
                .authorizationUri("https://nid.naver.com/oauth2.0/authorize")
                .tokenUri("https://nid.naver.com/oauth2.0/token")
                .userInfoUri("https://openapi.naver.com/v1/nid/me")
                .userNameAttributeName("response")
                .build();
    }

    public ClientRegistration googleClientRegistration() {

        return ClientRegistration.withRegistrationId("google")
                .clientId("858835447109-0842ugb17km53lhi18utng5oar8b86rs.apps.googleusercontent.com")
                .clientSecret("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")
                .redirectUri("http://localhost:8080/login/oauth2/code/google")
                .authorizationGrantType(AuthorizationGrantType.AUTHORIZATION_CODE)
                .scope("profile", "email")
                .authorizationUri("https://accounts.google.com/o/oauth2/v2/auth")
                .tokenUri("https://www.googleapis.com/oauth2/v4/token")
                .jwkSetUri("https://www.googlea][" +
                        "pis.com/oauth2/v3/certs")
                .issuerUri("https://accounts.google.com")
                .userInfoUri("https://www.googleapis.com/oauth2/v3/userinfo")
                .userNameAttributeName(IdTokenClaimNames.SUB)
                .build();
    }
    public ClientRegistration githubClientRegistration() {

        return ClientRegistration.withRegistrationId("github")
                .clientId("Ov23liTvpcPvgZl0DYNo")
                .clientSecret("2e59dd82334d6871e7bee03254712e9588e408a4")
                .redirectUri("http://localhost:8080/login/oauth2/code/github")
                .authorizationGrantType(AuthorizationGrantType.AUTHORIZATION_CODE)
                .scope("name", "email")
//                .authorizationUri("https://nid.naver.com/oauth2.0/authorize")
//                .tokenUri("https://nid.naver.com/oauth2.0/token")
//                .userInfoUri("https://openapi.naver.com/v1/nid/me")
                .userNameAttributeName("response")
                .build();
    }
    public ClientRegistration facebookClientRegistration() {

        return ClientRegistration.withRegistrationId("facebook")
                .clientId("799792711787725")
                .clientSecret("e17b2a0c9855779c7a44db1064b6452e")
                .redirectUri("http://localhost:8080/login/oauth2/code/facebook")
                .authorizationGrantType(AuthorizationGrantType.AUTHORIZATION_CODE)
                .scope("public_profile" , "email")
//                .authorizationUri("https://nid.naver.com/oauth2.0/authorize")
//                .tokenUri("https://nid.naver.com/oauth2.0/token")
//                .userInfoUri("https://openapi.naver.com/v1/nid/me")
                .userNameAttributeName("response")
                .build();
    }
}