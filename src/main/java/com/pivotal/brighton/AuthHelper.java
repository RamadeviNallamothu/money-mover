package com.pivotal.brighton;

import javax.servlet.http.HttpServletRequest;
import java.math.BigInteger;

public class AuthHelper {
    public static boolean isAuthenticated(HttpServletRequest httpServletRequest){
        BigInteger token = getTokenFromRequest(httpServletRequest);
        BigInteger sessionToken = httpServletRequest.getSession().getAttribute("money-mover.user.authToken")!=null?
                (BigInteger)httpServletRequest.getSession().getAttribute("money-mover.user.authToken"):null;
        return sessionToken.equals(token)?true:false;
    }

    private static BigInteger getTokenFromRequest(HttpServletRequest httpServletRequest) {
        return httpServletRequest.getHeader("auth_token")!=null &&
                    (Object)httpServletRequest.getHeader("auth_token") instanceof BigInteger?
                    new BigInteger(httpServletRequest.getHeader("auth_token")):null;
    }
}
