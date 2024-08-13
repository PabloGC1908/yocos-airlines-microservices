package com.pgc.vuelo.service;

import com.pgc.vuelo.exceptions.classes.AeropuertoNotFoundException;
import com.pgc.vuelo.models.Aeropuerto;
import com.pgc.vuelo.repository.AeropuertoRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AeropuertoService {
    private final AeropuertoRepository aeropuertoRepository;

    public AeropuertoService(AeropuertoRepository aeropuertoRepository) {
        this.aeropuertoRepository = aeropuertoRepository;
    }

    public Aeropuerto findAeropuertoById(long id) {
        Optional<Aeropuerto> aeropuerto = aeropuertoRepository.findById(id);

        return aeropuerto.orElseThrow(() -> new AeropuertoNotFoundException("Aeropuerto con id: " + id + " no existe"));
    }
}
