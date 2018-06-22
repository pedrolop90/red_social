package com.proyecto.arq.service;

import com.proyecto.arq.converter.Convertidor;
import com.proyecto.arq.entity.Comentario;
import com.proyecto.arq.repository.RComentario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("SComentario")
public class SComentario {

    @Autowired
    private RComentario rComentario;
    @Autowired
    private Convertidor convertidor;



    public int registrar(Comentario comentario) {
        try {
            return rComentario.save(comentario).getId();
        } catch (Exception e) {
            return -1;
        }
    }


    public boolean actualizar(Comentario comentario){
        try{
            rComentario.save(comentario);
            return true;
        }catch(Exception e){
            return false;
        }
    }

    public boolean eliminar(int id){
        try{
            rComentario.delete(rComentario.findById(id).get());
            return true;
        }catch(Exception e){
            return false;
        }
    }


}
