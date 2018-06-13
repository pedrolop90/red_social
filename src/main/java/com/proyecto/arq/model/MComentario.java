package com.proyecto.arq.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import java.util.Date;

public class MComentario {

    private int id;
    private String comentario;
    private int publicacion;
    private int usuario;
    private String nickname;
    private Date fecha;

    public MComentario(){

    }

    public MComentario(int id, String comentario, int publicacion, int usuario, String nickname, Date fecha) {
        this.id = id;
        this.comentario = comentario;
        this.publicacion = publicacion;
        this.usuario = usuario;
        this.nickname = nickname;
        this.fecha = fecha;
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

    public int getPublicacion() {
        return publicacion;
    }

    public void setPublicacion(int publicacion) {
        this.publicacion = publicacion;
    }

    public int getUsuario() {
        return usuario;
    }

    public void setUsuario(int usuario) {
        this.usuario = usuario;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @Override
    public int hashCode() {
        return id;
    }

}
