package com.pivotal.brighton.domain;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by pivotal on 1/26/16.
 */
@Entity
@Table(name = "customer_detail")
public class CustomerDetails implements Serializable {

    @Id
    @Column(name = "customer_id")
    private long customerId;

    @Column(name = "first_name", nullable =false)
    private String firstName;

    @Column(name = "last_name", nullable =false)
    private String lastName;

    @Column(name = "address")
    private String Address;

    @Column(name = "phone_num")
    private long phoneNumber;

    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
