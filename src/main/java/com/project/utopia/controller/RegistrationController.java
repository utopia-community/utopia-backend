package com.project.utopia.controller;

import com.project.utopia.entity.AuthorityType;
import com.project.utopia.entity.User;
import com.project.utopia.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class RegistrationController {
    @Autowired
    private UserService userService;

    //相当于 signupServlet doPost， value = /register
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    //@ResponseStatus： 添加返回状态 200， 404 。。。
    @ResponseStatus(value = HttpStatus.CREATED)
    //@RequestBody： Convert the request body( from json)  to a java object == jackson
    @ResponseBody
    public void signUp(User customer, AuthorityType auth) {
        userService.signUp(customer, auth);
    }
}
