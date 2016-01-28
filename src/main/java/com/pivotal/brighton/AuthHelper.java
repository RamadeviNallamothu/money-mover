package com.pivotal.brighton;

import javax.servlet.http.HttpServletRequest;
import java.math.BigInteger;

public class AuthHelper {
    public static boolean isAuthenticated(HttpServletRequest httpServletRequest){
//        BigInteger token = getTokenFromRequest(httpServletRequest);
//        BigInteger sessionToken = httpServletRequest.getSession().getAttribute("money-mover.user.authToken")!=null?
//                new BigInteger(httpServletRequest.getSession().getAttribute("money-mover.user.authToken")):null;
        String token = (String) httpServletRequest.getHeader("auth_token");
        String sessionToken = (String) httpServletRequest.getSession().getAttribute("money-mover.user.authToken");

        return sessionToken.equals(token);
    }

//    private static BigInteger getTokenFromRequest(HttpServletRequest httpServletRequest) {
//        return httpServletRequest.getHeader("auth_token")!=null &&
//                    (Object)httpServletRequest.getHeader("auth_token") instanceof BigInteger?
//                    new BigInteger(httpServletRequest.getHeader("auth_token")):null;
//    }
}