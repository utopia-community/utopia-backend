package com.project.utopia.service;

import com.project.utopia.dao.UserDao;
import com.project.utopia.entity.AuthorityType;
import com.project.utopia.entity.User;
import org.springframework.beans.factory.annotation.Autowired;

public class UserService {
    // service 层的作用: 把传进来的customer 绑定一个新的cart 然后调用dao写入db
    @Autowired
    private UserDao userDao;

    public void signUp(User user, AuthorityType authority) {

        user.setEnabled(true);
        userDao.signUp(user, authority);
    }

    public User getCustomer(String email) {
        return userDao.getUser(email);
    }
}
