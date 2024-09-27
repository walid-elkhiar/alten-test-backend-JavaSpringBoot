package com.testAlten.Test.Technique.Alten.Backend.Developer.Java.SpringBoot.exception;

public class ProductNotFoundException extends RuntimeException {

        public ProductNotFoundException(String message) {
            super(message);
        }

        public ProductNotFoundException(String message, Throwable cause) {
            super(message, cause);
        }
}
