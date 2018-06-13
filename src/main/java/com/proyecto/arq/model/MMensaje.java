package com.proyecto.arq.model;

import com.proyecto.arq.entity.Mensaje;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

public class MMensaje {

    private long id;
    private int origen;
    private int destino;
    private String msj;
    private boolean leido;
    private Date fecha;

    public MMensaje() {

    }

    public MMensaje(Mensaje mensaje) {
        id = mensaje.getId();
        origen = mensaje.getOrigen().getId();
        destino=mensaje.getDestino().getId();
        msj = mensaje.getMsj();
        leido = mensaje.isLeido();
        fecha = mensaje.getFecha();
    }

    public MMensaje(int origen, int destino, String msj, boolean leido, Date fecha) {
        this.origen = origen;
        this.destino = destino;
        this.msj = msj;
        this.leido = leido;
        this.fecha = fecha;
    }

    public MMensaje(int destino, String msj) {
        this.destino = destino;
        this.msj = msj;
    }

    public MMensaje(int origen, int destino, String msj) {
        this.origen = origen;
        this.destino = destino;
        this.msj = msj;
    }

    public MMensaje(int origen, int destino) {
        this.origen = origen;
        this.destino = destino;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getOrigen() {
        return origen;
    }

    public void setOrigen(int origen) {
        this.origen = origen;
    }

    public int getDestino() {
        return destino;
    }

    public void setDestino(int destino) {
        this.destino = destino;
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
