package com.proyecto.arq.entity;

import javax.persistence.*;

@Entity
public class Paso_Ingrediente {

    @Id
    @GeneratedValue
    private int id;
    @ManyToOne(fetch = FetchType.LAZY)
    private Paso paso;
    @ManyToOne(fetch = FetchType.LAZY)
    private Ingrediente ingrediente;
    private String medida;

    public Paso_Ingrediente(){

    }

    public Paso_Ingrediente(int id, Paso paso, Ingrediente ingrediente,String medida) {
        this.id = id;
        this.paso = paso;
        this.ingrediente = ingrediente;
        this.setMedida(medida);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Paso getPaso() {
        return paso;
    }


    public void setPaso(Paso paso) {
        this.paso = paso;
    }

    public Ingrediente getIngrediente() {
        return ingrediente;
    }

    public void setIngrediente(Ingrediente ingrediente) {
        this.ingrediente = ingrediente;
    }

    public String getMedida(){return medida;}

    public void setMedida(String medida) {
        this.medida = medida;
    }
}
