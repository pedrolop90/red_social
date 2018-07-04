package com.proyecto.arq.model;

import com.proyecto.arq.entity.Publicacion;
import com.proyecto.arq.entity.Receta;

import javax.persistence.Column;
import javax.persistence.Lob;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MPublicacion {

	private int id;
	private LocalDate fecha;
	private LocalTime hora;
	private String imagen_receta;
	private int cantidadLikes;
	private MReceta receta;
	private List<MComentario> comentarios;
	private boolean like;
	private boolean privacidad;
	
	public MPublicacion() {

	}

	public MPublicacion(Publicacion publicacion,int user) {
		comentarios = new ArrayList();
		this.like = false;
		this.id = publicacion.getId();
		this.fecha = publicacion.getFecha();
		this.hora = publicacion.getHora();
		this.imagen_receta = publicacion.getImage_receta();
		this.cantidadLikes = publicacion.getLikes().size();
		this.receta = new MReceta(publicacion.getReceta());
		for (int i = 0; publicacion.getLikes() != null && i < publicacion.getLikes().size(); i++) {
			if (publicacion.getLikes().get(i).getUsuario().getId() == user) {
				this.like = true;
				break;
			}
		}
		for (int i = 0; publicacion.getComentarios() != null && i < publicacion.getComentarios().size(); i++) {
			comentarios.add(new MComentario(publicacion.getComentarios().get(i)));
		}
		this.privacidad=publicacion.isPrivacidad();

	}

	
	
	public boolean isPrivacidad() {
		return privacidad;
	}

	public void setPrivacidad(boolean privacidad) {
		this.privacidad = privacidad;
	}

	public boolean isLike() {
		return like;
	}

	public void setLike(boolean like) {
		this.like = like;
	}

	public List<MComentario> getComentarios() {
		return comentarios;
	}

	public void setComentarios(List<MComentario> comentarios) {
		this.comentarios = comentarios;
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
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MPublicacion other = (MPublicacion) obj;
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
