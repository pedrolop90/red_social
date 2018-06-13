package com.proyecto.arq.model;


import com.proyecto.arq.entity.Cantidad;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

public class MIngrediente {

    private int id;
    private String nombre;
    private int receta;
    private int cantidad;

    public MIngrediente(){

    }

    public MIngrediente(int id, String nombre, int receta, int cantidad) {
        this.id = id;
        this.nombre = nombre;
        this.receta = receta;
        this.cantidad = cantidad;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getReceta() {
        return receta;
    }

    public void setReceta(int receta) {
        this.receta = receta;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public int hashCode() {
        return id;
    }

}
