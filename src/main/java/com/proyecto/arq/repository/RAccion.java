package com.proyecto.arq.repository;

import com.proyecto.arq.entity.Accion;
import com.proyecto.arq.entity.Publicacion;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface RAccion extends JpaRepository<Accion, Integer> {


	
	@Query("select a from Accion a where a.usuario.id=:usuario and a.publicacion.id=:publicacion")
	Accion findByUsuarioAndPublicacion(@Param("usuario") int usuario,@Param("publicacion") int publicacion);
	
}
