package com.pgc.vuelo.dto.request;

import java.util.List;

public record VueloRequest(
        Integer asientosTotales,
        Long idVueloIda,
        Long idAerolinea,
        Long idCiudadOrigen,
        Long idCiudadDestino,
        List<AsientoRequest> precioAsientos,
        List<EscalaRequest> escalas
) {
}
