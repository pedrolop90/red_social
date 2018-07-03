package com.proyecto.arq.controller;

import com.proyecto.arq.configuration.JwtUtil;
import com.proyecto.arq.entity.Accion;
import com.proyecto.arq.entity.Comentario;
import com.proyecto.arq.service.SAccion;
import com.proyecto.arq.service.SComentario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@RestController
@RequestMapping("/v1")
public class CAccion {

    @Autowired
    private SAccion sAccion;

    @PostMapping("/like")
    public int registrarLike(@RequestBody @Valid Accion accion,HttpServletRequest request){
    	try {
    		accion.setUsuario_id(Integer.parseInt(JwtUtil.getAuthentication(request)));
            return sAccion.registrar(accion);
    	}catch(Exception e) {
    		return -1;
    	}
    }

    @DeleteMapping("/like")
    public boolean eliminarLike(@RequestBody @Valid Accion accion){
        return sAccion.eliminar(accion.getId());
    }
    
}
