package com.olpasa.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "unidad_medida")
public class UnidadMedida {

	@Id
	@Column(name = "codigo_um", length = 10)
	private String codigo_um;
	
	@Column(name = "descripcion")
	private String descripcion;
	
	@Column(name = "codigo_onu")
	private String codigo_onu;
	
	@Column(name = "codigo_sunat")
	private String codigo_sunat;

	public String getCodigo_um() {
		return codigo_um;
	}

	public void setCodigo_um(String codigo_um) {
		this.codigo_um = codigo_um;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getCodigo_onu() {
		return codigo_onu;
	}

	public void setCodigo_onu(String codigo_onu) {
		this.codigo_onu = codigo_onu;
	}

	public String getCodigo_sunat() {
		return codigo_sunat;
	}

	public void setCodigo_sunat(String codigo_sunat) {
		this.codigo_sunat = codigo_sunat;
	}
	
	
	
	
	
	
}
