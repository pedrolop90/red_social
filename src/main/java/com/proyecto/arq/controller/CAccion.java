package com.proyecto.arq.controller;

import com.proyecto.arq.entity.Accion;
import com.proyecto.arq.entity.Comentario;
import com.proyecto.arq.service.SAccion;
import com.proyecto.arq.service.SComentario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/v1")
public class CAccion {

    @Autowired
    private SAccion sAccion;

    @PutMapping("/like")
    public int registrarComentario(@RequestBody @Valid Accion accion){
        return sAccion.registrar(accion);
    }
    @DeleteMapping("/like/{id}")
    public boolean eliminarIngrediente(@PathVariable("id") int id){
        return sAccion.eliminar(id);
    }

}
