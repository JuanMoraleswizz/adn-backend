package com.ceiba.usuario.modelo.entidad;

import lombok.Getter;

import static com.ceiba.dominio.ValidadorArgumento.*;

@Getter
public class Persona {
    private static final String SE_DEBE_INGRESAR_LOS_NOMBRES_DE_LA_PERSONA= "Se debe ingresar los nombres de la persona";
    private static final String SE_DEBE_INGRESAR_LA_IDENTIFICACION_DE_LA_PERSONA="Se debe ingresar la identificacion de la persona";
    private static final String SE_DEBE_INGRESAR_EL_PRIMER_APELLIDO_DE_LA_PERSONA="Se debe ingresar el primer apellido de la persona";
    private static final String LA_LONGITUD_DE_IDENTIFICACION_DE_LA_PERSONA_MAYOR_A_7="La longitud de la identificacion debe ser mayor a 7";


    private Long id;
    private String identificacion;
    private String nombres;
    private String primerApellido;
    private String segundoApellido;
    private String sexo;

    public Persona(Long id, String identificacion, String nombres, String primerApellido,
                   String segundoApellido, String sexo){
        validarObligatorio(identificacion,SE_DEBE_INGRESAR_LA_IDENTIFICACION_DE_LA_PERSONA);
        validarObligatorio(nombres,SE_DEBE_INGRESAR_LOS_NOMBRES_DE_LA_PERSONA);
        validarObligatorio(primerApellido,SE_DEBE_INGRESAR_EL_PRIMER_APELLIDO_DE_LA_PERSONA);
        validarLongitudMinima(identificacion,8,LA_LONGITUD_DE_IDENTIFICACION_DE_LA_PERSONA_MAYOR_A_7);
        this.id= id;
        this.identificacion = identificacion;
        this.nombres = nombres;
        this.primerApellido = primerApellido;
        this.segundoApellido = segundoApellido;
        this.sexo= sexo;
    }

}
