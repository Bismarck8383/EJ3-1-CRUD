package com.bosonit.TablaRelaciones.eje3.Student.infraestructura.dtos.output;

import com.bosonit.TablaRelaciones.eje3.Student.dominio.Student;
import com.bosonit.TablaRelaciones.eje3.Profesor.dominio.Profesor;
import com.bosonit.TablaRelaciones.eje3.Persona.dominio.Persona;
import com.bosonit.TablaRelaciones.eje3.StudenSubject.dominio.StudentSubject;
import lombok.*;


import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class StudentOutputDTO {
    private String id_student;
    private Persona persona;
    private Integer num_hours_week;
    private String coments;
    private Optional<Profesor> profesor;
    private String branch;
    private List<StudentSubject> estudios;

    public StudentOutputDTO(Student student){
        setId_student(student.getId_student());
        this.persona = student.getPersona();
        this.num_hours_week = student.getNum_hours_week();
        this.coments =student.getComents();
        this.profesor = Optional.ofNullable(student.getProfesor());
        this.branch = student.getBranch();
    }

}
