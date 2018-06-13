package com.proyecto.arq.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
public class Mensaje implements Serializable {

    @Id
    @GeneratedValue
    private int id;
    @ManyToOne(fetch = FetchType.LAZY)
    private Usuario origen;
    @ManyToOne(fetch = FetchType.LAZY)
    private Usuario destino;
    private String msj;
    private boolean leido;
    private Date fecha;

    public Mensaje() {

    }

    public Mensaje(Usuario origen, Usuario destino, String msj) {
        this.origen = origen;
        this.destino = destino;
        this.msj = msj;
    }

    public Usuario getDestino() {
        return destino;
    }

    public void setDestino(Usuario destino) {
        this.destino = destino;
    }

    public Usuario getOrigen() {
        return origen;
    }

    public void setOrigen(Usuario origen) {
        this.origen = origen;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMsj() {
        return msj;
    }

    public void setMsj(String msj) {
        this.msj = msj;
    }

    public boolean isLeido() {
        return leido;
    }

    public void setLeido(boolean leido) {
        this.leido = leido;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "Mensaje{" +
                "mensaje_id=" + id +
                ", msj='" + msj + '\'' +
                ", leido=" + leido +
                ", fecha=" + fecha +
                '}';
    }
}
