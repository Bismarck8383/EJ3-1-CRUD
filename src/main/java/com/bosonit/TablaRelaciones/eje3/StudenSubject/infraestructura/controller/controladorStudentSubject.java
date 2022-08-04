package com.bosonit.TablaRelaciones.eje3.StudenSubject.infraestructura.controller;

import com.bosonit.TablaRelaciones.eje3.StudenSubject.aplicacion.port.*;
import com.bosonit.TablaRelaciones.eje3.StudenSubject.infraestructura.dtos.input.StudentSubjectInputDTO;
import com.bosonit.TablaRelaciones.eje3.StudenSubject.infraestructura.dtos.output.StudentSubjectOutputDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/materias")
public class controladorStudentSubject {

    @Autowired
    CrearStudentSubjectI crearStudentSubjectI;

    @Autowired
    UpdateStudentSubjectI updateStudentSubjectI;

    @Autowired
    MostrarStudentSubjectI mostrarStudentSubjectI;

    @Autowired
    MostraAsignaturasStudenI mostraAsignaturasStudenI;

    @Autowired
    DeleteStudentSubjectI deleteStudentSubjectI;


    //Addiciona materias
    @PostMapping("/addMaterias")
    public StudentSubjectOutputDTO addEstudios(@RequestBody StudentSubjectInputDTO studentSubjectInputDTO) throws Exception{
        return crearStudentSubjectI.addEstudios(studentSubjectInputDTO);
    }

    //eliminar materia
    @DeleteMapping("/deleteMateria/{id_study}")
    public void deleteEstudios(@PathVariable String id_study) {
      deleteStudentSubjectI.deleteEstudios(id_study);
    }

    //update materia
    @PutMapping("/updateMateria/{id_study}")

    public  StudentSubjectOutputDTO updateStudios(@RequestBody StudentSubjectInputDTO studentSubjectInputDTO, @RequestParam  String id_study){
        return  updateStudentSubjectI.updateEstudios(id_study,studentSubjectInputDTO);
    }

    //mostrar materia por id
    @GetMapping("/mostrarMateria/{id_study}")
    public StudentSubjectOutputDTO buscarPorId (@PathVariable String id_study, @RequestParam String outputType) {
        return mostrarStudentSubjectI.mostrarId(id_study, outputType);
    }

    //Mostrar todas las mterias
    @GetMapping("/mostrarTodas")
    public List<StudentSubjectOutputDTO> buscarTodas (@RequestParam String outputType) throws Exception {
        return mostrarStudentSubjectI.mostrarTodos(outputType);
    }

    //buscar asignaturas de estudiantes
    @GetMapping("/mostrarASignadas/{id_student}")
    public List mostrarAsignas (@PathVariable String id_student) {
        return mostraAsignaturasStudenI.mostrarAsignaturas(id_student);
    }







}
