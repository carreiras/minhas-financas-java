package com.carreiras.minhasfinancas.service;

import com.carreiras.minhasfinancas.exception.RegraNegocioException;
import com.carreiras.minhasfinancas.model.repository.UsuarioRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("test")
public class UsuarioServiceTest {

    @Autowired
    UsuarioService usuarioService;

    @MockBean
    UsuarioRepository usuarioRepository;

    @Test
    public void deveValidarEmail() {
        Mockito.when(usuarioRepository.existsByEmail(Mockito.anyString())).thenReturn(false);

        usuarioService.validarEmail("usuario@email.com");
    }

    @Test()
    public void deveLancarErroAoValidarEmailQuandoExistirEmailCadastrado() {
        Mockito.when(usuarioRepository.existsByEmail(Mockito.anyString())).thenReturn(true);

        Throwable erroValidacaoEmail = Assertions
                .catchThrowable(() -> usuarioService.validarEmail("usuario@email.com"));

        Assertions.assertThat(erroValidacaoEmail)
                .isInstanceOf(RegraNegocioException.class)
                .hasMessage("Já existe um usuário cadastrado com este e-mail.");
    }
}
