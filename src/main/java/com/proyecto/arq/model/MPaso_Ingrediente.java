package com.proyecto.arq.model;

import com.proyecto.arq.entity.Paso_Ingrediente;

public class MPaso_Ingrediente {

    private int id;
    private int id_paso;
    private int id_ingrediente;
    private String medida;
    private String cantidad;
    private String nombre_ing;
    public MPaso_Ingrediente(){

    }



    public MPaso_Ingrediente(Paso_Ingrediente p_i) {
        this.id = p_i.getId();
        this.id_ingrediente = p_i.getIngrediente().getId();
        this.medida=p_i.getMedida();
        this.cantidad=p_i.getCantidad();
        this.nombre_ing=p_i.getIngrediente().getNombre();
    }

    
    
    public String getNombre_ing() {
		return nombre_ing;
	}



	public void setNombre_ing(String nombre_ing) {
		this.nombre_ing = nombre_ing;
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


    public int getId_paso() {
        return id_paso;
    }

    public void setId_paso(int id_paso) {
        this.id_paso = id_paso;
    }

    public int getId_ingrediente() {
        return id_ingrediente;
    }

    public void setId_ingrediente(int id_ingrediente) {
        this.id_ingrediente = id_ingrediente;
    }

    public String getMedida() {
        return medida;
    }

    public void setMedida(String medida) {
        this.medida = medida;
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
		MPaso_Ingrediente other = (MPaso_Ingrediente) obj;
		if (id != other.id)
			return false;
		return true;
	}
    
    
}
