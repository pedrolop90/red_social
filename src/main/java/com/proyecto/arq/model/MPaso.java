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
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MPaso other = (MPaso) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}
}
