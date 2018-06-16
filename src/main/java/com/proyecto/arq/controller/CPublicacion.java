package com.proyecto.arq.controller;

import com.proyecto.arq.entity.Categoria;
import com.proyecto.arq.entity.Ingrediente;
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
    public boolean listarCategorias(@PathVariable("id") int id){
        return sPublicacion.eliminar(id);
    }

    @GetMapping("/publicacion/{id}")
    public  List<MPublicacion> listarPublicacionesUnUsuario(@PathVariable("id") int id){
        return sPublicacion.listarPublicacionesUnUsuario(id);
    }

    @GetMapping("/publicacion/likes/{id}")
    public  int listarCantidadLikesPublicacion(@PathVariable("id") int id){
        return sPublicacion.listarCantidadLikesPublicacion(id);
    }

    @GetMapping("/publicacion/comentario/{id}")
    public  List<MComentario> listarComentariosPublicacion(@PathVariable("id") int id){
        return sPublicacion.listarComentariosPublicacion(id);
    }

}