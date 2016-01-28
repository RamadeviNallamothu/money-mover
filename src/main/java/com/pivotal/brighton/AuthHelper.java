package com.pivotal.brighton;

import javax.servlet.http.HttpServletRequest;
import java.math.BigInteger;

public class AuthHelper {
    public static boolean isAuthenticated(BigInteger token, HttpServletRequest httpServletRequest){
        BigInteger sessionToken = httpServletRequest.getSession().getAttribute("money-mover.user.authToken")!=null?
                (BigInteger)httpServletRequest.getSession().getAttribute("money-mover.user.authToken"):null;
        return sessionToken.equals(token)?true:false;
    }
}
