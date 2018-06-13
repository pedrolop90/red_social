package com.proyecto.arq.model;


public class MAmigo {

    private int id;
    private int id_usuario;
    private int id_amigo;

    public MAmigo() {
    }

    public MAmigo(int id_usuario, int id_amigo) {
        this.id_usuario = id_usuario;
        this.id_amigo = id_amigo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }


    public int getId_amigo() {
        return id_amigo;
    }

    public void setId_amigo(int id_amigo) {
        this.id_amigo = id_amigo;
    }

    @Override
    public int hashCode() {
        return id;
    }


}
