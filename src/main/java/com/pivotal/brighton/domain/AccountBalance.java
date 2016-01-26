package com.pivotal.brighton.domain;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by pivotal on 1/26/16.
 */
@Entity
@Table(name = "account_balance")
public class AccountBalance implements Serializable{

    @Id
    @GeneratedValue
    private long id;

    @Column(name = "account_type_id", nullable = false)
    private long AccountTypeId;

    @Column(name = "customer_id", nullable = false)
    private long customerId;

    @Column(name= "balance")
    private double balance;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getAccountTypeId() {
        return AccountTypeId;
    }

    public void setAccountTypeId(long accountTypeId) {
        AccountTypeId = accountTypeId;
    }

    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        customerId = customerId;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
