package com.proyecto.arq.model;

import com.proyecto.arq.entity.Categoria;
import com.proyecto.arq.entity.Ingrediente;
import com.proyecto.arq.entity.Paso;


public class MReceta {

    private int id;
    private String nombre;
    private int categoria;

    public MReceta() {

    }

    public MReceta(int id, String nombre, int categoria) {
        this.id = id;
        this.nombre = nombre;
        this.categoria = categoria;
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

    public int getCategoria() {
        return categoria;
    }

    public void setCategoria(int categoria) {
        this.categoria = categoria;
    }

    @Override
    public int hashCode() {
        return id;
    }
}
