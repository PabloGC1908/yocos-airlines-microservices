package com.pgc.vuelo.dto.request;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public record VueloRequest(
        @NotNull(message = "El numero de asientos no debe ser nulo")
        Integer asientosTotales,

        Long idVueloIda,

        @NotNull(message = "El vuelo debe de tener una aerolinea asociada")
        Long idAerolinea,

        @NotNull(message = "La ciudad de origen no puede ser nulo")
        Long idCiudadOrigen,

        @NotNull(message = "La ciudad de destino no puede ser nulo")
        Long idCiudadDestino,

        @NotNull(message = "El vuelo debe de tener precio de los asientos")
        @Valid
        List<AsientoRequest> precioAsientos,

        @NotNull(message = "Debe de tener al menos una escala")
        @Valid
        List<EscalaRequest> escalas
) {
}
