package com.proyecto.arq.model;


import com.proyecto.arq.entity.Categoria;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class MCategoria {

    private int id;
    private String nombre;

    public MCategoria(){

    }
    public MCategoria(Categoria categoria){
        this.id=categoria.getId();
        this.nombre=categoria.getNombre();
    }
    public MCategoria(int id, String nombre) {
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
 
    @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MCategoria other = (MCategoria) obj;
		if (id != other.id)
			return false;
		return true;
	}

}
