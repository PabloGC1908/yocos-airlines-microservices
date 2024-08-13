package com.pgc.vuelo.repository;

import com.pgc.vuelo.dto.response.AeropuertoResponse;
import com.pgc.vuelo.models.Aeropuerto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AeropuertoRepository extends JpaRepository<Aeropuerto, Long> {

    // TODO: Arreglar el error de este query, que a pesar que funcione, bota errores en el IDE
    @Query(value = " SELECT new com.pgc.vuelo.dto.response.AeropuertoResponse(a.id, a.aeropuerto, " +
            "new com.pgc.vuelo.dto.response.CiudadResponse(c.id, c.ciudad), a.x, a.y, a.zonaHoraria) " +
            "FROM Aeropuerto a JOIN a.ciudad c")
    List<AeropuertoResponse> findAllAeropuertoResponse();
}
