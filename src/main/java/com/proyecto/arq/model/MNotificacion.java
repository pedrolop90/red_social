package com.proyecto.arq.model;

import com.proyecto.arq.entity.Tipo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

public class MNotificacion {

    private int id;
    private int usuario;
    private String mensaje;
    private int tipo;

    public MNotificacion(){

    }

    public MNotificacion(int id, int usuario, String mensaje, int tipo) {
        this.id = id;
        this.usuario = usuario;
        this.mensaje = mensaje;
        this.tipo = tipo;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUsuario() {
        return usuario;
    }

    public void setUsuario(int usuario) {
        this.usuario = usuario;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    @Override
    public int hashCode() {
        return id;
    }
}
