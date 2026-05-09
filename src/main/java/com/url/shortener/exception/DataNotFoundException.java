package com.url.shortener.exception;

public class DataNotFoundException extends RuntimeException {
    public DataNotFoundException(String exceptionMessage) {
        super(exceptionMessage);
    }
}
