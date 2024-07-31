package com.pgc.usuario.repository;

import com.pgc.usuario.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Optional<Usuario> findByEmail(String email);

    @Query("SELECT u.id FROM Usuario u WHERE u.email=:email")
    Long findUsuarioByEmail(@Param("email") String email);
}
