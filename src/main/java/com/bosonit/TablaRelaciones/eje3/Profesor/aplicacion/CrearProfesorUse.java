package com.bosonit.TablaRelaciones.eje3.Profesor.aplicacion;

import com.bosonit.TablaRelaciones.eje3.Profesor.aplicacion.port.CrearProfesorI;
import com.bosonit.TablaRelaciones.eje3.Profesor.dominio.Profesor;
import com.bosonit.TablaRelaciones.eje3.Persona.dominio.Persona;
import com.bosonit.TablaRelaciones.eje3.Persona.infraestructura.repositorio.PersonaRepositorio;
import com.bosonit.TablaRelaciones.eje3.Profesor.infraestructura.dtos.input.ProfesorInputDTO;
import com.bosonit.TablaRelaciones.eje3.Profesor.infraestructura.dtos.output.ProfesorOutputDTO;
import com.bosonit.TablaRelaciones.eje3.Profesor.infraestructura.repositorio.ProfesorRepositorio;
import com.bosonit.TablaRelaciones.eje3.exceptions.NotFoundException;
import com.bosonit.TablaRelaciones.eje3.exceptions.UnprocesableException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CrearProfesorUse implements CrearProfesorI {

    @Autowired
    ProfesorRepositorio profesorRepositorio;

    @Autowired
    PersonaRepositorio personaRepositorio;

    @Override
    public ProfesorOutputDTO addProfesor(ProfesorInputDTO profesorInputDTO) throws  Exception{
        Profesor profesor = new Profesor(profesorInputDTO);
        profesor.setPersona(getPersona(profesorInputDTO));

        if (profesorInputDTO == null) {
            throw new UnprocesableException("No se puede introducir un estudiante sin datos");
        } else {
            profesorRepositorio.saveAndFlush(profesor);
            System.out.println("Profesor guardado");
        }

        return new ProfesorOutputDTO(profesor);
    }

    private Persona getPersona(ProfesorInputDTO profesorInputDTO) {
        String persona_id = profesorInputDTO.getPersona_id();
        Persona persona = personaRepositorio.findById(persona_id)
                .orElseThrow(() -> new NotFoundException("ID no encontrado"));

        return persona;


    }

}
