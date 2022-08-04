package com.bosonit.TablaRelaciones.eje3.Persona.infraestructura.dtos.output;

import com.bosonit.TablaRelaciones.eje3.Persona.dominio.Persona;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonaOutputDTO {
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

    public PersonaOutputDTO(Persona p){
        setPersona_id(p.getPersona_id());
        setUsuario(p.getUsuario());
        setPassword(p.getPassword());
        setName(p.getName());
        setSurname(p.getSurname());
        setCompany_email(p.getCompany_email());
        setPersonal_email(p.getPersonal_email());
        setCity(p.getCity());
        setActive(p.isActive());
        setCreated_date(p.getCreated_date());
        setImagen_url(p.getImagen_url());
        setTermination_date(p.getTermination_date());
    }

}
