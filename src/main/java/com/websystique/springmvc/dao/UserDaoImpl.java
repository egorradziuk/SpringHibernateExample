package com.websystique.springmvc.dao;

import com.websystique.springmvc.model.Employee;
import com.websystique.springmvc.model.User;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("userDao")
public class UserDaoImpl  implements UserDao{ //extends AbstractDao<Integer, User>

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
                "FROM User WHERE user_id=(SELECT user_id FROM " +
                "Account WHERE account = (SELECT MAX(account) FROM Account))")
                .uniqueResult();
        //getByKey(accountId);
    }

    public List<User> findAllUsers() {
        Query query = getSession().createQuery("FROM User");
        /*Criteria criteria = createEntityCriteria();
        return (List<User>) criteria.list();*/
        return query.list();
    }

    public void print() {
        Query query = getSession().createQuery("FROM User");
        List<User> list = query.list();
        for(User user: list) {
            System.out.println(user);
        }
    }


}
