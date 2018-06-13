package com.proyecto.arq.controller;


import com.proyecto.arq.entity.Mensaje;
import com.proyecto.arq.entity.Usuario;
import com.proyecto.arq.model.MAmigo;
import com.proyecto.arq.model.MMensaje;
import com.proyecto.arq.model.MUsuario;
import com.proyecto.arq.service.SMensaje;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/v1")
public class CMensaje {

    @Autowired
    private SMensaje sMensaje;

    @PutMapping("/mensaje")
    public int registrarUsuario(@RequestBody @Valid MMensaje mensaje, HttpServletRequest request){
        mensaje.setOrigen((Integer)request.getAttribute("usuario"));
        return sMensaje.registrar(mensaje);
    }
    @GetMapping("/mensaje/recibido/{id}")
    public List<MMensaje> listarMensajeRecibidos(@PathVariable("id") int id){
        return sMensaje.listarMensajesRecibidos(id);
    }
    @GetMapping("/mensaje/enviado/{id}")
    public List<MMensaje> listarMensajeEnviados(@PathVariable("id") int id){
        return sMensaje.listarMensajeEnviados(id);
    }
}
