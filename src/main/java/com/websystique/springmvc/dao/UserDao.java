package com.websystique.springmvc.dao;

import com.websystique.springmvc.model.User;

import java.util.List;

public interface UserDao {
    User findRichestUser();
    List<User> findAllUsers();
    void print();
}