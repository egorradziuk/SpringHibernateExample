package com.websystique.springmvc.dao;

import com.websystique.springmvc.model.Account;
import com.websystique.springmvc.model.User;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;

@Repository("userDao")
public class UserDaoImpl  implements UserDao{

    private SessionFactory sessionFactory;

    @Autowired
    public UserDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public Session getSession(){
        return sessionFactory.getCurrentSession();
    }

    public User findRichestUser() {
        return (User) getSession().createQuery(
                "FROM User WHERE user_id=(SELECT user.user_id FROM " +
                "Account WHERE account = (SELECT MAX(account) FROM Account))")
                .uniqueResult();

        /*return (User) getSession().createQuery(
                "FROM User WHERE user_id=(SELECT user.user_id FROM " +
                        "Account WHERE account = 6)")
                .uniqueResult();*/
    }

    public List<User> findAllUsers() {
        Query query = getSession().createQuery("FROM User");
        return query.list();
    }

}
