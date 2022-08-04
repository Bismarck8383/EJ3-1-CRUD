package com.bosonit.TablaRelaciones.eje3.Student.aplicacion;

import com.bosonit.TablaRelaciones.eje3.Student.aplicacion.port.AsignarAsignaturaI;
import com.bosonit.TablaRelaciones.eje3.Student.infraestructura.repositorio.StudentRepositorio;
import com.bosonit.TablaRelaciones.eje3.Student.dominio.Student;
import com.bosonit.TablaRelaciones.eje3.StudenSubject.dominio.StudentSubject;
import com.bosonit.TablaRelaciones.eje3.StudenSubject.infraestructura.repositorio.StudentSubjectRepositorio;
import com.bosonit.TablaRelaciones.eje3.Student.infraestructura.dtos.output.StudentOutputDTO;
import com.bosonit.TablaRelaciones.eje3.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AsignarAsignaturaUse implements AsignarAsignaturaI {
    @Autowired
    StudentRepositorio studentRepositorio;

    @Autowired
    StudentSubjectRepositorio studentSubjectRepositorio;


    @Override
    public StudentOutputDTO asignarMateria(String id_student, List<String> subjectIdList) throws Exception {
        Optional<Student> student = studentRepositorio.findById(id_student);
        if (student.isEmpty()) {
            throw new Exception("No existe un estudiante asociado a este id");
        }
        List<StudentSubject> subjectfromStudent = student.get().getEstudios();
        for (String id : subjectIdList){
         Optional<StudentSubject> subject = studentSubjectRepositorio.findById(id);

         if (subject.isPresent()){
             subjectfromStudent.add(subject.get());
             List<Student> studentFromsubject = subject.get().getStudentList();
             studentFromsubject.add(student.get());

             student.get().setEstudios(subjectfromStudent);
             subject.get().setStudentList(studentFromsubject);
         }
        }
        studentRepositorio.save(student.get());
        return new StudentOutputDTO(student.get());

    }

    @Override
    public Student quitarMateria(String id_student, List<String> subjectIdList) throws Exception {
        Student student = studentRepositorio.findById(id_student).orElseThrow(() -> new NotFoundException("ID de estudiante no encontrado"));

        for (String id: subjectIdList) {
            StudentSubject studentSubject = studentSubjectRepositorio.findById(id)
                    .orElseThrow(() -> new NotFoundException("ID de asignatura no encontrado"));
            student.getEstudios().remove(studentSubject);
            studentRepositorio.saveAndFlush(student);
        }
        return student;
    }
}
