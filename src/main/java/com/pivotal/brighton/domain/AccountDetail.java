package com.pivotal.brighton.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by pivotal on 1/26/16.
 */

@Entity
@Table(name = "account_detail")
public class AccountDetail {

    @Id
    @Column(name="account_number")
    private long accountNumber;

    @Column(name = "account_type")
    private String accountType;

    @Column(name = "user")
    private String user;

    @Column(name = "balance")
    private double balance;

    public long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
