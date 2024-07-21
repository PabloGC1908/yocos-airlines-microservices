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
@Table(name = "reembolso")
public class Reembolso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_pago")
    private Pago pago;

    @Column(name = "monto_reembolsado", nullable = false, precision = 12, scale = 4)
    private BigDecimal montoReembolsado;

    @Column(name = "tipo_moneda", nullable = false)
    private Moneda tipoMoneda;

    @Column(name = "estado_reembolso", nullable = false)
    private EstadoReembolso estadoReembolso;

    @Column(name = "fecha_reembolso", columnDefinition = "TIMESTAMP WITH TIME ZONE", nullable = false)
    private OffsetDateTime fechaReembolso;
}
