package com.bosonit.TablaRelaciones.eje3.Persona.aplicacion.port;

import com.bosonit.TablaRelaciones.eje3.exceptions.NotFoundException;

public interface DeletePersonaI {
    void  deletePersona(String persona_id) throws NotFoundException;
}
