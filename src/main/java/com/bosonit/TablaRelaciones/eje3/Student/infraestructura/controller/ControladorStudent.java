package com.bosonit.TablaRelaciones.eje3.Student.infraestructura.controller;


import com.bosonit.TablaRelaciones.eje3.Student.dominio.Student;
import com.bosonit.TablaRelaciones.eje3.Student.aplicacion.port.*;
import com.bosonit.TablaRelaciones.eje3.Student.infraestructura.dtos.input.StudentInputDTO;
import com.bosonit.TablaRelaciones.eje3.Student.infraestructura.dtos.output.StudentOutputDTO;
import com.bosonit.TablaRelaciones.eje3.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class ControladorStudent {

    @Autowired
    CrearStudentI crearStudentI;

    @Autowired
    UpdateStudentI updateStudentI;

    @Autowired
    DeleteStudentI deleteStudentI;

    @Autowired
    MostrarStudentI mostrarStudentI;

    @Autowired
    AsignarAsignaturaI asignarAsignaturaI;

    //mostrar todos
    @GetMapping("/mostrarTodos")
    public List<StudentOutputDTO> mostrarTodos () throws Exception {
        return mostrarStudentI.mostrarTodos();
    }

    //mostrar por id
    @GetMapping("/buscarId/{id_student}")
    public StudentOutputDTO buscarId(@PathVariable String id_student, @RequestParam(name = "outputType", defaultValue = "simple")String outputType) throws NotFoundException {
        return mostrarStudentI.buscarId(id_student,outputType);
    }

    //add estudiante
    @PostMapping("/addStudent")
    public StudentOutputDTO addStudent(@RequestBody StudentInputDTO studentInputDTO) throws Exception {
        return crearStudentI.addStudent(studentInputDTO);
    }

    //eliminar el estudiante
    @DeleteMapping("/deleteStudent/{id_student}")
    public void deleteStudent(@PathVariable String id_student) throws NotFoundException {
        deleteStudentI.deleteStudent(id_student);
    }

    /*
    *   Asignaturas
    * */

    //add asignatura
    @PutMapping("asignarEstudios/{id_student}")
    public StudentOutputDTO asignarMateria(@PathVariable String id_student, @RequestBody List<String> subjectIdList) throws Exception {
        return asignarAsignaturaI.asignarMateria(id_student, subjectIdList);
    }

    //delemateria
    @DeleteMapping("desasignarEstudios/{id_student}")
    public Student quitarMateria(@PathVariable String id_student, @RequestBody List<String> subjectIdList) throws Exception {
        return asignarAsignaturaI.quitarMateria(id_student,subjectIdList);
    }

}
