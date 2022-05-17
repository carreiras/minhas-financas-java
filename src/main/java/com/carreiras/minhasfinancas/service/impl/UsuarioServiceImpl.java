package com.carreiras.minhasfinancas.service.impl;

import com.carreiras.minhasfinancas.model.entity.Usuario;
import com.carreiras.minhasfinancas.model.repository.UsuarioRepository;
import com.carreiras.minhasfinancas.service.UsuarioService;

import org.springframework.beans.factory.annotation.Autowired;

public class UsuarioServiceImpl implements UsuarioService{

    @Autowired
    private UsuarioRepository usuarioRepository;
    
    @Override
    public Usuario autenticar(String email, String senha) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Usuario salvarUsuario(Usuario usuario) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void validarEmail(String email) {
        // TODO Auto-generated method stub
        
    }    
}
