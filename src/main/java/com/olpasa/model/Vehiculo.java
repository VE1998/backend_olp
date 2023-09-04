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
@Table(name = "vehiculo")
public class Vehiculo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_vehiculo;
	
	@ManyToOne
	@JoinColumn(name = "codigo_et", nullable = false, foreignKey = @ForeignKey(name = "fk_vehiculo_empresa_transporte"))
	private EmpresaTransporte codigo_et;
	
	@Column(name = "tipo")
	private String tipo;
	
	@Column(name = "marca")
	private String marca;
	
	@Column(name = "estado")
	private String estado;
	
	@Column(name = "placa")
	private String placa;
	
	@Column(columnDefinition = "DECIMAL(18,2)", name = "alto")
	private BigDecimal alto;
	
	@Column(columnDefinition = "DECIMAL(18,2)", name = "ancho")
	private BigDecimal ancho;
	
	@Column(columnDefinition = "DECIMAL(18,2)", name = "largo")
	private BigDecimal largo;
	
	@Column(name = "constancia")
	private String constancia;

	public Integer getId_vehiculo() {
		return id_vehiculo;
	}

	public void setId_vehiculo(Integer id_vehiculo) {
		this.id_vehiculo = id_vehiculo;
	}

	public EmpresaTransporte getCodigo_et() {
		return codigo_et;
	}

	public void setCodigo_et(EmpresaTransporte codigo_et) {
		this.codigo_et = codigo_et;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public BigDecimal getAlto() {
		return alto;
	}

	public void setAlto(BigDecimal alto) {
		this.alto = alto;
	}

	public BigDecimal getAncho() {
		return ancho;
	}

	public void setAncho(BigDecimal ancho) {
		this.ancho = ancho;
	}

	public BigDecimal getLargo() {
		return largo;
	}

	public void setLargo(BigDecimal largo) {
		this.largo = largo;
	}

	public String getConstancia() {
		return constancia;
	}

	public void setConstancia(String constancia) {
		this.constancia = constancia;
	}
	
	
	
	
}
