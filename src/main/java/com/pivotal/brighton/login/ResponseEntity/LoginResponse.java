package com.pivotal.brighton.login.ResponseEntity;

import org.springframework.stereotype.Component;

public class LoginResponse {
    private String authResponse;
    private String authToken;

    public String getAuthResponse() {
        return authResponse;
    }
    public void setAuthResponse(String authResponse){
        this.authResponse = authResponse;
    }

    public String getAuthToken() {
        return authToken;
    }
    public void setAuthToken(String authToken) {
        this.authToken = authToken;
    }
}
