package com.bosonit.TablaRelaciones.eje3.Student.aplicacion.port;

import com.bosonit.TablaRelaciones.eje3.Student.infraestructura.dtos.output.StudentOutputDTO;
import com.bosonit.TablaRelaciones.eje3.exceptions.NotFoundException;

import java.util.List;

public interface MostrarStudentI {
    StudentOutputDTO buscarId(String id_student,String outputType) throws NotFoundException;



    List<StudentOutputDTO> mostrarTodos() throws Exception;
}
