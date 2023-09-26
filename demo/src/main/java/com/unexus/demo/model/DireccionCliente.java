package com.unexus.demo.model;

import jakarta.persistence.*;

import static jakarta.persistence.FetchType.LAZY;

@Entity
@Table(name = "DIRECCIONCLIENTE")
public class DireccionCliente {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String provincia;
    private String ciudad;
    private String direccion;
    //Se controla mediante codigo de tipo direccion si es la principal o secundarias.
    private String tipoDireccion; // PR o SEC
    @Column(name = "NUMEROIDENTIFICACION")
    private Integer numeroIdentificacion; //Se manejan las direcciones por cedula del cliente



    public DireccionCliente() {
    }

    public DireccionCliente(Long id, String provincia, String ciudad, String direccion, String tipoDireccion, Integer numeroIdentificacion) {
        this.id = id;
        this.provincia = provincia;
        this.ciudad = ciudad;
        this.direccion = direccion;
        this.tipoDireccion = tipoDireccion;
        this.numeroIdentificacion = numeroIdentificacion;
    }

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "NUMEROIDENTIFICACION", referencedColumnName = "NUMEROIDENTIFICACION", insertable = false, updatable = false)
    private Cliente cliente;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTipoDireccion() {
        return tipoDireccion;
    }

    public void setTipoDireccion(String tipoDireccion) {
        this.tipoDireccion = tipoDireccion;
    }

    public Integer getNumeroIdentificacion() {
        return numeroIdentificacion;
    }

    public void setNumeroIdentificacion(Integer numeroIdentificacion) {
        this.numeroIdentificacion = numeroIdentificacion;
    }
}
