package com.pivotal.brighton.controller;

import com.pivotal.brighton.AuthHelper;
import com.pivotal.brighton.domain.AccountDetail;
import com.pivotal.brighton.repository.AccountDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.math.BigInteger;
import java.util.List;

/**
 * Created by pivotal on 1/28/16.
 */
@RestController
public class AccountController {

    @Autowired
    private AccountDetailRepository accountDetailRepository;

    @RequestMapping(value = "/accounts", method = RequestMethod.GET)
    public ResponseEntity<Iterable<AccountDetail>> getAccounts(HttpServletRequest httpServletRequest)
    {

        if(AuthHelper.isAuthenticated(httpServletRequest))
        {
            return new ResponseEntity<Iterable<AccountDetail>>(accountDetailRepository.findAll(), HttpStatus.OK);
        }

        return new ResponseEntity<Iterable<AccountDetail>>(HttpStatus.UNAUTHORIZED);
    }
}
