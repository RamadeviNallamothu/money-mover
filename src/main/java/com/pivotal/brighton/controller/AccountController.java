package com.pivotal.brighton.controller;

import com.pivotal.brighton.domain.AccountDetail;
import com.pivotal.brighton.dto.AccountsDTO;
import com.pivotal.brighton.dto.LoginRequest;
import com.pivotal.brighton.dto.LoginResponse;
import com.pivotal.brighton.repository.AccountDetailRepository;
import com.pivotal.brighton.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
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
    public ResponseEntity<AccountsDTO> getAccounts(HttpServletRequest httpServletRequest)
    {
        AccountsDTO accountsDTO = new AccountsDTO();
        if(loginService.isAuthenticated(httpServletRequest))
        {
            accountsDTO.setAccounts(accountDetailRepository.findAll());
            return new ResponseEntity<AccountsDTO>(accountsDTO, HttpStatus.OK);
        }

        return new ResponseEntity<AccountsDTO>(HttpStatus.UNAUTHORIZED);
    }


}
