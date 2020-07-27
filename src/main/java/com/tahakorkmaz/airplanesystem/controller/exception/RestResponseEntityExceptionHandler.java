package com.tahakorkmaz.airplanesystem.controller.exception;

import com.tahakorkmaz.airplanesystem.lib.resource.Response;
import com.tahakorkmaz.airplanesystem.util.FlightManagementException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.persistence.EntityNotFoundException;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler
    protected ResponseEntity<Object> handleFlighManagementException(FlightManagementException ex, WebRequest request) {
        Response response = Response.exception(ex.getStatus());
        response.addErrorMsgToResponse(ex.getDetail(), ex);
        return handleExceptionInternal(ex, response, new HttpHeaders(), ex.getStatus(), request);
    }

    @ExceptionHandler
    protected ResponseEntity<Object> handleEntityNotFoundException(EntityNotFoundException ex, WebRequest request) {
        Response response = Response.exception(HttpStatus.NOT_FOUND);
        response.addErrorMsgToResponse(ex.getClass().getName(), ex);
        return handleExceptionInternal(ex, response, new HttpHeaders(), response.getStatus(), request);
    }
}
