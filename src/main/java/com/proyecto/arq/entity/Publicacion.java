package com.proyecto.arq.entity;

import org.springframework.beans.factory.annotation.Value;

import javax.persistence.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Entity
public class Publicacion {

    @Id
    @GeneratedValue
    private int id;
    @OneToOne(cascade=CascadeType.ALL,fetch = FetchType.LAZY)
    private Receta receta;
    private LocalDate fecha= LocalDate.now();
    private LocalTime  hora= LocalTime.now();

    @Lob
    private String image_receta;

    private boolean privacidad=true;

    @ManyToOne(fetch = FetchType.LAZY)
    private Categoria categoria;

    @ManyToOne(fetch = FetchType.LAZY)
    private Usuario usuario;

    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL,mappedBy = "publicacion")
    private List<Comentario> comentarios;

    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL,mappedBy = "publicacion")
    private List<Accion> likes;


    public Publicacion(){
    }



    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public boolean isPrivacidad() {
        return privacidad;
    }

    public void setPrivacidad(boolean privacidad) {
        this.privacidad = privacidad;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Receta getReceta() {
        return receta;
    }

    public void setReceta(Receta receta) {
        this.receta = receta;
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

 

	public String getImage_receta() {
		return image_receta;
	}



	public void setImage_receta(String image_receta) {
		this.image_receta = image_receta;
	}



	public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
 
    
    
    public List<Comentario> getComentarios() {
		return comentarios;
	}



	public void setComentarios(List<Comentario> comentarios) {
		this.comentarios = comentarios;
	}



	public List<Accion> getLikes() {
        return likes;
    }

    public void setLikes(List<Accion> likes) {
        this.likes = likes;
    }




	@Override
    public int hashCode() {
        return id;
    }
}
