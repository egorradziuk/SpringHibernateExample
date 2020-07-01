package com.websystique.springmvc.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int user_id;
    @Column(name = "name")
    private String name;
    @Column(name = "sure_name")
    private String sure_name;

    @OneToMany(mappedBy = "user")
    private List<Account> accounts = new ArrayList<Account>();

    @Transient
    public String fullName() {
        return name+" "+sure_name;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSure_name() {
        return sure_name;
    }

    public void setSure_name(String sure_name) {
        this.sure_name = sure_name;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }

    @Override
    public String toString() {
        return "User [" +
                "userId=" + user_id +
                ", name='" + name + '\'' +
                ", sureName='" + sure_name + '\'' +
                ", accounts=" + accounts +
                ']';
    }
}