package com.pgc.vuelo.models;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name = "asiento")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Asiento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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
