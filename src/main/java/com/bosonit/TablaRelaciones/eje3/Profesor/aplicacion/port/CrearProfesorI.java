package com.bosonit.TablaRelaciones.eje3.Profesor.aplicacion.port;

import com.bosonit.TablaRelaciones.eje3.Profesor.infraestructura.dtos.input.ProfesorInputDTO;
import com.bosonit.TablaRelaciones.eje3.Profesor.infraestructura.dtos.output.ProfesorOutputDTO;

public interface CrearProfesorI {
    ProfesorOutputDTO addProfesor(ProfesorInputDTO profesorInputDTO) throws  Exception;
}
