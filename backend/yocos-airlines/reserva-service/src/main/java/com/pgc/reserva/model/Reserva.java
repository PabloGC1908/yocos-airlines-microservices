package com.pgc.reserva.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.OffsetDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Reserva {
    @Id
    private Integer id;
    private OffsetDateTime fechaReserva;
    private String estadoReserva;
    private Float montoTotal;
}
