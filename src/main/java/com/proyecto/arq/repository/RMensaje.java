package com.proyecto.arq.repository;

import com.proyecto.arq.entity.Mensaje;
import com.proyecto.arq.model.MMensaje;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RMensaje extends JpaRepository<Mensaje, Integer> {

}