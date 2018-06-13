package com.proyecto.arq.repository;

import com.proyecto.arq.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RUsuario extends JpaRepository<Usuario, Integer> {

    Usuario findByCorreo(String usuario);

    //@Query("SELECT U FROM Usuario U WHERE U.nickname LIKE %:nombre%")
    List<Usuario> findByNicknameIgnoreCaseContaining(@Param("nombre") String nick);


}