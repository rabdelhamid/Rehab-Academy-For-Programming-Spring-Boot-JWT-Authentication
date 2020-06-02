package com.example.demo.exceptions;

public class NoDataFoundException extends Exception {
    private static final long serialVersionUID = 1L;

    public NoDataFoundException(String message) {
        super(message);
    }

    public NoDataFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
