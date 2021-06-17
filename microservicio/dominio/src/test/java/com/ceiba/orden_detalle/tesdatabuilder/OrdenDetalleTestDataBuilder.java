package com.ceiba.orden_detalle.tesdatabuilder;

public class OrdenDetalleTestDataBuilder {
    private Long id;
    private Long idOrden;
    private Long idProducto;
    private Double valorUnitario;
    private Double cantidad;
    private Double subTotal;
    private Double iva;
    private Double descuento;

    OrdenDetalleTestDataBuilder(){
        this.idOrden = 1L;
        this.idProducto = 1L;
        this.valorUnitario = 1000.0;
        this.cantidad = 1.0;
        this.subTotal = 1000.0;
        this.iva = 0.0;
        this.descuento = 0.0;
    }
}
