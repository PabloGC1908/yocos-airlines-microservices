package com.pgc.vuelo.service;

import com.pgc.vuelo.exceptions.classes.CiudadNotFoundException;
import com.pgc.vuelo.models.Ciudad;
import com.pgc.vuelo.repository.CiudadRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CiudadService {
    private final CiudadRepository ciudadRepository;

    public CiudadService(CiudadRepository ciudadRepository) {
        this.ciudadRepository = ciudadRepository;
    }

    public Ciudad findCiudadById(long id) {
        Optional<Ciudad> ciudad = ciudadRepository.findById(id);

        return ciudad.orElseThrow(() ->
                new CiudadNotFoundException("Ciudad con id " + id + " no encontrado"));
    }
}
