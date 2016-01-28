package com.pivotal.brighton.controller;

import com.pivotal.brighton.service.TransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by pivotal on 1/27/16.
 */
@RestController
public class TransferController {

    @Autowired
    private TransferService transferService;

    @RequestMapping(path = "/transfer", method = RequestMethod.POST)
    public ResponseEntity<String> moneyTransfer(@Param("sourceAccountID") String sourceAccountID, @Param("destinationAccountID") String destinationAccountID,
                                                @Param("transactionAmount") double transactionAmount, @Param("transactionNotes") String transactionNotes )
    {

        return transferService.moneyTransfer(sourceAccountID,destinationAccountID, transactionAmount, transactionNotes);

    }
}
