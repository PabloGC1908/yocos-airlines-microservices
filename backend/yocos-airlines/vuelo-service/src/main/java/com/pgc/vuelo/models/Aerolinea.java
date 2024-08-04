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

    @Column(name = "aerolinea", nullable = false, unique = true)
    private String aerolinea;

    @OneToMany(mappedBy = "aerolinea", fetch = FetchType.LAZY)
    private List<Vuelo> vuelos;
}
