package com.pivotal.brighton.service;

import com.pivotal.brighton.dto.LoginResponse;
import org.junit.Before;
import org.junit.Test;
import org.springframework.mock.web.MockHttpServletRequest;

import static org.junit.Assert.*;

public class LoginServiceTest {
    private LoginService loginService;
    private MockHttpServletRequest httpServletRequest;

    @Before
    public void init(){
        loginService = new LoginService();
        httpServletRequest = new MockHttpServletRequest();
    }

    @Test
    public void testNoSuchUser(){
        LoginResponse response = loginService.login("food","bar",httpServletRequest);
        assertEquals("ERROR", response.getAuthResponse());
        assertNull(response.getAuthToken());
    }

    @Test
    public void testInvalidPassword(){
        LoginResponse response = loginService.login("foo","bark",httpServletRequest);
        assertEquals("ERROR", response.getAuthResponse());
        assertNull(response.getAuthToken());
    }

    @Test
    public void testAuthSuccess(){
        LoginResponse response = loginService.login("foo","bar",httpServletRequest);
        assertEquals("SUCCESS", response.getAuthResponse());
        assertNotNull(response.getAuthToken());
    }

    @Test
    public void testNullCredential(){
        LoginResponse response = loginService.login(null,null,httpServletRequest);
        assertEquals("ERROR", response.getAuthResponse());
        assertNull(response.getAuthToken());
    }

    @Test
    public void testUserSigningInAgainWithInvalidPassword(){
        loginService.login("foo","bar",httpServletRequest);
        LoginResponse response = loginService.login("foo","baz",httpServletRequest);
        assertEquals("ERROR", response.getAuthResponse());
        assertNull(response.getAuthToken());
    }

    @Test
    public void testUserSigningInAgainWithValidPassword(){
        loginService.login("foo","bar",httpServletRequest);
        LoginResponse response = loginService.login("foo","bar",httpServletRequest);
        assertEquals("SUCCESS", response.getAuthResponse());
        assertNotNull(response.getAuthToken());
    }

    @Test
    public void testUserSessionAuthenticatedWithValidTokenAfterLogin(){
        LoginResponse response = loginService.login("foo","bar",httpServletRequest);
        String authToken = response.getAuthToken();
        httpServletRequest.addHeader("authToken",authToken);
        assertTrue(loginService.isAuthenticated(httpServletRequest));
    }

    @Test
    public void testUserSessionAuthenticatedWithEmptyTokenAfterLogin(){
        loginService.login("foo","bar",httpServletRequest);
        assertFalse(loginService.isAuthenticated(httpServletRequest));
        String authToken = "";
        httpServletRequest.addHeader("authToken",authToken);
        assertFalse(loginService.isAuthenticated(httpServletRequest));
    }

    @Test
    public void testUserSessionNotAuthenticatedWithInvalidTokenAfterLogin(){
        loginService.login("foo","bar",httpServletRequest);
        String authToken = "345678";
        httpServletRequest.addHeader("authToken",authToken);
        assertFalse(loginService.isAuthenticated(httpServletRequest));
    }

    @Test
    public void testUserSessionNotAuthenticatedWithEmptyTokenBeforeLogin(){
        assertFalse(loginService.isAuthenticated(httpServletRequest));
        String authToken = "";
        httpServletRequest.addHeader("authToken",authToken);
        assertFalse(loginService.isAuthenticated(httpServletRequest));
    }

    @Test
    public void testUserSessionNotAuthenticatedWithInvalidTokenBeforeLogin(){
        String authToken = "345678";
        httpServletRequest.addHeader("authToken",authToken);
        assertFalse(loginService.isAuthenticated(httpServletRequest));
    }

}