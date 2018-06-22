package com.proyecto.arq.service;

import com.proyecto.arq.converter.Convertidor;
import com.proyecto.arq.entity.Notificacion;
import com.proyecto.arq.repository.RNotificacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("SNotificacion")
public class SNotificacion {

    @Autowired
    private RNotificacion rNotificacion;
    @Autowired
    private Convertidor convertidor;



    public int registrar(Notificacion notificacion){
        try{
            return rNotificacion.save(notificacion).getId();
        }catch(Exception e){
            return -1;
        }
    }


    public boolean actualizar(Notificacion notificacion){
        try{
            rNotificacion.save(notificacion);
            return true;
        }catch(Exception e){
            return false;
        }
    }

    public boolean eliminar(int id){
        try{
            rNotificacion.delete(rNotificacion.findById(id).get());
            return true;
        }catch(Exception e){
            return false;
        }
    }



}
