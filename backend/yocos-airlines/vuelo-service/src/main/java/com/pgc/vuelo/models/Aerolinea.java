package com.pgc.vuelo.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "aerolinea")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Aerolinea {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String aerolinea;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_ciudad")
    private Ciudad ciudad;

    private Float x;

    private Float y;

    @Column(name = "zona_horaria")
    private String zonaHoraria;

    @OneToMany(mappedBy = "aerolineaEmbarque")
    private List<Escala> escalas_embarque;

    @OneToMany(mappedBy = "aerolineaDestino")
    private List<Escala> escalas_destino;

}
