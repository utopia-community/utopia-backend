package com.project.utopia.holder.request;

public class SetRequestStatusRequestBody {

    private int requestId;
    private String status;

    public int getRequestId() {
        return requestId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}