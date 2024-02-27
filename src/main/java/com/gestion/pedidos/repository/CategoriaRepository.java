package com.gestion.pedidos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gestion.pedidos.entity.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Integer>{

}
