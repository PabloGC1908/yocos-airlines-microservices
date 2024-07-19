package com.pgc.vuelo.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "aerodromo")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Aerodromo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_aerolinea")
    private Aerolinea aerolinea;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_avion")
    private Avion avion;
}
