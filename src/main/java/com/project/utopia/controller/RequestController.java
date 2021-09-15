package com.project.utopia.controller;

import com.project.utopia.holder.request.RequestRequestBody;
import org.springframework.stereotype.Controller;
import com.project.utopia.service.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class RequestController {

    @Autowired
    private RequestService requestService;

    @RequestMapping(value = "/newRequest", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.CREATED)
    public void submitRequest(@RequestBody RequestRequestBody request) {
        requestService.submitRequest(request);
    }
}
