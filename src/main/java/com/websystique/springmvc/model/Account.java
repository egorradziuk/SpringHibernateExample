package com.websystique.springmvc.model;

import javax.persistence.*;

@Entity
@Table
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int account_id;
    @Column(name = "account")
    private int account;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;


    public int getAccount_id() {
        return account_id;
    }

    public void setAccount_id(int account_id) {
        this.account_id = account_id;
    }

    public int getAccount() {
        return account;
    }

    public void setAccount(int account) {
        this.account = account;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Account [" +
                "account_id=" + account_id +
                ", account=" + account +
                ", user=" + user +
                ']';
    }
}