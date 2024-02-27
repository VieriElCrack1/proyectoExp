package com.gestion.pedidos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.gestion.pedidos.entity.Pedidos;

public interface PedidoRepository extends JpaRepository<Pedidos, Integer> {
	@Query("select coalesce(max(p.idpedido), 0) + 1 from Pedidos p")
	int generarId();
}
