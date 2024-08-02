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
public class Aeropuerto {
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

    @OneToMany(mappedBy = "aeropuertoEmbarque")
    private List<Escala> escalas_embarque;

    @OneToMany(mappedBy = "aeropuertoDestino")
    private List<Escala> escalas_destino;

    @OneToMany(mappedBy = "aeropuerto")
    private List<Aerodromo> aerodromos;

}
