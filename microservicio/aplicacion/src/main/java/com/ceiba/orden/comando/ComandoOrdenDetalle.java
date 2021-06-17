package com.ceiba.orden.comando;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ComandoOrdenDetalle {
    private Long id;
    private Long idOrden;
    private Long idProducto;
    private Double valorUnitario;
    private Double cantidad;
    private Double iva;
    private Double descuento;
}
