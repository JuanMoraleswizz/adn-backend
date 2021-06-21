package com.ceiba.persona.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.dominio.excepcion.ExcepcionLongitudValor;
import com.ceiba.persona.servicio.testdatabuilder.PersonaTestDataBuilder;
import com.ceiba.producto.servicio.testdatabuilder.ProductoTestDataBuilder;
import com.ceiba.usuario.modelo.entidad.Persona;
import com.ceiba.usuario.modelo.entidad.Producto;
import com.ceiba.usuario.puerto.repositorio.RepositorioPersona;
import com.ceiba.usuario.puerto.repositorio.RepositorioProducto;
import com.ceiba.usuario.servicio.persona.ServicioActualizarPersona;
import com.ceiba.usuario.servicio.persona.ServicioCrearPersona;
import com.ceiba.usuario.servicio.producto.ServicioActualizarProducto;
import com.ceiba.usuario.servicio.producto.ServicioCrearProducto;
import com.ceiba.usuario.servicio.testdatabuilder.UsuarioTestDataBuilder;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

public class ServicioCrearPersonaTest {


    @Test
    public void validarIdentificacionLongitudMenor7Test() {
        // arrange
        PersonaTestDataBuilder personaTestDataBuilder = new PersonaTestDataBuilder().conIdentificacion("103812");
        // act - assert
        BasePrueba.assertThrows(() -> personaTestDataBuilder.build(), ExcepcionLongitudValor.class, "La longitud de la identificacion debe ser mayor a 7");
    }

    @Test
    public void validarPersonaPreviaTest() {
        // arrange
        Persona persona = new PersonaTestDataBuilder().conIdentificacion("1038125422").build();
        RepositorioPersona repositorioPersona = Mockito.mock(RepositorioPersona.class);
        Mockito.when(repositorioPersona.existe(Mockito.anyString())).thenReturn(true);
        ServicioActualizarPersona servicioActualizarPersona = new ServicioActualizarPersona(repositorioPersona);
        // act - assert
        BasePrueba.assertThrows(() -> servicioActualizarPersona.ejecutar(persona), ExcepcionDuplicidad.class,"La Persona ya existe en el sistema");
    }
    @Test
    public void validarCrearPersonaTest() {
        // arrange
        Persona persona = new PersonaTestDataBuilder().conIdentificacion("1038125422").build();
        RepositorioPersona repositorioPersona = Mockito.mock(RepositorioPersona.class);
        Mockito.when(repositorioPersona.crear(persona)).thenReturn(1L);
        ServicioCrearPersona servicioCrearPersona = new ServicioCrearPersona(repositorioPersona);
        // act - assert
        Long act = servicioCrearPersona.ejecutar(persona);
        //
        Assert.assertEquals(java.util.Optional.of(1L),java.util.Optional.of(act));
    }

}
