package com.ceiba.orden.adaptador.dto;

import com.ceiba.usuario.modelo.entidad.Orden;
import com.ceiba.usuario.modelo.entidad.Producto;

public class ArticulosOrdenEntity {
    private Long id;
    private Long idOrden;
    private Long idProducto;
    private Double valorUnitario;
    private Double cantidad;
    private Double iva;
    private Double descuento;

    public ArticulosOrdenEntity(Long id, Long idOrden, Long idProducto, Double valorUnitario, Double cantidad, Double iva, Double descuento) {
        this.id = id;
        this.idOrden = idOrden;
        this.idProducto = idProducto;
        this.valorUnitario = valorUnitario;
        this.cantidad = cantidad;
        this.iva = iva;
        this.descuento = descuento;
    }
}
