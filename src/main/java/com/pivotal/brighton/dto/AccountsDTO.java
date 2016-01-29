package com.pivotal.brighton.dto;

import com.pivotal.brighton.domain.AccountDetail;

import java.util.List;

/**
 * Created by pivotal on 1/29/16.
 */
public class AccountsDTO {

    private Iterable<AccountDetail> accounts;

    public Iterable<AccountDetail> getAccounts() {
        return accounts;
    }

    public void setAccounts(Iterable<AccountDetail> accounts) {
        this.accounts = accounts;
    }
}
