package com.proyecto.arq.controller;

import com.proyecto.arq.entity.Ingrediente;
import com.proyecto.arq.entity.Paso;
import com.proyecto.arq.service.SIngrediente;
import com.proyecto.arq.service.SPaso;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@RestController
@RequestMapping("/v1")
public class CPaso {

    @Autowired
    private SPaso sPaso;

    @PutMapping("/paso")
    public boolean actualizarPaso(@RequestBody @Valid Paso paso, HttpServletRequest request) {
        return sPaso.actualizar(paso);
    }
    @DeleteMapping("/paso/{id}")
    public boolean eliminarPaso(@PathVariable("id") int id){
        return sPaso.eliminar(id);
    }

}
