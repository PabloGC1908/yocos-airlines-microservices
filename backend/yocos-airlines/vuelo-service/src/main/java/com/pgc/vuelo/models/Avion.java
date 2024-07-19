package com.pgc.vuelo.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "avion")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Avion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String avion;

    @OneToMany(mappedBy = "avion")
    private List<Aerodromo> aerodromos;

    @OneToMany(mappedBy = "avion")
    private List<Escala> escalas;
}
