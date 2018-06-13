package com.proyecto.arq.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Ingrediente {

    @Id
    @GeneratedValue
    private int id;
    private String nombre;
    @ManyToOne
    private Cantidad cantidad;

    public Ingrediente(){

    }


    @Override
    public int hashCode() {
        return id;
    }

}
