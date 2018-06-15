package com.proyecto.arq.controller;

import com.proyecto.arq.entity.Comentario;
import com.proyecto.arq.entity.Ingrediente;
import com.proyecto.arq.service.SComentario;
import com.proyecto.arq.service.SIngrediente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@RestController
@RequestMapping("/v1")
public class CComentario {

    @Autowired
    private SComentario sComentario;

    @PutMapping("/comentario")
    public int registrarComentario(@RequestBody @Valid Comentario comentario){
        return sComentario.registrar(comentario);
    }
    @DeleteMapping("/comentario/{id}")
    public boolean eliminarIngrediente(@PathVariable("id") int id){
        return sComentario.eliminar(id);
    }

}
