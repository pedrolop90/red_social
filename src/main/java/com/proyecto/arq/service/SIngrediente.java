package com.proyecto.arq.service;

import com.proyecto.arq.converter.Convertidor;
import com.proyecto.arq.entity.Ingrediente;
import com.proyecto.arq.entity.Receta;
import com.proyecto.arq.model.MIngrediente;
import com.proyecto.arq.repository.RIngrediente;
import com.proyecto.arq.repository.RPaso_Ingrediente;
import com.proyecto.arq.repository.RReceta;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("SIngrediente")
public class SIngrediente {

    @Autowired
    private RIngrediente rIngrediente;
    @Autowired
    private RPaso_Ingrediente rPaso_Ingrediente;
    @Autowired
    private RReceta rReceta;
    @Autowired
    private Convertidor convertidor;


    public MIngrediente registrar(Receta receta) {
        try {
        	Receta r=rReceta.findById(receta.getId()).get();
        	r.getIngredientes().addAll(receta.getIngredientes());
        	if(r.getPasos()!=null) {
            	r.getPasos().size();
        	}
            return convertidor.convertirIngrediente(rReceta.save(r).getIngredientes().get(r.getIngredientes().size()-1));
        } catch (Exception e) {
            return null;
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
        	if(rPaso_Ingrediente.findByIngrediente(rIngrediente.findById(id).get())==null) {
                rIngrediente.deleteById(id);
                return true;
        	}
        	return false;
        }catch(Exception e){
            return false;
        }
    }


}
