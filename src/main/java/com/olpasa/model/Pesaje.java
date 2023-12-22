package com.olpasa.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import org.hibernate.query.sqm.FetchClauseType;


@Table(name = "pesaje")
@Entity
public class Pesaje {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_pesaje;
	@Column(name = "num_ticket")
	private String num_ticket;
	@Column(name = "tipo_operacion")
	private String tipo_operacion;
	
	@ManyToOne
	@JoinColumn(name = "id_to", foreignKey = @ForeignKey(name = "fk_pesaje_operacion"))
	private TipoOperacion id_to;
	
	@ManyToOne
	@JoinColumn(name = "codigo", nullable = false, foreignKey = @ForeignKey(name = "fk_pesaje_persona"))
	private Persona codigo;
	
	@Column(name = "fecha")
	private LocalDate fecha;
	
	@Column(name = "peso_ingreso")
	private Integer peso_ingreso;
	
	@Column(name = "peso_salida")
	private Integer peso_salida;
	
	@Column(name = "peso_neto")
	private Integer peso_neto;
	
	@Column(columnDefinition = "DECIMAL(18,2)", name = "castigo_importe")
	private BigDecimal castigo_importe;
	
	@Column(name = "castigo_peso")
	private Integer castigo_peso;
	
	@Column(columnDefinition = "DECIMAL(18,2)", name = "castigo_planilla")
	private BigDecimal castigo_planilla;
	
	@ManyToOne
	@JoinColumn(name = "id_vehiculo", nullable = false, foreignKey = @ForeignKey(name = "fk_pesaje_vehiculo"))
	private Vehiculo id_vehiculo;

	@ManyToOne
	@JoinColumn(name = "vehiculo_id_vehiculo", foreignKey = @ForeignKey(name = "fk_pesaje_vehiculo2"))
	private Vehiculo vehiculo_id_vehiculo;
	@ManyToOne
	@JoinColumn(name = "codigo_et", foreignKey = @ForeignKey(name = "fk_pesaje_empresa_transporte"))
	private EmpresaTransporte codigo_et;

	@ManyToOne
	@JoinColumn(name = "conductor", foreignKey = @ForeignKey(name = "FK_pesaje_conductor"))
	private Conductor conductor;
	
	@ManyToOne
	@JoinColumn(name = "id_parcela", nullable = false, foreignKey = @ForeignKey(name = "fk_pesaje_parcela"))
	private Parcela id_parcela;

	@ManyToOne
	@JoinColumn(name = "cod_producto",foreignKey = @ForeignKey(name = "producto_pesaje_fk"))
	private Producto cod_producto;
	
	@Column(name = "estado")
	private String estado;
	
	@Column(name = "retencion_flete")
	private String retencion_flete;
	
	@Column(name = "monto_flete")
	private String monto_flete;
	
	@Column(name = "tipo_registro")
	private String tipo_registro;
	
	@Column(name = "observaciones")
	private String observaciones;
	
	@Column(name = "version")
	private Integer version;
	
	@Column(name = "id_liquidacion")
	private Integer id_liquidacion;
	
	@Column(name = "usuario_ingreso")
	private String usuario_ingreso;
	
	@Column(name = "usuario_salida")
	private String usuario_salida;
	
	@Column(name = "usuario_version")
	private String usuario_version;
	
	
	@Column(name = "fecha_salida", columnDefinition = "DATETIME2")
	private LocalDateTime fecha_salida;
	
	@Column(name = "fecha_anul")
	private LocalDateTime fecha_anul;
	
	@Column(name = "bitacora")
	private String bitacora;
	
	@Column(name = "estado_sinc")
	private String estado_sinc;
	
	@Column(name = "reg_guia")
	private String reg_guia;
	
	@Column(name = "serie")
	private String serie;
	
	@Column(name = "numero")
	private String numero;


	public Integer getId_pesaje() {
		return id_pesaje;
	}

	public void setId_pesaje(Integer id_pesaje) {
		this.id_pesaje = id_pesaje;
	}

	public String getNum_ticket() {
		return num_ticket;
	}

	public void setNum_ticket(String num_ticket) {
		this.num_ticket = num_ticket;
	}

	public String getTipo_operacion() {
		return tipo_operacion;
	}

	public void setTipo_operacion(String tipo_operacion) {
		this.tipo_operacion = tipo_operacion;
	}

	public TipoOperacion getId_to() {
		return id_to;
	}

	public void setId_to(TipoOperacion id_to) {
		this.id_to = id_to;
	}

	public Persona getCodigo() {
		return codigo;
	}

