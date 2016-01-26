package com.pivotal.brighton.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

/**
 * Created by pivotal on 1/26/16.
 */

@Entity
@Table(name = "account_transaction_details")
public class AccountTransactionDetails implements Serializable {

    @Id
    @GeneratedValue
    private long transactionId;

    @Column(name = "transaction_date",nullable = false)
    private Date dateTime;

    @Column(name = "customer_id", nullable = false)
    private long customerId;

    @Column(name = "account_type_id", nullable = false)
    private long accountType;


    @Column(name = "transaction_type", nullable = false)
    private String transactionType;

    @Column(name="transaction_amount", nullable = false)
    private String transactionAccount;

    @Column(name = "remark")
    private String remarks;


    public long getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(long transactionId) {
        this.transactionId = transactionId;
    }

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public String getTransactionAccount() {
        return transactionAccount;
    }

    public void setTransactionAccount(String transactionAccount) {
        this.transactionAccount = transactionAccount;
    }

    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }

    public long getAccountType() {
        return accountType;
    }

    public void setAccountType(long accountType) {
        this.accountType = accountType;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}
