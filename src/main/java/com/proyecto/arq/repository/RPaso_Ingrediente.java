package com.proyecto.arq.repository;

import com.proyecto.arq.entity.Ingrediente;
import com.proyecto.arq.entity.Paso;
import com.proyecto.arq.entity.Paso_Ingrediente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RPaso_Ingrediente extends JpaRepository<Paso_Ingrediente,Integer> {

   // Paso findByIngrediente(Ingrediente ingrediente);


}
