package com.proyecto.arq.controller;

import com.proyecto.arq.entity.Receta;
import com.proyecto.arq.model.MIngrediente;
import com.proyecto.arq.model.MPaso;
import com.proyecto.arq.model.MReceta;
import com.proyecto.arq.service.SReceta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/v1")
public class CReceta {

    @Autowired
    private SReceta sReceta;

    @PostMapping("/receta")
    public MReceta registrarReceta(@RequestBody @Valid Receta receta,HttpServletRequest request){
       try{
    	   if(receta.getId_usuario()==0) {
    		   receta.setId_usuario((Integer) request.getSession().getAttribute("usuario"));
    	   }
           return sReceta.registrar(receta);
       }catch(Exception e){
    	   e.printStackTrace();
           return null;
       }
    }

    @PutMapping("/receta")
    public boolean actualizaReceta(@RequestBody @Valid Receta receta,HttpServletRequest request){
    	try {
    		 if(receta.getId_usuario()==0) {
    	  		   receta.setId_usuario((Integer) request.getSession().getAttribute("usuario"));
    	  	   }
    	        return sReceta.actualizar(receta);
    	}catch(Exception e) {
    		e.printStackTrace();
    		return false;
    	}
    }
    
    @GetMapping("/receta/{id}")
    public MReceta consultarReceta(@PathVariable("id") int id,HttpServletRequest request){
        return sReceta.consultarReceta(id);
    }
    
    @GetMapping("/receta/paso/{id}")
    public List<MPaso> listarPasos(@PathVariable("id") int id){
        return sReceta.listarPasos(id);
    }
    @GetMapping("/receta/ingrediente/{id}")
    public List<MIngrediente> listarIngredientes(@PathVariable("id") int id){
        return sReceta.listarIngredientes(id);
    }

}
