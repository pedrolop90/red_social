package com.proyecto.arq.model;


import com.proyecto.arq.entity.Paso;

public class MPaso {

    private int id;
    private String nombre;
    private String descripcion;
    private int receta;


    public MPaso(){

    }

    public MPaso(Paso paso){
        this.id=paso.getId();
        this.nombre=paso.getNombre();
        this.descripcion=paso.getDescripcion();
    }

    public MPaso(int id, String nombre, String descripcion, int receta) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.receta = receta;
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

    public int getReceta() {
        return receta;
    }

    public void setReceta(int receta) {
        this.receta = receta;
    }

    @Override
    public int hashCode() {
        return id;
    }
}
