package com.bosonit.TablaRelaciones.eje3.StudenSubject.infraestructura.repositorio;

import com.bosonit.TablaRelaciones.eje3.StudenSubject.dominio.StudentSubject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentSubjectRepositorio extends JpaRepository<StudentSubject, String> {
}
