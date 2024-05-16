package com.example.spring_oauth2_client_session.response.oauth2site;

import com.example.spring_oauth2_client_session.response.OAuth2Response;

import java.util.Map;

public class FaceBookResponse implements OAuth2Response {

    private final Map<String, Object> attribute;

    public FaceBookResponse(Map<String, Object> attribute){
        this.attribute = attribute;
    }
    @Override
    public String getProvider() {
        return "facebook";
    }

    @Override
    public String getProviderId() {
        return attribute.get("id").toString();
    }

    @Override
    public String getEmail() {
        return attribute.get("email").toString();
    }

    @Override
    public String getName() {
        return attribute.get("name").toString();
    }
}
