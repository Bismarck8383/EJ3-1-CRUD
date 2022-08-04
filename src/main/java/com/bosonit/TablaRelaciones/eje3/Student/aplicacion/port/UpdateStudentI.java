package com.bosonit.TablaRelaciones.eje3.Student.aplicacion.port;

import com.bosonit.TablaRelaciones.eje3.Student.infraestructura.dtos.input.StudentInputDTO;
import com.bosonit.TablaRelaciones.eje3.Student.infraestructura.dtos.output.StudentOutputDTO;
import com.bosonit.TablaRelaciones.eje3.exceptions.NotFoundException;

public interface UpdateStudentI {
    StudentOutputDTO updateStudent(String id_student, StudentInputDTO studentInputDTO)throws NotFoundException;
}
