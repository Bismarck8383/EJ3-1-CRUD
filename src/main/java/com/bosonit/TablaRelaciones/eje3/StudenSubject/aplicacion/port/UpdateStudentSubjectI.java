package com.bosonit.TablaRelaciones.eje3.StudenSubject.aplicacion.port;

import com.bosonit.TablaRelaciones.eje3.StudenSubject.infraestructura.dtos.input.StudentSubjectInputDTO;
import com.bosonit.TablaRelaciones.eje3.StudenSubject.infraestructura.dtos.output.StudentSubjectOutputDTO;
import com.bosonit.TablaRelaciones.eje3.exceptions.NotFoundException;

public interface UpdateStudentSubjectI {
    StudentSubjectOutputDTO updateEstudios(String id_study, StudentSubjectInputDTO studentSubjectInputDTO) throws NotFoundException;
}
