package com.example.spring_oauth2_client_session.oauth2;

import org.springframework.context.annotation.Configuration;

@Configuration
public class CustomClientRegistrationRepo {
    private final SocialClientRegistration socialClientRegistration;

    public CustomClientRegistrationRepo(SocialClientRegistration socialClientRegistration){
        this.socialClientRegistration = socialClientRegistration;
    }
}
