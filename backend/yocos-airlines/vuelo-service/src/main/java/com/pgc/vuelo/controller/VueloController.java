package com.pgc.vuelo.controller;

import com.pgc.vuelo.dto.request.VueloRequest;
import com.pgc.vuelo.service.VueloService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/flights")
public class VueloController {

    @GetMapping
    public ResponseEntity<?> getVuelos() {
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    // TODO: Implementar endpoint GET /flights/{flightId}.
    @GetMapping("/{flightId}")
    public ResponseEntity<?> getVueloById(@PathVariable(name = "flightId") Integer id) {
        return null;
    }

    // TODO: Implementar endpoint POST /flights para añadir un vuelo.
    @PostMapping
    public ResponseEntity<?> createVuelo(VueloRequest vueloRequest) {
        return null;
    }
}
