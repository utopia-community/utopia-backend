package com.project.utopia.service;

import com.project.utopia.dao.RequestDao;
import com.project.utopia.entity.Request;
import com.project.utopia.holder.request.RequestRequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class RequestService {

    @Autowired
    private RequestDao requestDao;

    public Request getRequest(int requestId) {
        return requestDao.getRequest(requestId);
    }

    public void submitRequest(RequestRequestBody requestBody) {

        Authentication loggedInUser = SecurityContextHolder.getContext().getAuthentication();
        String emailId = loggedInUser.getName();

        Request requestObject = new Request();

        requestObject.setEmailId(emailId);
        requestObject.setTitle(requestBody.getTitle());
        requestObject.setContent(requestBody.getContent());
        requestObject.setStatus("Open");
        requestObject.setCreationTime(System.currentTimeMillis());
        requestDao.save(requestObject);
    }
}
