package com.pgc.pago.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "pago")
public class Pago {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "monto", nullable = false, precision = 12, scale = 4)
    private BigDecimal monto;

    @Column(name = "tipo_moneda")
    private Moneda tipoMoneda;

    @Column(name = "estado_pago")
    private EstadoPago estadoPago;

    @Column(name = "fecha_pago", columnDefinition = "TIMESTAMP WITH TIME ZONE")
    private OffsetDateTime fechaPago;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_metodo_pago")
    private MetodoPago metodoPago;

    @OneToOne(fetch = FetchType.EAGER)
    private Reembolso reembolso;
}
