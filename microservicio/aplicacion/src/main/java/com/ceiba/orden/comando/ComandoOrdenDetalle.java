package com.ceiba.orden.comando;

import com.ceiba.producto.comando.ComandoProducto;
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
    private ComandoOrden orden;
    private ComandoProducto producto;
    private Double valorUnitario;
    private Double cantidad;
    private Double iva;
    private Double descuento;
}
