package com.salesianos.dam.Example_for_Security.Security.errorhandling;

public class JwtTokenException extends RuntimeException {
    public JwtTokenException(String msg) {
        super(msg);
    }
}
