package com.bosonit.TablaRelaciones.eje3.StudenSubject.aplicacion;

import com.bosonit.TablaRelaciones.eje3.StudenSubject.aplicacion.port.MostraAsignaturasStudenI;
import com.bosonit.TablaRelaciones.eje3.StudenSubject.infraestructura.repositorio.StudentSubjectRepositorio;
import com.bosonit.TablaRelaciones.eje3.Student.dominio.Student;
import com.bosonit.TablaRelaciones.eje3.Student.infraestructura.repositorio.StudentRepositorio;
import com.bosonit.TablaRelaciones.eje3.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MostrarAsignaturasStudentUse implements MostraAsignaturasStudenI {
    @Autowired
    StudentRepositorio studentRepositorio;
    @Override
    public List mostrarAsignaturas(String id_student) throws NotFoundException {
        Student student= studentRepositorio.findById(id_student)
                .orElseThrow( () -> new NotFoundException("Id de estudiante no encontrado"));
        List listaEstudios = student.getEstudios();
        return listaEstudios;
    }
}
