package com.bosonit.TablaRelaciones.eje3.StudenSubject.infraestructura.dtos.output;

import com.bosonit.TablaRelaciones.eje3.Profesor.dominio.Profesor;
import com.bosonit.TablaRelaciones.eje3.StudenSubject.dominio.StudentSubject;
import com.bosonit.TablaRelaciones.eje3.Student.dominio.Student;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class StudentSubjectOutputDTO {
    private String id_study;
    private List<Student> studentList;
    private String subject;
    private Profesor profesor;
    private String comment;
    private Date initial_date;
    private Date finish_date;

    public StudentSubjectOutputDTO(StudentSubject studentSubject){
        setId_study(studentSubject.getId_study());
        setSubject(studentSubject.getSubject());
        setComment(studentSubject.getComment());
        setProfesor(studentSubject.getProfesor());
        setInitial_date(studentSubject.getInitial_date());
        setFinish_date(studentSubject.getFinish_date());
    }
}
