package com.carreiras.minhasfinancas.service.impl;

import java.util.Optional;

import com.carreiras.minhasfinancas.exception.ErroAutenticacao;
import com.carreiras.minhasfinancas.exception.RegraNegocioException;
import com.carreiras.minhasfinancas.model.entity.Usuario;
import com.carreiras.minhasfinancas.model.repository.UsuarioRepository;
import com.carreiras.minhasfinancas.service.UsuarioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public Usuario autenticar(String email, String senha) {
        Optional<Usuario> usuario = usuarioRepository.findByEmail(email);

        if (!usuario.isEmpty())
            throw new ErroAutenticacao("Usuário não encontrado.");

        if (!usuario.get().getSenha().equals(senha))
            throw new ErroAutenticacao("Senha inválida.");

        return usuario.get();
    }

    @Override
    public Usuario salvarUsuario(Usuario usuario) {
        validarEmail(usuario.getEmail());
        return usuarioRepository.save(usuario);
    }

    @Override
    public void validarEmail(String email) {
        boolean existe = usuarioRepository.existsByEmail(email);

        if (existe)
            throw new RegraNegocioException("Já existe um usuário cadastrado com este e-mail.");
    }
}
