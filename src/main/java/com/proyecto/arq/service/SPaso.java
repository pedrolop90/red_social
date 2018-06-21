package com.proyecto.arq.service;
import com.proyecto.arq.converter.Convertidor;
import com.proyecto.arq.entity.Ingrediente;
import com.proyecto.arq.entity.Paso;
<<<<<<< HEAD
import com.proyecto.arq.entity.Paso_Ingrediente;
import com.proyecto.arq.model.MIngrediente;
import com.proyecto.arq.model.MPaso_Ingrediente;
import com.proyecto.arq.repository.RIngrediente;
=======
import com.proyecto.arq.model.MIngrediente;
>>>>>>> 8a144c1d7ca367baa1d6a384c2f44da46616b045
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
<<<<<<< HEAD

    @Autowired
    private RIngrediente rIng;
    @Autowired
    private RPaso_Ingrediente rPasoIng;




=======
    @Autowired
    private RPaso_Ingrediente rPasoIng;

>>>>>>> 8a144c1d7ca367baa1d6a384c2f44da46616b045
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

<<<<<<< HEAD
    //actualizar paso ingrediente
    public boolean actualizarpasoIngrediente(MPaso_Ingrediente ing){
       try{
           Ingrediente into=rIng.findOne(ing.getId_ingrediente());
           Paso p=rPaso.findOne(ing.getId_paso());
            Paso_Ingrediente pi=new Paso_Ingrediente();
            pi.setIngrediente(into);
            pi.setPaso(p);
            pi.setMedida(ing.getMedida());
            rPasoIng.save(pi);
           return true;
       } catch (Exception e){
           return false;
       }
    }
=======
>>>>>>> 8a144c1d7ca367baa1d6a384c2f44da46616b045

}
