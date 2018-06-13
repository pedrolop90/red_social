package com.proyecto.arq.service;

import com.proyecto.arq.converter.Convertidor;
import com.proyecto.arq.entity.Amigo;
import com.proyecto.arq.entity.Usuario;
import com.proyecto.arq.model.MAmigo;
import com.proyecto.arq.model.MUsuario;
import com.proyecto.arq.repository.RAmigo;
import com.proyecto.arq.repository.RUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("SUsuario")
public class SAccion {

    @Autowired
    private RUsuario rUsuario;
    @Autowired
    private RAmigo rAmigo;
    @Autowired
    private Convertidor convertidor;



    public int registrar(Usuario usuario){
        try{
            return rUsuario.save(usuario).getId();
        }catch(Exception e){
            return -1;
        }
    }

    public MUsuario consultarUsuario(int id){
        return convertidor.convertirUsuario(rUsuario.findOne(id));
    }

    public int login(MUsuario usuario){
        Usuario user=rUsuario.findByCorreo(usuario.getCorreo());
        if(user!=null&&user.getPassword().equals(usuario.getPassword())){
            return user.getId();
        }else{
            return -1;
        }
    }


    public boolean actualizar(Usuario usuario){
        try{
            rUsuario.save(usuario);
            return true;
        }catch(Exception e){
            return false;
        }
    }

    public boolean eliminar(int id){
        try{
            rUsuario.delete(rUsuario.findOne(id));
            return true;
        }catch(Exception e){
            return false;
        }
    }

    public boolean registrarSeguidor(MAmigo amigo){
        try{
            Usuario usuario=rUsuario.findOne(amigo.getId_usuario());
            Usuario seguido=rUsuario.findOne(amigo.getId_amigo());
            Amigo a=new Amigo();
            a.setUsuario(usuario);
            a.setAmigo(seguido);
            rAmigo.save(a);
            return true;
        }catch(Exception e){
            return false;
        }
    }

    public List<MUsuario> listarSeguidos(int id){
        return convertidor.convertirSeguidos(rUsuario.findOne(id).getSeguidos());
    }
    public List<MUsuario> listarSeguidores(int id){
        return convertidor.convertirSeguidores(rUsuario.findOne(id).getSeguidores());
    }

    public int cantidadSeguidores(int id){
        return rUsuario.findOne(id).getSeguidores().size();
    }

    public int cantidadSeguidos(int id){
        return rUsuario.findOne(id).getSeguidos().size();
    }

    public List<MUsuario> listarUsuariosNombre(String nombre){
        return convertidor.convertirUsuarios(rUsuario.findByNicknameIgnoreCaseContaining(nombre));
    }


}
