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
@Table(name = "producto")
public class Producto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cod_producto")
	private Integer cod_producto;
	
	@Column(name = "descripcion")
	private String descripcion;
	
	@ManyToOne
	@JoinColumn(name = "codigo_um", nullable = false, foreignKey = @ForeignKey(name = "fk_producto_unidad_medida"))
	private UnidadMedida codigo_um;
	
	@Column(columnDefinition = "DECIMAL(18,2)", name = "precio_venta")
	private BigDecimal precio_venta;
	
	@Column(name = "balanza")
	private String balanza;
	
	@Column(name = "tipo")
	private String tipo;
	
	@Column(name = "usuario")
	private String usuario;
	
	@Column(columnDefinition = "DECIMAL(18,2)", name = "stock")
	private BigDecimal stock;
	
	@Column(columnDefinition = "DECIMAL(18,2)", name = "stock_minimo")
	private BigDecimal stock_minimo;
	
	@Column(name = "ubicacion")
	private String ubicacion;
	
	@Column(name = "version")
	private Integer version;
	
	@ManyToOne
	@JoinColumn(name = "id_clasificacion", nullable = false, foreignKey = @ForeignKey(name = "fk_producto_clas_contable"))
	private ClasificacionContable id_clasificacion;
	
	@ManyToOne
	@JoinColumn(name = "id_clas", nullable = false, foreignKey = @ForeignKey(name = "fk_producto_clasificacion"))
	private Clasificacion id_clas;

	public Integer getCod_producto() {
		return cod_producto;
	}

	public void setCod_producto(Integer cod_producto) {
		this.cod_producto = cod_producto;
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

	public BigDecimal getPrecio_venta() {
		return precio_venta;
	}

	public void setPrecio_venta(BigDecimal precio_venta) {
		this.precio_venta = precio_venta;
	}

	public String getBalanza() {
		return balanza;
	}

	public void setBalanza(String balanza) {
		this.balanza = balanza;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public BigDecimal getStock() {
		return stock;
	}

	public void setStock(BigDecimal stock) {
		this.stock = stock;
	}

	public BigDecimal getStock_minimo() {
		return stock_minimo;
	}

	public void setStock_minimo(BigDecimal stock_minimo) {
		this.stock_minimo = stock_minimo;
	}

	public String getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	public ClasificacionContable getId_clasificacion() {
		return id_clasificacion;
	}

	public void setId_clasificacion(ClasificacionContable id_clasificacion) {
		this.id_clasificacion = id_clasificacion;
	}

	public Clasificacion getId_clas() {
		return id_clas;
	}

	public void setId_clas(Clasificacion id_clas) {
		this.id_clas = id_clas;
	}
	
	
	
	
	
}
