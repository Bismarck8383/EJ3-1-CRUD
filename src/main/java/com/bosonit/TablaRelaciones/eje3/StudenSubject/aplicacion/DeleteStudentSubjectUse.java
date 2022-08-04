package com.bosonit.TablaRelaciones.eje3.StudenSubject.aplicacion;

import com.bosonit.TablaRelaciones.eje3.StudenSubject.aplicacion.port.DeleteStudentSubjectI;
import com.bosonit.TablaRelaciones.eje3.StudenSubject.dominio.StudentSubject;
import com.bosonit.TablaRelaciones.eje3.StudenSubject.infraestructura.repositorio.StudentSubjectRepositorio;
import com.bosonit.TablaRelaciones.eje3.Student.infraestructura.repositorio.StudentRepositorio;
import com.bosonit.TablaRelaciones.eje3.exceptions.NotFoundException;
import com.bosonit.TablaRelaciones.eje3.exceptions.UnprocesableException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeleteStudentSubjectUse implements DeleteStudentSubjectI {
    @Autowired
    StudentSubjectRepositorio studentSubjectRepositorio;

    @Autowired
    StudentRepositorio studentRepositorio;

    @Override
    public void deleteEstudios(String id_study) throws NotFoundException {
        StudentSubject studentSubject = studentSubjectRepositorio.findById(id_study)
                .orElseThrow( () -> new NotFoundException("EL Id Introducido no existe"));
        studentSubjectRepositorio.findAll().forEach(m ->{
            if (m.getStudentList() == null){
                studentSubjectRepositorio.deleteById(id_study);
            }else {
                throw new UnprocesableException("No se puede eliminar asignatura con estudiante asignado");
            }
        });
    }
}
