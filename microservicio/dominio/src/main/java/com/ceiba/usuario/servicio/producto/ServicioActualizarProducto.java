package com.ceiba.usuario.servicio.producto;

import com.ceiba.usuario.modelo.entidad.Producto;
import com.ceiba.usuario.puerto.repositorio.RepositorioProducto;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
public class ServicioActualizarProducto {

    private static final String EL_PRODUCTO_YA_EXISTE_EN_EL_SISTEMA="El Producto ya existe en el sistema";
    private final RepositorioProducto repositorioProducto;

    public ServicioActualizarProducto(RepositorioProducto repositorioProducto){
        this.repositorioProducto = repositorioProducto;
    }

    public void ejecutar(Producto producto){
        validarExistenciaPrevia(producto);
        this.repositorioProducto.actualizar(producto);
    }
    private void validarExistenciaPrevia(Producto producto) {
        boolean existe = this.repositorioProducto.existe(producto.getCodigo());
        if(existe) {
            throw new ExcepcionDuplicidad(EL_PRODUCTO_YA_EXISTE_EN_EL_SISTEMA);
        }
    }
}
