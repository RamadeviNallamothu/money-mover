package com.pivotal.brighton;

import javax.servlet.http.HttpServletRequest;

public class AuthHelper {
    public static boolean isAuthenticated(HttpServletRequest httpServletRequest){
        String authToken = (String) httpServletRequest.getHeader("authToken");
        String sessionToken = (String) httpServletRequest.getSession().getAttribute("money-mover.user.authToken");
        return sessionToken!=null && sessionToken.equals(authToken);

    }
}