package com.bosonit.TablaRelaciones.eje3.Student.dominio;

import com.bosonit.TablaRelaciones.eje3.Persona.dominio.Persona;
import com.bosonit.TablaRelaciones.eje3.Profesor.dominio.Profesor;
import com.bosonit.TablaRelaciones.eje3.StringPrefixedSequenceIdGenerator;
import com.bosonit.TablaRelaciones.eje3.StudenSubject.dominio.StudentSubject;
import com.bosonit.TablaRelaciones.eje3.Student.infraestructura.dtos.input.StudentInputDTO;
import com.bosonit.TablaRelaciones.eje3.Student.infraestructura.dtos.output.StudentOutputDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "estudiantes")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ausencias_seq")
    @GenericGenerator(
            name = "ausencias_seq",
            strategy = "com.bosonit.TablaRelaciones.eje3.StringPrefixedSequenceIdGenerator",
            parameters = {
                    @org.hibernate.annotations.Parameter(name = StringPrefixedSequenceIdGenerator.INCREMENT_PARAM, value = "1"),
                    @org.hibernate.annotations.Parameter(name = StringPrefixedSequenceIdGenerator.VALUE_PREFIX_PARAMETER, value = "STU"),
                    @org.hibernate.annotations.Parameter(name = StringPrefixedSequenceIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%04d")
            })

    private String id_student;

    @OneToOne
    @JoinColumn(name = "persona_id")
    private Persona persona;
    @Column(name = "horas_por_semana")
    private Integer num_hours_week;

    @Column(name = "comentarios")
    private String coments;

    @ManyToOne(
            fetch = FetchType.LAZY)
    @JoinColumn(name = "id_profesor")
    @JsonIgnore
    private Profesor profesor;
    @Column(name = "rama")
    private String branch;

    @ManyToMany(mappedBy = "studentList")
    @JsonIgnore
    private List<StudentSubject> estudios;

    public Student(StudentInputDTO studentInputDTO) {
        setId_student(studentInputDTO.getId_student());
        setNum_hours_week(studentInputDTO.getNum_hours_week());
        setComents(studentInputDTO.getComents());
        setBranch(studentInputDTO.getBranch());
        setEstudios(studentInputDTO.getEstudios());
    }

    public Student(StudentOutputDTO studentOutputDTO) {
        setId_student(studentOutputDTO.getId_student());
        setPersona(studentOutputDTO.getPersona());
        setNum_hours_week(studentOutputDTO.getNum_hours_week());
        setComents(studentOutputDTO.getComents());

        setBranch(studentOutputDTO.getBranch());
        setEstudios(studentOutputDTO.getEstudios());
    }


    public void update(StudentInputDTO studentInputDTO) {
        setId_student(studentInputDTO.getId_student());
        setNum_hours_week(studentInputDTO.getNum_hours_week());
        setComents(studentInputDTO.getComents());
        setBranch(studentInputDTO.getBranch());
        setEstudios(studentInputDTO.getEstudios());
    }
}
