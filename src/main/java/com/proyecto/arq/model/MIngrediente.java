package com.proyecto.arq.model;


import com.proyecto.arq.entity.Ingrediente;

public class MIngrediente {

    private int id;
    private String nombre;
    private String medida;
    private String cantidad;

    public MIngrediente(){

    }

    public MIngrediente(Ingrediente ingrediente){
        this.id=ingrediente.getId();
        this.nombre=ingrediente.getNombre();
        this.medida=ingrediente.getMedida();
        this.cantidad=ingrediente.getCantidad();
    }
    
    
    public String getCantidad() {
		return cantidad;
	}

	public void setCantidad(String cantidad) {
		this.cantidad = cantidad;
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
 

    @Override
    public int hashCode() {
        return id;
    }

}
