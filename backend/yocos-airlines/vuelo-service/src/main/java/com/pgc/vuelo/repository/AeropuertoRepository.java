package com.pgc.vuelo.repository;

import com.pgc.vuelo.models.Aeropuerto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AeropuertoRepository extends JpaRepository<Aeropuerto, Long> {
}
