package com.pgc.vuelo.exceptions.classes;

public class VueloNotFoundException extends RuntimeException {
    public VueloNotFoundException(String message) {
        super(message);
    }
}
