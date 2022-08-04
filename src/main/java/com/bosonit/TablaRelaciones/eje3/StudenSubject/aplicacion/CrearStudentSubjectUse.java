package com.bosonit.TablaRelaciones.eje3.StudenSubject.aplicacion;

import com.bosonit.TablaRelaciones.eje3.StudenSubject.aplicacion.port.CrearStudentSubjectI;
import com.bosonit.TablaRelaciones.eje3.StudenSubject.dominio.StudentSubject;
import com.bosonit.TablaRelaciones.eje3.StudenSubject.infraestructura.dtos.input.StudentSubjectInputDTO;
import com.bosonit.TablaRelaciones.eje3.StudenSubject.infraestructura.dtos.output.StudentSubjectOutputDTO;
import com.bosonit.TablaRelaciones.eje3.StudenSubject.infraestructura.repositorio.StudentSubjectRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CrearStudentSubjectUse implements CrearStudentSubjectI {

    @Autowired
    StudentSubjectRepositorio studentSubjectRepositorio;

    @Override
    public StudentSubjectOutputDTO addEstudios(StudentSubjectInputDTO studentSubjectInputDTO) throws Exception {
        StudentSubject studentSubject = new StudentSubject(studentSubjectInputDTO);
       studentSubjectRepositorio.save(studentSubject);
       return new StudentSubjectOutputDTO(studentSubject);

    }
}
