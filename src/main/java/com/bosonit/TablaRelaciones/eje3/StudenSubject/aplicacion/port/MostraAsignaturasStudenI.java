package com.bosonit.TablaRelaciones.eje3.StudenSubject.aplicacion.port;

import com.bosonit.TablaRelaciones.eje3.exceptions.NotFoundException;

import java.util.List;

public interface MostraAsignaturasStudenI {
    List mostrarAsignaturas(String id_student) throws NotFoundException;
}
