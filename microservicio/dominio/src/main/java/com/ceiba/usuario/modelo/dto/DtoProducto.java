package com.ceiba.usuario.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class DtoProducto {
    private Long id;
    private String codigo;
    private String nombre;
    private String presentacion;
    private String urlImagen;
    private Double valorUnitario;
}
