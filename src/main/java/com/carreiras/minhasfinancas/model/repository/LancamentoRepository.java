package com.carreiras.minhasfinancas.model.repository;

import com.carreiras.minhasfinancas.model.entity.Lancamento;

import org.springframework.data.jpa.repository.JpaRepository;

public interface LancamentoRepository extends JpaRepository<Lancamento, Long>{
    
}
