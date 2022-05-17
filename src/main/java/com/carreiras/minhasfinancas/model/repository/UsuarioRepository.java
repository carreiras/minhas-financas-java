package com.carreiras.minhasfinancas.model.repository;

import com.carreiras.minhasfinancas.model.entity.Usuario;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
    
}
