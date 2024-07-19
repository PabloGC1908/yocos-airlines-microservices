package com.pgc.vuelo.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "vuelo")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Vuelo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "asientos_disponibles")
    private Integer asientosDisponibles;

    @Column(name = "estado_vuelo")
    @Enumerated(EnumType.STRING)
    private EstadoVuelo estadoVuelo;

    @Column(name = "es_viaje_ida")
    private Boolean esViajeIda;

    @OneToMany(mappedBy = "vuelo", fetch = FetchType.EAGER)
    private List<PrecioAsiento> preciosAsientos;

    @OneToMany(mappedBy = "vuelo", fetch = FetchType.EAGER)
    private List<Escala> escalas;
}
