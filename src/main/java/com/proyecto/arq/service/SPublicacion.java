package com.proyecto.arq.service;

import com.proyecto.arq.converter.Convertidor;
import com.proyecto.arq.entity.Publicacion;
import com.proyecto.arq.model.MComentario;
import com.proyecto.arq.model.MPublicacion;
import com.proyecto.arq.repository.RPublicacion;
import com.proyecto.arq.repository.RUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("SPublicacion")
public class SPublicacion {

    @Autowired
    private RPublicacion rPublicacion;
    @Autowired
    private RUsuario rUsuario;
    @Autowired
    private Convertidor convertidor;



    public int registrar(Publicacion publicacion){
        try{
            return rPublicacion.save(publicacion).getId();
        }catch(Exception e){
            return -1;
        }
    }

    public boolean actualizar(Publicacion publicacion){
        try{
            rPublicacion.save(publicacion);
            return true;
        }catch(Exception e){
            return false;
        }
    }

    public boolean eliminar(int id){
        try{
            rPublicacion.delete(rPublicacion.findOne(id));
            return true;
        }catch(Exception e){
            return false;
        }
    }
    public List<MPublicacion> listarPublicacionesUnUsuario(int id){
        return convertidor.convertirPublicacion(rUsuario.findOne(id).getPublicaciones());
    }


    public int listarCantidadLikesPublicacion(int id){
        return rPublicacion.findOne(id).getLikes().size();
    }

    public List<MComentario> listarComentariosPublicacion(int id){
        return convertidor.convertirComentario(rPublicacion.findOne(id).getComentario());
    }

}
