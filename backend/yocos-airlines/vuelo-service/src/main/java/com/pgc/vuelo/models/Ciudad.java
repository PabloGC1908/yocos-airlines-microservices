package com.pgc.vuelo.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "ciudad")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Ciudad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ciudad")
    private String ciudad;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_pais")
    private Pais pais;

    @OneToMany(mappedBy = "ciudad", fetch = FetchType.LAZY)
    private List<Aeropuerto> aeropuertos;

    @OneToMany(mappedBy = "ciudadDestino")
    private List<Vuelo> vuelosCiudadDestino;

    @OneToMany(mappedBy = "ciudadEmbarque")
    private List<Vuelo> vuelosCiudadEmbarque;
}