package com.project.utopia.dao;

import com.project.utopia.entity.Authority;
import com.project.utopia.entity.AuthorityType;
import com.project.utopia.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao {
    //这个session factory 是跟数据库交流的
    @Autowired
    private SessionFactory sessionFactory;

    public void signUp(User user, AuthorityType authority) {
        Authority authorities = new Authority();
        authorities.setAuthorities(authority);
        authorities.setEmail(user.getEmail());

        Session session = null;
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.save(authorities);
            session.save(user);
            session.getTransaction().commit();

        } catch (Exception ex) {
            ex.printStackTrace();
            session.getTransaction().rollback();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public User getUser(String email) {
        User user = null;
        Session session = null;
        try {
            session = sessionFactory.openSession();
            user = session.get(User.class, email);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return user;
    }
}