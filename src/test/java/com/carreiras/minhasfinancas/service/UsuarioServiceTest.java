package com.carreiras.minhasfinancas.service;

import com.carreiras.minhasfinancas.exception.RegraNegocioException;
import com.carreiras.minhasfinancas.model.entity.Usuario;
import com.carreiras.minhasfinancas.model.repository.UsuarioRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("test")
public class UsuarioServiceTest {

    @Autowired
    UsuarioService usuarioService;

    @Autowired
    UsuarioRepository usuarioRepository;

    @Test
    public void deveValidarEmail() {
        usuarioRepository.deleteAll();

        usuarioService.validarEmail("usuario@email.com");
    }

    @Test()
    public void deveLancarErroAoValidarEmailQuandoExistirEmailCadastrado() {
        Usuario usuario = Usuario.builder().nome("Usuário").email("usuario@email.com").build();
        usuarioRepository.save(usuario);

        Throwable erroValidacaoEmail = Assertions
                .catchThrowable(() -> usuarioService.validarEmail("usuario@email.com"));

        Assertions.assertThat(erroValidacaoEmail)
                .isInstanceOf(RegraNegocioException.class)
                .hasMessage("Já existe um usuário cadastrado com este e-mail.");
    }
}
