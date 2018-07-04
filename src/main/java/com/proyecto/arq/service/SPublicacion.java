package com.proyecto.arq.service;

import com.proyecto.arq.converter.Convertidor;
import com.proyecto.arq.entity.Amigo;
import com.proyecto.arq.entity.Publicacion;
import com.proyecto.arq.model.MComentario;
import com.proyecto.arq.model.MPublicacion;
import com.proyecto.arq.repository.RPublicacion;
import com.proyecto.arq.repository.RReceta;
import com.proyecto.arq.repository.RUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("SPublicacion")
public class SPublicacion {

    @Autowired
    private RPublicacion rPublicacion;
    @Autowired
    private RUsuario rUsuario;
    @Autowired
    private RReceta rReceta;
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
            rPublicacion.delete(rPublicacion.findByReceta(rReceta.findById(id).get()));
            return true;
        }catch(Exception e){
            return false;
        }
    }
    public List<MPublicacion> listarPublicacionesUnUsuario(int id){
        return convertidor.convertirPublicacion(rPublicacion.findByUnUsuario(id),id);
    }

    public List<MPublicacion> listarPublicacionesMiUsuario(int id){
        return convertidor.convertirPublicacion(rPublicacion.findByMiUsuario(id),id);
    }

    
    
    public int listarCantidadLikesPublicacion(int id){
        return rPublicacion.findById(id).get().getLikes().size();
    }

    public List<MComentario> listarComentariosPublicacion(int id){
        return convertidor.convertirComentario(rPublicacion.findById(id).get().getComentarios());
    }
    public boolean cambiarPrivacidadPublicacion(Publicacion publicacion){
        try{
            Publicacion p= rPublicacion.findById(publicacion.getId()).get();
            p.setPrivacidad(!p.isPrivacidad());
            rPublicacion.save(p);
            return true;
        }catch(Exception e){
            return false;
        }
    }
    
    public List<MPublicacion> listarUltimasPublicacionesPublicas(int user){
        return convertidor.convertirPublicacion(rPublicacion.findByUsuario(),user);
    }
    
    public List<MPublicacion> listarPublicacionesSeguidos(int id){
        return convertidor.convertirPublicacion(rPublicacion.findBySeguidos(id),id);
    }

}
