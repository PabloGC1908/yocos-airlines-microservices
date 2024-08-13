package com.pgc.vuelo.dto.request;

public record AeropuertoRequest (
        String nombreAeropuerto,
        Integer idCiudad,
        Float x,
        Float y,
        String zonaHoraria
) {
}
