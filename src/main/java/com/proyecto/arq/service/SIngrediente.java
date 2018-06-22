package com.proyecto.arq.service;

import com.proyecto.arq.converter.Convertidor;
import com.proyecto.arq.entity.Ingrediente;
import com.proyecto.arq.repository.RIngrediente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("SIngrediente")
public class SIngrediente {

    @Autowired
    private RIngrediente rIngrediente;
    @Autowired
    private Convertidor convertidor;



    public int registrar(Ingrediente ingrediente) {
        try {
            return rIngrediente.save(ingrediente).getId();
        } catch (Exception e) {
            return -1;
        }
    }


    public boolean actualizar(Ingrediente ingrediente){
        try{
            rIngrediente.save(ingrediente);
            return true;
        }catch(Exception e){
            return false;
        }
    }

    public boolean eliminar(int id){
        try{
            rIngrediente.delete(rIngrediente.findById(id).get());
            return true;
        }catch(Exception e){
            return false;
        }
    }


}
