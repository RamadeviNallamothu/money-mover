package com.pivotal.brighton;

import com.pivotal.brighton.login.Login;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class LoginTest extends TestCase{

    private Login loginSvc;

    @Before
    public void init(){
        loginSvc = new Login();
    }

    @Test
    public void testDefaultResponse(){
        String response = loginSvc.login("food","bar");
        assertEquals("ERROR", response);
    }


    @Test
    public void testAuthSuccess(){
        String response = loginSvc.login("foo","bar");
        assertEquals("SUCCESS", response);
    }

}