package com.pgc.vuelo.controller;

import com.pgc.vuelo.dto.response.AerolineaResponse;
import com.pgc.vuelo.models.Aerolinea;
import com.pgc.vuelo.service.AerolineaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/airlines")
public class AerolineaController {
    private final AerolineaService aerolineaService;

    public AerolineaController(AerolineaService aerolineaService) {
        this.aerolineaService = aerolineaService;
    }

    // TODO: Implementar endpoint GET /airlines.
    @GetMapping
    public ResponseEntity<List<AerolineaResponse>> getAerolineas() {
        List<AerolineaResponse> aerolineas = aerolineaService.findAll();

        if (aerolineas.isEmpty())
            return new ResponseEntity<>(aerolineas, HttpStatus.NO_CONTENT);

        return new ResponseEntity<>(aerolineas, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getAerolinea(@PathVariable Long id) {
        List<Aerolinea> aerolineas = null;

        return null;
    }

    // TODO: Implementar endpoint POST /airlines.
    @PostMapping
    public ResponseEntity<?> createAerolinea(Aerolinea aerolinea) {
        return null;
    }

    // TODO: Implementar endpoint PUT /airlines/{airlineId}.
    @PutMapping("/{id}")
    public ResponseEntity<?> updateAerolinea(@PathVariable Long id, Aerolinea aerolinea) {
        return null;
    }

    // TODO: Implementar endpoint DELETE /airlines/{airlineId}.
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteAerolinea(@PathVariable Long id) {
        return null;
    }
}
