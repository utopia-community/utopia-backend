package com.project.utopia.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
    @RequestMapping(value="/hello", method=RequestMethod.GET)
    @ResponseBody
    public String printHello(){
        return "Hello, welcome to Utopia!";
    }
}
