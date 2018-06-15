package com.proyecto.arq.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Paso {

    @Id
    @GeneratedValue
    private int id;
    private String nombre;


    @ManyToOne(fetch = FetchType.LAZY)
    private Receta receta;

    @Lob
    private String descripcion;

    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL,mappedBy = "receta")
    private List<Ingrediente> ingredientes;

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

    public Receta getReceta() {
        return receta;
    }

    public void setReceta(Receta receta) {
        this.receta = receta;
    }

    @Override
    public int hashCode() {
        return id;
    }
}
