package com.proyecto.arq.entity;

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
    private String imagen_receta;

    @ManyToOne(fetch = FetchType.LAZY)
    private Usuario usuario;

    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL,mappedBy = "usuario")
    private List<Comentario> comentario;

    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL,mappedBy = "usuario")
    private List<Accion> likes;


    public Publicacion(){

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

    public String getImagen_receta() {
        return imagen_receta;
    }

    public void setImagen_receta(String imagen_receta) {
        this.imagen_receta = imagen_receta;
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
