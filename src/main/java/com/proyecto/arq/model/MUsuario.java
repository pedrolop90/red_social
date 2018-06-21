package com.proyecto.arq.model;

import com.proyecto.arq.entity.Usuario;

public class MUsuario {

    private int id;
    private String nickname;
    private String correo;
    private String password;
    private int seguidores;
    private int seguidos;
    private String foto_perfil;
    private byte[] imagen_usuario;

    public MUsuario() {
    }

    public MUsuario(Usuario usuario){
        id=usuario.getId();
        nickname=usuario.getNickname();
        correo=usuario.getCorreo();
        password=usuario.getPassword();
        imagen_usuario=usuario.getImagen_usuario();
    }

    public MUsuario(String nickname, String correo, String password, int seguidores, int seguidos, String foto_perfil) {
        this.nickname = nickname;
        this.correo = correo;
        this.password = password;
        this.seguidores = seguidores;
        this.seguidos = seguidos;
        this.foto_perfil = foto_perfil;
    }

    public MUsuario(String correo, String password) {
        this.correo = correo;
        this.password = password;
    }


    public byte[] getImagen_usuario() {
        return imagen_usuario;
    }

    public void setImagen_usuario(byte[] imagen_usuario) {
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

    public String getFoto_perfil() {
        return foto_perfil;
    }

    public void setFoto_perfil(String foto_perfil) {
        this.foto_perfil = foto_perfil;
    }

    @Override
    public String toString() {
        return "MUsuario{" +
                "nickname='" + nickname + '\'' +
                ", correo='" + correo + '\'' +
                ", password='" + password + '\'' +
                ", seguidores=" + seguidores +
                ", seguidos=" + seguidos +
                ", foto_perfil='" + foto_perfil + '\'' +
                '}';
    }
}
