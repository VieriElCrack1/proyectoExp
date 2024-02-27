package com.gestion.pedidos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.gestion.pedidos.entity.Categoria;
import com.gestion.pedidos.entity.Estado;
import com.gestion.pedidos.entity.Pedidos;
import com.gestion.pedidos.service.PedidosService;

@Controller
public class PedidosController {
	@Autowired
	private PedidosService ser;
	
	@GetMapping("/pedidos/listado")
	public String index(Model model) {
		List<Pedidos> lista = ser.listadoPedidos();
		model.addAttribute("p", lista);
		return "index";
	}
	
	@GetMapping("/pedidos/registrar")
	public String registrar(Model model) {
		List<Categoria> lista1 = ser.categorias();
		model.addAttribute("c", lista1);
		List<Estado> lista2 = ser.estados();
		model.addAttribute("e", lista2);
		int cod = ser.obtenerID();
		model.addAttribute("cod", cod);
		return "registrar";
	}
	
	@PostMapping("/pedidos/registrar")
	public String registrar(@ModelAttribute Pedidos p) {
		ser.guardar(p);
		return "redirect:/pedidos/listado";
	}
	
	@GetMapping("/pedidos/actualizar/{idpedido}")
	public String actualizar(@PathVariable Integer idpedido ,Model model) {
		Pedidos p = ser.buscar(idpedido);
		model.addAttribute("p", p);
		List<Categoria> lista1 = ser.categorias();
		model.addAttribute("c", lista1);
		List<Estado> lista2 = ser.estados();
		model.addAttribute("e", lista2);
		return "actualizar";
	}
	
	@PostMapping("/pedidos/actualizar/{idpedido}")
	public String actualizar(@PathVariable Integer idpedido, @ModelAttribute Pedidos p) {
		Pedidos pd = ser.buscar(idpedido);
		pd.setNompedido(p.getNompedido());
		pd.setIdcategoria(p.getIdcategoria());
		pd.setFechaPedido(p.getFechaPedido());
		pd.setIdestado(p.getIdestado());
		ser.guardar(pd);
		return "redirect:/pedidos/listado";
	}
	
	@GetMapping("/pedidos/eliminar/{idpedido}")
	public String eliminar(@PathVariable Integer idpedido) {
		ser.eliminar(idpedido);
		return "redirect:/pedidos/listado";
	}
}
