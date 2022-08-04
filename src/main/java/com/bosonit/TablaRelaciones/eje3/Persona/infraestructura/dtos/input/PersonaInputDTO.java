package com.bosonit.TablaRelaciones.eje3.Persona.infraestructura.dtos.input;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonaInputDTO {
    private String persona_id;

    private String usuario;
    private String password;
    private String name;
    private String surname;
    private String company_email;
    private String personal_email;
    private String city;
    private boolean active;
    private Date created_date = new Date();
    private String imagen_url;
    private Date termination_date;
}
