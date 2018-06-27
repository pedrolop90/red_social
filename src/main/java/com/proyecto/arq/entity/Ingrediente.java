package com.proyecto.arq.entity;


import javax.persistence.*;
import java.util.List;

@Entity
public class Ingrediente {

    @Id
    @GeneratedValue
    private int id;
    private String nombre;
    private String cantidad;
    private String medida;

    public Ingrediente(){

    }

 
    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
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


    @Override
	public String toString() {
		return "Ingrediente [id=" + id + ", nombre=" + nombre + ", cantidad=" + cantidad + ", medida=" + medida + "]";
	}


	@Override
    public int hashCode() {
        return id;
    }

}
