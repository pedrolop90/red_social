package com.proyecto.arq.entity;


import javax.persistence.*;
import java.util.List;

@Entity
public class Ingrediente {

    @Id
    @GeneratedValue
    private int id;
    private String nombre;
    private String medida;
    @Transient
    private int id_receta;
    @ManyToOne(fetch = FetchType.LAZY)
    private Receta receta;

    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL,mappedBy = "ingrediente")
    private List<Paso_Ingrediente> pasos;
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

    public int getId_receta() {
        return id_receta;
    }

    public void setId_receta(int id_receta) {
        this.id_receta = id_receta;
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
