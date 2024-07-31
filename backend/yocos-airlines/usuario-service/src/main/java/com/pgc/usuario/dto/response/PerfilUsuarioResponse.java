package com.pgc.usuario.dto.response;

import java.time.LocalDate;

public record PerfilUsuarioResponse (
        String nombre,
        String apellido,
        String email,
        String telefono,
        Integer dni,
        LocalDate fechaNacimiento,
        String nacionalidad,
        String direccion
) {
}