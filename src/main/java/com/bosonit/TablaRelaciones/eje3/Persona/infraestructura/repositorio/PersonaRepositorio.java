package com.bosonit.TablaRelaciones.eje3.Persona.infraestructura.repositorio;

import com.bosonit.TablaRelaciones.eje3.Persona.dominio.Persona;
import com.bosonit.TablaRelaciones.eje3.Persona.infraestructura.dtos.output.PersonaOutputDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonaRepositorio extends JpaRepository <Persona, String>{

    List<PersonaOutputDTO> findByName(String name);
}
