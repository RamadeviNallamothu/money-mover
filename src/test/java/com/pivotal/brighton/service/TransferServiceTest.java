package com.pivotal.brighton.service;

import com.pivotal.brighton.repository.AccountDetailRepository;
import com.pivotal.brighton.service.TransferService;
import com.pivotal.brighton.domain.AccountDetail;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import static org.junit.Assert.*;

/**
 * Created by pivotal on 1/27/16.
 */

public class TransferServiceTest {

    @InjectMocks private TransferService mockTransferService;

    @Mock private AccountDetailRepository accountDetailRepository;


    AccountDetail fromAccountDetail;
    AccountDetail toAccountDetail;

    @Before
    public void initAccounts()
    {
        mockTransferService = new TransferService();
        MockitoAnnotations.initMocks(this);


        fromAccountDetail = new AccountDetail();
        fromAccountDetail.setAccountNumber("12345");
        fromAccountDetail.setAccountType("Savings");
        fromAccountDetail.setAccountBalance(5000.00);
//        fromAccountDetail.setUser();

        Mockito.when(accountDetailRepository.findOne("12345")).thenReturn(fromAccountDetail);


        toAccountDetail = new AccountDetail();
        toAccountDetail.setAccountNumber("11111");
        toAccountDetail.setAccountType("Checking");
        toAccountDetail.setAccountBalance(2000.00);
//        fromAccountDetail.setUser();

        Mockito.when(accountDetailRepository.findOne("11111")).thenReturn(toAccountDetail);
    }

    @Test
    public void moneyTransferTest()
    {
        mockTransferService.moneyTransfer("12345", "11111", 1000.00, "");
        assertEquals(fromAccountDetail.getAccountBalance(), 4000.00, 0.0001);
        assertEquals(toAccountDetail.getAccountBalance(), 3000.00, 0.0001);
        assertEquals(fromAccountDetail.getTransactionAmount(), 1000.00, 0.0001);
        assertEquals(fromAccountDetail.getTransactionType(), "withdrawal");
        assertEquals(toAccountDetail.getTransactionAmount(), 1000.00, 0.0001);
        assertEquals(toAccountDetail.getTransactionType(), "deposit");
    }

    @Test
    public void moneyTransferInsufficientFundsTest()
    {
        mockTransferService.moneyTransfer("12345", "11111", 5000.00, "");
        assertEquals(fromAccountDetail.getAccountBalance(), 0.00, 0.0001);
        assertEquals(toAccountDetail.getAccountBalance(), 7000.00, 0.0001);
        assertEquals(fromAccountDetail.getTransactionAmount(), 5000.00, 0.0001);
        assertEquals(fromAccountDetail.getTransactionType(), "withdrawal");
        assertEquals(toAccountDetail.getTransactionAmount(), 5000.00, 0.0001);
        assertEquals(toAccountDetail.getTransactionType(), "deposit");

        mockTransferService.moneyTransfer("12345", "11111", 1.00, "");
        assertEquals(fromAccountDetail.getAccountBalance(), 0.00, 0.0001);
        assertEquals(fromAccountDetail.getTransactionAmount(), 5000.00, 0.0001);
        assertEquals(fromAccountDetail.getTransactionType(), "withdrawal");
        assertEquals(toAccountDetail.getTransactionAmount(), 5000.00, 0.0001);
        assertEquals(toAccountDetail.getTransactionType(), "deposit");


    }



}
