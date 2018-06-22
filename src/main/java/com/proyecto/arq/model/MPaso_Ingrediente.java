package com.proyecto.arq.model;

public class MPaso_Ingrediente {

    private int id;
    private int id_paso;
    private int id_ingrediente;
    private String medida;
    private String cantidad;
    public MPaso_Ingrediente(){

    }



    public MPaso_Ingrediente(int id, int id_paso, int id_ingrediente, String medida) {
        this.id = id;
        this.id_paso = id_paso;
        this.id_ingrediente = id_ingrediente;
        this.medida = medida;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public int getId_paso() {
        return id_paso;
    }

    public void setId_paso(int id_paso) {
        this.id_paso = id_paso;
    }

    public int getId_ingrediente() {
        return id_ingrediente;
    }

    public void setId_ingrediente(int id_ingrediente) {
        this.id_ingrediente = id_ingrediente;
    }

    public String getMedida() {
        return medida;
    }

    public void setMedida(String medida) {
        this.medida = medida;
    }
}
