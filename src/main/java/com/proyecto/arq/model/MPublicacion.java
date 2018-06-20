package com.proyecto.arq.model;


import com.proyecto.arq.entity.Publicacion;

import javax.persistence.Column;
import javax.persistence.Lob;
import java.util.Date;

public class MPublicacion {

    private int id;
    private Date fecha;
    private String hora;
    @Column(nullable = false)
    private  String nombre_imagen_publicacion;
    private byte[] imagen_publicacion;
    private  String nombre_imagen_receta;
    private byte[] imagen_receta;
    private int cantidadLikes;

    public MPublicacion(){

    }

    public MPublicacion(Publicacion publicacion){
        this.id=publicacion.getId();
        this.fecha=publicacion.getFecha();
        this.hora=publicacion.getHora();
        this.nombre_imagen_publicacion=publicacion.getNombre_imagen_publicacion();
        this.imagen_publicacion=publicacion.getImagen_publicacion();
        this.nombre_imagen_receta=publicacion.getNombre_imagen_receta();
        this.imagen_receta=publicacion.getImage_receta();
        this.cantidadLikes=publicacion.getLikes().size();
    }

    public MPublicacion(int id, Date fecha, String hora, byte[] imagen_receta, String nickname, int receta, int usuario) {
        this.id = id;
        this.fecha = fecha;
        this.hora = hora;
        this.imagen_receta = imagen_receta;
    }

    public String getNombre_imagen_publicacion() {
        return nombre_imagen_publicacion;
    }

    public byte[] getImagen_publicacion() {
        return imagen_publicacion;
    }

    public void setImagen_publicacion(byte[] imagen_publicacion) {
        this.imagen_publicacion = imagen_publicacion;
    }

    public String getNombre_imagen_receta() {
        return nombre_imagen_receta;
    }

    public void setNombre_imagen_receta(String nombre_imagen_receta) {
        this.nombre_imagen_receta = nombre_imagen_receta;
    }

    public void setNombre_imagen_publicacion(String nombre_imagen_publicacion) {
        this.nombre_imagen_publicacion = nombre_imagen_publicacion;
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


    public byte[] getImagen_receta() {
        return imagen_receta;
    }

    public void setImagen_receta(byte[] imagen_receta) {
        this.imagen_receta = imagen_receta;
    }


    @Override
    public int hashCode() {
        return id;
    }
}
