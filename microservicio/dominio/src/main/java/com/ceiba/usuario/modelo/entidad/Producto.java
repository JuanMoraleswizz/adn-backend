package com.ceiba.usuario.modelo.entidad;
import lombok.Getter;

import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;
import static com.ceiba.dominio.ValidadorArgumento.validarPositivo;
@Getter
public class Producto {
    private static final String SE_DEBE_INGRESAR_EL_NOMBRE_DEL_PRODUCTO= "Se debe ingresar el nombre del producto";
    private static final String SE_DEBE_INGRESAR_LA_PRESENTACION_DEL_PRODUCTO="Se debe ingresar la presentacion del producto";
    private static final String SE_DEBE_INGRESAR_EL_CODIGO_DEL_PRODUCTO="Se debe ingresar el codigo del producto";
    private static final String SE_DEBE_ADJUNTAR_LA_IMAGEN_DEL_PRODUCTO="Se debe ingresar la imagen del producto";
    private static final String SE_DEBE_INGRESAR_EL_VALOR_UNITARIO_DEL_PRODUCTO="Se debe ingresar el valor del producto";
    private static final String EL_VALOR_UNITARIO_DEBE_SER_POSITIVO="El valor unitario debe ser positivo";

    private Long id;
    private String codigo;
    private String nombre;
    private String presentacion;
    private String urlImagen;
    private Double valorUnitario;

    public Producto(Long id,String codigo ,String nombre,String presentacion, String urlImagen, Double valorUnitario){
        validarObligatorio(nombre,SE_DEBE_INGRESAR_EL_NOMBRE_DEL_PRODUCTO);
        validarObligatorio(codigo,SE_DEBE_INGRESAR_EL_CODIGO_DEL_PRODUCTO);
        validarObligatorio(presentacion,SE_DEBE_INGRESAR_LA_PRESENTACION_DEL_PRODUCTO);
        validarObligatorio(urlImagen,SE_DEBE_ADJUNTAR_LA_IMAGEN_DEL_PRODUCTO);
        validarObligatorio(valorUnitario,SE_DEBE_INGRESAR_EL_VALOR_UNITARIO_DEL_PRODUCTO);
        validarPositivo(valorUnitario, EL_VALOR_UNITARIO_DEBE_SER_POSITIVO);

        this.id= id;
        this.nombre = nombre;
        this.codigo = codigo;
        this.presentacion = presentacion;
        this.valorUnitario = valorUnitario;
    }

}
