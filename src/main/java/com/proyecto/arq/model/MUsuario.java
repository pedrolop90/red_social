package com.proyecto.arq.model;

import java.util.Arrays;

import com.proyecto.arq.entity.Usuario;

public class MUsuario {

    private int id;
    private String nickname;
    private String correo;
    private String password;
    private int seguidores;
    private int seguidos;
    private String imagen_usuario;
    private boolean privacidad;

    public MUsuario() {
    }

    public MUsuario(Usuario usuario){
        id=usuario.getId();
        nickname=usuario.getNickname();
        correo=usuario.getCorreo();
        password=usuario.getPassword();
        imagen_usuario=usuario.getImagen_usuario();
        privacidad=usuario.isPrivacidad();
    }

    public MUsuario(String nickname, String correo, String password, int seguidores, int seguidos) {
        this.nickname = nickname;
        this.correo = correo;
        this.password = password;
        this.seguidores = seguidores;
        this.seguidos = seguidos;
    }

    
    
    public boolean isPrivacidad() {
		return privacidad;
	}

	public void setPrivacidad(boolean privacidad) {
		this.privacidad = privacidad;
	}

	public MUsuario(String correo, String password) {
        this.correo = correo;
        this.password = password;
    }

 

    public String getImagen_usuario() {
		return imagen_usuario;
	}

	public void setImagen_usuario(String imagen_usuario) {
		this.imagen_usuario = imagen_usuario;
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

    public int getSeguidores() {
        return seguidores;
    }

    public void setSeguidores(int seguidores) {
        this.seguidores = seguidores;
    }

    public int getSeguidos() {
        return seguidos;
    }

    public void setSeguidos(int seguidos) {
        this.seguidos = seguidos;
    }
 
    
    
}
