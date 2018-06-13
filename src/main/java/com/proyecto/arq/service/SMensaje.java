package com.proyecto.arq.service;


import com.proyecto.arq.converter.Convertidor;
import com.proyecto.arq.entity.Mensaje;
import com.proyecto.arq.entity.Usuario;
import com.proyecto.arq.model.MMensaje;
import com.proyecto.arq.repository.RMensaje;
import com.proyecto.arq.repository.RUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("SMensaje")
public class SMensaje {

    @Autowired
    private RMensaje rMensaje;
    @Autowired
    private RUsuario rUsuario;
    @Autowired
    private Convertidor convertidor;


    public int registrar(MMensaje mensaje){
        try{
            Usuario emi=rUsuario.findOne(mensaje.getOrigen());
            Usuario des=rUsuario.findOne(mensaje.getDestino());
            Mensaje m=new Mensaje();
            m.setOrigen(emi);
            m.setDestino(des);
            m.setMsj(mensaje.getMsj());
            return rMensaje.save(m).getId();
        }catch(Exception e){
            return -1;
        }
    }

    public boolean actualizar(Mensaje mensaje){
        try{
            rMensaje.save(mensaje).getId();
            return true;
        }catch(Exception e){
            return false;
        }
    }
    public boolean eliminar(int id){
        try{
            rMensaje.delete(id);
            return true;
        }catch(Exception e){
            return false;
        }
    }

    public List<MMensaje> listarMensajesRecibidos(int id){
        return convertidor.convertirMensajesRecibidos(rUsuario.findOne(id).getMensajesRecibidos());
    }

    public List<MMensaje> listarMensajeEnviados(int id){
        return convertidor.convertirMensajesRecibidos(rUsuario.findOne(id).getMensajesEnviados());
    }

}
