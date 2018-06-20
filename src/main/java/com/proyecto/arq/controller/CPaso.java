package com.proyecto.arq.controller;

import com.proyecto.arq.entity.Ingrediente;
import com.proyecto.arq.entity.Paso;
import com.proyecto.arq.model.MIngrediente;
import com.proyecto.arq.model.MPaso_Ingrediente;
import com.proyecto.arq.service.SIngrediente;
import com.proyecto.arq.service.SPaso;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

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

    //Lista ingrediente pasoxingrediente
    @GetMapping("/paso/ingrediente/{id}")
    public List<MIngrediente> listarpasoxingrediente(@PathVariable("id") int id){
        return sPaso.Listaringredientesporpasos(id);
    }

    @DeleteMapping("/paso/eliminaringrediente/{id}")
    public boolean eliminarIngredienteaunpaso(@PathVariable("id") int id)
    {
        return sPaso.eliminarIngrediente(id);
    }

}
