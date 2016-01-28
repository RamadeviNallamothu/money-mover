package com.pivotal.brighton.service;

import com.pivotal.brighton.AuthHelper;
import com.pivotal.brighton.controller.LoginController;
import com.pivotal.brighton.dto.LoginResponse;
import org.apache.http.auth.AUTH;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;

import static org.junit.Assert.*;

public class LoginServiceTest {
    private LoginController loginController;
    private MockHttpServletRequest httpServletRequest;

    @Before
    public void init(){
        loginController = new LoginController();
        httpServletRequest = new MockHttpServletRequest();
        httpServletRequest.getSession().setAttribute("money-mover.user.authToken","12345789101");
    }

    @Test
    public void testNoSuchUser(){
        ResponseEntity<LoginResponse> response = loginController.login("food","bar",httpServletRequest);
        assertEquals("ERROR", response.getBody().getAuthResponse());
        assertNull(response.getBody().getAuthToken());
    }

    @Test
    public void testInvalidPassword(){
        ResponseEntity<LoginResponse> response = loginController.login("foo","bark",httpServletRequest);
        assertEquals("ERROR", response.getBody().getAuthResponse());
        assertNull(response.getBody().getAuthToken());
    }

    @Test
    public void testAuthSuccess(){
        ResponseEntity<LoginResponse> response = loginController.login("foo","bar",httpServletRequest);
        assertEquals("SUCCESS", response.getBody().getAuthResponse());
        assertNotNull(response.getBody().getAuthToken());
    }

    @Test
    public void testNullCredential(){
        ResponseEntity<LoginResponse> response = loginController.login(null,null,httpServletRequest);
        assertEquals("ERROR", response.getBody().getAuthResponse());
        assertNull(response.getBody().getAuthToken());
    }

    @Test
    public void alreadySignedInUserInvalidPassword(){
        loginController.login("foo","bar",httpServletRequest);
        ResponseEntity<LoginResponse> response = loginController.login("foo","baz",httpServletRequest);
        assertEquals("ERROR", response.getBody().getAuthResponse());
        assertNull(response.getBody().getAuthToken());
    }

    @Test
    public void alreadySignedInUserValidPassword(){
        loginController.login("foo","bar",httpServletRequest);
        ResponseEntity<LoginResponse> response = loginController.login("foo","bar",httpServletRequest);
        assertEquals("SUCCESS", response.getBody().getAuthResponse());
        assertNotNull(response.getBody().getAuthToken());
    }

    @Test
    public void testAuthentication(){
        httpServletRequest.addHeader("auth_token","12345789101");
        assertTrue(AuthHelper.isAuthenticated(httpServletRequest));
    }

}