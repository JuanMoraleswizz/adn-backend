package com.ceiba.usuario.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@Getter
public class DtoOrden {
    private Long id;
    private Long idPersona;
    private String cliente;
    private String identificacion;
    private LocalDateTime fecha;
    private Double valorTotal;
}
