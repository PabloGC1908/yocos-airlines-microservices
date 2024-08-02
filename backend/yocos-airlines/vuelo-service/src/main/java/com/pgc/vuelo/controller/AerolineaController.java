package com.pgc.vuelo.controller;

import com.pgc.vuelo.models.Aerolinea;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/airlines")
public class AerolineaController {

    // TODO: Implementar endpoint GET /airlines.
    public ResponseEntity<?> getAerolineas() {
        return null;
    }

    // TODO: Implementar endpoint POST /airlines.
    public ResponseEntity<?> createAerolinea(Aerolinea aerolinea) {
        return null;
    }

    // TODO: Implementar endpoint PUT /airlines/{airlineId}.
    public ResponseEntity<?> updateAerolinea(Aerolinea aerolinea) {
        return null;
    }

    // TODO: Implementar endpoint DELETE /airlines/{airlineId}.
    public ResponseEntity<?> deleteAerolinea(Aerolinea aerolinea) {
        return null;
    }
}
