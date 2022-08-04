package com.bosonit.TablaRelaciones.eje3.Persona.aplicacion;

import com.bosonit.TablaRelaciones.eje3.Persona.aplicacion.port.CrearPersonaI;
import com.bosonit.TablaRelaciones.eje3.Persona.dominio.Persona;
import com.bosonit.TablaRelaciones.eje3.Persona.infraestructura.dtos.input.PersonaInputDTO;
import com.bosonit.TablaRelaciones.eje3.Persona.infraestructura.dtos.output.PersonaOutputDTO;
import com.bosonit.TablaRelaciones.eje3.Persona.infraestructura.repositorio.PersonaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CrearPersonaUse implements CrearPersonaI {

    @Autowired
    PersonaRepositorio personaRepositorio;

    @Override
    public PersonaOutputDTO addPersona(PersonaInputDTO personaInputDTO) throws Exception{
        Persona persona = new Persona(personaInputDTO);
        PersonaOutputDTO personaOutputDTO= new PersonaOutputDTO(persona);
        personaRepositorio.saveAndFlush(persona);
        return personaOutputDTO;
    }
}
