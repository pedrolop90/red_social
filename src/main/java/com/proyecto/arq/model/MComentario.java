package com.proyecto.arq.model;

import com.proyecto.arq.entity.Comentario;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

public class MComentario {

    private int id;
    private String comentario;
    private int publicacion;
    private int id_usuario;
    private String nickname;
    private LocalDate fecha;
    private LocalTime  hora;

    public MComentario(){

    }

    public MComentario(Comentario comentario){
        this.id=comentario.getId();
        this.publicacion=comentario.getPublicacion().getId();
        this.id_usuario=comentario.getUsuario().getId();
        this.comentario=comentario.getComentario();
        this.nickname=comentario.getUsuario().getNickname();
        this.fecha=comentario.getFecha();
        this.hora=comentario.getHora();
    }

 

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }


    public void setPublicacion(int publicacion) {
        this.publicacion = publicacion;
    }
 
    public int getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(int id_usuario) {
		this.id_usuario = id_usuario;
	}

	public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
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

	@Override
    public int hashCode() {
        return id;
    }

}
