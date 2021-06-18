package com.ceiba.orden_detalle.tesdatabuilder;

import com.ceiba.producto.servicio.testdatabuilder.ProductoTestDataBuilder;
import com.ceiba.usuario.modelo.entidad.ArticulosOrden;
import com.ceiba.usuario.modelo.entidad.Orden;
import com.ceiba.usuario.modelo.entidad.Producto;

public class ArticulosOrdenTestDataBuilder {
    private Long id;
    private Orden idOrden;
    private Producto idProducto;
    private Double valorUnitario;
    private Double cantidad;
    private Double subTotal;
    private Double iva;
    private Double descuento;

    public ArticulosOrdenTestDataBuilder(){
       ProductoTestDataBuilder productoTestDataBuilder = new ProductoTestDataBuilder();
        this.idOrden =null;
        productoTestDataBuilder.conCodigo("test");
        productoTestDataBuilder.conId(1L);
        this.idProducto = productoTestDataBuilder.build();
        this.valorUnitario = 1000.0;
        this.cantidad = 1.0;
        this.subTotal = 1000.0;
        this.iva = 0.0;
        this.descuento = 0.0;
    }

    public ArticulosOrdenTestDataBuilder conId(Long id){
        this.id=id;
        return this;
    }

    public ArticulosOrden build(){
        return new ArticulosOrden(id,idOrden,idProducto,valorUnitario,cantidad,iva,descuento);
    }
}
