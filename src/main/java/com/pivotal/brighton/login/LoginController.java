package com.pivotal.brighton.login;

import com.pivotal.brighton.login.ResponseEntity.LoginResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class LoginController {
    private Map<String, String> credentialRepoDTO= new HashMap<String, String>(){{
        put("foo", "bar");
    }};

    @RequestMapping(value="/users/sign_in", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<LoginResponse> login(String userName, String password) {

        ResponseEntity<LoginResponse> responseEntity;
        LoginResponse loginResponse = new LoginResponse();

        if(authenticate(userName, password)) {
            loginResponse.setAuthResponse("SUCCESS");
            responseEntity = new ResponseEntity<LoginResponse>(loginResponse,HttpStatus.ACCEPTED);
        }
        else {
            loginResponse.setAuthResponse("ERROR");
            responseEntity = new ResponseEntity<LoginResponse>(loginResponse,HttpStatus.UNAUTHORIZED);
        }

        return responseEntity;
    }

    private boolean authenticate(String userName, String password){
        return password!=null?password.equals(credentialRepoDTO.get(userName)):false;
    }

}
