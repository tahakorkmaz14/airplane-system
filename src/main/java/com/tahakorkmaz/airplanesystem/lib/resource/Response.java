package com.tahakorkmaz.airplanesystem.lib.resource;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.springframework.http.HttpStatus;

import java.util.Date;

@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Response<T> {

    private HttpStatus status;
    private T payload;
    private Object errors;
    private Object metadata;

    public static <T> Response<T> authenticationFail(Exception error) {
        Response<T> response = new Response<>();
        response.setStatus(HttpStatus.UNAUTHORIZED);
        response.addErrorMsgToResponse(error.getMessage(), error);

        return response;
    }

    public static <T> Response<T> badRequest() {
        Response<T> response = new Response<>();
        response.setStatus(HttpStatus.BAD_REQUEST);
        return response;
    }

    public static <T> Response<T> ok() {
        Response<T> response = new Response<>();
        response.setStatus(HttpStatus.OK);
        return response;
    }

    public static <T> Response<T> ok(T payload) {
        Response<T> response = new Response<>();
        response.setStatus(HttpStatus.OK);
        response.setPayload(payload);
        return response;
    }

    public static <T> Response<T> exception(HttpStatus status) {
        Response<T> response = new Response<>();
        response.setStatus(status);
        return response;
    }

    public void addErrorMsgToResponse(String errorMsg, Exception ex) {
        ResponseError error = new ResponseError()
                .setDetails(errorMsg)
                .setMessage(ex.getMessage())
                .setTimestamp(new Date());
        setErrors(error);
    }
}