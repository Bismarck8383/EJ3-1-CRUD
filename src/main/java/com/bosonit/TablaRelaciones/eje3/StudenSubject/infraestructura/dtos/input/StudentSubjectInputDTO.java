package com.bosonit.TablaRelaciones.eje3.StudenSubject.infraestructura.dtos.input;

import com.bosonit.TablaRelaciones.eje3.Student.dominio.Student;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class StudentSubjectInputDTO {
    private String id_study;
    private  String id_profesor;
    private List<Student> studentList;
    private String subject;
    private String comment;
    private Date initial_date;
    private Date finish_date;
}
