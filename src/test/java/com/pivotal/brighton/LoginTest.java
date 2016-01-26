package com.pivotal.brighton;

import com.pivotal.brighton.login.LoginController;
import com.pivotal.brighton.login.ResponseEntity.LoginResponse;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.ResponseEntity;

import static org.junit.Assert.assertEquals;

public class LoginTest {

    private LoginController loginController;

    @Before
    public void init(){
        loginController = new LoginController();
    }

    @Test
    public void testNoSuchUser(){
        ResponseEntity<LoginResponse> response = loginController.login("food","bar");
        assertEquals("ERROR", response.getBody().getAuthResponse());
    }

    @Test
    public void testInvalidPassword(){
        ResponseEntity<LoginResponse> response = loginController.login("foo","bark");
        assertEquals("ERROR", response.getBody().getAuthResponse());
    }

    @Test
    public void testAuthSuccess(){
        ResponseEntity<LoginResponse> response = loginController.login("foo","bar");
        assertEquals("SUCCESS", response.getBody().getAuthResponse());
    }

    @Test
    public void testNullCredential(){
        ResponseEntity<LoginResponse> response = loginController.login(null,null);
        assertEquals("ERROR", response.getBody().getAuthResponse());
    }

}