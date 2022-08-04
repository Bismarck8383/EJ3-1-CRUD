package com.bosonit.TablaRelaciones.eje3.Student.infraestructura.dtos.input;

import com.bosonit.TablaRelaciones.eje3.StudenSubject.dominio.StudentSubject;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentInputDTO {
    private String id_student;
    private String  persona_id;
    private Integer num_hours_week;
    private String coments;
    private String id_profesor;
    private String branch;
    private List estudios;

}
