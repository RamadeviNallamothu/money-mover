package com.pivotal.brighton.domain;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by pivotal on 1/26/16.
 */
@Entity
@Table(name = "account_type")
public class AccountType implements Serializable {

    @Id
    private long id;

    @Column(name= "account_type" ,nullable = false)
    private String accountType;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }


}
