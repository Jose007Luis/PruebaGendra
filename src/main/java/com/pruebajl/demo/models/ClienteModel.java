package com.pruebajl.demo.models;

import jakarta.persistence.*;

@Entity
@Table(name = "Clientes")
public class ClienteModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private int idCliente;

    private String nombre;
    private String frecuente;


    public int getIdCliente() {
        return idCliente;
    }
    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getFrecuente() {
        return frecuente;
    }
    public void setFrecuente(String frecuente) {
        this.frecuente = frecuente;
    }
}
