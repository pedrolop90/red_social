package com.proyecto.arq.model;


import com.proyecto.arq.entity.Ingrediente;

public class MIngrediente {

    private int id;
    private String nombre;
    private String medida;
    private int id_receta;

    public MIngrediente(){

    }

    public MIngrediente(Ingrediente ingrediente){
        this.id=ingrediente.getId();
        this.nombre=ingrediente.getNombre();
        this.medida=ingrediente.getMedida();

    }

    public MIngrediente(int id, String nombre, int receta) {
        this.id = id;
        this.nombre = nombre;
        this.id_receta = receta;
    }

    public MIngrediente(String nombre, String medida, int id_receta) {
        this.nombre = nombre;
        this.medida = medida;
        this.id_receta = id_receta;
    }

    public String getMedida() {
        return medida;
    }

    public void setMedida(String medida) {
        this.medida = medida;
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

    public int getId_receta() {
        return id_receta;
    }

    public void setId_receta(int id_receta) {
        this.id_receta = id_receta;
    }

    @Override
    public int hashCode() {
        return id;
    }

}
