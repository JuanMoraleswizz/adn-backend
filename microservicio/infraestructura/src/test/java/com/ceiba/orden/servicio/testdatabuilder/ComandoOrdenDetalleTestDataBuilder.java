package com.ceiba.orden.servicio.testdatabuilder;

import com.ceiba.orden.comando.ComandoOrdenDetalle;
import com.ceiba.persona.comando.ComandoPersona;

public class ComandoOrdenDetalleTestDataBuilder {
    private Long id;
    private Long idOrden;
    private Long idProducto;
    private Double valorUnitario;
    private Double cantidad;
    private Double subTotal;
    private Double iva;
    private Double descuento;

    public ComandoOrdenDetalleTestDataBuilder (){
        this.idOrden = 1L;
        this.idProducto = 1L;
        this.valorUnitario = 1000.0;
        this.cantidad = 1.0;
        this.subTotal = 1000.0;
        this.iva = 1.0;
        this.descuento = 1.0;
    }
    public ComandoOrdenDetalle buildDetalle(){
        return new ComandoOrdenDetalle(id,idOrden,idProducto,valorUnitario,cantidad,subTotal,iva,descuento);
    }

}
