package com.bosonit.TablaRelaciones.eje3.Student.aplicacion.port;

import com.bosonit.TablaRelaciones.eje3.Student.dominio.Student;
import com.bosonit.TablaRelaciones.eje3.Student.infraestructura.dtos.output.StudentOutputDTO;

import java.util.List;

public interface AsignarAsignaturaI {
   StudentOutputDTO asignarMateria(String id_student, List<String> subjectIdList) throws Exception;
    Student quitarMateria(String id_student, List<String> subjectIdList) throws Exception;
}
