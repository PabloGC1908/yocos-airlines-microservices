package com.pgc.vuelo.exceptions.classes;

public class AeropuertoNotFoundException extends RuntimeException {
    public AeropuertoNotFoundException(String message) {
        super(message);
    }
}
