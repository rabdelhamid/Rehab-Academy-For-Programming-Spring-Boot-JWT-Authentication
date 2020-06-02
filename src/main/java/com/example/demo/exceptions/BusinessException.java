package com.example.demo.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
//@ApplicationException(rollback = true)
//http://www.springboottutorial.com/spring-boot-exception-handling-for-rest-services

@ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
public class BusinessException extends RuntimeException {

    private Object[] params = null;

    public BusinessException(String message) {
        super(message);
    }

    public BusinessException(String message, Throwable cause) {
        super(message, cause);
    }

    public BusinessException(String message, Object[] params) {
        super(message);
        this.params = params;
    }

    public Object[] getParams() {
        return params;
    }

    public void setParams(Object[] params) {
        this.params = params;
    }

}
