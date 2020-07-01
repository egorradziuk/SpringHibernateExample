package com.websystique.springmvc.service;

import com.websystique.springmvc.dao.UserDao;
import com.websystique.springmvc.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    public User findByRichestUser() {
        return userDao.findRichestUser();
    }

    public List<User> findAllUsers() {
        return userDao.findAllUsers();
    }

    public void print() {
        userDao.print();
    }
}
