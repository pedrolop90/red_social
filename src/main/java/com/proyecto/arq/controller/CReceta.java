package com.proyecto.arq.controller;

import com.proyecto.arq.entity.Ingrediente;
import com.proyecto.arq.entity.Paso;
import com.proyecto.arq.entity.Receta;
import com.proyecto.arq.model.MIngrediente;
import com.proyecto.arq.model.MPaso;
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
    public int registrarUsuario(@RequestParam("imagen_receta") MultipartFile imagen_receta,
                                @RequestParam("imagen_publicacion") MultipartFile imagen_publicacion,
                                @RequestParam("nombre") String nombre,
                                @RequestParam("id_categoria") int id_categoria,
                                @RequestParam("pasos") List<Paso> pasos,
                                @RequestParam("ingredientes") List<Ingrediente> ingredientes,
                                HttpServletRequest request){
       try{
           return sReceta.registrar(imagen_receta,
                   imagen_publicacion,
                   nombre,
                   id_categoria,
                   (Integer)request.getSession().getAttribute("usuario"),pasos,ingredientes);
       }catch(Exception e){
           return -1;
       }
    }

    @PutMapping("/receta")
    public boolean actualizaReceta(@RequestBody @Valid Receta receta,HttpServletRequest request){
        return sReceta.actualizar(receta);
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
