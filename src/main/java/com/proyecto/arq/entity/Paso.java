package com.proyecto.arq.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Paso {

    @Id
    @GeneratedValue
    private int id;
    private String nombre;
    @Lob
    private String descripcion;
    @ManyToMany
    private List<Ingrediente> ingredientes;
    @ManyToOne
    private Cantidad cantidad;

    public Paso(){

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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public List<Ingrediente> getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(List<Ingrediente> ingredientes) {
        this.ingredientes = ingredientes;
    }

    public Cantidad getCantidad() {
        return cantidad;
    }

    public void setCantidad(Cantidad cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public int hashCode() {
        return id;
    }
}
