package com.bosonit.TablaRelaciones.eje3.Student.infraestructura.repositorio;

import com.bosonit.TablaRelaciones.eje3.Student.dominio.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepositorio extends JpaRepository<Student, String> {
}
