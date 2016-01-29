package com.pivotal.brighton.controller;

import com.pivotal.brighton.dto.LoginResponse;
import com.pivotal.brighton.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class LoginController {

    @Autowired
    private LoginService loginService;

    @RequestMapping(value="/login", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<LoginResponse> login(String username, String password, HttpServletRequest httpServletRequest) {
        LoginResponse loginResponse = loginService.login(username, password, httpServletRequest);
        return "SUCCESS".equals(loginResponse.getAuthResponse())?
                new ResponseEntity<LoginResponse>(loginResponse, HttpStatus.ACCEPTED):
                new ResponseEntity<LoginResponse>(loginResponse,HttpStatus.UNAUTHORIZED);
    }

}
