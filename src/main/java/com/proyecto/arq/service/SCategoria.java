package com.proyecto.arq.service;

import com.proyecto.arq.converter.Convertidor;
import com.proyecto.arq.entity.Categoria;
import com.proyecto.arq.model.MCategoria;
import com.proyecto.arq.repository.RCategoria;
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
            rCategoria.delete(rCategoria.findById(id).get());
            return true;
        }catch(Exception e){
            return false;
        }
    }

    public List<MCategoria> listarCategorias(){
        try{
            return convertidor.convertirCategorias(rCategoria.findAll());
        }catch(Exception e){
            return null;
        }
    }

}
