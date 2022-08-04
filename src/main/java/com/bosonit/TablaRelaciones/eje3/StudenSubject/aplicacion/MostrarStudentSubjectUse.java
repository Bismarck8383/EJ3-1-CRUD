package com.bosonit.TablaRelaciones.eje3.StudenSubject.aplicacion;

import com.bosonit.TablaRelaciones.eje3.StudenSubject.aplicacion.port.MostrarStudentSubjectI;
import com.bosonit.TablaRelaciones.eje3.StudenSubject.dominio.StudentSubject;
import com.bosonit.TablaRelaciones.eje3.StudenSubject.infraestructura.dtos.output.StudentSubjectOutputDTO;
import com.bosonit.TablaRelaciones.eje3.StudenSubject.infraestructura.repositorio.StudentSubjectRepositorio;
import com.bosonit.TablaRelaciones.eje3.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MostrarStudentSubjectUse implements MostrarStudentSubjectI {

    @Autowired
    StudentSubjectRepositorio studentSubjectRepositorio;
    @Override
    public StudentSubjectOutputDTO mostrarId(String id_study, String outputType) throws NotFoundException {
        StudentSubject studentSubject = studentSubjectRepositorio.findById(id_study)
                .orElseThrow( () -> new NotFoundException("Id no encontrado "));
        return opciones(id_study, outputType);

    }

    private  StudentSubjectOutputDTO opciones(String id_study, String outputType){
        StudentSubject studentSubject = studentSubjectRepositorio.findById(id_study)
                .orElseThrow( () -> new NotFoundException("Id no encontrado"));

        if (outputType.equalsIgnoreCase("full")){
         return  fullDTO(studentSubject);
        }else {
            return  simpleDTO(studentSubject);
        }

    }

    private StudentSubjectOutputDTO simpleDTO(StudentSubject alumnos ) {
      StudentSubject studentSubject = new StudentSubject();

        studentSubject.setId_study(alumnos.getId_study());
        studentSubject.setSubject(alumnos.getSubject());
        studentSubject.setInitial_date(alumnos.getInitial_date());
        studentSubject.setFinish_date(alumnos.getFinish_date());

        return new StudentSubjectOutputDTO(studentSubject);
    }

    private StudentSubjectOutputDTO fullDTO(StudentSubject alumnos) {
        StudentSubject studentSubject = new StudentSubject();

        studentSubject.setStudentList(alumnos.getStudentList());
        studentSubject.setProfesor(alumnos.getProfesor());
        studentSubject.setId_study(alumnos.getId_study());
        studentSubject.setSubject(alumnos.getSubject());
        studentSubject.setInitial_date(alumnos.getInitial_date());
        studentSubject.setFinish_date(alumnos.getFinish_date());

        return new StudentSubjectOutputDTO(studentSubject);
    }

    @Override
    public List<StudentSubjectOutputDTO> mostrarTodos(String outputType) throws Exception {
        return null;
    }
}
