package com.bosonit.TablaRelaciones.eje3.StudenSubject.aplicacion;

import com.bosonit.TablaRelaciones.eje3.Profesor.dominio.Profesor;
import com.bosonit.TablaRelaciones.eje3.Profesor.infraestructura.repositorio.ProfesorRepositorio;
import com.bosonit.TablaRelaciones.eje3.StudenSubject.aplicacion.port.UpdateStudentSubjectI;
import com.bosonit.TablaRelaciones.eje3.StudenSubject.dominio.StudentSubject;
import com.bosonit.TablaRelaciones.eje3.StudenSubject.infraestructura.dtos.input.StudentSubjectInputDTO;
import com.bosonit.TablaRelaciones.eje3.StudenSubject.infraestructura.dtos.output.StudentSubjectOutputDTO;
import com.bosonit.TablaRelaciones.eje3.StudenSubject.infraestructura.repositorio.StudentSubjectRepositorio;
import com.bosonit.TablaRelaciones.eje3.Student.dominio.Student;
import com.bosonit.TablaRelaciones.eje3.Student.infraestructura.repositorio.StudentRepositorio;
import com.bosonit.TablaRelaciones.eje3.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UpdateStudentSubjectUse implements UpdateStudentSubjectI {
   @Autowired
    StudentSubjectRepositorio studentSubjectRepositorio;

   @Autowired
    ProfesorRepositorio profesorRepositorio;

   @Autowired
    StudentRepositorio studentRepositorio;

    @Override
    public StudentSubjectOutputDTO updateEstudios(String id_study, StudentSubjectInputDTO studentSubjectInputDTO) throws NotFoundException {
        StudentSubject studentSubject =  studentSubjectRepositorio.findById(id_study)
                .orElseThrow( () -> new NotFoundException("El Id introducido no existe"));
        studentSubject.update(studentSubjectInputDTO);
        studentSubject.setProfesor(getIdProfesor(studentSubjectInputDTO));
        studentSubjectRepositorio.saveAndFlush(studentSubject);
        return new StudentSubjectOutputDTO(studentSubject);
    }

    //tomar id profesor
    public Profesor getIdProfesor(StudentSubjectInputDTO studentSubjectInputDTO){
        String id_profesor =  studentSubjectInputDTO.getId_profesor();

        Profesor profesor = profesorRepositorio.findById(id_profesor)
                .orElseThrow( () -> new NotFoundException("Id de estudiante no encontrado"));
        return profesor;
    }

    //tomar id student

    private Student getIdStudent(StudentSubjectInputDTO studentSubjectInputDTO){

        String id_student = String.valueOf(studentSubjectInputDTO.getStudentList());

        Student student= studentRepositorio.findById(id_student)
                .orElseThrow( () -> new NotFoundException("Id de estudiante no encontrado"));
        return student;
    }
}
