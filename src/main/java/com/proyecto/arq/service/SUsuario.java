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

import java.util.ArrayList;
import java.util.List;

@Service("SUsuario")
public class SUsuario {

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
        try{
            return convertidor.convertirUsuario(rUsuario.findById(id).get());
        }catch(Exception e){
            return null;
        }

    }

    public int login(MUsuario usuario){
       try{
           Usuario user=rUsuario.findByCorreo(usuario.getCorreo());
           
           
           if(user.getPassword().equals(usuario.getPassword())){
               return user.getId();
           }else{
               return -1;
           }
       }catch(Exception e){
           return -1;
       }
    }


    public boolean actualizar(Usuario usuario){
        try{
        	Usuario user=rUsuario.findByCorreo(usuario.getCorreo());
        	user.setImagen_usuario(usuario.getImagen_usuario());
        	user.setNickname(usuario.getNickname());
        	user.setPassword(usuario.getPassword());
        	user.setPrivacidad(usuario.isPrivacidad());
            rUsuario.save(user);
            return true;
        }catch(Exception e){
        	e.printStackTrace();
            return false;
        }
    }

    public boolean eliminar(int id){
        try{
            rUsuario.delete(rUsuario.findById(id).get());
            return true;
        }catch(Exception e){
            return false;
        }
    }

    public boolean registrarSeguidor(MAmigo amigo){
        try{
            Usuario usuario=rUsuario.findById(amigo.getId_usuario()).get();
            Usuario seguido=rUsuario.findById(amigo.getId_amigo()).get();
            Amigo a=new Amigo();
            a.setUsuario(usuario);
            a.setAmigo(seguido);
            rAmigo.save(a);
            return true;
        }catch(Exception e){
            return false;
        }
    }
    
    public boolean eliminarSeguidor(MAmigo amigo){
        try{
            rAmigo.deleteById(rAmigo.findByAmigoAndUsuario(amigo.getId_usuario(), amigo.getId_amigo()).getId());
            return true;
        }catch(Exception e){
            return false;
        }
    }
    

    public List<MUsuario> listarSeguidos(int id){
         List<MUsuario> usuarios=convertidor.convertirSeguidos(rUsuario.findById(id).get().getSeguidos());
         for (int i = 0; i < usuarios.size(); i++) {
    				usuarios.get(i).setSiguiendo(true);
 			}
         return usuarios;
    }
    
    public List<MUsuario> listarSeguidores(int id){
       try{
           List<MUsuario> usuarios=convertidor.convertirSeguidores(rUsuario.findById(id).get().getSeguidores());
       	for (int i = 0; i < usuarios.size(); i++) {
       		if(rAmigo.findByAmigoAndUsuario(id,usuarios.get(i).getId())!=null) {
   				usuarios.get(i).setSiguiendo(true);
       		}
			}
           return usuarios;
       }catch (Exception e){
           return null;
        }
    }

    public int cantidadSeguidores(int id){
        return rUsuario.findById(id).get().getSeguidores().size();
    }

    public int cantidadSeguidos(int id){
        return rUsuario.findById(id).get().getSeguidos().size();
    }

    public List<MUsuario> listarUsuariosNombre(String nombre,int id){
        try{
        	List<MUsuario> usuarios=convertidor.convertirUsuarios(rUsuario.findByNicknameIgnoreCaseContaining(nombre));
        	for (int i = 0; i < usuarios.size(); i++) {
        		if(rAmigo.findByAmigoAndUsuario(id,usuarios.get(i).getId())!=null) {
    				usuarios.get(i).setSiguiendo(true);
        		}
			}
            return usuarios;
        }catch(Exception e){
            return null;
        }
    }

    public boolean cambiarPrivacidad(int usuario){
        try{
            Usuario user=rUsuario.findById(usuario).get();
            user.setPrivacidad(!rUsuario.findById(usuario).get().isPrivacidad());
            rUsuario.save(user);
            return true;
        }catch(Exception e){
            return false;
        }
    }


	
}
