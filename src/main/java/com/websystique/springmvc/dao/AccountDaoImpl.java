package com.websystique.springmvc.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

@Repository("accountDao")
public class AccountDaoImpl implements AccountDao {

    private SessionFactory sessionFactory;

    @Autowired
    public AccountDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public Session getSession(){
        return sessionFactory.getCurrentSession();
    }
    

    public BigDecimal sum() {
        Query query = getSession().createSQLQuery("SELECT SUM(account) FROM " +
                "Account");
        return (BigDecimal) query.uniqueResult();
    }
}
