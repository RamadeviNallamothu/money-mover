package com.pivotal.brighton.service;

import com.pivotal.brighton.dto.LoginResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.HashMap;
import java.util.Map;

@Service
public class LoginService {
    private Map<String, String> credentialRepo= new HashMap<String, String>(){{
        put("foo", "bar");
    }};

    public LoginResponse login(String username, String password, HttpServletRequest httpServletRequest) {
        ResponseEntity<LoginResponse> responseEntity;
        LoginResponse loginResponse = new LoginResponse();

        if(authenticate(username, password)) {
            loginResponse.setAuthResponse("SUCCESS");
            loginResponse.setAuthToken(generateAuthToken());
            httpServletRequest.getSession().setAttribute("money-mover.user.authToken", loginResponse.getAuthToken());
        }
        else {
            loginResponse.setAuthResponse("ERROR");
            httpServletRequest.getSession().invalidate();
        }

        return loginResponse;
    }

    public static boolean isAuthenticated(HttpServletRequest httpServletRequest){
        String authToken = (String) httpServletRequest.getHeader("authToken");
        String sessionToken = (String) httpServletRequest.getSession().getAttribute("money-mover.user.authToken");
        return sessionToken!=null && sessionToken.equals(authToken);

    }

    private boolean authenticate(String username, String password){
        return password!=null?password.equals(credentialRepo.get(username)):false;
    }

    private String generateAuthToken(){
        SecureRandom random = new SecureRandom();
        return new BigInteger(130,random).toString(64);
    }

}
