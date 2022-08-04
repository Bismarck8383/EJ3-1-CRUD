package com.bosonit.TablaRelaciones.eje3.Profesor.aplicacion.port;

import com.bosonit.TablaRelaciones.eje3.Profesor.infraestructura.dtos.output.ProfesorOutputDTO;

import java.util.List;

public interface MostrarProfesorI {
    ProfesorOutputDTO profesorId(String id_profesor) throws Exception;

    List<ProfesorOutputDTO> findAll();


}
