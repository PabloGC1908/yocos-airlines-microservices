package com.pgc.vuelo.service;

import com.pgc.vuelo.dto.request.VueloRequest;
import com.pgc.vuelo.models.Vuelo;
import com.pgc.vuelo.repository.VueloRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VueloService {
    private final VueloRepository vueloRepository;

    public VueloService(VueloRepository vueloRepository) {
        this.vueloRepository = vueloRepository;
    }

    @Transactional
    public void saveVuelo(VueloRequest vueloRequest) {

    }
}
