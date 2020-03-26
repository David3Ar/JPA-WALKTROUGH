package com.galvanize.japdemo.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;



/**
 * Customer
 */
@Entity
public class Customer {

    @Id 
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String firstname;
    private String lastname;
    private String email;

    @OneToOne(cascade = CascadeType.ALL)        //ALSO UPDATES / SAVE THE ACCOUNT WHEN MODIEFYING CUSTOMER
    private Account account;

    public Customer() {};

    public Customer(String firstname , String lastname , String email) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
    }

    public Customer(String firstname , String lastname , String email, Account account) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.account = account;
    }




    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

}