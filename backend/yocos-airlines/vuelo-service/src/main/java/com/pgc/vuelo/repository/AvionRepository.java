package com.pgc.vuelo.repository;

import com.pgc.vuelo.models.Avion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AvionRepository extends JpaRepository<Avion, Long> {
}
