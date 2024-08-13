package com.pgc.vuelo.exceptions.classes;

public class CiudadNotFoundException extends RuntimeException {
    public CiudadNotFoundException(String message) {
        super(message);
    }
}
