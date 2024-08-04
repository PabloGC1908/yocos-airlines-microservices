package com.pgc.vuelo.repository;

import com.pgc.vuelo.dto.response.AerolineaResponse;
import com.pgc.vuelo.models.Aerolinea;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AerolineaRepository extends JpaRepository<Aerolinea, Integer> {

    @Query("SELECT new com.pgc.vuelo.dto.response.AerolineaResponse(a.id, a.aerolinea) FROM Aerolinea a")
    List<AerolineaResponse> findAllAerolineas();
}
