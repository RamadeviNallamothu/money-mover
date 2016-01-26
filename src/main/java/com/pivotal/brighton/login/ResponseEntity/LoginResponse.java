package com.pivotal.brighton.login.ResponseEntity;

import org.springframework.stereotype.Component;

public class LoginResponse {
    private String authResponse;

    public String getAuthResponse() {
        return authResponse;
    }
    public void setAuthResponse(String authResponse){
        this.authResponse = authResponse;
    }
}
