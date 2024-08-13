package com.pgc.vuelo.service;

import com.pgc.vuelo.dto.request.AeropuertoRequest;
import com.pgc.vuelo.dto.response.AeropuertoResponse;
import com.pgc.vuelo.dto.response.CiudadResponse;
import com.pgc.vuelo.exceptions.classes.AeropuertoNotFoundException;
import com.pgc.vuelo.models.Aeropuerto;
import com.pgc.vuelo.models.Ciudad;
import com.pgc.vuelo.repository.AeropuertoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class AeropuertoService {
    private final CiudadService ciudadService;

    private final AeropuertoRepository aeropuertoRepository;

    public AeropuertoService(CiudadService ciudadService,
                             AeropuertoRepository aeropuertoRepository) {
        this.ciudadService = ciudadService;
        this.aeropuertoRepository = aeropuertoRepository;
    }

    public List<AeropuertoResponse> getAeropuertos() {
        return aeropuertoRepository.findAllAeropuertoResponse();
    }

    @Transactional
    public String registerAeropuerto(AeropuertoRequest aeropuertoRequest) {
        Ciudad ciudad = ciudadService.findCiudadById(aeropuertoRequest.idCiudad());

        Aeropuerto aeropuerto = Aeropuerto.builder()
                .aeropuerto(aeropuertoRequest.nombreAeropuerto())
                .ciudad(ciudad)
                .x(aeropuertoRequest.x())
                .y(aeropuertoRequest.y())
                .zonaHoraria(aeropuertoRequest.zonaHoraria())
                .build();

        aeropuertoRepository.save(aeropuerto);

        return "Se registro el aeropuerto exitosamente";
    }


    public String deleteAeropuerto(long id) {
        aeropuertoRepository.deleteById(id);

        return "Se elimino el aeropuerto exitosamente";
    }

    public Aeropuerto findAeropuertoById(long id) {
        Optional<Aeropuerto> aeropuerto = aeropuertoRepository.findById(id);

        return aeropuerto.orElseThrow(() -> new AeropuertoNotFoundException("Aeropuerto con id: " + id + " no existe"));
    }
}
