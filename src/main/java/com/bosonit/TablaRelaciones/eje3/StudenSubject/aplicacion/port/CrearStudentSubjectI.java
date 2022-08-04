package com.bosonit.TablaRelaciones.eje3.StudenSubject.aplicacion.port;

import com.bosonit.TablaRelaciones.eje3.StudenSubject.infraestructura.dtos.input.StudentSubjectInputDTO;
import com.bosonit.TablaRelaciones.eje3.StudenSubject.infraestructura.dtos.output.StudentSubjectOutputDTO;

public interface CrearStudentSubjectI {
    StudentSubjectOutputDTO addEstudios(StudentSubjectInputDTO studentSubjectInputDTO) throws Exception;
}
