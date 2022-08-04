package com.bosonit.TablaRelaciones.eje3.StudenSubject.dominio;

import com.bosonit.TablaRelaciones.eje3.Profesor.dominio.Profesor;
import com.bosonit.TablaRelaciones.eje3.StringPrefixedSequenceIdGenerator;
import com.bosonit.TablaRelaciones.eje3.StudenSubject.infraestructura.dtos.input.StudentSubjectInputDTO;
import com.bosonit.TablaRelaciones.eje3.StudenSubject.infraestructura.dtos.output.StudentSubjectOutputDTO;
import com.bosonit.TablaRelaciones.eje3.Student.dominio.Student;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Data
@Table(name= "estudios")
@AllArgsConstructor
@NoArgsConstructor
public class StudentSubject {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ausencias_seq")
    @GenericGenerator(
            name = "ausencias_seq",
            strategy = "com.bosonit.TablaRelaciones.eje3.StringPrefixedSequenceIdGenerator",
            parameters = {
                    @org.hibernate.annotations.Parameter(name = StringPrefixedSequenceIdGenerator.INCREMENT_PARAM, value = "1"),
                    @org.hibernate.annotations.Parameter(name = StringPrefixedSequenceIdGenerator.VALUE_PREFIX_PARAMETER, value = "SUB"),
                    @org.hibernate.annotations.Parameter(name = StringPrefixedSequenceIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%04d")
            })
    private String id_study;

    @ManyToMany( cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "student_subject",
            joinColumns =  {@JoinColumn(name= "id_study")},
            inverseJoinColumns = {@JoinColumn(name = "id_student")}
    )
    @JsonIgnore
    private List<Student> studentList;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_profesor")
    Profesor profesor;

    @Column(name = "asignatura")
    private String subject;

    @Column(name = "comentarios")
    private String comment;

    @Column(name = "initial_date")
    private Date initial_date;

    @Column(name = "finish_date")
    private Date finish_date;


    public  StudentSubject(StudentSubjectInputDTO studentSubjectInputDTO){
        setId_study(studentSubjectInputDTO.getId_study());
        setSubject(studentSubjectInputDTO.getSubject());
        setComment(studentSubjectInputDTO.getComment());
        setInitial_date(studentSubjectInputDTO.getInitial_date());
        setFinish_date(studentSubjectInputDTO.getFinish_date());

    }
    public void update(StudentSubjectInputDTO studentSubjectInputDTO){
        setId_study(studentSubjectInputDTO.getId_study());
        setSubject(studentSubjectInputDTO.getSubject());
        setComment(studentSubjectInputDTO.getComment());
        setInitial_date(studentSubjectInputDTO.getInitial_date());
        setFinish_date(studentSubjectInputDTO.getFinish_date());

    }

    public  StudentSubject(StudentSubjectOutputDTO studentSubjectOutputDTO){
        setId_study(studentSubjectOutputDTO.getId_study());
        setSubject(studentSubjectOutputDTO.getSubject());
        setInitial_date(studentSubjectOutputDTO.getInitial_date());
        setFinish_date(studentSubjectOutputDTO.getFinish_date());
        setComment(studentSubjectOutputDTO.getComment());
    }
}
