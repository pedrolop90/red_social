package com.proyecto.arq.service;

import com.proyecto.arq.converter.Convertidor;
import com.proyecto.arq.entity.Ingrediente;
import com.proyecto.arq.entity.Paso;
import com.proyecto.arq.entity.Paso_Ingrediente;
import com.proyecto.arq.entity.Receta;
import com.proyecto.arq.model.MIngrediente;
import com.proyecto.arq.model.MPaso;
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
    @Autowired
    private RIngrediente rIngrediente;

    public MPaso registrar(Receta receta){
    	try {
        	Receta r=rReceta.findById(receta.getId()).get();
        	for (int i = 0; i < receta.getPasos().size(); i++) {
        		for (int j = 0; j < receta.getPasos().get(i).getIngredientes().size(); j++) {
        			System.out.println(receta.getPasos().get(i).getIngredientes().get(i).toString());
        			receta.getPasos().get(i).getIngredientes().get(j).setIngrediente(rIngrediente.findById(receta.getPasos().get(i).getIngredientes().get(j).getId_ingrediente()).get());
				}
        		r.getPasos().add(receta.getPasos().get(i));
			}
        	if(r.getIngredientes()!=null) {
            	r.getIngredientes().size();
        	}
            return convertidor.convertirPasos(rReceta.save(r).getPasos().get(r.getPasos().size()-1));
        } catch (Exception e) {
            return null;
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
        	System.out.println("bbbbbbbbbbb");
            rPaso.deleteById(id);
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
            rPasoIng.deleteById(id);
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
