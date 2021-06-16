package com.ceiba.usuario.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class DtoPersona {
    private Long id;
    private String identificacion;
    private String nombres;
    private String primerApellido;
    private String segundoApellido;
    private String sexo;
}
