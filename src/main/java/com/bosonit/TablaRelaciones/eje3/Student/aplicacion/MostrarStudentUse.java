package com.bosonit.TablaRelaciones.eje3.Student.aplicacion;

import com.bosonit.TablaRelaciones.eje3.Student.aplicacion.port.MostrarStudentI;
import com.bosonit.TablaRelaciones.eje3.Student.dominio.Student;
import com.bosonit.TablaRelaciones.eje3.Student.infraestructura.dtos.output.StudentOutputDTO;
import com.bosonit.TablaRelaciones.eje3.Student.infraestructura.repositorio.StudentRepositorio;
import com.bosonit.TablaRelaciones.eje3.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MostrarStudentUse implements MostrarStudentI {

    @Autowired
    StudentRepositorio studentRepositorio;


    @Override
    public StudentOutputDTO buscarId(String id_student, String outputType) throws NotFoundException {
       Student student = studentRepositorio.findById(id_student)
               .orElseThrow( () -> new NotFoundException("ID : "+id_student+" No encontrado"));
               return fullOrSimple(id_student,outputType);
    }

    private StudentOutputDTO fullOrSimple(String id_student, String outputType) {
        Student student = studentRepositorio.findById(id_student)
                .orElseThrow( () -> new NotFoundException("ID : "+id_student+" No encontrado"));

        if (outputType.equalsIgnoreCase("full")) {
            return fullDTO(student);
        } else {
            return simpleDTO(student);
        }
    }

    private StudentOutputDTO simpleDTO(Student student) {
        Student studentAux = new Student();

        studentAux.setId_student(student.getId_student());
        studentAux.setNum_hours_week(student.getNum_hours_week());
        studentAux.setComents(student.getComents());
        studentAux.setBranch(student.getBranch());

        return new StudentOutputDTO(studentAux);

    }

    private StudentOutputDTO fullDTO(Student student) {
        Student studentAux = new Student();

        studentAux.setId_student(student.getId_student());
        studentAux.setPersona(student.getPersona());
        studentAux.setNum_hours_week(student.getNum_hours_week());
        studentAux.setComents(student.getComents());
        studentAux.setProfesor(student.getProfesor());
        studentAux.setBranch(student.getBranch());

        return new StudentOutputDTO(studentAux);
    }
    //mostrar todos los estuduaintes
    @Override
    public List<StudentOutputDTO> mostrarTodos() throws Exception {
        List<StudentOutputDTO> allStudent = new ArrayList<>();

        studentRepositorio.findAll().forEach( s ->{
                    StudentOutputDTO studentOutputDTO= new StudentOutputDTO();
                    allStudent.add(studentOutputDTO);
                }
        );

        if (allStudent.isEmpty()){
            throw  new Exception("No se encontraron estudiantes en la base de datos");
        }
        return  allStudent;
    }
}
