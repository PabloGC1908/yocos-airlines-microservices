package com.pgc.vuelo.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Builder
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
