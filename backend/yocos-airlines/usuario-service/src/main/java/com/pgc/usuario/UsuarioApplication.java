package com.pgc.usuario;


import com.pgc.usuario.repository.UsuarioRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class UsuarioApplication {
    public static void main(String[] args) {
        SpringApplication.run(UsuarioApplication.class, args);
    }

    CommandLineRunner init(UsuarioRepository repository) {
        return args -> {

        };
    }
}