package com.proyecto.arq.repository;

import com.proyecto.arq.entity.Publicacion;
import com.proyecto.arq.entity.Receta;
import com.proyecto.arq.entity.Usuario;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface RPublicacion extends JpaRepository<Publicacion, Integer> {

	@Query("select p from Publicacion p where p.usuario.privacidad=1 and p.privacidad=1 order by p.fecha,p.hora desc")
	List<Publicacion> findByUsuario();
	
	@Query("select p from Amigo a join Publicacion p on a.usuario.id=:usuario and p.usuario.id=a.amigo.id and p.privacidad=1 order by p.fecha,p.hora desc")
	List<Publicacion> findBySeguidos(@Param("usuario")int id);

	@Query("select p from  Publicacion p where p.usuario.id=:usuario and p.privacidad=1 order by p.fecha,p.hora desc")
	List<Publicacion> findByUnUsuario(@Param("usuario")int id);
	
	@Query("select p from  Publicacion p where p.usuario.id=:usuario order by p.fecha,p.hora desc")
	List<Publicacion> findByMiUsuario(@Param("usuario")int id);
	
	Publicacion findByReceta(Receta receta);
	
}