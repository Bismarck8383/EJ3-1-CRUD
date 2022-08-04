package com.bosonit.TablaRelaciones.eje3.Profesor.dominio;


import com.bosonit.TablaRelaciones.eje3.Persona.dominio.Persona;
import com.bosonit.TablaRelaciones.eje3.Profesor.infraestructura.dtos.input.ProfesorInputDTO;
import com.bosonit.TablaRelaciones.eje3.Profesor.infraestructura.dtos.output.ProfesorOutputDTO;
import com.bosonit.TablaRelaciones.eje3.Student.dominio.Student;
import com.bosonit.TablaRelaciones.eje3.StringPrefixedSequenceIdGenerator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "profesor")
public class Profesor {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ausencias_seq")
    @GenericGenerator(
            name = "ausencias_seq",
            strategy = "com.bosonit.TablaRelaciones.eje3.StringPrefixedSequenceIdGenerator",
            parameters = {
                    @org.hibernate.annotations.Parameter(name = StringPrefixedSequenceIdGenerator.INCREMENT_PARAM, value = "1"),
                    @org.hibernate.annotations.Parameter(name = StringPrefixedSequenceIdGenerator.VALUE_PREFIX_PARAMETER, value = "PRO"),
                    @org.hibernate.annotations.Parameter(name = StringPrefixedSequenceIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%04d")
            })
    private String id_profesor;

    @OneToOne
    @JoinColumn(name = "persona_id")
    private Persona persona;

    @Column(name = "coments")
    String coments;

    @Column(name = "branch")
    String branch;


    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private List<Student> students;


    public Profesor(ProfesorInputDTO profesorInputDTO) {
        setId_profesor(profesorInputDTO.getId_profesor());
        setBranch(profesorInputDTO.getBranch());
        setComents(profesorInputDTO.getComents());
    }

    public Profesor(ProfesorOutputDTO profesorOutputDTO) {
        setId_profesor(profesorOutputDTO.getId_profesor());
        setPersona(profesorOutputDTO.getPersona());
        setStudents(profesorOutputDTO.getStudents());
        setBranch(profesorOutputDTO.getBranch());
        setComents(profesorOutputDTO.getComents());
    }
}
