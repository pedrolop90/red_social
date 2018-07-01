package com.proyecto.arq.repository;

import com.proyecto.arq.entity.Amigo;
import com.proyecto.arq.entity.Publicacion;
import com.proyecto.arq.entity.Usuario;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface RAmigo extends JpaRepository<Amigo, Integer> {

	@Query("delete from Amigo a where a.usuario.id=:user and a.amigo.id=:amigo")
	Amigo findByAmigoAndUsuario(@Param("user")int usuario,@Param("amigo")int amigo);
	
	
}