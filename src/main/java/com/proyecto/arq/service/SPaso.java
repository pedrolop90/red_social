package com.proyecto.arq.service;

import com.proyecto.arq.converter.Convertidor;
import com.proyecto.arq.entity.Paso;
<<<<<<< HEAD
import com.proyecto.arq.entity.Usuario;
import com.proyecto.arq.model.MAmigo;
import com.proyecto.arq.model.MIngrediente;
import com.proyecto.arq.model.MPaso_Ingrediente;
import com.proyecto.arq.model.MUsuario;
import com.proyecto.arq.repository.RAmigo;
import com.proyecto.arq.repository.RPaso;
import com.proyecto.arq.repository.RPaso_Ingrediente;
import com.proyecto.arq.repository.RUsuario;
=======
import com.proyecto.arq.repository.RPaso;
>>>>>>> cd4adfaf57fc9adeabdc80bc497c6320d18f0cc1
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service("SPaso")
public class SPaso {

    @Autowired
    private RPaso rPaso;
    @Autowired
    private Convertidor convertidor;

<<<<<<< HEAD
    @Autowired
    private RPaso_Ingrediente rPasoIng;



=======
>>>>>>> cd4adfaf57fc9adeabdc80bc497c6320d18f0cc1
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
    ///listaringredienteporpasos
    public List<MIngrediente> Listaringredientesporpasos(int id){
      return convertidor.convertirPasoporIngredientes(rPaso.findOne(id).getIngredientes());

    }

//eliminar ingrediente

    public boolean eliminarIngrediente(int id) {
        try {
            rPasoIng.delete(id);
            return true;
        } catch (Exception e) {
            return false;
        }

    }

}
