package com.proyecto.arq.service;

import com.proyecto.arq.converter.Convertidor;
import com.proyecto.arq.entity.Ingrediente;
import com.proyecto.arq.entity.Paso;
import com.proyecto.arq.entity.Paso_Ingrediente;
import com.proyecto.arq.model.MIngrediente;
import com.proyecto.arq.model.MPaso_Ingrediente;
import com.proyecto.arq.repository.RIngrediente;
import com.proyecto.arq.repository.RPaso;
import com.proyecto.arq.repository.RPaso_Ingrediente;
import com.proyecto.arq.repository.RReceta;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service("SPaso")
public class SPaso {

    @Autowired
    private RPaso rPaso;
    @Autowired
    private Convertidor convertidor;
    @Autowired
    private RIngrediente rIng;
    @Autowired
    private RReceta rReceta;
    @Autowired
    private RPaso_Ingrediente rPasoIng;

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
            rPaso.delete(rPaso.findById(id).get());
            return true;
        }catch(Exception e){
            return false;
        }
    }

    public List<MIngrediente> Listaringredientesporpasos(int id){
        return convertidor.convertirPasoporIngredientes(rPaso.findById(id).get().getIngredientes());

    }


    public boolean eliminarIngrediente(int id) {
        try {
            rPasoIng.delete(rPasoIng.findById(id).get());
            return true;
        } catch (Exception e) {
            return false;
        }

    }
    public boolean actualizarpasoIngrediente(MPaso_Ingrediente ing){
        try{
            Paso paso=rPaso.findById(ing.getId_paso()).get();
            Ingrediente ingrediente=rIng.findById(ing.getId_ingrediente()).get();
            Paso_Ingrediente paso_ingrediente=rPasoIng.findByIngrediente(ingrediente);
            paso_ingrediente.setMedida(ing.getMedida());
            paso_ingrediente.setMedida(ing.getCantidad());
            rPasoIng.save(paso_ingrediente);
            return true;
        } catch (Exception e){
            return false;
        }
    }


}
