package com.pivotal.brighton.controller;

import com.pivotal.brighton.dto.TransferRequestDTO;
import com.pivotal.brighton.service.LoginService;
import com.pivotal.brighton.service.TransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by pivotal on 1/27/16.
 */
@RestController
public class TransferController {

    @Autowired
    private TransferService transferService;

    @Autowired
    private LoginService loginService;

    @RequestMapping(path = "/transfer", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> moneyTransfer(@RequestBody TransferRequestDTO transferRequestDTO, HttpServletRequest httpServletRequest)
    {
        if(loginService.isAuthenticated(httpServletRequest))
        {
            return transferService.moneyTransfer(transferRequestDTO.getSourceAccountID(),transferRequestDTO.getDestinationAccountID(),transferRequestDTO.getTransactionAmount(),transferRequestDTO.getTransactionNotes());
        }

        return new ResponseEntity<String>("401", HttpStatus.UNAUTHORIZED);
    }
}
