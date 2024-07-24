package com.pgc.usuario.dto.request;

import java.time.LocalDate;

public record UsuarioFormRequest(
        String nombre,
        String apellido,
        Integer dni,
        LocalDate fechaNacimiento,
        String nacionalidad,
        String direccion,
        String telefono,
        String email,
        String contrasenia
) {
}
