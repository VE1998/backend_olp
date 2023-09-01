package com.olpasa.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "sector")
public class Sector {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_sector")
	private Integer id_sector;
	
	@Column(name = "nombre")
	private String nombre;
	
	@Column(name = "codigo_tony")
	private Integer codigo_tony;
	
	@Column(name = "region")
	private String region;

	public Integer getId_sector() {
		return id_sector;
	}

	public void setId_sector(Integer id_sector) {
		this.id_sector = id_sector;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getCodigo_tony() {
		return codigo_tony;
	}

	public void setCodigo_tony(Integer codigo_tony) {
		this.codigo_tony = codigo_tony;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}
	
	
	
	
	
}
