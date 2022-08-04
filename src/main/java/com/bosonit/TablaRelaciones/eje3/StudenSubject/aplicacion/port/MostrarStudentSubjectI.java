package com.bosonit.TablaRelaciones.eje3.StudenSubject.aplicacion.port;

import com.bosonit.TablaRelaciones.eje3.StudenSubject.infraestructura.dtos.output.StudentSubjectOutputDTO;
import com.bosonit.TablaRelaciones.eje3.exceptions.NotFoundException;

import java.util.List;

public interface MostrarStudentSubjectI {
    StudentSubjectOutputDTO mostrarId(String id_study, String outputType) throws NotFoundException;

    List<StudentSubjectOutputDTO> mostrarTodos(String outputType) throws Exception;
}
