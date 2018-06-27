package com.proyecto.arq.model;


import com.proyecto.arq.entity.Publicacion;
import com.proyecto.arq.entity.Receta;

import javax.persistence.Column;
import javax.persistence.Lob;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

public class MPublicacion {

    private int id;
    private LocalDate fecha;
    private LocalTime  hora;
    private String imagen_receta;
    private int cantidadLikes;
    private MReceta receta;
    public MPublicacion(){

    }

    public MPublicacion(Publicacion publicacion){
        this.id=publicacion.getId();
        this.fecha=publicacion.getFecha();
        this.hora=publicacion.getHora();
        this.imagen_receta=publicacion.getImage_receta();
        this.cantidadLikes=publicacion.getLikes().size();
        this.receta=new MReceta(publicacion.getReceta());
    }
 
      

	public MReceta getReceta() {
		return receta;
	}

	public void setReceta(MReceta receta) {
		this.receta = receta;
	} 
	

	public void setImagen_receta(String imagen_receta) {
		this.imagen_receta = imagen_receta;
	}

	public int getCantidadLikes() {
        return cantidadLikes;
    }

    public void setCantidadLikes(int cantidadLikes) {
        this.cantidadLikes = cantidadLikes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
 
    public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public LocalTime getHora() {
		return hora;
	}

	public void setHora(LocalTime hora) {
		this.hora = hora;
	}

	public String getImagen_receta() {
		return imagen_receta;
	}

	@Override
    public int hashCode() {
        return id;
    }
}
