package com.ceiba.orden.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.*;
import com.ceiba.orden.servicio.TestDataBuilder.OrdenTestDataBuilder;
import com.ceiba.persona.servicio.testdatabuilder.PersonaTestDataBuilder;
import com.ceiba.producto.servicio.testdatabuilder.ProductoTestDataBuilder;
import com.ceiba.usuario.modelo.entidad.ArticulosOrden;
import com.ceiba.usuario.modelo.entidad.Orden;
import com.ceiba.usuario.modelo.entidad.Producto;
import com.ceiba.usuario.puerto.repositorio.RepositorioOrden;
import com.ceiba.usuario.puerto.repositorio.RepositorioPersona;
import com.ceiba.usuario.puerto.repositorio.RepositorioProducto;
import com.ceiba.usuario.servicio.orden.ServicioCrearOrden;
import com.ceiba.usuario.servicio.persona.ServicioActualizarPersona;
import com.ceiba.usuario.servicio.producto.ServicioCrearProducto;
import org.junit.Test;
import org.mockito.Mockito;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ServicioCrearOrdenTest {

    OrdenTestDataBuilder ordenTestDataBuilder = new OrdenTestDataBuilder();
    @Test
    public void validarQueLaListaNoEsteVacia(){
        List<ArticulosOrden> lista = new ArrayList<>();
        ordenTestDataBuilder.conArticulos(lista);
        BasePrueba.assertThrows(() -> ordenTestDataBuilder.build(), ExcepcionValorObligatorio.class, "La lista de articulos no puedeser vacia");
    }

    @Test
    public void validarQueLaPersonaExista(){
        ordenTestDataBuilder.conPersona(null);
        BasePrueba.assertThrows(() -> ordenTestDataBuilder.build(), ExcepcionValorObligatorio.class, "La persona debe estar registrada en el sistema");
    }

    @Test
    public void validarQueLaFechaDeLaOrdenNoPuedeSerMenorAlaActual(){
        LocalDateTime fechaAnterior = LocalDateTime.of(2017, 2, 13, 15, 56);
        ordenTestDataBuilder.conFecha(fechaAnterior);
        BasePrueba.assertThrows(() -> ordenTestDataBuilder.build(), ExcepcionValorInvalido.class,"La fecha no puede ser menor a la actual");
    }
    @Test
    public void debeValidarQueLosVernesTenganDescuentoTest(){
        LocalDateTime fechaViernes = LocalDateTime.of(2021, 6, 25, 2, 56);
        Orden orden = new OrdenTestDataBuilder().conFecha(fechaViernes).build();
        RepositorioOrden repositorioOrden = Mockito.mock(RepositorioOrden.class);
        ServicioCrearOrden servicioCrearOrden = new ServicioCrearOrden(repositorioOrden);
        // act - assert
        BasePrueba.assertThrows(() -> servicioCrearOrden.ejecutar(orden), ExcepcionDescuento.class,"Todos lo articulos debe tener descuento minimo de 5%");

    }
    @Test
    public void debeValidarQueLosMartesTenganDescuentoTest(){
        LocalDateTime fechaMartes = LocalDateTime.of(2021, 6, 22, 2, 56);
        Orden orden = new OrdenTestDataBuilder().conFecha(fechaMartes).build();
        RepositorioOrden repositorioOrden = Mockito.mock(RepositorioOrden.class);
        ServicioCrearOrden servicioCrearOrden = new ServicioCrearOrden(repositorioOrden);
        // act - assert
        BasePrueba.assertThrows(() -> servicioCrearOrden.ejecutar(orden), ExcepcionDescuento.class,"Todos lo articulos debe tener descuento minimo de 5%");

    }

}
