package com.pgc.vuelo.controller;

import com.pgc.vuelo.dto.request.AerolineaRequest;
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

    @GetMapping
    public ResponseEntity<List<AerolineaResponse>> getAerolineas() {
        List<AerolineaResponse> aerolineas = aerolineaService.findAllAerolineas();

        if (aerolineas.isEmpty())
            return new ResponseEntity<>(aerolineas, HttpStatus.NO_CONTENT);

        return new ResponseEntity<>(aerolineas, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AerolineaResponse> getAerolinea(@PathVariable(name = "id") Integer id) {
        return new ResponseEntity<>(aerolineaService.findAerolineaById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> createAerolinea(@RequestBody AerolineaRequest aerolineaRequest) {
        String response = aerolineaService.registerAerolinea(aerolineaRequest);

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateAerolinea(@PathVariable(name = "id") Integer id, @RequestBody AerolineaRequest aerolineaRequest) {
        String response = aerolineaService.updateAerolinea(id, aerolineaRequest);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAerolinea(@PathVariable("id") Integer id) {
        aerolineaService.deleteAerolinea(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
