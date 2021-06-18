package com.ceiba.usuario.modelo.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class DtoArticulosOrden {
    private Long id;
    private Long orden;
    private Long producto;
    private Double valorUnitario;
    private Double cantidad;
    private Double iva;
    private Double descuento;
}
