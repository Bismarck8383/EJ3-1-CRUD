package com.bosonit.TablaRelaciones.eje3.Student.aplicacion;

import com.bosonit.TablaRelaciones.eje3.Student.aplicacion.port.UpdateStudentI;
import com.bosonit.TablaRelaciones.eje3.Student.dominio.Student;
import com.bosonit.TablaRelaciones.eje3.Student.infraestructura.dtos.input.StudentInputDTO;
import com.bosonit.TablaRelaciones.eje3.Student.infraestructura.dtos.output.StudentOutputDTO;
import com.bosonit.TablaRelaciones.eje3.Student.infraestructura.repositorio.StudentRepositorio;
import com.bosonit.TablaRelaciones.eje3.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UpdateStudentUse implements UpdateStudentI {

    @Autowired
    StudentRepositorio studentRepositorio;


    @Override
    public StudentOutputDTO updateStudent(String id_student, StudentInputDTO studentInputDTO) throws NotFoundException{
        Student student=  studentRepositorio.findById(id_student)
                .orElseThrow( () -> new NotFoundException("ID : "+id_student+" No encontrado."));
        student.update(studentInputDTO);
        return  new StudentOutputDTO(student);
    }
}
