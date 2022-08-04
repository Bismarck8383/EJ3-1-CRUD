package com.bosonit.TablaRelaciones.eje3.Student.aplicacion;

import com.bosonit.TablaRelaciones.eje3.Student.dominio.Student;
import com.bosonit.TablaRelaciones.eje3.Student.infraestructura.repositorio.StudentRepositorio;
import com.bosonit.TablaRelaciones.eje3.Student.aplicacion.port.DeleteStudentI;
import com.bosonit.TablaRelaciones.eje3.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeleteStudentUse implements DeleteStudentI {

    @Autowired
    StudentRepositorio studentRepositorio;
    @Override
    public void deleteStudent(String id_student) throws NotFoundException {
        Student student;
        student = studentRepositorio.findById(id_student)
                .orElseThrow(() -> new NotFoundException("ID: "+id_student+" no encontrado"));

        studentRepositorio.deleteById(id_student);
    }


}
