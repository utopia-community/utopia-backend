package com.project.utopia.controller;

import com.project.utopia.entity.Request;
import com.project.utopia.holder.request.NewRequestRequestBody;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import com.project.utopia.service.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class RequestController {

    @Autowired
    private RequestService requestService;

    @RequestMapping(value = "/newRequest", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.CREATED)
    public void submitRequest(@RequestBody NewRequestRequestBody request) {
        requestService.submitRequest(request);
    }

    @RequestMapping(value = "/currentRequests", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<Object> getCurrentRequests() {
        List<Request> requestList = requestService.getCurrentRequests();
        return new ResponseEntity<>(requestList, HttpStatus.OK);
    }

    @RequestMapping(value = "/allRequests", method = RequestMethod.GET)
    public ResponseEntity<Object> getOpenRequests() {
        List<Request> requestList = requestService.getAllRequests();
        return new ResponseEntity<>(requestList, HttpStatus.OK);
    }
//
//    @RequestMapping(value = "/solveRequest", method = RequestMethod.POST)
//    @ResponseStatus(value = HttpStatus.CREATED)
//    public void solveRequests() {
//
//    }
}
