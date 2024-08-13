package com.pgc.vuelo.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "vuelo")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Vuelo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "asientos_totales", nullable = false)
    private Integer asientosTotales;

    @Column(name = "asientos_disponibles", nullable = false)
    private Integer asientosDisponibles;

    @Column(name = "estado_vuelo", nullable = false)
    @Enumerated(EnumType.STRING)
    private EstadoVuelo estadoVuelo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_aerolinea")
    private Aerolinea aerolinea;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_ciudad_embarque", nullable = false)
    private Ciudad ciudadEmbarque;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_ciudad_destino", nullable = false)
    private Ciudad ciudadDestino;

    @OneToMany(mappedBy = "vuelo", fetch = FetchType.EAGER)
    private List<Asiento> asientos;

    @OneToMany(mappedBy = "vuelo", fetch = FetchType.EAGER)
    private List<Escala> escalas;

    @OneToOne
    @JoinColumn(name = "id_vuelo_ida")
    private Vuelo vueloIda;
}
