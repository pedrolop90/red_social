package com.proyecto.arq.model;

import com.proyecto.arq.entity.Mensaje;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

public class MMensaje {

    private long id;
    private int origen;
    private int destino;
    private String msj;
    private boolean leido;
    private LocalDate fecha;
    private LocalTime  hora;

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
 
    public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public LocalTime getHora() {
		return hora;
	}

	public void setHora(LocalTime hora) {
		this.hora = hora;
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
