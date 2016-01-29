package com.pivotal.brighton.controller;

import com.pivotal.brighton.dto.LoginResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.HashMap;
import java.util.Map;

@RestController
public class LoginController {
    private Map<String, String> credentialRepoDTO= new HashMap<String, String>(){{
        put("foo", "bar");
    }};

    @RequestMapping(value="/login", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<LoginResponse> login(String username, String password, HttpServletRequest httpServletRequest) {
        ResponseEntity<LoginResponse> responseEntity;
        LoginResponse loginResponse = new LoginResponse();

        if(authenticate(username, password)) {
            loginResponse.setAuthResponse("SUCCESS");
            loginResponse.setAuthToken(generateAuthToken());
            httpServletRequest.getSession().setAttribute("money-mover.user.authToken", loginResponse.getAuthToken());
            responseEntity = new ResponseEntity<LoginResponse>(loginResponse,HttpStatus.ACCEPTED);
        }
        else {
            loginResponse.setAuthResponse("ERROR");
            responseEntity = new ResponseEntity<LoginResponse>(loginResponse,HttpStatus.UNAUTHORIZED);
            httpServletRequest.getSession().invalidate();
        }

        return responseEntity;
    }

    private boolean authenticate(String username, String password){
        return password!=null?password.equals(credentialRepoDTO.get(username)):false;
    }

    private String generateAuthToken(){
        SecureRandom random = new SecureRandom();
        return new BigInteger(130,random).toString(64);
    }

}
