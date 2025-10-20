package com.ironhack.aeropuerto.model;

import jakarta.persistence.*;

@Entity
public class Vuelo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idVuelo;
    @Column(unique = true)
    private String numeroVuelo;
    private String aeronave;
    private Integer totalAsientosAeronave;
    private Integer millasVuelo;

    public Vuelo() {
    }

    public Vuelo(String numeroVuelo, String aeronave, Integer totalAsientosAeronave, Integer millasVuelo) {
        this.numeroVuelo = numeroVuelo;
        this.aeronave = aeronave;
        this.totalAsientosAeronave = totalAsientosAeronave;
        this.millasVuelo = millasVuelo;
    }

    public Integer getIdVuelo() {
        return idVuelo;
    }
    public void setIdVuelo(Integer idVuelo) {
        this.idVuelo = idVuelo;
    }

    public String getNumeroVuelo() {
        return numeroVuelo;
    }
    public void setNumeroVuelo(String numeroVuelo) {
        this.numeroVuelo = numeroVuelo;
    }

    public String getAeronave() {
        return aeronave;
    }
    public void setAeronave(String aeronave) {
        this.aeronave = aeronave;
    }

    public Integer getTotalAsientosAeronave() {
        return totalAsientosAeronave;
    }
    public void setTotalAsientosAeronave(Integer totalAsientosAeronave) {
        this.totalAsientosAeronave = totalAsientosAeronave;
    }

    public Integer getMillasVuelo() {
        return millasVuelo;
    }
    public void setMillasVuelo(Integer millasVuelo) {
        this.millasVuelo = millasVuelo;
    }
}
