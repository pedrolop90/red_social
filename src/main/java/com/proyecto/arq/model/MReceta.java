package com.proyecto.arq.model;

import java.util.ArrayList;
import java.util.List;

import com.proyecto.arq.entity.Receta;



public class MReceta {

    private int id;
    private String nombre;
    private List<MIngrediente> ingredientes;
    private List<MPaso> pasos;
    public MReceta() {

    }
    
    
    public MReceta(Receta receta) {
    	this.id=receta.getId();
    	this.nombre=receta.getNombre();
    	ingredientes=new ArrayList<>();
    	pasos=new ArrayList<>();
    	for (int i = 0; receta.getIngredientes()!=null && i <receta.getIngredientes().size(); i++) {
			ingredientes.add(new MIngrediente(receta.getIngredientes().get(i)));
		}
    	for (int i = 0;receta.getPasos()!=null&& i < receta.getPasos().size(); i++) {
			pasos.add(new MPaso(receta.getPasos().get(i)));
		}
    }

    public MReceta(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
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

 


	public List<MPaso> getPasos() {
		return pasos;
	}


	public void setPasos(List<MPaso> pasos) {
		this.pasos = pasos;
	}


	public List<MIngrediente> getIngredientes() {
		return ingredientes;
	}


	public void setIngredientes(List<MIngrediente> ingredientes) {
		this.ingredientes = ingredientes;
	}

	
	

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MReceta other = (MReceta) obj;
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
