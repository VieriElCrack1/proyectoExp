package com.gestion.pedidos.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "tb_pedidos")
public class Pedidos {
	@Id
	private Integer idpedido;
	private String nompedido;
	private int idcategoria;
	private String fechaPedido;
	private int idestado;
	
	@ManyToOne
	@JoinColumn(name = "idcategoria", insertable = false, updatable = false)
	@JsonIgnore
	private Categoria cat;
	
	@ManyToOne
	@JoinColumn(name = "idestado", insertable = false, updatable = false)
	@JsonIgnore
	private Estado est;
}
