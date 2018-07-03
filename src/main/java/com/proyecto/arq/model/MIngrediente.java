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
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MIngrediente other = (MIngrediente) obj;
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
