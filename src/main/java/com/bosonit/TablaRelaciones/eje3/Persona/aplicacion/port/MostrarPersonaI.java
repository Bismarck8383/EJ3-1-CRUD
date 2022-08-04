package com.bosonit.TablaRelaciones.eje3.Persona.aplicacion.port;

import com.bosonit.TablaRelaciones.eje3.Persona.dominio.Persona;
import com.bosonit.TablaRelaciones.eje3.Persona.infraestructura.dtos.output.PersonaOutputDTO;
import com.bosonit.TablaRelaciones.eje3.exceptions.NotFoundException;

import java.util.List;

public interface MostrarPersonaI {

    //mostrar por Id
    PersonaOutputDTO mostrarId(String persona_id) throws NotFoundException;

    //Mostrar todas las personas
    List<PersonaOutputDTO> mostrarTodos() throws Exception;

    //Mostrar por nombres

    List<PersonaOutputDTO>findByName(String name) throws Exception;


}
