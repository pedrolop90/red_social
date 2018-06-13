package com.proyecto.arq.model;

public class MSeguidor {

    private int usuario;
    private int seguido;

    public MSeguidor(){

    }

    public MSeguidor(int usuario, int seguido) {
        this.usuario = usuario;
        this.seguido = seguido;
    }

    public int getUsuario() {
        return usuario;
    }

    public void setUsuario(int usuario) {
        this.usuario = usuario;
    }

    public int getSeguido() {
        return seguido;
    }

    public void setSeguido(int seguido) {
        this.seguido = seguido;
    }


    @Override
    public String toString() {
        return "MSeguidor{" +
                "usuario=" + usuario +
                ", seguido=" + seguido +
                '}';
    }
}
