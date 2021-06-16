package com.ceiba.persona.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.dominio.excepcion.ExcepcionLongitudValor;
import com.ceiba.persona.servicio.testdatabuilder.PersonaTestDataBuilder;
import com.ceiba.producto.servicio.testdatabuilder.ProductoTestDataBuilder;
import com.ceiba.usuario.modelo.entidad.Producto;
import com.ceiba.usuario.puerto.repositorio.RepositorioProducto;
import com.ceiba.usuario.servicio.producto.ServicioActualizarProducto;
import com.ceiba.usuario.servicio.producto.ServicioCrearProducto;
import com.ceiba.usuario.servicio.testdatabuilder.UsuarioTestDataBuilder;
import org.junit.Test;
import org.mockito.Mockito;

public class ServicioCrearPersonaTest {


    @Test
    public void validarClaveLongitudMenor7Test() {
        // arrange
        PersonaTestDataBuilder personaTestDataBuilder = new PersonaTestDataBuilder().conIdentificacion("103812");
        // act - assert
        BasePrueba.assertThrows(() -> personaTestDataBuilder.build(), ExcepcionLongitudValor.class, "La longitud de la identificacion debe ser mayor a 7");
    }

    @Test
    public void validarProductoExistenciaPreviaTest() {
        // arrange
        Producto producto = new ProductoTestDataBuilder().conCodigo("test").build();
        RepositorioProducto repositorioProducto = Mockito.mock(RepositorioProducto.class);
        Mockito.when(repositorioProducto.existe(Mockito.anyString())).thenReturn(true);
        ServicioCrearProducto servicioCrearProducto = new ServicioCrearProducto(repositorioProducto);
        // act - assert
        BasePrueba.assertThrows(() -> servicioCrearProducto.ejecutar(producto), ExcepcionDuplicidad.class,"La Persona ya existe en el sistema");
    }

}
