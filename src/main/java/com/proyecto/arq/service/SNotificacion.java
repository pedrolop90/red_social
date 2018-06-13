package com.proyecto.arq.service;

import com.proyecto.arq.converter.Convertidor;
import com.proyecto.arq.entity.Amigo;
import com.proyecto.arq.entity.Notificacion;
import com.proyecto.arq.entity.Usuario;
import com.proyecto.arq.model.MAmigo;
import com.proyecto.arq.model.MUsuario;
import com.proyecto.arq.repository.RAmigo;
import com.proyecto.arq.repository.RNotificacion;
import com.proyecto.arq.repository.RUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
            rNotificacion.delete(rNotificacion.findOne(id));
            return true;
        }catch(Exception e){
            return false;
        }
    }



}
