package com.pgc.vuelo.repository;

import com.pgc.vuelo.models.Asiento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AsientoRepository extends JpaRepository<Asiento, Long> {
}
