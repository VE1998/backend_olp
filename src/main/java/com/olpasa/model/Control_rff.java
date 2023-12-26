package com.olpasa.model;

import jakarta.persistence.*;

@Entity
@Table( name = "control_rff")
public class Control_rff {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_control;

    @ManyToOne
    @JoinColumn(name = "id_pesaje", foreignKey = @ForeignKey(name = "fk_control_rff_pesaje"))
    private Pesaje id_pesaje;

    @Column(name = "campaña")
    private String campaña;

    @Column(name = "tipo_racimo")
    private String tipo_racimo;

    @Column(name = "condicion")
    private String condicion;

    @Column(name = "usuario")
    private String usuario;

    public Integer getId_control() {
        return id_control;
    }

    public void setId_control(Integer id_control) {
        this.id_control = id_control;
    }

    public Pesaje getId_pesaje() {
        return id_pesaje;
    }

    public void setId_pesaje(Pesaje id_pesaje) {
        this.id_pesaje = id_pesaje;
    }

    public String getCampaña() {
        return campaña;
    }

    public void setCampaña(String campaña) {
        this.campaña = campaña;
    }

    public String getTipo_racimo() {
        return tipo_racimo;
    }

    public void setTipo_racimo(String tipo_racimo) {
        this.tipo_racimo = tipo_racimo;
    }

    public String getCondicion() {
        return condicion;
    }

    public void setCondicion(String condicion) {
        this.condicion = condicion;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
}
