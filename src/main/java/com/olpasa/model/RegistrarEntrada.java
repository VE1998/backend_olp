package com.olpasa.model;

import java.time.LocalDateTime;
import java.time.LocalTime;

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
@Table(name = "registrar_entrada")
public class RegistrarEntrada {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_ingreso;
	
	@Column(name = "fecha")
	private LocalDateTime fecha;
	
	@ManyToOne
	@JoinColumn(name = "codigo_et", nullable = false, foreignKey = @ForeignKey(name = "fk_registro_empresa_transporte"))
	private EmpresaTransporte codigo_et;
	
	@ManyToOne
	@JoinColumn(name = "codigo", nullable = false, foreignKey = @ForeignKey(name = "fk_registro_conductor"))
	private Conductor codigo;
	
	@ManyToOne
	@JoinColumn(name = "id_vehiculo", nullable = false, foreignKey = @ForeignKey(name = "fk_registro_vehiculo"))
	private Vehiculo id_vehiculo;
	
	@Column(name = "hora_ingreso")
	private LocalTime hora_ingreso;
	
	@Column(name = "hora_salida")
	private LocalTime hora_salida;
	
	@Column(name = "estado")
	private String estado;

	public Integer getId_ingreso() {
		return id_ingreso;
	}

	public void setId_ingreso(Integer id_ingreso) {
		this.id_ingreso = id_ingreso;
	}

	public LocalDateTime getFecha() {
		return fecha;
	}

	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}

	public EmpresaTransporte getCodigo_et() {
		return codigo_et;
	}

	public void setCodigo_et(EmpresaTransporte codigo_et) {
		this.codigo_et = codigo_et;
	}

	public Conductor getCodigo() {
		return codigo;
	}

	public void setCodigo(Conductor codigo) {
		this.codigo = codigo;
	}

	public Vehiculo getId_vehiculo() {
		return id_vehiculo;
	}

	public void setId_vehiculo(Vehiculo id_vehiculo) {
		this.id_vehiculo = id_vehiculo;
	}

	public LocalTime getHora_ingreso() {
		return hora_ingreso;
	}

	public void setHora_ingreso(LocalTime hora_ingreso) {
		this.hora_ingreso = hora_ingreso;
	}

	public LocalTime getHora_salida() {
		return hora_salida;
	}

	public void setHora_salida(LocalTime hora_salida) {
		this.hora_salida = hora_salida;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	
	
}
