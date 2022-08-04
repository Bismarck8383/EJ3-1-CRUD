package com.bosonit.TablaRelaciones.eje3.Student.aplicacion;

import com.bosonit.TablaRelaciones.eje3.Profesor.infraestructura.repositorio.ProfesorRepositorio;
import com.bosonit.TablaRelaciones.eje3.Persona.dominio.Persona;
import com.bosonit.TablaRelaciones.eje3.Persona.infraestructura.repositorio.PersonaRepositorio;
import com.bosonit.TablaRelaciones.eje3.Student.aplicacion.port.CrearStudentI;
import com.bosonit.TablaRelaciones.eje3.Student.dominio.Student;
import com.bosonit.TablaRelaciones.eje3.Student.infraestructura.dtos.input.StudentInputDTO;
import com.bosonit.TablaRelaciones.eje3.Student.infraestructura.dtos.output.StudentOutputDTO;
import com.bosonit.TablaRelaciones.eje3.Student.infraestructura.repositorio.StudentRepositorio;
import com.bosonit.TablaRelaciones.eje3.exceptions.NotFoundException;
import com.bosonit.TablaRelaciones.eje3.exceptions.UnprocesableException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CrearStudentUse implements CrearStudentI {
    @Autowired
    ProfesorRepositorio profesorRepositorio;

    @Autowired
    PersonaRepositorio personaRepositorio;

    @Autowired
    StudentRepositorio studentRepositorio;

    @Override
    public StudentOutputDTO addStudent(StudentInputDTO studentInputDTO) throws Exception {
        Student student = new Student(studentInputDTO);
        student.setPersona(getPersona(studentInputDTO));

        StudentOutputDTO studentOutputDTO = new StudentOutputDTO(student);

        if(studentInputDTO == null){
            throw new UnprocesableException("No se puede introducir un estudiante sin datos");
        }else{
            studentRepositorio.saveAndFlush(student);
            System.out.println("Estudiante guardado");
        }
        return studentOutputDTO;
    }


    //obtenemos el id_persona de entity Persona
    private Persona getPersona(StudentInputDTO studentInputDTO) {
      String persona_id = studentInputDTO.getPersona_id();
        Persona persona = personaRepositorio.findById(persona_id).orElseThrow(() -> new NotFoundException("ID INVÁLIDO"));

        return persona;
    }
}
