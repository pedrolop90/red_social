package com.proyecto.arq.service;

import com.proyecto.arq.converter.Convertidor;
import com.proyecto.arq.entity.Accion;
import com.proyecto.arq.repository.RAccion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("SAccion")
public class SAccion {

    @Autowired
    private RAccion rAccion;
    @Autowired
    private Convertidor convertidor;



    public int registrar(Accion accion){
        try{
            return rAccion.save(accion).getId();
        }catch(Exception e){
            return -1;
        }
    }


    public boolean actualizar(Accion accion){
        try{
            rAccion.save(accion);
            return true;
        }catch(Exception e){
            return false;
        }
    }

    public boolean eliminar(int id){
        try{
            rAccion.delete(rAccion.findOne(id));
            return true;
        }catch(Exception e){
            return false;
        }
    }


}
