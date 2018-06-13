package com.proyecto.arq.service;

import com.proyecto.arq.converter.Convertidor;
import com.proyecto.arq.entity.Amigo;
import com.proyecto.arq.entity.Receta;
import com.proyecto.arq.entity.Usuario;
import com.proyecto.arq.model.MAmigo;
import com.proyecto.arq.model.MUsuario;
import com.proyecto.arq.repository.RAmigo;
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
    private Convertidor convertidor;



    public int registrar(Receta receta){
        try{
            return rReceta.save(receta).getId();
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


}
