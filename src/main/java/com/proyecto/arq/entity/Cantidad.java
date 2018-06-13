package com.proyecto.arq.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Cantidad {

    @Id
    @GeneratedValue
    private int id;
    private String tipo;

    public Cantidad(){

    }

    @Override
    public int hashCode() {
        return id;
    }
}
