package com.ceiba.orden.servicio.testdatabuilder;

import com.ceiba.orden.comando.ComandoOrden;
import com.ceiba.orden.comando.ComandoOrdenDetalle;
import com.ceiba.persona.comando.ComandoPersona;
import com.ceiba.producto.comando.ComandoProducto;
import com.ceiba.usuario.modelo.entidad.Orden;
import com.ceiba.usuario.modelo.entidad.Producto;

import java.time.LocalDateTime;

public class ComandoOrdenDetalleTestDataBuilder {
    private Long id;
    private ComandoOrden orden;
    private ComandoProducto producto;
    private Double valorUnitario;
    private Double cantidad;
    private Double iva;
    private Double descuento;

    public ComandoOrdenDetalleTestDataBuilder (){
        ComandoPersona persona = new ComandoPersona(1L,"1038125422","Juan David","Morales","Muñoz","Masculino");
        ComandoProducto producto = new ComandoProducto(1L,"test","producto1","prueba","NA",1000.0);
        this.orden = new ComandoOrden(1L,persona, LocalDateTime.now(),null);
        this.producto = producto;
        this.valorUnitario = 1000.0;
        this.cantidad = 1.0;
        this.iva = 1.0;
        this.descuento = 1.0;
    }
    public ComandoOrdenDetalle buildDetalle(){
        return new ComandoOrdenDetalle(id,orden,producto,valorUnitario,cantidad,iva,descuento);
    }

}
