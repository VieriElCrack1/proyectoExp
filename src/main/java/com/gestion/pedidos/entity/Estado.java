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
@Table(name = "tb_estado")
public class Estado {
	@Id
	private Integer idestado;
	private String descrip;
	
	@OneToMany(mappedBy = "est")
	@JsonIgnore
	private List<Pedidos> lstPedidos;
}
