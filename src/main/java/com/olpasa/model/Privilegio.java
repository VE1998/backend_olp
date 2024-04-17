package com.olpasa.model;

import jakarta.persistence.*;

@Entity
@Table(name = "privilegio")
public class Privilegio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_privilegio")
    private Integer id_privilegio;
    @Column(name = "descripcion")
    private  String descripcion;
    @Column(name = "Observacion")
    private String observacion;
    @Column(name = "Modulo")
    private String modulo;

    public Integer getId_privilegio() {
        return id_privilegio;
    }

    public void setId_privilegio(Integer id_privilegio) {
        this.id_privilegio = id_privilegio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public String getModulo() {
        return modulo;
    }

    public void setModulo(String modulo) {
        this.modulo = modulo;
    }
}
