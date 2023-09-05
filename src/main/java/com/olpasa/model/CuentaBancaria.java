package com.olpasa.model;

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
@Table(name = "cuenta_bancaria")
public class CuentaBancaria {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_cuenta;
	
	@Column(name = "estado")
	private String estado;
	
	@ManyToOne
	@JoinColumn(name = "codigo", nullable = false, foreignKey = @ForeignKey(name = "fk_cuenta_persona"))
	private Persona codigo;
	
	@ManyToOne
	@JoinColumn(name = "id_banco", nullable = false, foreignKey = @ForeignKey(name = "fk_cuenta_banco"))
	private Banco id_banco;
	
	@Column(name = "numero")
	private String numero;
	
	@Column(name = "cci")
	private String cci;
	
	@Column(name = "usuario")
	private String usuario;
	
	@Column(name = "observacion")
	private String observacion;

	public Integer getId_cuenta() {
		return id_cuenta;
	}

	public void setId_cuenta(Integer id_cuenta) {
		this.id_cuenta = id_cuenta;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Persona getCodigo() {
		return codigo;
	}

	public void setCodigo(Persona codigo) {
		this.codigo = codigo;
	}

	public Banco getId_banco() {
		return id_banco;
	}

	public void setId_banco(Banco id_banco) {
		this.id_banco = id_banco;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getCci() {
		return cci;
	}

	public void setCci(String cci) {
		this.cci = cci;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}
	
	
	
	
}
