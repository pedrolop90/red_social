package com.proyecto.arq.entity;

import org.springframework.beans.factory.annotation.Value;

import javax.persistence.*;
import java.util.List;

@Entity
public class Usuario {

    @Id
    @GeneratedValue
    private int id;
    private String nickname;
    @Column(unique = true)
    private String correo;
    private String password;
    private boolean privacidad=true;
    @Lob
    private String imagen_usuario;

    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL,mappedBy = "usuario")
    private List<Amigo> seguidos;
    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL,mappedBy = "amigo")
    private List<Amigo> seguidores;

    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL,mappedBy = "destino")
    private List<Mensaje> mensajesRecibidos;
    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL,mappedBy = "origen")
    private List<Mensaje> mensajesEnviados;


    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL,mappedBy = "usuario")
    private List<Publicacion> publicaciones;
    
    

    public Usuario() {
    }

    
     

    public String getImagen_usuario() {
		return imagen_usuario;
	}




	public void setImagen_usuario(String imagen_usuario) {
		this.imagen_usuario = imagen_usuario;
	}




	public boolean isPrivacidad() {
        return privacidad;
    }

    public void setPrivacidad(boolean privacidad) {
        this.privacidad = privacidad;
    }

    public List<Amigo> getSeguidos() {
        return seguidos;
    }

    public void setSeguidos(List<Amigo> seguidos) {
        this.seguidos = seguidos;
    }

    public List<Amigo> getSeguidores() {
        return seguidores;
    }

    public void setSeguidores(List<Amigo> seguidores) {
        this.seguidores = seguidores;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Mensaje> getMensajesRecibidos() {
        return mensajesRecibidos;
    }

    public void setMensajesRecibidos(List<Mensaje> mensajesRecibidos) {
        this.mensajesRecibidos = mensajesRecibidos;
    }

    public List<Mensaje> getMensajesEnviados() {
        return mensajesEnviados;
    }

    public void setMensajesEnviados(List<Mensaje> mensajesEnviados) {
        this.mensajesEnviados = mensajesEnviados;
    }
 
    public List<Publicacion> getPublicaciones() {
        return publicaciones;
    }

    public void setPublicaciones(List<Publicacion> publicaciones) {
        this.publicaciones = publicaciones;
    }



    @Override
    public String toString() {
        return "Usuario{" +
                "usuario_id=" + id +
                ", nickname='" + nickname + '\'' +
                ", correo='" + correo + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        return id;
    }
}
