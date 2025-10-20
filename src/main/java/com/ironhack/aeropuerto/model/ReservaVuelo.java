package com.ironhack.aeropuerto.model;

import jakarta.persistence.*;

@Entity
public class ReservaVuelo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idReserva;

    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "id_vuelo")
    private Vuelo vuelo;

    public ReservaVuelo() {
    }

    public ReservaVuelo(Integer idReserva, Vuelo vuelo) {
        this.idReserva = idReserva;
        this.vuelo = vuelo;
    }

    public Integer getIdReserva() {
        return idReserva;
    }
    public void setIdReserva(Integer idReserva) {
        this.idReserva = idReserva;
    }

    public Cliente getCliente() {
        return cliente;
    }
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Vuelo getVuelo() {
        return vuelo;
    }
    public void setVuelo(Vuelo vuelo) {
        this.vuelo = vuelo;
    }
}
