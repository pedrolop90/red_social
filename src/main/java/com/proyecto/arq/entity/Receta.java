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
    @JsonProperty("nombre")
    private String nombre;
    @Transient
    private int id_usuario;
    @Transient
    @JsonProperty("imagen_receta")
    private MultipartFile imagen_receta;
    @Transient
    @JsonProperty("imagen_publicacion")
    private MultipartFile imagen_publicacion;
    @Transient
    @JsonProperty("id_categoria")
    private int id_categoria;

    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL,mappedBy = "receta")
    private List<Paso> pasos;


    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL,mappedBy = "receta")
    private List<Ingrediente> ingredientes;

    public Receta() {

    }


    public MultipartFile getImagen_receta() {
        return imagen_receta;
    }

    public void setImagen_receta(MultipartFile imagen_receta) {
        this.imagen_receta = imagen_receta;
    }

    public MultipartFile getImagen_publicacion() {
        return imagen_publicacion;
    }

    public void setImagen_publicacion(MultipartFile imagen_publicacion) {
        this.imagen_publicacion = imagen_publicacion;
    }

    public int getId_categoria() {
        return id_categoria;
    }

    public void setId_categoria(int id_categoria) {
        this.id_categoria = id_categoria;
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
    public int hashCode() {
        return id;
    }
}
