package com.proyecto.arq.entity;

import javax.persistence.*;

@Entity
public class Notificacion {

    @Id
    @GeneratedValue
    private int id;
    private String mensaje;
    @ManyToOne(fetch = FetchType.LAZY)
    private Usuario usuario;

    @ManyToOne
    private Tipo tipo;

    public Notificacion(){

    }

    public Notificacion(String mensaje, Usuario usuario, Tipo tipo) {
        this.mensaje = mensaje;
        this.usuario = usuario;
        this.tipo = tipo;
    }

    public Notificacion(String mensaje, Tipo tipo) {
        this.mensaje = mensaje;
        this.tipo = tipo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Notificacion{" +
                "notificacion_id=" + id +
                ", mensaje='" + mensaje + '\'' +
                ", tipo=" + tipo +
                '}';
    }

    @Override
    public int hashCode() {
        return id;
    }
}
