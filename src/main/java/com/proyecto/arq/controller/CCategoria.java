package com.proyecto.arq.controller;

import com.proyecto.arq.entity.Categoria;
import com.proyecto.arq.entity.Receta;
import com.proyecto.arq.model.MCategoria;
import com.proyecto.arq.service.SCategoria;
import com.proyecto.arq.service.SReceta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/v1")
public class CCategoria {

    @Autowired
    private SCategoria sCategoria;

    @GetMapping("/categoria")
    public List<MCategoria> listarCategorias(){
        return sCategoria.listarCategorias();
    }

}