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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + seguido;
		result = prime * result + usuario;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MSeguidor other = (MSeguidor) obj;
		if (seguido != other.seguido)
			return false;
		if (usuario != other.usuario)
			return false;
		return true;
	}
 
    
    
}
