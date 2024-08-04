package com.pgc.vuelo.service;

import com.pgc.vuelo.dto.response.AerolineaResponse;
import com.pgc.vuelo.models.Aerolinea;
import com.pgc.vuelo.repository.AerolineaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AerolineaService {
    private final AerolineaRepository aerolineaRepository;

    public AerolineaService(AerolineaRepository aerolineaRepository) {
        this.aerolineaRepository = aerolineaRepository;
    }

    public List<AerolineaResponse> findAll() {
        return aerolineaRepository.findAllAerolineas();
    }
}
