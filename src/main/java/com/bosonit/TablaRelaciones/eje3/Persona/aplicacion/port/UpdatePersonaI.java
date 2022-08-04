package com.bosonit.TablaRelaciones.eje3.Persona.aplicacion.port;

import com.bosonit.TablaRelaciones.eje3.Persona.infraestructura.dtos.input.PersonaInputDTO;
import com.bosonit.TablaRelaciones.eje3.Persona.infraestructura.dtos.output.PersonaOutputDTO;
import org.springframework.data.crossstore.ChangeSetPersister;

public interface UpdatePersonaI {
    PersonaOutputDTO updatePersona (String persona_id, PersonaInputDTO personaInputDTO) throws ChangeSetPersister.NotFoundException;
}
