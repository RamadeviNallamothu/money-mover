package com.pivotal.brighton.login;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class Login {
    private Map<String, String> credentialRepoDTO= new HashMap<String, String>();

    public String login(String userName, String password) {
        return authenticate(userName, password)?"SUCCESS":"ERROR";
    }

    private boolean authenticate(String userName, String password){
        return password.equals(credentialRepoDTO.get(userName));
    }

    /*@RequestMapping(value="/users/sign-in", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> login(){
        return new ResponseEntity<String>("SUCCESS", HttpStatus.ACCEPTED);
    }*/
}
