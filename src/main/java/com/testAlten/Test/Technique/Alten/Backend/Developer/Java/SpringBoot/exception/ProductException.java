package com.testAlten.Test.Technique.Alten.Backend.Developer.Java.SpringBoot.exception;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
@AllArgsConstructor

public class ProductException {
    private final String message;
    private final Throwable throwable;
    private final HttpStatus httpStatus;



    public String getMessage() {
        return message;
    }

    public Throwable getThrowable() {
        return throwable;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }
}
