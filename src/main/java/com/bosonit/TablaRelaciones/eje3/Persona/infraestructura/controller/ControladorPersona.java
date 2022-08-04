package com.bosonit.TablaRelaciones.eje3.Persona.infraestructura.controller;


import com.bosonit.TablaRelaciones.eje3.Persona.aplicacion.port.CrearPersonaI;
import com.bosonit.TablaRelaciones.eje3.Persona.aplicacion.port.DeletePersonaI;
import com.bosonit.TablaRelaciones.eje3.Persona.aplicacion.port.MostrarPersonaI;
import com.bosonit.TablaRelaciones.eje3.Persona.aplicacion.port.UpdatePersonaI;
import com.bosonit.TablaRelaciones.eje3.Persona.infraestructura.dtos.input.PersonaInputDTO;
import com.bosonit.TablaRelaciones.eje3.Persona.infraestructura.dtos.output.PersonaOutputDTO;
import com.bosonit.TablaRelaciones.eje3.exceptions.NotFoundException;
import com.bosonit.TablaRelaciones.eje3.exceptions.UnprocesableException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/persona")
public class ControladorPersona {

    @Autowired
    CrearPersonaI crearPersonaI;

    @Autowired
    DeletePersonaI deletePersonaI;

    @Autowired
    UpdatePersonaI updatePersonaI;

    @Autowired
    MostrarPersonaI mostrarPersonaI;


    //Agregar Persona
    @PostMapping()
    public PersonaOutputDTO addPersona (@RequestBody PersonaInputDTO personaInputDTO) throws Exception {
        checkPersona(personaInputDTO);
        PersonaOutputDTO personaOutputDTO = crearPersonaI.addPersona(personaInputDTO);
        return personaOutputDTO;
    }

    //Mostrar todos
    @GetMapping()
    public List<PersonaOutputDTO> mostrarTodos () throws Exception{
        return mostrarPersonaI.mostrarTodos();
    }

    //mostrar por id
    @GetMapping("/id/{persona_id}")
    public PersonaOutputDTO mostrarId(@PathVariable String persona_id) throws Exception {
        return mostrarPersonaI.mostrarId(persona_id);
    }


    //mostrar por nombre
    @GetMapping("/name/{name}")
    public List<PersonaOutputDTO> mostrarNombre(@PathVariable String name) throws Exception {
        return mostrarPersonaI.findByName(name);
    }

    //Eliminar
    @DeleteMapping("/deletePersona/{persona_id}")
    public void deletePersona (@PathVariable String persona_id) throws NotFoundException {
        deletePersonaI.deletePersona(persona_id);
    }
    //Actualizar

    @PutMapping("/updatePersona/{Persona_id}")
    public PersonaOutputDTO updatePersona (@PathVariable String persona_id, @RequestBody PersonaInputDTO personaInputDTO) throws NotFoundException, ChangeSetPersister.NotFoundException {
        checkPersona(personaInputDTO);
        return updatePersonaI.updatePersona(persona_id, personaInputDTO);
    }

    private void checkPersona(PersonaInputDTO personaInputDTO){
        if(personaInputDTO == null){
            throw new UnprocesableException("No se puede introducir una persona sin información");
        }
        if (personaInputDTO.getUsuario() == null || personaInputDTO.getUsuario().isBlank()) {
            throw new UnprocesableException("El campo Usuario no puede ser nulo ni estar vacío");
        }
        if (personaInputDTO.getUsuario().length() > 10) {
            throw new UnprocesableException("El campo Usuario debe tener como máximo 10 caracteres de longitud");
        }
        if (personaInputDTO.getUsuario().length() < 6) {
            throw new UnprocesableException("El campo Usuario debe tener como mínimo 6 caracteres de longitud");
        }
        if (personaInputDTO.getPassword() == null || personaInputDTO.getPassword().isBlank()) {
            throw new UnprocesableException("El campo Password no puede ser nulo ni estar vacío");
        }
        if (personaInputDTO.getName() == null || personaInputDTO.getName().isBlank()) {
            throw new UnprocesableException("El campo nombre no puede ser nulo ni estar vacío");
        }
        if (personaInputDTO.getCompany_email() == null || personaInputDTO.getCompany_email().isBlank()) {
            throw new UnprocesableException("El campo Company_Email no puede ser nulo ni estar vacío");
        }
        if (personaInputDTO.getPersonal_email() == null || personaInputDTO.getPersonal_email().isBlank()) {
            throw new UnprocesableException("El campo Personal_Email no puede ser nulo ni estar vacío");
        }
        if (personaInputDTO.getCity() == null || personaInputDTO.getCity().isBlank()) {
            throw new UnprocesableException("El campo Ciudad no puede ser nulo ni estar vacío");
        }
        if (personaInputDTO.getCreated_date() == null) {
            throw new UnprocesableException("El campo Created-Date no puede ser nulo ni estar vacío");
        }
    }

}
