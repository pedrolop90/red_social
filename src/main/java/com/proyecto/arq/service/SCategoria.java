package com.proyecto.arq.service;

import com.proyecto.arq.converter.Convertidor;
import com.proyecto.arq.entity.Amigo;
import com.proyecto.arq.entity.Categoria;
import com.proyecto.arq.entity.Usuario;
import com.proyecto.arq.model.MAmigo;
import com.proyecto.arq.model.MUsuario;
import com.proyecto.arq.repository.RAmigo;
import com.proyecto.arq.repository.RCategoria;
import com.proyecto.arq.repository.RUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("SCategoria")
public class SCategoria {

    @Autowired
    private RCategoria rCategoria;
    @Autowired
    private Convertidor convertidor;



    public int registrar(Categoria categoria){
        try{
            return rCategoria.save(categoria).getId();
        }catch(Exception e){
            return -1;
        }
    }

    public boolean actualizar(Categoria categoria){
        try{
            rCategoria.save(categoria);
            return true;
        }catch(Exception e){
            return false;
        }
    }

    public boolean eliminar(int id){
        try{
            rCategoria.delete(rCategoria.findOne(id));
            return true;
        }catch(Exception e){
            return false;
        }
    }

    public List<Categoria> listarCategorias(){
        try{
            return rCategoria.findAll();
        }catch(Exception e){
            return null;
        }
    }

}
