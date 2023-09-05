package com.olpasa.model;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "parcela")
public class Parcela {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_parcela")
	private Integer id_parcela;
	
	@ManyToOne
	@JoinColumn(name = "id_sector", nullable = false, foreignKey = @ForeignKey(name = "fk_parcela_sector"))
	private Sector id_sector;
	
	@ManyToOne
	@JoinColumn(name = "codigo", nullable = false, foreignKey = @ForeignKey(name = "fk_parcela_proveedor"))
	private Proveedor codigo;
	
	@Column(name = "descripcion")
	private String descripcion;
	
	@Column(precision = 18, scale = 2, name = "area" )
	private BigDecimal area;
	
	@Column(name = "estado")
	private String estado;
	
	@Column(name = "usuario")
	private String usuario;

	public Integer getId_parcela() {
		return id_parcela;
	}

	public void setId_parcela(Integer id_parcela) {
		this.id_parcela = id_parcela;
	}

	public Sector getId_sector() {
		return id_sector;
	}

	public void setId_sector(Sector id_sector) {
		this.id_sector = id_sector;
	}

	public Proveedor getCodigo() {
		return codigo;
	}

	public void setCodigo(Proveedor codigo) {
		this.codigo = codigo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public BigDecimal getArea() {
		return area;
	}

	public void setArea(BigDecimal area) {
		this.area = area;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	
	
	
	
	
}
