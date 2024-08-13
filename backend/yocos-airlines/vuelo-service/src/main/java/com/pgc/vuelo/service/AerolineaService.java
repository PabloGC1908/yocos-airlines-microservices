package com.pgc.vuelo.service;

import com.pgc.vuelo.dto.request.AerolineaRequest;
import com.pgc.vuelo.dto.response.AerolineaResponse;
import com.pgc.vuelo.exceptions.classes.AerolineaNotFoundException;
import com.pgc.vuelo.models.Aerolinea;
import com.pgc.vuelo.repository.AerolineaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class AerolineaService {
    private final AerolineaRepository aerolineaRepository;

    public AerolineaService(AerolineaRepository aerolineaRepository) {
        this.aerolineaRepository = aerolineaRepository;
    }

    public List<AerolineaResponse> findAllAerolineas() {
        return aerolineaRepository.findAllAerolineas();
    }

    public AerolineaResponse findAerolineaResponseById(long id) {
        Optional<AerolineaResponse> aerolinea = Optional.ofNullable(aerolineaRepository.findAerolineaById(id));

        if(aerolinea.isEmpty())
            throw new AerolineaNotFoundException("Aerolinea con id " + id + " no encontrada");

        return aerolinea.get();
    }

    public Aerolinea findAerolineaById(long id) {
        Optional<Aerolinea> aerolinea = aerolineaRepository.findById(id);

        return aerolinea.orElseThrow(() ->
                new AerolineaNotFoundException("Aerolinea con id " + id + " no encontrado."));
    }

    @Transactional
    public String registerAerolinea(AerolineaRequest aerolineaRequest) {
        Aerolinea aerolinea = Aerolinea.builder()
                .aerolinea(aerolineaRequest.aerolinea())
                .build();

        aerolineaRepository.save(aerolinea);

        return "Se registro la aerolinea " + aerolinea.getAerolinea();
    }

    @Transactional
    public String updateAerolinea(long id, AerolineaRequest aerolineaRequest) {
        Optional<Aerolinea> aerolineaOptional = aerolineaRepository.findById(id);

        if (aerolineaOptional.isEmpty())
            throw new AerolineaNotFoundException("Aerolinea " + id + " no encontrada");

        Aerolinea aerolinea = aerolineaOptional.get();

        aerolinea.setAerolinea(aerolineaRequest.aerolinea());

        return "Se actualizo la aerolinea con id " + id + " a nombre: " + aerolinea.getAerolinea();
    }

    @Transactional
    public void deleteAerolinea(long id) {
        Optional<Aerolinea> aerolineaOptional = aerolineaRepository.findById(id);

        if (aerolineaOptional.isEmpty())
            throw new AerolineaNotFoundException("Aerolinea " + id + " no encontrada");

        aerolineaRepository.delete(aerolineaOptional.get());
    }
}