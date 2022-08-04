package com.bosonit.TablaRelaciones.eje3.Profesor.aplicacion;

import com.bosonit.TablaRelaciones.eje3.Profesor.aplicacion.port.MostrarProfesorI;
import com.bosonit.TablaRelaciones.eje3.Profesor.dominio.Profesor;
import com.bosonit.TablaRelaciones.eje3.Profesor.infraestructura.dtos.output.ProfesorOutputDTO;
import com.bosonit.TablaRelaciones.eje3.Profesor.infraestructura.repositorio.ProfesorRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MostrarProfesorUse implements MostrarProfesorI {
    @Autowired
    ProfesorRepositorio profesorRepositorio;


    @Override
    public ProfesorOutputDTO profesorId(String id_profesor) throws Exception {
        Profesor profesor =
                profesorRepositorio
                        .findById(id_profesor)
                        .orElseThrow(() -> new Exception("No se ha encontrado el profesor indicado"));

        return new ProfesorOutputDTO(profesor);
    }

    @Override
    public List<ProfesorOutputDTO> findAll() {
        List<ProfesorOutputDTO> profesorOutputDTOList = new ArrayList<>();
        for (Profesor profesor : profesorRepositorio.findAll()) {
            profesorOutputDTOList.add(new ProfesorOutputDTO(profesor));
        }
        return profesorOutputDTOList;
    }


}
