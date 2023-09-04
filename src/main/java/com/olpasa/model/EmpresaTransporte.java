package com.olpasa.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "empresa_transporte")
public class EmpresaTransporte {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "codigo_et")
	private Integer codigo_et;
	
	@Column(name = "estado")
	private String estado;
	
	@Column(name = "id_cuenta")
	private Integer id_cuenta;
	
	@Column(name = "usuario")
	private String usuario;
	
	

	public Integer getCodigo_et() {
		return codigo_et;
	}

	public void setCodigo_et(Integer codigo_et) {
		this.codigo_et = codigo_et;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Integer getId_cuenta() {
		return id_cuenta;
	}

	public void setId_cuenta(Integer id_cuenta) {
		this.id_cuenta = id_cuenta;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	

}
