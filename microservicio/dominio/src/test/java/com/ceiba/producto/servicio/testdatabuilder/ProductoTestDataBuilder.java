package com.ceiba.producto.servicio.testdatabuilder;

import com.ceiba.usuario.modelo.entidad.Producto;

public class ProductoTestDataBuilder {
    private Long id;
    private String nombre;
    private String codigo;
    private String presentacion;
    private String urlImagen;
    private Double valorUnitario;

    public  ProductoTestDataBuilder(){
        this.nombre = "Tomate";
        this.presentacion = "Por Libra";
        this.urlImagen = "../../../../../resource/Tomate.png";
        this.valorUnitario= 2000.0;
    }

    public ProductoTestDataBuilder conId(Long id){
        this.id = id;
        return this;
    }
    public ProductoTestDataBuilder conCodigo(String codigo){
        this.codigo = codigo;
        return this;
    }
    public Producto build(){ return  new Producto(id,codigo,nombre,presentacion,urlImagen,valorUnitario);}
}
