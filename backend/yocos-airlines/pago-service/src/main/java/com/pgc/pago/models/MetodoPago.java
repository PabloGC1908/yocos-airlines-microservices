package com.pgc.pago.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "metodo_pago")
public class MetodoPago {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nombre_tarjeta", nullable = false)
    private String nombreTarjeta;

    @Column(name = "numero_tarjeta", nullable = false)
    private String numeroTarjeta;

    @Column(name = "anio_expiracion", nullable = false)
    private String anioExpiracion;

    @Column(name = "mes_expiracion", nullable = false)
    private String mesExpiracion;

    @Column(name = "cvv", nullable = false)
    private Integer cvv;

    @Enumerated(EnumType.STRING)
    @Column(name = "proveedor", nullable = false)
    private Proveedor proveedor;

    @Column(name = "id_usuario")
    private Integer idUsuario;

    @OneToMany(mappedBy = "metodoPago", fetch = FetchType.LAZY)
    private List<Pago> pagos = new ArrayList<>();
}
