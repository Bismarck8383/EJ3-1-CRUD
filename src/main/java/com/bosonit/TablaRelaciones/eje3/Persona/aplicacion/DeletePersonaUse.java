package com.bosonit.TablaRelaciones.eje3.Persona.aplicacion;


import com.bosonit.TablaRelaciones.eje3.Persona.aplicacion.port.DeletePersonaI;
import com.bosonit.TablaRelaciones.eje3.Persona.dominio.Persona;
import com.bosonit.TablaRelaciones.eje3.Persona.infraestructura.repositorio.PersonaRepositorio;
import com.bosonit.TablaRelaciones.eje3.exceptions.NotFoundException;
import com.bosonit.TablaRelaciones.eje3.exceptions.UnprocesableException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeletePersonaUse implements DeletePersonaI {
    @Autowired
    PersonaRepositorio personaRepositorio;

    @Override
    public void deletePersona(String persona_id) throws NotFoundException{
        Persona personaAux = personaRepositorio.findById(persona_id)
                .orElseThrow(() -> new NotFoundException("El ID introducido no existe"));


       // boolean borrar = true;

        /*

        studentRepositorio.findAll().forEach(student -> {
            if (student.getPersona() != null) {
                if (persona_id == student.getPersona().getId_persona()) {
                    throw new UnprocesableException("No se puede borrar una persona con un estudiante asignado");
                }
            }
        });

        profesorRepositorio.findAll().forEach(profesor -> {
            if (profesor.getPersona() != null) {
                if (persona_id == profesor.getPersona().getId_persona()) {
                    throw new UnprocesableException("No se puede borrar una persona con un estudiante asignado");
                }
            }
        });


         */
        personaRepositorio.deleteById(persona_id);

    }
}
