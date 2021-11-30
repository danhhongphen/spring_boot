package com.phanhlearning.rest.webservices.restfulwebservices.auth.jwt.resource;

public class AuthenticationException extends RuntimeException {
    public AuthenticationException(String message, Throwable cause) {
        super(message, cause);
    }
}
