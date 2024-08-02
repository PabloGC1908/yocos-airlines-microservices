package com.pgc.vuelo.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.OffsetDateTime;

@Entity
@Table(name = "escala")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Escala {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_aerolinea_embarque", nullable = false)
    private Aeropuerto aeropuertoEmbarque;

    @ManyToOne
    @JoinColumn(name = "id_aerolinea_destino", nullable = false)
    private Aeropuerto aeropuertoDestino;

    @ManyToOne
    @JoinColumn(name = "id_avion", nullable = false)
    private Avion avion;

    @ManyToOne
    @JoinColumn(name = "id_vuelo", nullable = false)
    private Vuelo vuelo;

    @Column(name = "fecha_embarque", columnDefinition = "TIMESTAMP WITH TIME ZONE", nullable = false)
    private OffsetDateTime fechaEmbarque;

    @Column(name = "fecha_destino", columnDefinition = "TIMESTAMP WITH TIME ZONE", nullable = false)
    private OffsetDateTime fechaDestino;
}
