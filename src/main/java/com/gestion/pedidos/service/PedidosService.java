package com.gestion.pedidos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestion.pedidos.entity.Categoria;
import com.gestion.pedidos.entity.Estado;
import com.gestion.pedidos.entity.Pedidos;
import com.gestion.pedidos.repository.CategoriaRepository;
import com.gestion.pedidos.repository.EstadoRepository;
import com.gestion.pedidos.repository.PedidoRepository;

@Service
public class PedidosService {
	@Autowired
	private PedidoRepository ser;
	
	@Autowired
	private CategoriaRepository serC;
	
	@Autowired
	private EstadoRepository serE;
	
	public void guardar(Pedidos p) {
		ser.save(p);
	}
	
	public void eliminar(int id) {
		ser.deleteById(id);
	}
	
	public Pedidos buscar(int id) {
		return ser.findById(id).orElse(null);
	}
	
	public List<Pedidos> listadoPedidos() {
		return ser.findAll();
	}
	
	public List<Categoria> categorias() {
		return serC.findAll();
	}
	
	public List<Estado> estados() {
		return serE.findAll();
	}
	
	public int obtenerID() {
		return ser.generarId();
	}
}
