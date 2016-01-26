package com.pivotal.brighton.Data.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User {

    @Id
    private String userName;
    private String password;

    protected User(){}

}
