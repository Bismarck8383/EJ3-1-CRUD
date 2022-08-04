package com.bosonit.TablaRelaciones.eje3.StudenSubject.aplicacion.port;

import com.bosonit.TablaRelaciones.eje3.exceptions.NotFoundException;

public interface DeleteStudentSubjectI {
    void deleteEstudios(String id_study) throws NotFoundException;
}
