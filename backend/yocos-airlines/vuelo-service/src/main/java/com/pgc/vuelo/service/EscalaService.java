package com.pgc.vuelo.service;

import com.pgc.vuelo.dto.request.EscalaRequest;
import com.pgc.vuelo.models.Aeropuerto;
import com.pgc.vuelo.models.Avion;
import com.pgc.vuelo.models.Escala;
import com.pgc.vuelo.models.Vuelo;
import com.pgc.vuelo.repository.EscalaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EscalaService {
    private final AeropuertoService aeropuertoService;
    private final AvionService avionService;

    private final EscalaRepository escalaRepository;

    public EscalaService(AeropuertoService aeropuertoService,
                         AvionService avionService,
                         EscalaRepository escalaRepository) {
        this.aeropuertoService = aeropuertoService;
        this.avionService = avionService;
        this.escalaRepository = escalaRepository;
    }

    @Transactional
    public void registerEscala(Vuelo vuelo, List<EscalaRequest> escalasRequest) {
        escalasRequest.forEach(escalaRequest -> {
            Aeropuerto aeropuertoEmbarque = aeropuertoService.findAeropuertoById(escalaRequest.idAeropuertoEmbarque());
            Aeropuerto aeropuertoDestino = aeropuertoService.findAeropuertoById(escalaRequest.idAeropuertoDestino());
            Avion avion = avionService.findAvionById(escalaRequest.idAvion());

            Escala escala = Escala.builder()
                    .vuelo(vuelo)
                    .aeropuertoEmbarque(aeropuertoEmbarque)
                    .aeropuertoDestino(aeropuertoDestino)
                    .avion(avion)
                    .fechaEmbarque(escalaRequest.fechaEmbarque())
                    .fechaDestino(escalaRequest.fechaDestino())
                    .build();

            escalaRepository.save(escala);
        });
    }
}
