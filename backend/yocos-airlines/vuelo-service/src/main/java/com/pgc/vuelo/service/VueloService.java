package com.pgc.vuelo.service;

import com.pgc.vuelo.dto.request.VueloRequest;
import com.pgc.vuelo.exceptions.classes.VueloNotFoundException;
import com.pgc.vuelo.models.Aerolinea;
import com.pgc.vuelo.models.Ciudad;
import com.pgc.vuelo.models.EstadoVuelo;
import com.pgc.vuelo.models.Vuelo;
import com.pgc.vuelo.repository.VueloRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class VueloService {
    private final CiudadService ciudadService;
    private final AerolineaService aerolineaService;
    private final AsientoService asientoService;
    private final EscalaService escalaService;

    private final VueloRepository vueloRepository;

    public VueloService(CiudadService ciudadService,
                        AerolineaService aerolineaService,
                        AsientoService asientoService, EscalaService escalaService,
                        VueloRepository vueloRepository) {
        this.ciudadService = ciudadService;
        this.aerolineaService = aerolineaService;
        this.asientoService = asientoService;
        this.escalaService = escalaService;
        this.vueloRepository = vueloRepository;
    }

    public Vuelo findVueloById(long id) {
        Optional<Vuelo> vuelo = vueloRepository.findById(id);

        return vuelo.orElseThrow(() -> new VueloNotFoundException("Vuelo con id " + id + " no encontrado"));
    }

    @Transactional
    public String registerVuelo(VueloRequest vueloRequest) {
        Ciudad ciudadOrigen = ciudadService.findCiudadById(vueloRequest.idCiudadOrigen());
        Ciudad ciudadDestino = ciudadService.findCiudadById(vueloRequest.idCiudadDestino());
        Aerolinea aerolinea = aerolineaService.findAerolineaById(vueloRequest.idAerolinea());

        Vuelo vuelo = Vuelo.builder()
                .asientosTotales(vueloRequest.asientosTotales())
                .asientosDisponibles(vueloRequest.asientosTotales())
                .estadoVuelo(EstadoVuelo.PROGRAMADO)
                .aerolinea(aerolinea)
                .ciudadEmbarque(ciudadOrigen)
                .ciudadDestino(ciudadDestino)
                .build();

        if (vueloRequest.idVueloIda() != null) {
            Optional<Vuelo> vueloIda = vueloRepository.findById(vueloRequest.idVueloIda());
            vueloIda.ifPresent(vuelo::setVueloIda);
        }
        vuelo.setVueloIda(null);

        Vuelo vueloRegistrado = vueloRepository.save(vuelo);

        asientoService.registerAsiento(vueloRegistrado, vueloRequest.precioAsientos());
        escalaService.registerEscala(vueloRegistrado, vueloRequest.escalas());

        return "Vuelo registrado correctamente";
    }
}
