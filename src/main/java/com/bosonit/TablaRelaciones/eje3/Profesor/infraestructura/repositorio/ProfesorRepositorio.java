package com.bosonit.TablaRelaciones.eje3.Profesor.infraestructura.repositorio;

import com.bosonit.TablaRelaciones.eje3.Profesor.dominio.Profesor;
import com.bosonit.TablaRelaciones.eje3.Profesor.infraestructura.dtos.output.ProfesorOutputDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.swing.*;
import java.util.List;

@Component
@Repository
public interface ProfesorRepositorio extends JpaRepository<Profesor,String> {

}
