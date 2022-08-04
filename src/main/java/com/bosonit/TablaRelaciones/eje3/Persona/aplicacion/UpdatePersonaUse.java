package com.bosonit.TablaRelaciones.eje3.Persona.aplicacion;

import com.bosonit.TablaRelaciones.eje3.Persona.aplicacion.port.UpdatePersonaI;
import com.bosonit.TablaRelaciones.eje3.Persona.dominio.Persona;
import com.bosonit.TablaRelaciones.eje3.Persona.infraestructura.dtos.input.PersonaInputDTO;
import com.bosonit.TablaRelaciones.eje3.Persona.infraestructura.dtos.output.PersonaOutputDTO;
import com.bosonit.TablaRelaciones.eje3.Persona.infraestructura.repositorio.PersonaRepositorio;
import com.bosonit.TablaRelaciones.eje3.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UpdatePersonaUse implements UpdatePersonaI {
    @Autowired
    PersonaRepositorio personaRepositorio;

    @Override

    public PersonaOutputDTO updatePersona(String persona_id, PersonaInputDTO personaInputDTO) throws NotFoundException{
        Persona persona = personaRepositorio.findById(persona_id)
                .orElseThrow( () -> new NotFoundException("El ID no existe")) ;
        persona.actualizarDatos(personaInputDTO);
        personaRepositorio.save(persona);
        return  new PersonaOutputDTO(persona);
    }
}
