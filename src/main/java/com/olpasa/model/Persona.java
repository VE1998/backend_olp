package com.olpasa.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "persona")
public class Persona {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "codigo")
	private Integer codigo;
	
	@Column(name = "tipo")
	private String tipo;
	
	@Column(name = "tipo_documento")
	private String tipo_documento;
	
	@Column(name = "numero_documento")
	private String numero_documento;
	
	@Column(name = "nombres")
	private String nombres;
	
	@Column(name = "paterno")
	private String paterno;
	
	@Column(name = "materno")
	private String materno;
	
	@Column(name = "telefono")
	private String telefono;
	
	@Column(name = "direccion")
	private String direccion;
	
	@Column(name = "direccion2")
	private String direcion2;
	
	@Column(name = "habilitado")
	private String habilitado;
	
	@Column(name = "balanza")
	private String balanza;
	
	@Column(name = "es_mp")
	private String es_mp;
	
	@Column(name = "es_transportista")
	private String es_transportista;
	
	@Column(name = "es_bienes")
	private String es_bienes;
	
	@Column(name = "cuenta")
	private String cuenta;
	
	@Column(name = "banco")
	private String banco;
	
	@Column(name = "codigo_tony")
	private String codigo_tony;

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getTipo_documento() {
		return tipo_documento;
	}

	public void setTipo_documento(String tipo_documento) {
		this.tipo_documento = tipo_documento;
	}

	public String getNumero_documento() {
		return numero_documento;
	}

	public void setNumero_documento(String numero_documento) {
		this.numero_documento = numero_documento;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getPaterno() {
		return paterno;
	}

	public void setPaterno(String paterno) {
		this.paterno = paterno;
	}

	public String getMaterno() {
		return materno;
	}

	public void setMaterno(String materno) {
		this.materno = materno;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getDirecion2() {
		return direcion2;
	}

	public void setDirecion2(String direcion2) {
		this.direcion2 = direcion2;
	}

	public String getHabilitado() {
		return habilitado;
	}

	public void setHabilitado(String habilitado) {
		this.habilitado = habilitado;
	}

	public String getBalanza() {
		return balanza;
	}

	public void setBalanza(String balanza) {
		this.balanza = balanza;
	}

	public String getEs_mp() {
		return es_mp;
	}

	public void setEs_mp(String es_mp) {
		this.es_mp = es_mp;
	}

	public String getEs_transportista() {
		return es_transportista;
	}

	public void setEs_transportista(String es_transportista) {
		this.es_transportista = es_transportista;
	}

	public String getEs_bienes() {
		return es_bienes;
	}

	public void setEs_bienes(String es_bienes) {
		this.es_bienes = es_bienes;
	}

	public String getCuenta() {
		return cuenta;
	}

	public void setCuenta(String cuenta) {
		this.cuenta = cuenta;
	}

	public String getBanco() {
		return banco;
	}

	public void setBanco(String banco) {
		this.banco = banco;
	}

	public String getCodigo_tony() {
		return codigo_tony;
	}

	public void setCodigo_tony(String codigo_tony) {
		this.codigo_tony = codigo_tony;
	}

	
	
	

	
	
	

}
