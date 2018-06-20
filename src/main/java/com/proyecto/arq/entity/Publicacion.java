package com.proyecto.arq.entity;

import org.springframework.beans.factory.annotation.Value;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Publicacion {

    @Id
    @GeneratedValue
    private int id;
    @OneToOne(cascade=CascadeType.ALL,fetch = FetchType.LAZY)
    private Receta receta;
    private Date fecha;
    private String hora;
    private String nombre_imagen_publicacion;
    @Lob
    private byte[] imagen_publicacion;
    private String nombre_imagen_receta;
    @Lob
    private byte[] image_receta;

    private boolean privacidad=true;

    @ManyToOne(fetch = FetchType.LAZY)
    private Categoria categoria;

    @ManyToOne(fetch = FetchType.LAZY)
    private Usuario usuario;

    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL,mappedBy = "publicacion")
    private List<Comentario> comentario;

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

    public String getNombre_imagen_publicacion() {
        return nombre_imagen_publicacion;
    }

    public void setNombre_imagen_publicacion(String nombre_imagen_publicacion) {
        this.nombre_imagen_publicacion = nombre_imagen_publicacion;
    }

    public String getNombre_imagen_receta() {
        return nombre_imagen_receta;
    }

    public void setNombre_imagen_receta(String nombre_imagen_receta) {
        this.nombre_imagen_receta = nombre_imagen_receta;
    }

    public byte[] getImagen_publicacion() {
        return imagen_publicacion;
    }

    public void setImagen_publicacion(byte[] imagen_publicacion) {
        this.imagen_publicacion = imagen_publicacion;
    }


    public byte[] getImage_receta() {
        return image_receta;
    }

    public void setImage_receta(byte[] image_receta) {
        this.image_receta = image_receta;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<Comentario> getComentario() {
        return comentario;
    }

    public void setComentario(List<Comentario> comentario) {
        this.comentario = comentario;
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
