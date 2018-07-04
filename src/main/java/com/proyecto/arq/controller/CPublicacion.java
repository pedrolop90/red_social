package com.proyecto.arq.controller;

import com.proyecto.arq.configuration.JwtUtil;
import com.proyecto.arq.entity.Categoria;
import com.proyecto.arq.entity.Ingrediente;
import com.proyecto.arq.entity.Publicacion;
import com.proyecto.arq.model.MComentario;
import com.proyecto.arq.model.MPublicacion;
import com.proyecto.arq.service.SCategoria;
import com.proyecto.arq.service.SPublicacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/v1")
public class CPublicacion {

    @Autowired
    private SPublicacion sPublicacion;

    @DeleteMapping("/publicacion/{id}")
    public boolean eliminarPublicacion(@PathVariable("id") int id){
        return sPublicacion.eliminar(id);
    }

    @GetMapping("/publicacion/{id}")
    public  List<MPublicacion> listarPublicacionesUnUsuario(@PathVariable("id") int id){
        try{
            return sPublicacion.listarPublicacionesUnUsuario(id);
        }catch(Exception e){
            return null;
        }
    }
    
    @GetMapping("/publicacion/publicas")
    public  List<MPublicacion> listarUltimasPublicacionesPublicas(HttpServletRequest request){
        try{
            return sPublicacion.listarUltimasPublicacionesPublicas(Integer.parseInt(JwtUtil.getAuthentication(request)));
        }catch(Exception e){
            return null;
        }
    }
    
    @GetMapping("/publicacion/seguidos")
    public  List<MPublicacion> listarPublicacionesSeguidos(HttpServletRequest request){
        try{
            return sPublicacion.listarPublicacionesSeguidos(Integer.parseInt(JwtUtil.getAuthentication(request)));
        }catch(Exception e){
            return null;
        }
    }
    
    
    @GetMapping("/publicacion")
    public  List<MPublicacion> listarPublicacionMiPerfil(HttpServletRequest request){
        try{
            return sPublicacion.listarPublicacionesMiUsuario(Integer.parseInt(JwtUtil.getAuthentication(request)));
        }catch(Exception e){
            return null;
        }
    }
    

    @GetMapping("/publicacion/likes/{id}")
    public  int listarCantidadLikesPublicacion(@PathVariable("id") int id){
       try{
           return sPublicacion.listarCantidadLikesPublicacion(id);
       }catch(Exception e){
           return -1;
       }
    }

    @GetMapping("/publicacion/comentario/{id}")
    public  List<MComentario> listarComentariosPublicacion(@PathVariable("id") int id){
        try{
            return sPublicacion.listarComentariosPublicacion(id);
        }catch(Exception e){
            return null;
        }
    }

    @PutMapping("/publicacion/privacidad")
    public  boolean cambiarPrivacidadPublicacion(@RequestBody @Valid Publicacion publicacion){
        try{
            return sPublicacion.cambiarPrivacidadPublicacion(publicacion);
        }catch(Exception e){
            return false;
        }
    }


}