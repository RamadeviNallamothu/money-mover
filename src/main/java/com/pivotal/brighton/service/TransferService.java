package com.pivotal.brighton.service;

import com.pivotal.brighton.domain.AccountDetail;
import com.pivotal.brighton.repository.AccountDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * Created by pivotal on 1/27/16.
 */
@Service
public class TransferService {

    @Autowired
    private AccountDetailRepository accountDetailRepository;

    private AccountDetail sourceAccountDetail;
    private AccountDetail destinationAccountDetail;

    @Transactional
    public ResponseEntity<String> moneyTransfer(String sourceAccountID,  String destinationAccountID, double transactionAmount,  String transactionNotes )
    {

        sourceAccountDetail = accountDetailRepository.findOne(sourceAccountID);
        destinationAccountDetail = accountDetailRepository.findOne(destinationAccountID);

        if(sourceAccountDetail.getAccountBalance() >= transactionAmount)
        {
            sourceAccountDetail.setAccountBalance((sourceAccountDetail.getAccountBalance()-transactionAmount));
            sourceAccountDetail.setTransactionAmount(transactionAmount);
            sourceAccountDetail.setTransactionDate(new Date());
            sourceAccountDetail.setTransactionNotes(transactionNotes);
            sourceAccountDetail.setTransactionType("withdrawal");

            destinationAccountDetail.setAccountBalance(destinationAccountDetail.getAccountBalance()+transactionAmount);
            destinationAccountDetail.setTransactionAmount(transactionAmount);
            destinationAccountDetail.setTransactionDate(new Date());
            destinationAccountDetail.setTransactionNotes(transactionNotes);
            destinationAccountDetail.setTransactionType("deposit");

            accountDetailRepository.save(sourceAccountDetail);
            accountDetailRepository.save(destinationAccountDetail);

            return new ResponseEntity<String>("200", HttpStatus.OK);

        }else
        {
            System.out.println("Insufficient fund");

            return new ResponseEntity<String>("400", HttpStatus.BAD_REQUEST);

        }

    }

}
