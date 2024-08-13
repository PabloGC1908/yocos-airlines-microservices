package com.pgc.vuelo.exceptions.classes;

public class AerolineaNotFoundException extends RuntimeException {
    public AerolineaNotFoundException(String message) {
        super(message);
    }
}
