package com.proyecto.arq.converter;

import com.proyecto.arq.entity.*;
import com.proyecto.arq.model.*;
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

    public List<MPaso> convertirPaso(List<Paso> pasos){
        List<MPaso> mpaso=new ArrayList<>();
        for (Paso u:pasos){
            mpaso.add(new MPaso(u));
        }
        return mpaso;
    }

    public List<MIngrediente> convertirIngredientes(List<Ingrediente> ingredientes){
        List<MIngrediente> mIngredientes=new ArrayList<>();
        for (Ingrediente u:ingredientes){
            mIngredientes.add(new MIngrediente(u));
        }
        return mIngredientes;
    }

    public List<MPublicacion> convertirPublicacion(List<Publicacion> publicaciones){
        List<MPublicacion> mPublicacions=new ArrayList<>();
        for (Publicacion u:publicaciones){
            mPublicacions.add(new MPublicacion(u));
        }
        return mPublicacions;
    }



    public MUsuario convertirUsuario(Usuario usuario){
        return new MUsuario(usuario);
    }

}