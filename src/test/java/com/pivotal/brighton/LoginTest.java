package com.pivotal.brighton;

import com.pivotal.brighton.login.LoginController;
import com.pivotal.brighton.login.ResponseEntity.LoginResponse;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.http.client.MockClientHttpRequest;
import org.springframework.mock.web.MockHttpServletRequest;

import javax.servlet.http.HttpServletRequest;

import static org.junit.Assert.assertEquals;

public class LoginTest {
    private LoginController loginController;
    private MockHttpServletRequest httpServletRequest;
    @Before
    public void init(){
        loginController = new LoginController();
        httpServletRequest = new MockHttpServletRequest();
    }

    @Test
    public void testNoSuchUser(){
        ResponseEntity<LoginResponse> response = loginController.login("food","bar",httpServletRequest);
        assertEquals("ERROR", response.getBody().getAuthResponse());
    }

    @Test
    public void testInvalidPassword(){
        ResponseEntity<LoginResponse> response = loginController.login("foo","bark",httpServletRequest);
        assertEquals("ERROR", response.getBody().getAuthResponse());
    }

    @Test
    public void testAuthSuccess(){
        ResponseEntity<LoginResponse> response = loginController.login("foo","bar",httpServletRequest);
        assertEquals("SUCCESS", response.getBody().getAuthResponse());
    }

    @Test
    public void testNullCredential(){
        ResponseEntity<LoginResponse> response = loginController.login(null,null,httpServletRequest);
        assertEquals("ERROR", response.getBody().getAuthResponse());
    }
}