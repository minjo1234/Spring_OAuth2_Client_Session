package com.example.spring_oauth2_client_session.service;

import com.example.spring_oauth2_client_session.entity.UserEntity;
import com.example.spring_oauth2_client_session.repository.UserRepository;
import com.example.spring_oauth2_client_session.response.*;
import com.example.spring_oauth2_client_session.response.oauth2site.FaceBookResponse;
import com.example.spring_oauth2_client_session.response.oauth2site.GithubResponse;
import com.example.spring_oauth2_client_session.response.oauth2site.GoogleResponse;
import com.example.spring_oauth2_client_session.response.oauth2site.NaverResponse;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

@Service
public class CustomOAuth2UserService extends DefaultOAuth2UserService {

    private final UserRepository userRepository;

    public CustomOAuth2UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }
    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {

        OAuth2User oAuth2User = super.loadUser(userRequest);
        System.out.println(oAuth2User.getAttributes());

        String registrationID = userRequest.getClientRegistration().getRegistrationId();
        OAuth2Response oAuth2Response = null;

        if (registrationID.equals("naver")) {
            oAuth2Response = new NaverResponse(oAuth2User.getAttributes());
        } else if (registrationID.equals("google")){
            oAuth2Response = new GoogleResponse(oAuth2User.getAttributes());
        } else if (registrationID.equals("github")){
            oAuth2Response = new GithubResponse(oAuth2User.getAttributes());
            System.out.println(oAuth2Response);
        } else if (registrationID.equals("facebook")){
            System.out.println(oAuth2Response);
            oAuth2Response = new FaceBookResponse(oAuth2User.getAttributes());
        }
        else {
            return null;
        }

        String username = oAuth2Response.getProvider()+" "+oAuth2Response.getProviderId();
        UserEntity exsitData = userRepository.findByUsername(username);
        String role = "ROLE_USER";
        if (exsitData == null){
            UserEntity userEntity = new UserEntity();
            userEntity.setUsername(username);
            userEntity.setEmail(oAuth2Response.getEmail());
            userEntity.setRole("ROLE_USER");

            userRepository.save(userEntity);
        } else {
            exsitData.setEmail(oAuth2Response.getEmail());

            userRepository.save(exsitData);
        }
        return new CustomOAuth2User(oAuth2Response, role);
    }

}