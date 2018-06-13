package com.proyecto.arq.converter;

import com.proyecto.arq.entity.Amigo;
import com.proyecto.arq.entity.Mensaje;
import com.proyecto.arq.entity.Usuario;
import com.proyecto.arq.model.MMensaje;
import com.proyecto.arq.model.MUsuario;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component("convertidor")
public class Convertidor {

    public List<MUsuario> convertirSeguidos(List<Amigo> personas){
        List<MUsuario> mpersonas=new ArrayList();
        for(Amigo p:personas){
            mpersonas.add(new MUsuario(p.getAmigo()));
        }
        return mpersonas;
    }

    public List<MUsuario> convertirSeguidores(List<Amigo> personas){
        List<MUsuario> mpersonas=new ArrayList();
        for(Amigo p:personas){
            mpersonas.add(new MUsuario(p.getUsuario()));
        }
        return mpersonas;
    }


    public List<MMensaje> convertirMensajesRecibidos(List<Mensaje> mensajes){
        List<MMensaje> mmensajes=new ArrayList();
        for(Mensaje p:mensajes){
            mmensajes.add(new MMensaje(p));
        }
        return mmensajes;
    }

    public List<MUsuario> convertirUsuarios(List<Usuario> usuarios){
        List<MUsuario> musaurio=new ArrayList<>();
        for (Usuario u:usuarios){
            musaurio.add(new MUsuario(u));
        }
        return musaurio;
    }

    public MUsuario convertirUsuario(Usuario usuario){
        return new MUsuario(usuario);
    }

}