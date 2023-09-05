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
@Table(name = "proveedor")
public class Proveedor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "codigo")
	private Integer codigo;
	
	@ManyToOne
	@JoinColumn(name = "id_sector", nullable = false, foreignKey = @ForeignKey(name = "fk_proveedor_sector"))
	private Sector id_sector;
	
	@ManyToOne
	@JoinColumn(name = "id_cuenta", nullable = false, foreignKey = @ForeignKey(name = "fk_proveedor_cuenta"))
	private CuentaBancaria id_cuenta;
	
	@Column(name = "es_mp")
	private String es_mp;
	
	@Column(name = "es_suministro")
	private String es_suministro;
	
	@Column(name = "estado")
	private String estado;
	
	@Column(name = "anexoconcar")
	private String anexoconcar;
	
	@Column(name = "enviar_sms")
	private String enviar_sms;
	
	@Column(name = "tipo_comp")
	private String tipo_comp;
	
	@Column(name = "usuario")
	private String usuario;

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public Sector getId_sector() {
		return id_sector;
	}

	public void setId_sector(Sector id_sector) {
		this.id_sector = id_sector;
	}

	public CuentaBancaria getId_cuenta() {
		return id_cuenta;
	}

	public void setId_cuenta(CuentaBancaria id_cuenta) {
		this.id_cuenta = id_cuenta;
	}

	public String getEs_mp() {
		return es_mp;
	}

	public void setEs_mp(String es_mp) {
		this.es_mp = es_mp;
	}

	public String getEs_suministro() {
		return es_suministro;
	}

	public void setEs_suministro(String es_suministro) {
		this.es_suministro = es_suministro;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getAnexoconcar() {
		return anexoconcar;
	}

	public void setAnexoconcar(String anexoconcar) {
		this.anexoconcar = anexoconcar;
	}

	public String getEnviar_sms() {
		return enviar_sms;
	}

	public void setEnviar_sms(String enviar_sms) {
		this.enviar_sms = enviar_sms;
	}

	public String getTipo_comp() {
		return tipo_comp;
	}

	public void setTipo_comp(String tipo_comp) {
		this.tipo_comp = tipo_comp;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	
	
	
	
}
