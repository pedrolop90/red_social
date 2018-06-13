package com.proyecto.arq.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Accion {

    @Id
    @GeneratedValue
    private int id;
    private Date fecha;

    @ManyToOne(fetch = FetchType.LAZY)
    private Usuario usuario;

    public Accion(){

    }

    @Override
    public int hashCode() {
        return id;
    }

}
