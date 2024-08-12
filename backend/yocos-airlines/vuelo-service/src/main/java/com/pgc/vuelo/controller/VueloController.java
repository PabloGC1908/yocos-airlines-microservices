package com.pgc.vuelo.controller;

import com.pgc.vuelo.dto.request.FormularioVueloRequest;
import com.pgc.vuelo.models.Vuelo;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/flights")
public class VueloController {

    // TODO: Implementar endpoint GET /flights/search.
    public ResponseEntity<?> getVuelos() {
        return null;
    }

    // TODO: Implementar endpoint GET /flights/{flightId}.
    public ResponseEntity<?> getVueloById(Integer id) {
        return null;
    }

    // TODO: Implementar endpoint POST /flights para añadir un vuelo.
    public ResponseEntity<?> createVuelo(FormularioVueloRequest formularioVuelo) {
        return null;
    }
}
