package com.pgc.usuario.dto.request;

import java.time.LocalDate;

public record UsuarioUpdateRequest(
        String nombre,
        String apellido,
        String telefono,
        Integer dni,
        LocalDate fechaNacimiento,
        String nacionalidad,
        String direccion
) {
}
