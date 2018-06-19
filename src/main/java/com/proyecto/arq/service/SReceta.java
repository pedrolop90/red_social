package com.proyecto.arq.service;

import com.proyecto.arq.converter.Convertidor;
import com.proyecto.arq.entity.*;
import com.proyecto.arq.model.MAmigo;
import com.proyecto.arq.model.MIngrediente;
import com.proyecto.arq.model.MPaso;
import com.proyecto.arq.model.MUsuario;
import com.proyecto.arq.repository.RAmigo;
import com.proyecto.arq.repository.RPublicacion;
import com.proyecto.arq.repository.RReceta;
import com.proyecto.arq.repository.RUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Service("SReceta")
public class SReceta {

    @Autowired
    private RReceta rReceta;
    @Autowired
    private RPublicacion rPublicacion;
    @Autowired
    private RUsuario rUsuario;
    @Autowired
    private Convertidor convertidor;

    private String url_folder_imagenes=".//src//main//resources//files//";

    public void guardarArchivo(MultipartFile file){
        if(!file.isEmpty()){
            try {
                byte[] bytes=file.getBytes();
                Path path= Paths.get(url_folder_imagenes+file.getOriginalFilename());
                Files.write(path,bytes);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }


    public int registrar(MultipartFile file,String nombre,int id){
        try{
            Publicacion p=new Publicacion();
            Receta receta=rReceta.findOne(id);
            receta.setId_usuario(id);
            receta.setFile(file);
            p.setReceta(receta);
            p.setUsuario(rUsuario.findOne(receta.getId_usuario()));
            return rPublicacion.save(p).getReceta().getId();
        }catch(Exception e){
            return -1;
        }
    }

    public boolean actualizar(Receta receta){
        try{
            rReceta.save(receta);
            return true;
        }catch(Exception e){
            return false;
        }
    }

    public boolean eliminar(int id){
        try{
            rReceta.delete(rReceta.findOne(id));
            return true;
        }catch(Exception e){
            return false;
        }
    }

    public List<MPaso> listarPasos(int id){
        return convertidor.convertirPaso(rReceta.findOne(id).getPasos());
    }

    public List<MIngrediente> listarIngredientes(int id){
        return convertidor.convertirIngredientes(rReceta.findOne(id).getIngredientes());
    }

}
