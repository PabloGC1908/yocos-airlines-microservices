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
    private Ciudad paisEmbarque;

    @ManyToOne(fetch = FetchType.LAZY)
    private Ciudad paisDestino;

    @OneToMany(mappedBy = "vuelo", fetch = FetchType.EAGER)
    private List<PrecioAsiento> preciosAsientos;

    @OneToMany(mappedBy = "vuelo", fetch = FetchType.EAGER)
    private List<Escala> escalas;

    @OneToOne
    @JoinColumn(name = "id_vuelo_ida")
    private Vuelo vueloIda;
}
