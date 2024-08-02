package com.pgc.vuelo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/flights")
public class VueloController {

    public ResponseEntity<?> getVuelos() {

    }

    public ResponseEntity<?> getVueloById(int id) {

    }
}
