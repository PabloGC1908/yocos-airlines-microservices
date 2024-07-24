package com.pgc.usuario.service;

import com.pgc.usuario.exceptions.classes.RolNotFoundException;
import com.pgc.usuario.model.Rol;
import com.pgc.usuario.repository.RolRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RolService {
    private final RolRepository rolRepository;

    public RolService(RolRepository rolRepository) {
        this.rolRepository = rolRepository;
    }

    public boolean saveRol(Rol rol) {
        Rol savedRol = rolRepository.save(rol);

        return rolRepository.findById(savedRol.getId()).isPresent();
    }

    public List<Rol> findAllRoles() {
        return rolRepository.findAll();
    }

    public Rol findById(Integer id) {
        Optional<Rol> rol = rolRepository.findById(id);

        return rol.orElseThrow(()
                -> new RolNotFoundException("No se pudo encontrar el rol con id: ".concat(id.toString())));
    }
}
