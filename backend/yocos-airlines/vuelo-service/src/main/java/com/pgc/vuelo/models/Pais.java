package com.pgc.vuelo.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "pais")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Pais {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String pais;

    @Column(name = "pais_abrev")
    private String paisAbreviatura;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "pais")
    private List<Ciudad> ciudades;
}
