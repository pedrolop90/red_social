package com.proyecto.arq.model;


import java.util.ArrayList;
import java.util.List;

import com.proyecto.arq.entity.Paso;

public class MPaso {

    private int id;
    private String nombre;
    private String descripcion;
    private List<MPaso_Ingrediente> ingredientes;

    public MPaso(){

    }

    public MPaso(Paso paso){
        this.id=paso.getId();
        this.nombre=paso.getNombre();
        this.descripcion=paso.getDescripcion();
        ingredientes=new ArrayList<>();
    	for (int i = 0; i < paso.getIngredientes().size(); i++) {
			ingredientes.add(new MPaso_Ingrediente(paso.getIngredientes().get(i)));
		}
    }

     
	public List<MPaso_Ingrediente> getIngredientes() {
		return ingredientes;
	}

	public void setIngredientes(List<MPaso_Ingrediente> ingredientes) {
		this.ingredientes = ingredientes;
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


    @Override
    public int hashCode() {
        return id;
    }
}
