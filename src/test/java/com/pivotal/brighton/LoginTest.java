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
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

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

}