package com.bosonit.TablaRelaciones.eje3.Profesor.aplicacion;

import com.bosonit.TablaRelaciones.eje3.Profesor.aplicacion.port.DeleteProfesorI;
import com.bosonit.TablaRelaciones.eje3.Profesor.dominio.Profesor;
import com.bosonit.TablaRelaciones.eje3.Profesor.infraestructura.repositorio.ProfesorRepositorio;
import com.bosonit.TablaRelaciones.eje3.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeleteProfesorUse  implements DeleteProfesorI {

    @Autowired
    ProfesorRepositorio profesorRepositorio;


    @Override
    public  void deleteProfesor(String id_profesor) throws NotFoundException{
        Profesor profesor;
        profesor = profesorRepositorio.findById(id_profesor)
                .orElseThrow( () -> new NotFoundException("Id no encontrado"));
        profesorRepositorio.deleteById(id_profesor);
    }
}
