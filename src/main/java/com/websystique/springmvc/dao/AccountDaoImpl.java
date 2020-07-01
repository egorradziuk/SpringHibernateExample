package com.websystique.springmvc.dao;

import com.websystique.springmvc.model.Account;
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

    public int getMaxValue() {
//        int i = 0;
        Query query = getSession().createSQLQuery("SELECT user_id FROM " +
                "Account WHERE account = (SELECT MAX(account) FROM Account)");
        return (Integer) query.uniqueResult();
//        return i;
    }

    public BigDecimal sum() {
        Query query = getSession().createSQLQuery("SELECT SUM(account) FROM " +
                "Account");
        return (BigDecimal) query.uniqueResult();
//        return 0;
    }
}
