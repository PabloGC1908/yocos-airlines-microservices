package com.pgc.vuelo.service;

import com.pgc.vuelo.exceptions.classes.AvionNotFoundException;
import com.pgc.vuelo.models.Avion;
import com.pgc.vuelo.repository.AvionRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AvionService {
    private final AvionRepository avionRepository;

    public AvionService(AvionRepository avionRepository) {
        this.avionRepository = avionRepository;
    }

    public Avion findAvionById(long id) {
        Optional<Avion> avion = avionRepository.findById(id);

        return avion.orElseThrow(() -> new AvionNotFoundException("Avion con id " + id + " no encontrado"));
    }
}
