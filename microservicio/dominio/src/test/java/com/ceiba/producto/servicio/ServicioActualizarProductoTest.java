package com.ceiba.producto.servicio;

import com.ceiba.persona.servicio.testdatabuilder.PersonaTestDataBuilder;
import com.ceiba.producto.servicio.testdatabuilder.ProductoTestDataBuilder;
import com.ceiba.usuario.modelo.entidad.Persona;
import com.ceiba.usuario.modelo.entidad.Producto;
import com.ceiba.usuario.puerto.repositorio.RepositorioPersona;
import com.ceiba.usuario.puerto.repositorio.RepositorioProducto;
import com.ceiba.usuario.servicio.persona.ServicioActualizarPersona;
import com.ceiba.usuario.servicio.producto.ServicioActualizarProducto;
import org.junit.Test;
import org.mockito.Mockito;
import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
public class ServicioActualizarProductoTest {
    @Test
    public void validarPersonaExistenciaPreviaTest() {
        // arrange
        Persona persona = new PersonaTestDataBuilder().conIdentificacion("1038125422").build();
        RepositorioPersona repositorioPersona = Mockito.mock(RepositorioPersona.class);
        Mockito.when(repositorioPersona.existe(Mockito.anyString())).thenReturn(true);
        ServicioActualizarPersona servicioActualizarPersona= new ServicioActualizarPersona(repositorioPersona);
        // act - assert
        BasePrueba.assertThrows(() -> servicioActualizarPersona.ejecutar(persona), ExcepcionDuplicidad.class,"La Persona ya existe en el sistema");
    }
}
