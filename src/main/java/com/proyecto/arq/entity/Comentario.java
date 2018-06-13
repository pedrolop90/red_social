package com.proyecto.arq.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Comentario {

    @Id
    @GeneratedValue
    private int id;

    @Lob
    private String comentario;
    private String nickname;
    private Date fecha;

    @ManyToOne(fetch = FetchType.LAZY)
    private Usuario usuario;


    public Comentario(){

    }

    @Override
    public int hashCode() {
        return id;
    }

}
