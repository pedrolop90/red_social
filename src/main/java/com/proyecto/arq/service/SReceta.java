package com.proyecto.arq.service;

import com.proyecto.arq.converter.Convertidor;
import com.proyecto.arq.entity.*;
import com.proyecto.arq.model.MIngrediente;
import com.proyecto.arq.model.MPaso;
import com.proyecto.arq.model.MReceta;
import com.proyecto.arq.model.MUsuario;
import com.proyecto.arq.repository.RCategoria;
import com.proyecto.arq.repository.RIngrediente;
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
import java.util.Iterator;
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
    private RCategoria rCategoria;
    @Autowired
    private RIngrediente rIngrediente;
    @Autowired
    private Convertidor convertidor;

//    private String url_folder_imagenes=".//src//main//resources//files//";

   /* public void guardarArchivo(MultipartFile file){
        if(!file.isEmpty()){
            try {
                byte[] bytes=file.getBytes();
                Path path= Paths.get(url_folder_imagenes+file.getOriginalFilename());
                Files.write(path,bytes);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }*/


    public MReceta registrar(Receta receta){
        try{
            Publicacion p=new Publicacion();
            p.setUsuario(rUsuario.findById(receta.getId_usuario()).get());
            p.setImage_receta(receta.getImagen_receta());
            p.setReceta(receta);
            p.setCategoria(rCategoria.findById(receta.getId_categoria()).get());
            return  convertidor.convertirReceta(rPublicacion.save(p).getReceta());
        }catch(Exception e){
        	e.printStackTrace();
            return null;
        }
    }

    public MReceta actualizar(Receta receta){
        try{
        	Publicacion p=rPublicacion.findByReceta(receta);
            p.setUsuario(rUsuario.findById(receta.getId_usuario()).get());
            p.setImage_receta(receta.getImagen_receta());
            p.setReceta(receta);
            p.setCategoria(rCategoria.findById(receta.getId_categoria()).get());
            if(receta.getPasos()!=null) {
            	for (int i = 0; i < receta.getPasos().size(); i++) {
            		for (int j = 0; j < receta.getPasos().get(i).getIngredientes().size(); j++) {
            			receta.getPasos().get(i).getIngredientes().get(j).setIngrediente(rIngrediente.findById(receta.getPasos().get(i).getIngredientes().get(j).getId_ingrediente()).get());
					System.out.println(receta.getPasos().get(i).getIngredientes().get(j).getIngrediente());
            		}
				}
            }
            return  convertidor.convertirReceta(rPublicacion.save(p).getReceta());
        }catch(Exception e){
        	e.printStackTrace();
            return null;
        }
    }

    public boolean eliminar(int id){
        try{
            rReceta.delete(rReceta.findById(id).get());
            return true;
        }catch(Exception e){
            return false;
        }
    }

    public List<MPaso> listarPasos(int id){
        return convertidor.convertirPaso(rReceta.findById(id).get().getPasos());
    }

    public List<MIngrediente> listarIngredientes(int id){
        return convertidor.convertirIngredientes(rReceta.findById(id).get().getIngredientes());
    }

    
    public MReceta consultarReceta(int id){
        try{
            return convertidor.convertirReceta(rReceta.findById(id).get());
        }catch(Exception e){
            return null;
        }

    }
    
    
}
