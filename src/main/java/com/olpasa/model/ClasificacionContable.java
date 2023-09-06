package com.olpasa.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "clasificacion_contable")
public class ClasificacionContable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_clasificacion")
	private Integer id_clasificacion;
	
	@Column(name = "descripcion")
	private String descripcion;

	public Integer getId_clasificacion() {
		return id_clasificacion;
	}

	public void setId_clasificacion(Integer id_clasificacion) {
		this.id_clasificacion = id_clasificacion;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
	
}
