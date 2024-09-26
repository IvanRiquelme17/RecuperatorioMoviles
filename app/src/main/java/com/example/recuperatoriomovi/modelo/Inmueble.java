package com.example.recuperatoriomovi.modelo;

import java.io.Serializable;

public class Inmueble implements Serializable {
    private String codigo;
    private String descripcion;
    private int cantAmbientes;
    private String direccion;
    private double precio;

    public Inmueble(String codigo, String descripcion, int cantAmbientes, String direccion, double precio) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.cantAmbientes = cantAmbientes;
        this.direccion = direccion;
        this.precio = precio;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getCantAmbientes() {
        return cantAmbientes;
    }

    public void setCantAmbientes(int cantAmbientes) {
        this.cantAmbientes = cantAmbientes;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
}