	public void setCodigo(Persona codigo) {
		this.codigo = codigo;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public Integer getPeso_ingreso() {
		return peso_ingreso;
	}

	public void setPeso_ingreso(Integer peso_ingreso) {
		this.peso_ingreso = peso_ingreso;
	}

	public Integer getPeso_salida() {
		return peso_salida;
	}

	public void setPeso_salida(Integer peso_salida) {
		this.peso_salida = peso_salida;
	}

	public Integer getPeso_neto() {
		return peso_neto;
	}

	public void setPeso_neto(Integer peso_neto) {
		this.peso_neto = peso_neto;
	}

	public BigDecimal getCastigo_importe() {
		return castigo_importe;
	}

	public void setCastigo_importe(BigDecimal castigo_importe) {
		this.castigo_importe = castigo_importe;
	}

	public Integer getCastigo_peso() {
		return castigo_peso;
	}

	public void setCastigo_peso(Integer castigo_peso) {
		this.castigo_peso = castigo_peso;
	}

	public BigDecimal getCastigo_planilla() {
		return castigo_planilla;
	}

	public void setCastigo_planilla(BigDecimal castigo_planilla) {
		this.castigo_planilla = castigo_planilla;
	}

	public Vehiculo getId_vehiculo() {
		return id_vehiculo;
	}

	public void setId_vehiculo(Vehiculo id_vehiculo) {
		this.id_vehiculo = id_vehiculo;
	}

	public Vehiculo getVehiculo_id_vehiculo() {
		return vehiculo_id_vehiculo;
	}

	public void setVehiculo_id_vehiculo(Vehiculo vehiculo_id_vehiculo) {
		this.vehiculo_id_vehiculo = vehiculo_id_vehiculo;
	}

	public EmpresaTransporte getCodigo_et() {
		return codigo_et;
	}

	public void setCodigo_et(EmpresaTransporte codigo_et) {
		this.codigo_et = codigo_et;
	}

	public Conductor getConductor() {
		return conductor;
	}

	public void setConductor(Conductor conductor) {
		this.conductor = conductor;
	}

	public Parcela getId_parcela() {
		return id_parcela;
	}

	public void setId_parcela(Parcela id_parcela) {
		this.id_parcela = id_parcela;
	}

	public Producto getCod_producto() {
		return cod_producto;
	}

	public void setCod_producto(Producto cod_producto) {
		this.cod_producto = cod_producto;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getRetencion_flete() {
		return retencion_flete;
	}

	public void setRetencion_flete(String retencion_flete) {
		this.retencion_flete = retencion_flete;
	}

	public String getMonto_flete() {
		return monto_flete;
	}

	public void setMonto_flete(String monto_flete) {
		this.monto_flete = monto_flete;
	}

	public String getTipo_registro() {
		return tipo_registro;
	}

	public void setTipo_registro(String tipo_registro) {
		this.tipo_registro = tipo_registro;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	public Integer getId_liquidacion() {
		return id_liquidacion;
	}

	public void setId_liquidacion(Integer id_liquidacion) {
		this.id_liquidacion = id_liquidacion;
	}

	public String getUsuario_ingreso() {
		return usuario_ingreso;
	}

	public void setUsuario_ingreso(String usuario_ingreso) {
		this.usuario_ingreso = usuario_ingreso;
	}

	public String getUsuario_salida() {
		return usuario_salida;
	}

	public void setUsuario_salida(String usuario_salida) {
		this.usuario_salida = usuario_salida;
	}

	public String getUsuario_version() {
		return usuario_version;
	}

	public void setUsuario_version(String usuario_version) {
		this.usuario_version = usuario_version;
	}

	public LocalDateTime getFecha_salida() {
		return fecha_salida;
	}

	public void setFecha_salida(LocalDateTime fecha_salida) {
		this.fecha_salida = fecha_salida;
	}

	public LocalDateTime getFecha_anul() {
		return fecha_anul;
	}

	public void setFecha_anul(LocalDateTime fecha_anul) {
		this.fecha_anul = fecha_anul;
	}

	public String getBitacora() {
		return bitacora;
	}

	public void setBitacora(String bitacora) {
		this.bitacora = bitacora;
	}

	public String getEstado_sinc() {
		return estado_sinc;
	}

	public void setEstado_sinc(String estado_sinc) {
		this.estado_sinc = estado_sinc;
	}

	public String getReg_guia() {
		return reg_guia;
	}

	public void setReg_guia(String reg_guia) {
		this.reg_guia = reg_guia;
	}

	public String getSerie() {
		return serie;
	}

	public void setSerie(String serie) {
		this.serie = serie;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}
}
