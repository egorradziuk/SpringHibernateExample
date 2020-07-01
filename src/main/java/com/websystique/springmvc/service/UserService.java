package com.websystique.springmvc.service;

import com.websystique.springmvc.model.User;

import java.util.List;

public interface UserService {
    User findByRichestUser();
    List<User> findAllUsers();
    void print();
}
