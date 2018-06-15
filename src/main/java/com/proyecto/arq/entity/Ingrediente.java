package com.proyecto.arq.entity;


import javax.persistence.*;

@Entity
public class Ingrediente {

    @Id
    @GeneratedValue
    private int id;
    private String nombre;
    private String medida;
    @ManyToOne(fetch = FetchType.LAZY)
    private Receta receta;

    public Ingrediente(){

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

    public String getMedida() {
        return medida;
    }

    public void setMedida(String medida) {
        this.medida = medida;
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
