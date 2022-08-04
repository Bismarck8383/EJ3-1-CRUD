package com.bosonit.TablaRelaciones.eje3.Persona.aplicacion;

import com.bosonit.TablaRelaciones.eje3.Persona.aplicacion.port.MostrarPersonaI;
import com.bosonit.TablaRelaciones.eje3.Persona.dominio.Persona;
import com.bosonit.TablaRelaciones.eje3.Persona.infraestructura.dtos.output.PersonaOutputDTO;
import com.bosonit.TablaRelaciones.eje3.Persona.infraestructura.repositorio.PersonaRepositorio;
import com.bosonit.TablaRelaciones.eje3.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;

@Service
public class MostrarPersonaUse implements MostrarPersonaI {

    /*
    * Mostramos Persona por Id
    * */
    @Autowired
    PersonaRepositorio personaRepositorio;

  @Override
    public PersonaOutputDTO mostrarId(String persona_id) throws NotFoundException{
        Persona personaAux;
        PersonaOutputDTO personaDTO;

        personaAux = personaRepositorio.findById(persona_id)
                .orElseThrow(() -> new NotFoundException("El Id no existe"));

        personaDTO = new PersonaOutputDTO(personaAux);
        return personaDTO;
    }

    /*
    * Mostramos por Nombre
    * */
    @Override
    public List<PersonaOutputDTO> findByName(@PathVariable String name) throws Exception {
        try {
            return personaRepositorio.findByName(name);
        }catch (Exception e){
            throw new Exception("No se pudo encontrar el nombre");
        }
    }


    /*
    * Mostrar Todos
    * */
    @Override
    public List<PersonaOutputDTO> mostrarTodos() throws Exception {
        List<PersonaOutputDTO> listaPersonas = new ArrayList<>();

        personaRepositorio.findAll().forEach(persona -> {
            PersonaOutputDTO personaDTO = new PersonaOutputDTO(persona);
            listaPersonas.add(personaDTO);
        });

        if (listaPersonas.isEmpty()) {
            throw new Exception("No hay usuarios en la base de datos");
        }
        return listaPersonas;
    }

}
