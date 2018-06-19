package com.proyecto.arq.service;

import com.proyecto.arq.converter.Convertidor;
import com.proyecto.arq.entity.Paso;
import com.proyecto.arq.repository.RPaso;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service("SPaso")
public class SPaso {

    @Autowired
    private RPaso rPaso;
    @Autowired
    private Convertidor convertidor;

    public int registrar(Paso paso){
        try{
            return rPaso.save(paso).getId();
        }catch(Exception e){
            return -1;
        }
    }

    public boolean actualizar(Paso paso){
        try{
            rPaso.save(paso);
            return true;
        }catch(Exception e){
            return false;
        }
    }

    public boolean eliminar(int id){
        try{
            rPaso.delete(rPaso.findOne(id));
            return true;
        }catch(Exception e){
            return false;
        }
    }

}
