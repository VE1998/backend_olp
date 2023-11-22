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
@Table(name = "evaluacion_calidad")
public class EvaluacionCalidad {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_evaluacion")
	private Integer id_evaluacion;
	
	@ManyToOne
	@JoinColumn(name = "id_pesaje", nullable = false, foreignKey = @ForeignKey(name = "fk_evaluacionCalidad_pesaje"))
	private Pesaje id_pesaje;
	
	@ManyToOne
	@JoinColumn(name = "id_criterio", nullable = false, foreignKey = @ForeignKey(name = "fk_evaluacionCalidad_criterioCalidad"))
	private CriterioCalidad id_criterio;
	
	@Column(columnDefinition = "DECIMAL(18,2)", name = "valor")
	private BigDecimal valor;
	
	@Column(name = "codigo_um")
	private String codigo_um;
	
	@Column(name = "castigo")
	private String castigo;
	
	@Column(name = "forma_castigo")
	private String forma_castigo;
	
	@Column(name = "factor_castigo")
	private String factor_castigo;
	
	@Column(name = "usuario")
	private String usuario;

	public Integer getId_evaluacion() {
		return id_evaluacion;
	}

	public void setId_evaluacion(Integer id_evaluacion) {
		this.id_evaluacion = id_evaluacion;
	}

	public Pesaje getId_pesaje() {
		return id_pesaje;
	}

	public void setId_pesaje(Pesaje id_pesaje) {
		this.id_pesaje = id_pesaje;
	}

	public CriterioCalidad getId_criterio() {
		return id_criterio;
	}

	public void setId_criterio(CriterioCalidad id_criterio) {
		this.id_criterio = id_criterio;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public String getCodigo_um() {
		return codigo_um;
	}

	public void setCodigo_um(String codigo_um) {
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

	public String getFactor_castigo() {
		return factor_castigo;
	}

	public void setFactor_castigo(String factor_castigo) {
		this.factor_castigo = factor_castigo;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	
	
	
	
	
}
