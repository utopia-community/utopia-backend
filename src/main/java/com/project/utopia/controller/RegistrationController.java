package com.project.utopia.controller;

import com.project.utopia.entity.AuthorityType;
import com.project.utopia.entity.User;
import com.project.utopia.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;

public class RegistrationController {
    @Autowired
    private UserService userService;

    //相当于 signupServlet doPost， value = /signup
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    //@ResponseStatus： 添加返回状态 200， 404 。。。
    @ResponseStatus(value = HttpStatus.CREATED)
    //@RequestBody： Convert the request body( from json)  to a java object == jackson
    public void signUp(@RequestBody User user, AuthorityType authority) {
        userService.signUp(user,authority);
    }
}
