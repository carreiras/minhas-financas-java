package com.carreiras.minhasfinancas.repository;

import com.carreiras.minhasfinancas.model.entity.Usuario;
import com.carreiras.minhasfinancas.model.repository.UsuarioRepository;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class UsuarioRepositoryTest {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Test
    public void deveVerificarAExistenciaDeUmEmail() {
        Usuario usuario = Usuario.builder()
                .nome("Usuário")
                .email("usuario@email.com")
                .build();
        usuarioRepository.save(usuario);

        boolean result = usuarioRepository.existsByEmail("usuario@email.com");

        Assertions.assertThat(result).isTrue();
    }
}
