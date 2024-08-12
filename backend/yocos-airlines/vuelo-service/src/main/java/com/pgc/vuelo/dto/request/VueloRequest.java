package com.pgc.vuelo.dto.request;

import jakarta.validation.constraints.Null;

import java.util.List;

public record VueloRequest(
        Integer asientosTotales,
        Integer idVueloIda,
        Integer idAerolinea,
        Integer idCiudadOrigen,
        Integer idCiudadDestino,
        List<PrecioAsientosRequest> precioAsientos,
        List<EscalaRequest> escalas
) {
}
