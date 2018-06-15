package com.proyecto.arq.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Accion {

    @Id
    @GeneratedValue
    private int id;
    private Date fecha;

    @ManyToOne(fetch = FetchType.LAZY)
    private Usuario usuario;

    @ManyToOne(fetch = FetchType.LAZY)
    private Accion like;

    public Accion(){

    }

    public Accion getLike() {
        return like;
    }

    public void setLike(Accion like) {
        this.like = like;
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

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public int hashCode() {
        return id;
    }

}
