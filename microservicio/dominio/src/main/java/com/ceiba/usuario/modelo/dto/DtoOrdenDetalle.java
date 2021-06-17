package com.ceiba.usuario.modelo.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class DtoOrdenDetalle {
    private Long id;
    private Long idOrden;
    private Long idProducto;
    private Double valorUnitario;
    private Double cantidad;
    private Double subTotal;
    private Double iva;
    private Double descuento;

}
