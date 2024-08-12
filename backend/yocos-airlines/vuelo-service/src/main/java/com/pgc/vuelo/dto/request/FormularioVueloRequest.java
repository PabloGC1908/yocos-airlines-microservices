package com.pgc.vuelo.dto.request;

public record FormularioVueloRequest (
    Integer asientosDisponibles,
    String estadoVuelo,
    Boolean esViajeIda

) {
}
