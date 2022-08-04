package com.bosonit.TablaRelaciones.eje3.Student.aplicacion.port;

import com.bosonit.TablaRelaciones.eje3.Student.infraestructura.dtos.input.StudentInputDTO;
import com.bosonit.TablaRelaciones.eje3.Student.infraestructura.dtos.output.StudentOutputDTO;

public interface CrearStudentI {

    StudentOutputDTO addStudent(StudentInputDTO studentInputDTO) throws Exception;
}
