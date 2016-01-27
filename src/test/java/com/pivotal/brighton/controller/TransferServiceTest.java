package com.pivotal.brighton.controller;

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
        fromAccountDetail.setBalance(5000.00);
//        fromAccountDetail.setUser();

        Mockito.when(accountDetailRepository.findOne("12345")).thenReturn(fromAccountDetail);


        toAccountDetail = new AccountDetail();
        toAccountDetail.setAccountNumber("11111");
        toAccountDetail.setAccountType("Checking");
        toAccountDetail.setBalance(2000.00);
//        fromAccountDetail.setUser();

        Mockito.when(accountDetailRepository.findOne("11111")).thenReturn(toAccountDetail);
    }

    @Test
    public void moneyTransferTest()
    {
        mockTransferService.moneyTransfer("12345", "11111", 1000.00, "");
        assertEquals(toAccountDetail.getBalance(), 3000.00, 0.0001);

    }



}
