package com.project.utopia.service;
import com.project.utopia.dao.CustomerDao;
import com.project.utopia.entity.Customer;
import com.project.utopia.holder.request.RegisterRequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    // service 层的作用: 把传进来的customer 绑定一个新的cart 然后调用dao写入db
    @Autowired
    private CustomerDao customerDao;

    public int addCustomer(RegisterRequestBody request) {
        return customerDao.addCustomer(request);
    }
    public Customer getCurrentCustomer() {
        return customerDao.getCurrentCustomer();
    }
}
