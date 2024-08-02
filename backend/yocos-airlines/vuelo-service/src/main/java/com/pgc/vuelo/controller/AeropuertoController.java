package com.pgc.vuelo.controller;

import com.pgc.vuelo.models.Aeropuerto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/airports")
public class AeropuertoController {



    // TODO: Implementar endpoint POST /airports.
    public ResponseEntity<?> createAeropuerto(Aeropuerto aeropuerto) {
        return null;
    }

    // TODO: Implementar endpoint DELETE /airports/{airportId}.
    public ResponseEntity<?> deleteAeropuerto(Aeropuerto aeropuerto) {
        return null;
    }
}
