package com.proyecto.arq.service;

import com.proyecto.arq.converter.Convertidor;
import com.proyecto.arq.entity.Comentario;
import com.proyecto.arq.model.FirebaseResponse;
import com.proyecto.arq.repository.RComentario;
import com.proyecto.arq.repository.RPublicacion;
import com.proyecto.arq.repository.RUsuario;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.proyecto.arq.converter.Convertidor;
import com.proyecto.arq.entity.Accion;
import com.proyecto.arq.error.FirebaseException;
import com.proyecto.arq.error.JacksonUtilityException;
import com.proyecto.arq.repository.RAccion;
import com.proyecto.arq.repository.RPublicacion;
import com.proyecto.arq.repository.RUsuario;
import  com.proyecto.arq.model.FirebaseResponse;



@Service("SComentario")
public class SComentario {

    @Autowired
    private RComentario rComentario;
    @Autowired
    private RPublicacion rPublicacion;
    @Autowired
    private RUsuario rUsuario;
    @Autowired
    private Convertidor convertidor;

	private String firebase_baseUrl = "https://proyecto1-a52ec.firebaseio.com/";


    public int registrar(Comentario comentario) {
        try {
        	comentario.setPublicacion(rPublicacion.findById(comentario.getPublicacion_id()).get());
        	comentario.setUsuario(rUsuario.findById(comentario.getUsuario_id()).get());
    		Firebase firebase = new Firebase( this.firebase_baseUrl );
    		FirebaseResponse response = null;

    		Map<String, Object> dataMap1 = new LinkedHashMap<String,Object>();
    		dataMap1.put( "notificacion", comentario.getUsuario().getNickname() +" ha comentado tu publicacion "+comentario.getPublicacion().getReceta().getNombre());
    		response = firebase.put(comentario.getUsuario().getId()+"", dataMap1 );
            return rComentario.save(comentario).getId();
        } catch (Exception e) {
            return -1;
        } catch (JacksonUtilityException e) {
			e.printStackTrace();
			return -1;
		} catch (FirebaseException e) {
			e.printStackTrace();
			return -1;
		}
    }


    public boolean actualizar(Comentario comentario){
        try{
            rComentario.save(comentario);
            return true;
        }catch(Exception e){
            return false;
        }
    }

    public boolean eliminar(int id){
        try{
            rComentario.delete(rComentario.findById(id).get());
            return true;
        }catch(Exception e){
            return false;
        }
    }


}
