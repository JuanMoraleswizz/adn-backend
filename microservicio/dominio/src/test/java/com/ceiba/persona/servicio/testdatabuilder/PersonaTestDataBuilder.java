package com.ceiba.persona.servicio.testdatabuilder;

import com.ceiba.producto.servicio.testdatabuilder.ProductoTestDataBuilder;
import com.ceiba.usuario.modelo.entidad.Persona;
import com.ceiba.usuario.modelo.entidad.Producto;

import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;

public class PersonaTestDataBuilder {
    private Long id;
    private String identificacion;
    private String nombres;
    private String primerApellido;
    private String segundoApellido;
    private String sexo;

    public PersonaTestDataBuilder(){

        this.identificacion = "1038125422";
        this.nombres = "Juan David";
        this.primerApellido = "Morales";
        this.segundoApellido = "Muñoz";
        this.sexo= "Masculino";
    }
    public PersonaTestDataBuilder conId(Long id){
        this.id = id;
        return this;
    }
    public PersonaTestDataBuilder conIdentificacion(String identificacion){
        this.identificacion = identificacion;
        return this;
    }
    public Persona build(){ return  new Persona(id,identificacion,nombres,primerApellido,segundoApellido,sexo);}

}
