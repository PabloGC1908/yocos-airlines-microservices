package com.pgc.vuelo.service;

import com.pgc.vuelo.dto.request.AsientoRequest;
import com.pgc.vuelo.models.Asiento;
import com.pgc.vuelo.models.Vuelo;
import com.pgc.vuelo.repository.AsientoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AsientoService {
    private final AsientoRepository asientoRepository;

    public AsientoService(AsientoRepository asientoRepository) {
        this.asientoRepository = asientoRepository;
    }

    @Transactional
    public void registerAsiento(Vuelo vuelo, List<AsientoRequest> asientos) {
        asientos.forEach(asientoRequest -> {
            Asiento asiento = Asiento.builder()
                    .vuelo(vuelo)
                    .claseAsiento(asientoRequest.claseAsiento())
                    .precioAsiento(asientoRequest.precio())
                    .cantidadAsientos(asientoRequest.cantidadAsientos())
                    .build();

            asientoRepository.save(asiento);
        });
    }
}
