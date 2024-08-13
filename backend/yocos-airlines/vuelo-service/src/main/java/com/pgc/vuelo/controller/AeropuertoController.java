package com.pgc.vuelo.controller;

import com.pgc.vuelo.dto.request.AeropuertoRequest;
import com.pgc.vuelo.models.Aeropuerto;
import com.pgc.vuelo.service.AeropuertoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/airports")
public class AeropuertoController {
    private final AeropuertoService aeropuertoService;

    public AeropuertoController(AeropuertoService aeropuertoService) {
        this.aeropuertoService = aeropuertoService;
    }



    // TODO: Implementar endpoint POST /airports.
    @PostMapping
    public ResponseEntity<String> createAeropuerto(AeropuertoRequest aeropuertoRequest) {
        String response = aeropuertoService.registerAeropuerto(aeropuertoRequest);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    // TODO: Implementar endpoint DELETE /airports/{airportId}.
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteAeropuerto(@PathVariable("id") Long id) {
        return null;
    }
}
