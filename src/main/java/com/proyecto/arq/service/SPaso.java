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
            rPaso.delete(rPaso.findOne(id));
            return true;
        }catch(Exception e){
            return false;
        }
    }

    public List<MIngrediente> Listaringredientesporpasos(int id){
        return convertidor.convertirPasoporIngredientes(rPaso.findOne(id).getIngredientes());

    }


    public boolean eliminarIngrediente(int id) {
        try {
            rPasoIng.delete(id);
            return true;
        } catch (Exception e) {
            return false;
        }

    }
    public boolean actualizarpasoIngrediente(MPaso_Ingrediente ing){
        try{
            Paso paso=rPaso.findOne(ing.getId_paso());
            Ingrediente ingrediente=rIng.findOne(ing.getId_ingrediente());
            Paso_Ingrediente paso_ingrediente=rPasoIng.findByIngredienteAndPaso(ingrediente,paso);
            paso_ingrediente.setMedida(ing.getMedida());
            rPasoIng.save(paso_ingrediente);
            return true;
        } catch (Exception e){
            return false;
        }
    }


}
