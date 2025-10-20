package com.ironhack.aeropuerto.model;

import jakarta.persistence.*;

@Entity
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCliente;
    private String nombreCliente;
    private Integer millasTotalesCliente;

    @Enumerated(EnumType.STRING)
    private EstadoCliente estadoCliente;

    public Cliente() {
    }

    public Cliente(String nombreCliente, EstadoCliente estadoCliente, Integer millasTotalesCliente) {
        this.nombreCliente = nombreCliente;
        this.estadoCliente = estadoCliente;
        this.millasTotalesCliente = millasTotalesCliente;
    }

    public Integer getIdCliente() {
        return idCliente;
    }
    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }
    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public EstadoCliente getEstadoCliente() {
        return estadoCliente;
    }
    public void setEstadoCliente(EstadoCliente estadoCliente) {
        this.estadoCliente = estadoCliente;
    }

    public Integer getMillasTotalesCliente() {
        return millasTotalesCliente;
    }
    public void setMillasTotalesCliente(Integer millasTotalesCliente) {
        this.millasTotalesCliente = millasTotalesCliente;
    }
}