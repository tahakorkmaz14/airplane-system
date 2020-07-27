package com.tahakorkmaz.airplanesystem.util;

import org.springframework.http.HttpStatus;

public class FlightManagementException extends RuntimeException{

    private HttpStatus status;

    private String detail;

    private String message;

    public FlightManagementException(HttpStatus status, String detail) {
        super();
        this.status = status;
        this.detail = detail;
    }

    public FlightManagementException(HttpStatus status) {
        super();
        this.status = status;
    }

    public FlightManagementException(Exception ex) {
        super();
        this.status = HttpStatus.INTERNAL_SERVER_ERROR;
        this.message = ex.getLocalizedMessage();
        this.detail = ex.getMessage();
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}