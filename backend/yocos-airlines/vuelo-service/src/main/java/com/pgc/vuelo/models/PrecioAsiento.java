package com.pgc.vuelo.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name = "precio_asiento")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PrecioAsiento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_vuelo")
    private Vuelo vuelo;

    @Column(name = "clase_asiento")
    @Enumerated(EnumType.STRING)
    private ClaseAsiento claseAsiento;

    @Column(name = "precio_asiento")
    private BigDecimal precioAsiento;

    @Column(name = "cantidad_asientos")
    private Integer cantidadAsientos;
}
