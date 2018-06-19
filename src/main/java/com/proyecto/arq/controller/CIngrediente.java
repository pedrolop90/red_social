package com.proyecto.arq.controller;

import com.proyecto.arq.entity.Categoria;
import com.proyecto.arq.entity.Ingrediente;
import com.proyecto.arq.entity.Receta;
import com.proyecto.arq.model.MIngrediente;
import com.proyecto.arq.service.SCategoria;
import com.proyecto.arq.service.SIngrediente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/v1")
public class CIngrediente {

    @Autowired
    private SIngrediente sIngrediente;

    @PutMapping("/ingrediente")
    public boolean actualizarIngrediente(@RequestBody @Valid Ingrediente ingrediente, HttpServletRequest request){
        return sIngrediente.actualizar(ingrediente);
    }
    @DeleteMapping("/ingrediente/{id}")
    public boolean eliminarIngrediente(@PathVariable("id") int id){
        return sIngrediente.eliminar(id);
    }

}
