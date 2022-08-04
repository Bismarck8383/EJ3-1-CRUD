package com.bosonit.TablaRelaciones.eje3.Profesor.infraestructura.dtos.input;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProfesorInputDTO {

    private String id_profesor;
    private String persona_id;
    private String branch;
    private String coments;
}
