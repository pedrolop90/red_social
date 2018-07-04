package com.proyecto.arq.controller;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.proyecto.arq.configuration.JwtUtil;
import com.proyecto.arq.entity.Usuario;
import com.proyecto.arq.model.MAmigo;
import com.proyecto.arq.model.MUsuario;
import com.proyecto.arq.service.SUsuario;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.io.IOException;
import java.util.Enumeration;
import java.util.List;

@RestController
@RequestMapping("/v1")
public class CUsuario {

    @Autowired
    private SUsuario sUsuario;

    @PostMapping("/usuario")
    public String registrarUsuario( @RequestBody @Valid Usuario usuario,HttpServletResponse response){
        String res= sUsuario.registrar(usuario)+"";
        if (!res.equalsIgnoreCase("-1")) {
        	res=JwtUtil.addAuthentication(response,res+"");
        }
        return res;
    }

    @PostMapping("/usuario/seguir")
    public boolean registrarSeguido(HttpServletRequest request, @RequestBody @Valid MAmigo amigo) {
        try{
            amigo.setId_usuario(Integer.parseInt(JwtUtil.getAuthentication(request)));
            return sUsuario.registrarSeguidor(amigo);
        }catch (Exception e){
        	e.printStackTrace();
            return false;
        }
    }

    @DeleteMapping("/usuario/seguir")
    public boolean eliminarSeguido(HttpServletRequest request, @RequestBody @Valid MAmigo amigo) {
        try{
            amigo.setId_usuario(Integer.parseInt(JwtUtil.getAuthentication(request)));
            return sUsuario.eliminarSeguidor(amigo);
        }catch (Exception e){
        	e.printStackTrace();
            return false;
        }
    }

    @GetMapping("/usuario/seguidos")
    public List<MUsuario> listarSeguidos(HttpServletRequest request) {
        try {
            return sUsuario.listarSeguidos(Integer.parseInt(JwtUtil.getAuthentication(request)));
            
        }catch (Exception e){
            return null;
        }
    }

    @GetMapping("/usuario/seguidores")
    public List<MUsuario> listarSeguidores(HttpServletRequest request) {
        try {
            return sUsuario.listarSeguidores(Integer.parseInt(JwtUtil.getAuthentication(request)));
        }catch (Exception e){
            return null;
        }
    }
    @PostMapping("usuario/login")
    public String login(@RequestBody @Valid MUsuario usuario,HttpServletRequest request,HttpServletResponse response) {
        String res = sUsuario.login(usuario)+"";
        if (!res.equalsIgnoreCase("-1")) {
        	res=JwtUtil.addAuthentication(response,res+"");
        }
        return res;
    }

    @GetMapping("usuario/seguidores/cantidad")
    public int cantidadSeguidores(HttpServletRequest request) {
        try{
            return sUsuario.cantidadSeguidores(Integer.parseInt(JwtUtil.getAuthentication(request)));
        }catch (Exception e){
            return -1;
        }
    }

    @GetMapping("usuario/seguidos/cantidad")
    public int cantidadSeguidos(HttpServletRequest request) {
       try{
           return sUsuario.cantidadSeguidos(Integer.parseInt(JwtUtil.getAuthentication(request)));
       }catch(Exception e){
           return -1;
       }
    }

    @GetMapping("usuarios/{nombre}")
    public List<MUsuario> listarUsuariosNombre(@PathVariable("nombre") String nombre,HttpServletRequest request) {
        return sUsuario.listarUsuariosNombre(nombre,Integer.parseInt(JwtUtil.getAuthentication(request)));
    }

    @GetMapping("usuario/{id}")
    public MUsuario consultarUsuario(@PathVariable("id") int id) {
        return sUsuario.consultarUsuario(id);
    }
    
    @GetMapping("usuario")
    public MUsuario consultarUsuarioPropio(HttpServletRequest request) {
    	try { 
            return sUsuario.consultarUsuario(Integer.parseInt(JwtUtil.getAuthentication(request)));
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
    	   return sUsuario.cambiarPrivacidad(Integer.parseInt(JwtUtil.getAuthentication(request)));
       }catch(Exception e){
    	   e.printStackTrace();
           return false;
       }
    }
}