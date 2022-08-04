package com.bosonit.TablaRelaciones.eje3.Profesor.aplicacion;

import com.bosonit.TablaRelaciones.eje3.Profesor.aplicacion.port.UpdateProfesorI;
import com.bosonit.TablaRelaciones.eje3.Profesor.dominio.Profesor;
import com.bosonit.TablaRelaciones.eje3.Profesor.infraestructura.dtos.input.ProfesorInputDTO;
import com.bosonit.TablaRelaciones.eje3.Profesor.infraestructura.dtos.output.ProfesorOutputDTO;
import com.bosonit.TablaRelaciones.eje3.Profesor.infraestructura.repositorio.ProfesorRepositorio;
import com.bosonit.TablaRelaciones.eje3.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UpdateProfesorUse implements UpdateProfesorI {
    @Autowired
    ProfesorRepositorio profesorRepositorio;

    @Override
     public ProfesorOutputDTO updateProfesor(String id_profesor, ProfesorInputDTO profesorInputDTO) throws NotFoundException{
        Profesor profesor = profesorRepositorio.findById(id_profesor)
                .orElseThrow( () -> new NotFoundException("ID no encontrada"));
        profesorRepositorio.saveAndFlush(profesor);
        return  new ProfesorOutputDTO(profesor);
    }
}
