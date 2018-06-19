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
    @Transient
    private int id_receta;

    @ManyToOne(fetch = FetchType.LAZY)
    private Receta receta;

    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL,mappedBy = "paso")
    private List<Paso_Ingrediente> ingredientes;

    public Paso(){

    }

    public int getId_receta() {
        return id_receta;
    }

    public void setId_receta(int id_receta) {
        this.id_receta = id_receta;
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

    public List<Paso_Ingrediente> getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(List<Paso_Ingrediente> ingredientes) {
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
