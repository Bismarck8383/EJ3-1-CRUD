package com.bosonit.TablaRelaciones.eje3.Persona.aplicacion.port;

import com.bosonit.TablaRelaciones.eje3.Persona.infraestructura.dtos.input.PersonaInputDTO;
import com.bosonit.TablaRelaciones.eje3.Persona.infraestructura.dtos.output.PersonaOutputDTO;

public interface CrearPersonaI {
    PersonaOutputDTO addPersona(PersonaInputDTO personaInputDTO) throws Exception;
}
