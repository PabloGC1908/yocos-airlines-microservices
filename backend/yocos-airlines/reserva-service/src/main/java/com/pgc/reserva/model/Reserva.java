package com.pgc.reserva.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.OffsetDateTime;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Reserva {
    @Id
    private Integer id;

    @Column(name = "id_pago")
    private Integer idPago;

    @Column(name = "id_usuario")
    private Integer idUsuario;

    @Column(name = "fecha_reserva")
    private OffsetDateTime fechaReserva;

    @Column(name = "estado_reserva")
    private String estadoReserva;

    @Column(name = "monto_total")
    private Float montoTotal;

    @OneToMany(mappedBy = "reserva")
    private List<Asiento> asientos;
}
