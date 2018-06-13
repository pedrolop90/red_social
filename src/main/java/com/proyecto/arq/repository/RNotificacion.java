package com.proyecto.arq.repository;

import com.proyecto.arq.entity.Comentario;
import com.proyecto.arq.entity.Notificacion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RNotificacion extends JpaRepository<Notificacion, Integer> {

}
