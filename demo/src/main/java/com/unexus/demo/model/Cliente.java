package com.unexus.demo.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "CLIENTE")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String tipoIdentiofiacion;
    @Column(name = "NUMEROIDENTIFICACION", unique = true)
    private Integer numeroIdentificacion;
    private String nombre;
    private String apellido;
    private String correo;
    private String numeroCelular;

    // Constructor sin argumentos (default)
    public Cliente() {
    }
    public Cliente(Long id, String tipoIdentiofiacion, Integer numeroIdentificacion, String nombre, String apellido, String correo, String numeroCelular) {
        this.id = id;
        this.tipoIdentiofiacion = tipoIdentiofiacion;
        this.numeroIdentificacion = numeroIdentificacion;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.numeroCelular = numeroCelular;
    }

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DireccionCliente> direccionClientes;

    // Getter y Setter para direccionClientes
    public List<DireccionCliente> getDireccionClientes() {
        return direccionClientes;
    }

    public void setDireccionClientes(List<DireccionCliente> direccionClientes) {
        this.direccionClientes = direccionClientes;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTipoIdentiofiacion() {
        return tipoIdentiofiacion;
    }

    public void setTipoIdentiofiacion(String tipoIdentiofiacion) {
        this.tipoIdentiofiacion = tipoIdentiofiacion;
    }

    public Integer getNumeroIdentificacion() {
        return numeroIdentificacion;
    }

    public void setNumeroIdentificacion(Integer numeroIdentificacion) {
        this.numeroIdentificacion = numeroIdentificacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getNumeroCelular() {
        return numeroCelular;
    }

    public void setNumeroCelular(String numeroCelular) {
        this.numeroCelular = numeroCelular;
    }
}
