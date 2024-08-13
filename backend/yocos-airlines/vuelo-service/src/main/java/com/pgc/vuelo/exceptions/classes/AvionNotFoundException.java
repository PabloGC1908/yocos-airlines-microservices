package com.pgc.vuelo.exceptions.classes;

public class AvionNotFoundException extends RuntimeException {
    public AvionNotFoundException(String message) {
        super(message);
    }
}
