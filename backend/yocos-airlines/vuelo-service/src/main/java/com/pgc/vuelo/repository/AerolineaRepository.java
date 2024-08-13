package com.pgc.vuelo.repository;

import com.pgc.vuelo.dto.response.AerolineaResponse;
import com.pgc.vuelo.models.Aerolinea;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AerolineaRepository extends JpaRepository<Aerolinea, Long> {

    @Query("SELECT new com.pgc.vuelo.dto.response.AerolineaResponse(a.id, a.aerolinea) FROM Aerolinea a")
    List<AerolineaResponse> findAllAerolineas();

    @Query("SELECT new com.pgc.vuelo.dto.response.AerolineaResponse(a.id, a.aerolinea) FROM Aerolinea a WHERE a.id=:id")
    AerolineaResponse findAerolineaById(@Param("id") long id);
}
