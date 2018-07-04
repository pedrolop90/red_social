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

    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
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
		Paso other = (Paso) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
	
	
}
