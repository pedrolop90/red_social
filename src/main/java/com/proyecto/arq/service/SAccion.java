package com.proyecto.arq.service;

import com.proyecto.arq.converter.Convertidor;
import com.proyecto.arq.entity.Accion;
import com.proyecto.arq.error.FirebaseException;
import com.proyecto.arq.error.JacksonUtilityException;
import com.proyecto.arq.repository.RAccion;
import com.proyecto.arq.repository.RPublicacion;
import com.proyecto.arq.repository.RUsuario;
import  com.proyecto.arq.model.FirebaseResponse;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.List;

@Service("SAccion")
public class SAccion {

    @Autowired
    private RAccion rAccion;
    @Autowired
    private RPublicacion rPublicacion;
    @Autowired
    private RUsuario rUsuario;
    @Autowired
    private Convertidor convertidor;
    
	private String firebase_baseUrl = "https://proyecto1-a52ec.firebaseio.com/";



    public int registrar(Accion accion){
        try{
        	accion.setPublicacion(rPublicacion.findById(accion.getPublicacion_id()).get());
        	accion.setUsuario(rUsuario.findById(accion.getUsuario_id()).get());
    		Firebase firebase = new Firebase( this.firebase_baseUrl );
    		FirebaseResponse response = null;

    		Map<String, Object> dataMap1 = new LinkedHashMap<String,Object>();
    		dataMap1.put( "notificacion", accion.getUsuario().getNickname() +" le ha dado like a tu publicacion "+accion.getPublicacion().getReceta().getNombre());
    		Map<String, Object> dataMap2 = new LinkedHashMap<String, Object>();
    		dataMap2.put(accion.getUsuario().getId()+"", dataMap1);
    		response = firebase.put( "usuario", dataMap2 );
            return rAccion.save(accion).getId();
        }catch(Exception e){
            return -1;
        } catch (FirebaseException e) {
			e.printStackTrace();
			return -1;
		} catch (JacksonUtilityException e) {
			e.printStackTrace();
			return -1;
		}
    }
    
    public boolean eliminar(int id) {
    	try {
    		rAccion.deleteById(id);
    		return true;
    	}catch(Exception e) {
    		return false;
    	}
    }
    



}
