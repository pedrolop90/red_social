package com.proyecto.arq.controller;

import com.proyecto.arq.entity.Ingrediente;
import com.proyecto.arq.entity.Usuario;
import com.proyecto.arq.model.MAmigo;
import com.proyecto.arq.model.MUsuario;
import com.proyecto.arq.service.SUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/v1")
public class CUsuario {

    @Autowired
    private SUsuario sUsuario;

    @PostMapping("/usuario")
    public int registrarUsuario(@RequestBody @Valid Usuario usuario){
        return sUsuario.registrar(usuario);
    }

    @PostMapping("/usuario/seguir")
    public boolean registrarSeguidos(HttpServletRequest request,@RequestBody @Valid MAmigo amigo){
        amigo.setId_usuario((Integer) request.getSession().getAttribute("usuario"));
        return sUsuario.registrarSeguidor(amigo);
    }



    @GetMapping("/usuario/seguidos")
    public List<MUsuario> listarSeguidos(HttpServletRequest request){
        return sUsuario.listarSeguidos((Integer) request.getSession().getAttribute("usuario"));
    }
    @GetMapping("/usuario/seguidores")
    public List<MUsuario> listarSeguidores(HttpServletRequest request){
        return sUsuario.listarSeguidores((Integer) request.getSession().getAttribute("usuario"));
    }

    @PostMapping("usuario/login")
    public int login(HttpServletRequest request,@RequestBody @Valid MUsuario usuario){
      int res=sUsuario.login(usuario);
      if(res!=-1){
          request.getSession(true);
          request.getSession().setAttribute("usuario",res);
      }
      return res;
    }

    @GetMapping("usuario/seguidores/cantidad")
    public int cantidadSeguidores(HttpServletRequest request){
        return sUsuario.cantidadSeguidores((Integer) request.getSession().getAttribute("usuario"));
    }
    @GetMapping("usuario/seguidos/cantidad")
    public int cantidadSeguidos(HttpServletRequest request){
        return sUsuario.cantidadSeguidos((Integer) request.getSession().getAttribute("usuario"));
    }
    @GetMapping("usuarios/{nombre}")
    public List<MUsuario> listarUsuariosNombre(@PathVariable("nombre") String nombre){
        return sUsuario.listarUsuariosNombre(nombre);
    }

    @GetMapping("usuario/{id}")
    public MUsuario consultarUsuario(@PathVariable("id") int id){
        return sUsuario.consultarUsuario(id);
    }

    @PutMapping("usuario")
    public boolean actualizarUsuario(@RequestBody @Valid Usuario usuario,HttpServletRequest request){
        usuario.setId((Integer) request.getSession().getAttribute("usuario"));
        return sUsuario.actualizar(usuario);
    }

    @PostMapping("usuario/privacidad")
     public int actualizarestado(@RequestBody @Valid Usuario usuario,HttpServletRequest request){
        if(usuario.isPrivacidad()){
            usuario.setPrivacidad(false);
            sUsuario.actualizar(usuario);
            return 1;
        }else{
            usuario.setPrivacidad(true);
            sUsuario.actualizar(usuario);
            return 2;
        }

    }

}
