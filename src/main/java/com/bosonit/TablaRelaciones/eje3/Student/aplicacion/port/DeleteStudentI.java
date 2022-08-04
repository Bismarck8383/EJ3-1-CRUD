package com.bosonit.TablaRelaciones.eje3.Student.aplicacion.port;

import com.bosonit.TablaRelaciones.eje3.exceptions.NotFoundException;

public interface DeleteStudentI {
    void deleteStudent(String id_student) throws NotFoundException;
}
