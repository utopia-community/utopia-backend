package com.project.utopia.dao;

import com.project.utopia.entity.Customer;
import org.springframework.stereotype.Repository;
import com.project.utopia.entity.Request;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

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
     * Get list of requests created by current customer
     * @return List of Request objects
     */
    public List<Request> getCurrentUserRequests() {
        System.out.println("Now into requestDao - getCurrentUserRequests");
        Customer customer = customerDao.getCurrentCustomer();
        if (customer != null) {
            return customer.getRequests();
        }
        return new ArrayList<>();
    }

//    /**
//     * Get all requests list for with status "Open"
//     * @return List of Request objects
//     */
//    public List<Request> getAllRequests() {
//        return new ArrayList<>();
//    }
//
//    /**
//     * Get all requests list for with status "Open"
//     *
//     * @return
//     */
//    public void solveRequests() {
//    }

}