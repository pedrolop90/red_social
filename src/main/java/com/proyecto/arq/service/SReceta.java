package com.proyecto.arq.service;

import com.proyecto.arq.converter.Convertidor;
import com.proyecto.arq.entity.*;
import com.proyecto.arq.model.MAmigo;
import com.proyecto.arq.model.MIngrediente;
import com.proyecto.arq.model.MPaso;
import com.proyecto.arq.model.MUsuario;
import com.proyecto.arq.repository.RAmigo;
import com.proyecto.arq.repository.RPublicacion;
import com.proyecto.arq.repository.RReceta;
import com.proyecto.arq.repository.RUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("SReceta")
public class SReceta {

    @Autowired
    private RReceta rReceta;
    @Autowired
    private RPublicacion rPublicacion;
    @Autowired
    private RUsuario rUsuario;
    @Autowired
    private Convertidor convertidor;



    public int registrar(Receta receta){
        try{
            Publicacion p=new Publicacion();
            p.setReceta(receta);
            p.setUsuario(rUsuario.findOne(receta.getId_usuario()));
            return rPublicacion.save(p).getReceta().getId();
        }catch(Exception e){
            return -1;
        }
    }

    public boolean actualizar(Receta receta){
        try{
            rReceta.save(receta);
            return true;
        }catch(Exception e){
            return false;
        }
    }

    public boolean eliminar(int id){
        try{
            rReceta.delete(rReceta.findOne(id));
            return true;
        }catch(Exception e){
            return false;
        }
    }

    public List<MPaso> listarPasos(int id){
        return convertidor.convertirPaso(rReceta.findOne(id).getPasos());
    }

    public List<MIngrediente> listarIngredientes(int id){
        return convertidor.convertirIngredientes(rReceta.findOne(id).getIngredientes());
    }

}
