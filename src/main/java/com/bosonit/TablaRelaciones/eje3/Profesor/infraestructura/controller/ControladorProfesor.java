package com.bosonit.TablaRelaciones.eje3.Profesor.infraestructura.controller;


import com.bosonit.TablaRelaciones.eje3.Profesor.aplicacion.port.CrearProfesorI;
import com.bosonit.TablaRelaciones.eje3.Profesor.aplicacion.port.DeleteProfesorI;
import com.bosonit.TablaRelaciones.eje3.Profesor.aplicacion.port.MostrarProfesorI;
import com.bosonit.TablaRelaciones.eje3.Profesor.aplicacion.port.UpdateProfesorI;
import com.bosonit.TablaRelaciones.eje3.Profesor.infraestructura.dtos.input.ProfesorInputDTO;
import com.bosonit.TablaRelaciones.eje3.Profesor.infraestructura.dtos.output.ProfesorOutputDTO;
import com.bosonit.TablaRelaciones.eje3.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("profesor/crud")
public class ControladorProfesor {

    @Autowired
    CrearProfesorI crearProfesorI;

    @Autowired
    UpdateProfesorI updateProfesorI;

    @Autowired
    DeleteProfesorI deleteProfesorI;

    @Autowired
    MostrarProfesorI mostrarProfesorI;


    //Profesor por Id
    @GetMapping("mostrarProfesor/{id_profesor}")
    public ProfesorOutputDTO profesorId(@PathVariable String id_profesor) throws Exception{
        return mostrarProfesorI.profesorId(id_profesor);
    }

    //Todos los porfesores
    @GetMapping("/allProfesor")
    public List<ProfesorOutputDTO> allProfesors(){
        return  mostrarProfesorI.findAll();
    }

    //Crear Profesor
    @PostMapping("/addProfesor")
    public  ProfesorOutputDTO addProfesor(@RequestBody ProfesorInputDTO profesorInputDTO) throws Exception {
        return crearProfesorI.addProfesor(profesorInputDTO);
    }

    //Actualizar Profesor
    @PutMapping("/update/{id_profesor}")
    public ProfesorOutputDTO  updateProfesor(@PathVariable String id_profesor, @RequestBody ProfesorInputDTO profesorInputDTO) throws NotFoundException{
        return updateProfesorI.updateProfesor(id_profesor,profesorInputDTO);
    }

    //DeleteProfesor
    @DeleteMapping("/delete/{id_profesor}")
    public void  deleteProfesor(@PathVariable String id_profesor) throws Exception {
        deleteProfesorI.deleteProfesor(id_profesor);
    }


}
