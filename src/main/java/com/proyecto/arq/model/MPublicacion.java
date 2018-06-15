package com.proyecto.arq.model;


import com.proyecto.arq.entity.Publicacion;

import java.util.Date;

public class MPublicacion {

    private int id;
    private Date fecha;
    private String hora;
    private String imagen_receta;
    private int receta;
    private int usuario;
    private int cantidadLikes;

    public MPublicacion(){

    }

    public MPublicacion(Publicacion publicacion){
        this.fecha=publicacion.getFecha();
        this.hora=publicacion.getHora();
        this.imagen_receta=publicacion.getImagen_receta();
        this.cantidadLikes=publicacion.getLikes().size();
    }

    public MPublicacion(int id, Date fecha, String hora, String imagen_receta, String nickname, int receta, int usuario) {
        this.id = id;
        this.fecha = fecha;
        this.hora = hora;
        this.imagen_receta = imagen_receta;
        this.receta = receta;
        this.usuario = usuario;
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

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getImagen_receta() {
        return imagen_receta;
    }

    public void setImagen_receta(String imagen_receta) {
        this.imagen_receta = imagen_receta;
    }


    public int getReceta() {
        return receta;
    }

    public void setReceta(int receta) {
        this.receta = receta;
    }

    public int getUsuario() {
        return usuario;
    }

    public void setUsuario(int usuario) {
        this.usuario = usuario;
    }

    @Override
    public int hashCode() {
        return id;
    }
}
