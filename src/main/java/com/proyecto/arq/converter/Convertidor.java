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

    public List<MPublicacion> convertirPublicacion(List<Publicacion> publicaciones,int user){
        List<MPublicacion> mPublicacions=new ArrayList<>();
        for (Publicacion u:publicaciones){
            mPublicacions.add(new MPublicacion(u,user));
        }
        return mPublicacions;
    }



    public List<MComentario> convertirComentario(List<Comentario> comentarios){
        List<MComentario> mComentario=new ArrayList<>();
        for (Comentario u:comentarios){
            mComentario.add(new MComentario(u));
        }
        return mComentario;
    }
    public List<MIngrediente> convertirPasoporIngredientes(List<Paso_Ingrediente> ingredientes){
        List<MIngrediente> mIngredient=new ArrayList<>();
        for (Paso_Ingrediente u:ingredientes){
            mIngredient.add(new MIngrediente(u.getIngrediente()));
        }
        return mIngredient;
    }


    public List<MCategoria> convertirCategorias(List<Categoria> categorias){
        List<MCategoria> mCategorias=new ArrayList<>();
        for (Categoria u:categorias){
            mCategorias.add(new MCategoria(u));
        }
        return mCategorias;
    }
    public MReceta convertirReceta(Receta receta){
        return new MReceta(receta);
    }

    public MIngrediente convertirIngrediente(Ingrediente ingrediente){
        return new MIngrediente(ingrediente);
    }
    
    public MUsuario convertirUsuario(Usuario usuario){
        return new MUsuario(usuario);
    }

    public MPaso convertirPasos(Paso paso){
        return new MPaso(paso);
    }

    
    
    
}