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
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
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
		MAmigo other = (MAmigo) obj;
		if (id != other.id)
			return false;
		return true;
	}


}
