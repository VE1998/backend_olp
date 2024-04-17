package com.olpasa.model;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "usuario")
public class Usuario {

    @Id
    @Column(name = "nombre_cuenta", length = 10)
    private String nombre_cuenta;
    @Column(name = "nombres")
    private  String nombres;
    @Column(name = "estado")
    private String estado;
    @Column(name = "password")
    private String password;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "usuario_privilegio", joinColumns = @JoinColumn(name = "nombre_cuenta"), inverseJoinColumns = @JoinColumn(name = "id_privilegio"))
    private Set<Privilegio> privilegios = new HashSet<>();

    public String getNombre_cuenta() {
        return nombre_cuenta;
    }

    public void setNombre_cuenta(String nombre_cuenta) {
        this.nombre_cuenta = nombre_cuenta;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
