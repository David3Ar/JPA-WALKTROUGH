package com.galvanize.japdemo.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * Account
 */
@Entity
public class Account {
    @Id
    @GeneratedValue 
    private Long id;

    private String accountNumber;

    @OneToMany( cascade = CascadeType.ALL , fetch = FetchType.EAGER)
    private Set<CreditCard> creditCards = new HashSet<>();

    public Account() {}
    
    public Account(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    
    

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Set<CreditCard> getCreditCards() {
        return creditCards;
    }

    public void setCreditCards(Set<CreditCard> creditCards) {
        this.creditCards = creditCards;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    
    
}