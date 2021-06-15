package com.ceiba.producto.servicio;

import com.ceiba.producto.servicio.testdatabuilder.ProductoTestDataBuilder;
import com.ceiba.usuario.modelo.entidad.Producto;
import com.ceiba.usuario.modelo.entidad.Usuario;
import com.ceiba.usuario.puerto.repositorio.RepositorioProducto;
import com.ceiba.usuario.puerto.repositorio.RepositorioUsuario;
import com.ceiba.usuario.servicio.producto.ServicioActualizarProducto;
import org.junit.Test;
import org.mockito.Mockito;
import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
public class ServicioActualizarProductoTest {
    @Test
    public void validarProductoExistenciaPreviaTest() {
        // arrange
        Producto producto = new ProductoTestDataBuilder().conCodigo("test").build();
        RepositorioProducto repositorioProducto = Mockito.mock(RepositorioProducto.class);
        Mockito.when(repositorioProducto.existe(Mockito.anyString())).thenReturn(true);
        ServicioActualizarProducto servicioActualizarProducto = new ServicioActualizarProducto(repositorioProducto);
        // act - assert
        BasePrueba.assertThrows(() -> servicioActualizarProducto.ejecutar(producto), ExcepcionDuplicidad.class,"El Producto ya existe en el sistema");
    }
}
