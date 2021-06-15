package com.ceiba.servicio.testdatabuilder;

import com.ceiba.producto.comando.ComandoProducto;
import com.ceiba.producto.controlador.ComandoControladorProductoTest;

import java.util.UUID;

public class ComandoProductoTestDataBuilder {
    private Long id;
    private String nombre;
    private String codigo;
    private String presentacion;
    private String urlImagen;
    private Double valorUnitario;

    public ComandoProductoTestDataBuilder(){
        this.nombre= "producto 1";
        this.codigo = UUID.randomUUID().toString();
        this.presentacion= "LB";
        this.urlImagen = "NONE";
        this.valorUnitario = 2000.0;

    }

    public ComandoProductoTestDataBuilder conCodigo(String codigo) {
        this.codigo = codigo;
        return this;
    }
    public ComandoProducto build(){
        return  new ComandoProducto(id,codigo,nombre,presentacion,urlImagen,valorUnitario);
    }
}
