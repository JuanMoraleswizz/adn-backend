package com.ceiba.persona.servicio.testdatabuilder;

import com.ceiba.persona.comando.ComandoPersona;
import com.ceiba.producto.comando.ComandoProducto;
import com.ceiba.producto.servicio.testdatabuilder.ComandoProductoTestDataBuilder;

import java.util.UUID;

public class ComandoPersonaTestDataBuilder {
    private Long id;
    private String identificacion;
    private String nombres;
    private String primerApellido;
    private String segundoApellido;
    private String sexo;
    public ComandoPersonaTestDataBuilder(){
        this.identificacion = UUID.randomUUID().toString();
        this.nombres = "Juan David";
        this.primerApellido = "Morales";
        this.segundoApellido = "Muñoz";
        this.sexo= "Masculino";
    }

    public ComandoPersonaTestDataBuilder conIdentificacion(String identificacion) {
        this.identificacion = identificacion;
        return this;
    }
    public ComandoPersona build(){
        return  new ComandoPersona(id,identificacion,nombres,primerApellido,segundoApellido,sexo);
    }
}
