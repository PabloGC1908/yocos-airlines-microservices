package com.pgc.vuelo.dto.request;

import java.time.OffsetDateTime;

public record EscalaRequest(
    Integer idAeropuertoEmbarque,
    Integer idAeropuertoDestino,
    Integer idAvion,
    OffsetDateTime fechaEmbarque,
    OffsetDateTime fechaDestino
) {
}
