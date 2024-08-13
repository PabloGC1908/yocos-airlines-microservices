package com.pgc.vuelo.exceptions.handlers;

import com.pgc.vuelo.exceptions.classes.AerolineaNotFoundException;
import com.pgc.vuelo.exceptions.classes.CiudadNotFoundException;
import com.pgc.vuelo.exceptions.classes.VueloNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(CiudadNotFoundException.class)
    public ResponseEntity<String> handleCiudadNotFoundException(final CiudadNotFoundException ex) {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(ex.getMessage());
    }

    @ExceptionHandler(AerolineaNotFoundException.class)
    public ResponseEntity<String> handleAerolineaNotFoundException(final AerolineaNotFoundException ex) {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(ex.getMessage());
    }

    @ExceptionHandler(VueloNotFoundException.class)
    public ResponseEntity<String> handleVueloNotFoundException(final VueloNotFoundException ex) {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(ex.getMessage());
    }
}
