package com.pivotal.brighton.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * Created by pivotal on 1/26/16.
 */

@Entity
@Table(name = "account_detail")
public class AccountDetail {

    @Id
    @Column(name="account_number")
    private String accountNumber;

    @Column(name = "account_type")
    private String accountType;

    @Column(name = "account_name")
    private String accountName;

    @Column(name = "balance")
    private double balance;

    @Column(name = "transaction_date", nullable = false)
    private Date transactionDate;

    @Column(name = "transaction_amount")
    private double transactionAmount;

    @Column(name = "transaction_notes")
    private String transactionNotes;

    @Column(name="transaction_type")
    private String transactionType;

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }

    public double getTransactionAmount() {
        return transactionAmount;
    }

    public void setTransactionAmount(double transactionAmount) {
        this.transactionAmount = transactionAmount;
    }

    public String getTransactionNotes() {
        return transactionNotes;
    }

    public void setTransactionNotes(String transactionNotes) {
        this.transactionNotes = transactionNotes;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }
}
