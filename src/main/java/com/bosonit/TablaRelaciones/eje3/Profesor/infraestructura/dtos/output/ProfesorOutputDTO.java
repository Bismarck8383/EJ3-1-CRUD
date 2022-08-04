package com.bosonit.TablaRelaciones.eje3.Profesor.infraestructura.dtos.output;


import com.bosonit.TablaRelaciones.eje3.Profesor.dominio.Profesor;
import com.bosonit.TablaRelaciones.eje3.Persona.dominio.Persona;
import com.bosonit.TablaRelaciones.eje3.Student.dominio.Student;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProfesorOutputDTO {

    private String id_profesor;
    private Persona persona;
    private List<Student> students;
    private String branch;
    private String coments;

    public ProfesorOutputDTO(Profesor profesor) {
        setId_profesor(profesor.getId_profesor());
        setPersona(profesor.getPersona());
        setStudents(profesor.getStudents());
        setBranch(profesor.getBranch());
        setComents(profesor.getComents());
    }
}
