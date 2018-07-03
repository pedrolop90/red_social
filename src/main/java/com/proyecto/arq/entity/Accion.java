package com.proyecto.arq.entity;

import javax.persistence.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

@Entity
public class Accion {

    @Id
    @GeneratedValue
    private int id;
    private LocalDate fecha= LocalDate.now();
    private LocalTime  hora= LocalTime.now();
    @Transient
    private int usuario_id;
    @Transient
    private int publicacion_id;


    @ManyToOne(fetch = FetchType.LAZY)
    private Usuario usuario;
    
    @ManyToOne(fetch = FetchType.LAZY)
    private Publicacion publicacion;

    public Accion(){

    }

    
    
    public Usuario getUsuario() {
		return usuario;
	}



	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}



	public int getUsuario_id() {
        return usuario_id;
    }

    public void setUsuario_id(int usuario_id) {
        this.usuario_id = usuario_id;
    }

    public int getPublicacion_id() {
        return publicacion_id;
    }

    public void setPublicacion_id(int publicacion_id) {
        this.publicacion_id = publicacion_id;
    }

    public Publicacion getPublicacion() {
        return publicacion;
    }

    public void setPublicacion(Publicacion publicacion) {
        this.publicacion = publicacion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Accion other = (Accion) obj;
		if (id != other.id)
			return false;
		return true;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

}
