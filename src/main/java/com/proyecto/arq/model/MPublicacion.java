package com.proyecto.arq.model;


import com.proyecto.arq.entity.Publicacion;

import javax.persistence.Column;
import javax.persistence.Lob;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

public class MPublicacion {

    private int id;
    private LocalDate fecha;
    private LocalTime  hora;
    private String imagen_publicacion;
    private String imagen_receta;
    private int cantidadLikes;
    private int id_receta;
    public MPublicacion(){

    }

    public MPublicacion(Publicacion publicacion){
        this.id=publicacion.getId();
        this.fecha=publicacion.getFecha();
        this.hora=publicacion.getHora();
        this.imagen_publicacion=publicacion.getImagen_publicacion();
        this.imagen_receta=publicacion.getImage_receta();
        this.cantidadLikes=publicacion.getLikes().size();
        this.id_receta=publicacion.getReceta().getId();
    }
 
    
    

	public int getId_receta() {
		return id_receta;
	}

	public void setId_receta(int id_receta) {
		this.id_receta = id_receta;
	}

	public String getImagen_publicacion() {
		return imagen_publicacion;
	}

	public void setImagen_publicacion(String imagen_publicacion) {
		this.imagen_publicacion = imagen_publicacion;
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
