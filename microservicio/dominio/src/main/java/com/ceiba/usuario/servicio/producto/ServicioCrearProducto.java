package com.ceiba.usuario.servicio.producto;

import com.ceiba.usuario.modelo.entidad.Producto;
import com.ceiba.usuario.puerto.repositorio.RepositorioProducto;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;


public class ServicioCrearProducto {
    private static final String EL_PRODUCTO_YA_EXISTE_EN_EL_SISTEMA="El Producto ya existe en el sistema";

    private final RepositorioProducto repositorioProducto;

    public ServicioCrearProducto(RepositorioProducto repositorioProducto){
        this.repositorioProducto =repositorioProducto;
    }

    public Long ejecutar(Producto producto){
        validarExistenciaPrevia(producto);
      return   this.repositorioProducto.crear(producto);
    }
    private void validarExistenciaPrevia(Producto producto) {
        boolean existe = this.repositorioProducto.existe(producto.getCodigo());
        if(existe) {
            throw new ExcepcionDuplicidad(EL_PRODUCTO_YA_EXISTE_EN_EL_SISTEMA);
        }
    }
}
