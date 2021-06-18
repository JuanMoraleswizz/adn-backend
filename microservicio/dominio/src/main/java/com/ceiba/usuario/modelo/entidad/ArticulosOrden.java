package com.ceiba.usuario.modelo.entidad;

import com.ceiba.dominio.ValidadorArgumento;
import lombok.Getter;

@Getter
public class ArticulosOrden {
    private static final String SE_DEBE_INGRESAR_EL_PRODUCTO = "Se debe selecionar un product";
    private static final String LA_CANTIDAD_MINIMA_ES_1 = "Se debe selecionar un cliente";
    private static final String EL_VALOR_MINIMO_ES_1 = "Se debe ingresar un valor mayor a 0";
    private static final String EL_VALOR_NO_PUEDE_SER_NEGATIVO = "El valor no puede ser menor a 0";
    private Long id;
    private Orden orden;
    private Producto producto;
    private Double valorUnitario;
    private Double cantidad;
    private Double iva;
    private Double descuento;

    public ArticulosOrden(Long id, Orden orden, Producto producto, Double valorUnitario,
                          Double cantidad, Double iva, Double descuento) {

        ValidadorArgumento.validarObligatorio(producto.getId(),SE_DEBE_INGRESAR_EL_PRODUCTO);
        ValidadorArgumento.validarPositivo(valorUnitario,EL_VALOR_NO_PUEDE_SER_NEGATIVO);
        ValidadorArgumento.validarPositivo(cantidad, LA_CANTIDAD_MINIMA_ES_1);
        ValidadorArgumento.validarPositivo(iva,EL_VALOR_NO_PUEDE_SER_NEGATIVO);
        ValidadorArgumento.validarPositivo(descuento,EL_VALOR_NO_PUEDE_SER_NEGATIVO);

        this.id = id;
        this.orden = orden;
        this.producto = producto;
        this.valorUnitario = valorUnitario;
        this.cantidad = cantidad;
        this.iva = iva;
        this.descuento = descuento;
    }
}
