package com.bosonit.TablaRelaciones.eje3.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
public class UnprocesableException extends RuntimeException{
     public UnprocesableException(String message){
         super("La validacion de los campos no cumple los requisitos establecidos");
     }
}
