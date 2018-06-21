package com.proyecto.arq.controller;

import com.proyecto.arq.entity.Ingrediente;
import com.proyecto.arq.entity.Usuario;
import com.proyecto.arq.model.MAmigo;
import com.proyecto.arq.model.MUsuario;
import com.proyecto.arq.service.SUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

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
    public int login(HttpServletRequest request, @RequestBody @Valid MUsuario usuario) {
        int res = sUsuario.login(usuario);
        if (res != -1) {
            request.getSession(true);
            request.getSession().setAttribute("usuario", res);
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

    @PutMapping("usuario")
    public boolean actualizarUsuario(@RequestParam("imagen_usuario")MultipartFile imagen_usuario,
                                     @RequestParam("nickname") String nickname,
                                     @RequestParam("correo")String correo,
                                     @RequestParam("password")String password, HttpServletRequest request) {
        try{
            Usuario usuario=new Usuario();
            usuario.setCorreo(correo);
            try {
                usuario.setImagen_usuario(imagen_usuario.getBytes());
                usuario.setNickname(nickname);
                usuario.setPassword(password);
                usuario.setId((Integer) request.getSession().getAttribute("usuario"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            return sUsuario.actualizar(usuario);
        }catch(Exception e){
            return false;
        }
    }

    @PostMapping("usuario/cerraSession")
    public boolean cerraSession(HttpServletRequest request) {
        try{
            request.getSession().removeAttribute("usuario");
            return true;
        }catch(Exception e){
            return false;
        }
    }

    @PutMapping("usuario/privacidad")
    public boolean actualizarEstado(HttpServletRequest request) {
       try{
           return sUsuario.cambiarPrivacidad((Integer) request.getSession().getAttribute("usuario"));
       }catch(Exception e){
           return false;
       }
    }
}