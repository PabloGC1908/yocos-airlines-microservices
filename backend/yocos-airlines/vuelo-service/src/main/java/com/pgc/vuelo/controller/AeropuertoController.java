package com.pgc.vuelo.controller;

import com.pgc.vuelo.dto.request.AeropuertoRequest;
import com.pgc.vuelo.dto.response.AeropuertoResponse;
import com.pgc.vuelo.models.Aeropuerto;
import com.pgc.vuelo.service.AeropuertoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/airports")
public class AeropuertoController {
    private final AeropuertoService aeropuertoService;

    public AeropuertoController(AeropuertoService aeropuertoService) {
        this.aeropuertoService = aeropuertoService;
    }

    @GetMapping
    public ResponseEntity<List<AeropuertoResponse>> getAeropuertos() {
        List<AeropuertoResponse> aeropuertos = aeropuertoService.getAeropuertos();

        return new ResponseEntity<>(aeropuertos, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> createAeropuerto(@RequestBody @Valid AeropuertoRequest aeropuertoRequest) {
        String response = aeropuertoService.registerAeropuerto(aeropuertoRequest);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAeropuerto(@PathVariable("id") Long id) {
        if (id == null)
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("id invalido");

        return ResponseEntity.status(HttpStatus.OK).body(aeropuertoService.deleteAeropuerto(id));
    }
}
