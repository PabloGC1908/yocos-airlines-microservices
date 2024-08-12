package com.pgc.vuelo.dto.request;

import com.pgc.vuelo.models.ClaseAsiento;

import java.math.BigDecimal;

public record PrecioAsientosRequest(
    ClaseAsiento claseAsiento,
    Integer cantidadAsientos,
    BigDecimal precio
) {
}
