package com.pivotal.brighton.controller;

import com.pivotal.brighton.domain.AccountDetail;
import com.pivotal.brighton.repository.AccountDetailRepository;
import com.pivotal.brighton.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by pivotal on 1/28/16.
 */
@RestController
public class AccountController {

    @Autowired
    private AccountDetailRepository accountDetailRepository;

    @Autowired
    private LoginService loginService;

    @RequestMapping(value = "/accounts", method = RequestMethod.GET)
    public ResponseEntity<Iterable<AccountDetail>> getAccounts(HttpServletRequest httpServletRequest)
    {

        if(loginService.isAuthenticated(httpServletRequest))
        {
            return new ResponseEntity<Iterable<AccountDetail>>(accountDetailRepository.findAll(), HttpStatus.OK);
        }

        return new ResponseEntity<Iterable<AccountDetail>>(HttpStatus.UNAUTHORIZED);
    }
}
