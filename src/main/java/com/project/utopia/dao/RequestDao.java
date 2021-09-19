package com.project.utopia.dao;

import com.project.utopia.entity.Customer;
import org.springframework.stereotype.Repository;
import com.project.utopia.entity.Request;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
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
     * Get list of requests created by current customer
     * @return List of Request objects
     */
    public List<Request> getCurrentUserRequests() {
        Customer customer = customerDao.getCurrentCustomer();
        if (customer != null) {
            return customer.getRequests();
        }
        return new ArrayList<>();
    }

    /**
     * Get all requests list for sorted by lastModified time, used by Admin
     * @return List of Request objects
     */
    public List<Request> getAllRequests() {
        Session session = null;
        List<Request> requestList = new ArrayList<>();
        try {
            session = sessionFactory.openSession();
            //use query to fetch requests for different status and append to request list
            //Requests of same status are sorted by lastModifiedTime
            TypedQuery<Request> openQuery =  session.createQuery("SELECT request FROM Request request WHERE request.status = 'OPEN' ORDER BY request.lastModifiedTime", Request.class);
            requestList.addAll(openQuery.getResultList());
            TypedQuery<Request> inProgressQuery =  session.createQuery("SELECT request FROM Request request WHERE request.status = 'IN_PROGRESS' ORDER BY request.lastModifiedTime", Request.class);
            requestList.addAll(inProgressQuery.getResultList());
            TypedQuery<Request> resolvedQuery =  session.createQuery("SELECT request FROM Request request WHERE request.status = 'RESOLVED' ORDER BY request.lastModifiedTime", Request.class);
            requestList.addAll(resolvedQuery.getResultList());
            return requestList;
        } catch (Exception ex) {
            ex.printStackTrace();
            if (session != null) session.getTransaction().rollback();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return requestList;
    }

//    /**
//     * Modified request status submitted by Admin
//     *
//     * @return
//     */
//    public void solveRequests() {
//    }

}