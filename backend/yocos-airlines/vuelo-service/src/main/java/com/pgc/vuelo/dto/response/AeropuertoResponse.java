package com.pgc.vuelo.dto.response;

public record AeropuertoResponse(
        Long id,
        String nombreAeropuerto,
        CiudadResponse ciudad,
        Float x,
        Float y,
        String zonaHoraria
) {
}
