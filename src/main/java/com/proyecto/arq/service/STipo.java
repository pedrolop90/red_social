package com.proyecto.arq.service;

import com.proyecto.arq.converter.Convertidor;
import com.proyecto.arq.entity.Tipo;
import com.proyecto.arq.repository.RTipo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service("STipo")
public class STipo {

    @Autowired
    private RTipo rTipo;
    @Autowired
    private Convertidor convertidor;



    public int registrar(Tipo tipo) {
        try {
            return rTipo.save(tipo).getId();
        } catch (Exception e) {
            return -1;
        }
    }


    public boolean actualizar(Tipo tipo){
        try{
            rTipo.save(tipo);
            return true;
        }catch(Exception e){
            return false;
        }
    }

    public boolean eliminar(int id){
        try{
            rTipo.delete(rTipo.findOne(id));
            return true;
        }catch(Exception e){
            return false;
        }
    }


}
