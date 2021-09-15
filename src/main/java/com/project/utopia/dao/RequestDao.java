package com.project.utopia.dao;

import com.project.utopia.entity.Customer;
import org.springframework.stereotype.Repository;
import com.project.utopia.entity.Request;
import com.project.utopia.entity.User;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class RequestDao {

    @Autowired
    private SessionFactory sessionFactory;
    @Autowired
    private CustomerDao customerDao;

    /**
     * Submit a request object to database
     * @param request
     */
    public void save(Request request) {
        Session session = null;
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.save(request);
            session.getTransaction().commit();

        } catch (Exception ex) {
            ex.printStackTrace();
            if (session != null) session.getTransaction().rollback();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    /**
     * Get most recent requests list for given emailId, limit to 20 requests
     * @param emailId
     * @return
     */
    public List<Request> getAllRequests(String emailId) {
        Customer customer = customerDao.getCurrentCustomer();
        if (customer != null) {
            return customer.getRequests();
        }
        return new ArrayList<>();
    }

    public Request getRequest(int requestId) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(Request.class, requestId);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
