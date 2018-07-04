package com.proyecto.arq.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import java.util.List;

@Entity
public class Receta {

    @Id
    @GeneratedValue
    private int id;
    private String nombre;
    @Transient
    private int id_usuario;
    @Transient
    private String imagen_receta;
    @Transient
    private String imagen_publicacion;
    @Transient
    private int id_categoria;
    
    
    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<Paso> pasos;


    @OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private List<Ingrediente> ingredientes;

    /**
     * 
     */
    public Receta() {

    }
 

    
    

    public int getId_categoria() {
		return id_categoria;
	}





	public void setId_categoria(int id_categoria) {
		this.id_categoria = id_categoria;
	}





	public String getImagen_receta() {
		return imagen_receta;
	}





	public void setImagen_receta(String imagen_receta) {
		this.imagen_receta = imagen_receta;
	}





	public String getImagen_publicacion() {
		return imagen_publicacion;
	}





	public void setImagen_publicacion(String imagen_publicacion) {
		this.imagen_publicacion = imagen_publicacion;
	}





	public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public List<Paso> getPasos() {
        return pasos;
    }

    public void setPasos(List<Paso> pasos) {
        this.pasos = pasos;
    }

    public List<Ingrediente> getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(List<Ingrediente> ingredientes) {
        this.ingredientes = ingredientes;
    }

    
     

	@Override
	public String toString() {
		return "Receta [id=" + id + ", nombre=" + nombre + ", id_usuario=" + id_usuario + ", imagen_receta="
				+ imagen_receta + ", imagen_publicacion=" + imagen_publicacion + ", id_categoria=" + id_categoria
				+ ", pasos=" + pasos + ", ingredientes=" + ingredientes + "]";
	}





	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Receta other = (Receta) obj;
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
