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
@Table(name = "criterio_calidad")
public class CriterioCalidad {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_criterio")
	private Integer id_criterio;
	
	@Column(name = "descripcion")
	private String descripcion;
	
	@ManyToOne
	@JoinColumn(name = "codigo_um", nullable = false, foreignKey = @ForeignKey(name = "fk_calidad_unidadmedida"))
	private UnidadMedida codigo_um;
	
	@Column(name = "castigo")
	private String castigo;
	
	@Column(name = "forma_castigo")
	private String forma_castigo;
	
	@Column(columnDefinition = "DECIMAL(18,2)", name = "factor_castigo")
	private BigDecimal factor_castigo;
	
	@Column(name = "factor_variable")
	private String factor_variable;
	
	@Column(name = "impresion_ticket")
	private String impresion_tiket;
	
	@Column(name = "estado")
	private String estado;
	
	@Column(name = "usuario")
	private String usuario;

	public Integer getId_criterio() {
		return id_criterio;
	}

	public void setId_criterio(Integer id_criterio) {
		this.id_criterio = id_criterio;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public UnidadMedida getCodigo_um() {
		return codigo_um;
	}

	public void setCodigo_um(UnidadMedida codigo_um) {
		this.codigo_um = codigo_um;
	}

	public String getCastigo() {
		return castigo;
	}

	public void setCastigo(String castigo) {
		this.castigo = castigo;
	}

	public String getForma_castigo() {
		return forma_castigo;
	}

	public void setForma_castigo(String forma_castigo) {
		this.forma_castigo = forma_castigo;
	}

	public BigDecimal getFactor_castigo() {
		return factor_castigo;
	}

	public void setFactor_castigo(BigDecimal factor_castigo) {
		this.factor_castigo = factor_castigo;
	}

	public String getFactor_variable() {
		return factor_variable;
	}

	public void setFactor_variable(String factor_variable) {
		this.factor_variable = factor_variable;
	}

	public String getImpresion_tiket() {
		return impresion_tiket;
	}

	public void setImpresion_tiket(String impresion_tiket) {
		this.impresion_tiket = impresion_tiket;
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
