package com.pivotal.brighton.service;

import com.pivotal.brighton.AuthHelper;
import com.pivotal.brighton.controller.LoginController;
import com.pivotal.brighton.dto.LoginResponse;
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
    public void testUserSigningInAgainWithInvalidPassword(){
        loginController.login("foo","bar",httpServletRequest);
        ResponseEntity<LoginResponse> response = loginController.login("foo","baz",httpServletRequest);
        assertEquals("ERROR", response.getBody().getAuthResponse());
        assertNull(response.getBody().getAuthToken());
    }

    @Test
    public void testUserSigningInAgainWithValidPassword(){
        loginController.login("foo","bar",httpServletRequest);
        ResponseEntity<LoginResponse> response = loginController.login("foo","bar",httpServletRequest);
        assertEquals("SUCCESS", response.getBody().getAuthResponse());
        assertNotNull(response.getBody().getAuthToken());
    }

    @Test
    public void testUserSessionAuthenticatedWithValidTokenAfterLogin(){
        ResponseEntity<LoginResponse> response = loginController.login("foo","bar",httpServletRequest);
        String authToken = response.getBody().getAuthToken();
        httpServletRequest.addHeader("authToken",authToken);
        assertTrue(AuthHelper.isAuthenticated(httpServletRequest));
    }

    @Test
    public void testUserSessionAuthenticatedWithEmptyTokenAfterLogin(){
        loginController.login("foo","bar",httpServletRequest);
        assertFalse(AuthHelper.isAuthenticated(httpServletRequest));
        String authToken = "";
        httpServletRequest.addHeader("authToken",authToken);
        assertFalse(AuthHelper.isAuthenticated(httpServletRequest));
    }

    @Test
    public void testUserSessionNotAuthenticatedWithInvalidTokenAfterLogin(){
        ResponseEntity<LoginResponse> response = loginController.login("foo","bar",httpServletRequest);
        String authToken = "345678";
        httpServletRequest.addHeader("authToken",authToken);
        assertFalse(AuthHelper.isAuthenticated(httpServletRequest));
    }

    @Test
    public void testUserSessionNotAuthenticatedWithEmptyTokenBeforeLogin(){
        assertFalse(AuthHelper.isAuthenticated(httpServletRequest));
        String authToken = "";
        httpServletRequest.addHeader("authToken",authToken);
        assertFalse(AuthHelper.isAuthenticated(httpServletRequest));
    }

    @Test
    public void testUserSessionNotAuthenticatedWithInvalidTokenBeforeLogin(){
        String authToken = "345678";
        httpServletRequest.addHeader("authToken",authToken);
        assertFalse(AuthHelper.isAuthenticated(httpServletRequest));
    }

}