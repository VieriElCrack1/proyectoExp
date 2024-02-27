package com.gestion.pedidos.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "tb_categoria")
public class Categoria {
	@Id
	private Integer idcategoria;
	private String nomcategoria;
	
	@OneToMany(mappedBy = "cat")
	@JsonIgnore
	private List<Pedidos> lstPedidos;
}
