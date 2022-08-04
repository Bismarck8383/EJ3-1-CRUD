package com.bosonit.TablaRelaciones.eje3.Profesor.aplicacion.port;

import com.bosonit.TablaRelaciones.eje3.Profesor.infraestructura.dtos.input.ProfesorInputDTO;
import com.bosonit.TablaRelaciones.eje3.Profesor.infraestructura.dtos.output.ProfesorOutputDTO;
import com.bosonit.TablaRelaciones.eje3.exceptions.NotFoundException;

public interface UpdateProfesorI {
    ProfesorOutputDTO updateProfesor(String id_profesor, ProfesorInputDTO profesorInputDTO) throws NotFoundException;
}
