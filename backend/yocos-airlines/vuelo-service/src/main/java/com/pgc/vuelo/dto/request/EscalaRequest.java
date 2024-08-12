package com.pgc.vuelo.dto.request;

import java.time.OffsetDateTime;

public record EscalaRequest(
    Integer idAerolineaEmbarque,
    Integer idAerolineaDestino,
    Integer idAvion,
    OffsetDateTime fechaEmbarque,
    OffsetDateTime fechaDestino
) {
}
