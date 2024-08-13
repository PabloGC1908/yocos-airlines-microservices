package com.pgc.vuelo.dto.request;

import com.pgc.vuelo.models.ClaseAsiento;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record AsientoRequest(
    @NotNull(message = "La clase del asiento no debe ser nulo")
    ClaseAsiento claseAsiento,

    @NotNull(message = "La cantidad de asientos no debe ser nulo")
    Integer cantidadAsientos,

    @NotNull(message = "El precio del asiento no debe ser nulo")
    @Min(value = 0, message = "El precio del asiento no puede ser negativo")
    BigDecimal precio
) {
}
