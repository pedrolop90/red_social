package com.proyecto.arq.controller;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.proyecto.arq.entity.Usuario;
import com.proyecto.arq.model.MAmigo;
import com.proyecto.arq.model.MUsuario;
import com.proyecto.arq.service.SUsuario;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/v1")
public class CUsuario {

    @Autowired
    private SUsuario sUsuario;

    @PostMapping("/usuario")
    public int registrarUsuario( @RequestBody @Valid Usuario usuario){
        return sUsuario.registrar(usuario);
    }

    @PostMapping("/usuario/seguir")
    public boolean registrarSeguidos(HttpServletRequest request, @RequestBody @Valid MAmigo amigo) {
        try{
            amigo.setId_usuario((Integer) request.getSession().getAttribute("usuario"));
            return sUsuario.registrarSeguidor(amigo);
        }catch (Exception e){
            return false;
        }
    }


    @GetMapping("/usuario/seguidos")
    public List<MUsuario> listarSeguidos(HttpServletRequest request) {
        try {
            return sUsuario.listarSeguidos((Integer) request.getSession().getAttribute("usuario"));
        }catch (Exception e){
            return null;
        }
    }

    @GetMapping("/usuario/seguidores")
    public List<MUsuario> listarSeguidores(HttpServletRequest request) {
        try {
            return sUsuario.listarSeguidores((Integer) request.getSession().getAttribute("usuario"));
        }catch (Exception e){
            return null;
        }
    }

    @PostMapping("usuario/login")
    public int login(@RequestBody @Valid MUsuario usuario,HttpServletRequest request) {
        int res = sUsuario.login(usuario);
        if (res != -1) {
        	request.getSession(true);
            request.getSession(true).setAttribute("usuario", res);
            
        }
        return res;
    }

    @GetMapping("usuario/seguidores/cantidad")
    public int cantidadSeguidores(HttpServletRequest request) {
        try{
            return sUsuario.cantidadSeguidores((Integer) request.getSession().getAttribute("usuario"));
        }catch (Exception e){
            return -1;
        }
    }

    @GetMapping("usuario/seguidos/cantidad")
    public int cantidadSeguidos(HttpServletRequest request) {
       try{
           return sUsuario.cantidadSeguidos((Integer) request.getSession().getAttribute("usuario"));
       }catch(Exception e){
           return -1;
       }
    }

    @GetMapping("usuarios/{nombre}")
    public List<MUsuario> listarUsuariosNombre(@PathVariable("nombre") String nombre) {
        return sUsuario.listarUsuariosNombre(nombre);
    }

    @GetMapping("usuario/{id}")
    public MUsuario consultarUsuario(@PathVariable("id") int id) {
        return sUsuario.consultarUsuario(id);
    }
    
    @GetMapping("usuario")
    public MUsuario consultarUsuarioPropio(HttpServletRequest request) {
    	try {
            return sUsuario.consultarUsuario((Integer)request.getSession().getAttribute("usuario"));
    	}catch(Exception e) {
    		return null;
    	}
    }

    @PutMapping("usuario")
    public boolean actualizarUsuario(@RequestBody @Valid Usuario usuario, HttpServletRequest request) {
        try{
            return sUsuario.actualizar(usuario);
        }catch(Exception e){
        	e.printStackTrace();
            return false;
        }
    }
     

    @PostMapping("usuario/cerrarSession")
    public boolean cerraSession(HttpServletRequest request) {
        try{
            request.getSession().removeAttribute("usuario");
            return true;
        }catch(Exception e){
            return false;
        }
    }

    @PutMapping("usuario/privacidad/prueba")
    public boolean actualizarEstado(@RequestBody @Valid Usuario usuario,HttpServletRequest request) {
       try{
    	   return sUsuario.cambiarPrivacidad(usuario.getId());
       }catch(Exception e){
           return false;
       }
    }
    @PutMapping("usuario/privacidad")
    public boolean actualizarEstado(HttpServletRequest request) {
       try{
    	   return sUsuario.cambiarPrivacidad((Integer) request.getSession().getAttribute("usuario"));
       }catch(Exception e){
    	   e.printStackTrace();
           return false;
       }
    }
}