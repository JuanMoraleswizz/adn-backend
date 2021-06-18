package com.ceiba.orden.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.dominio.excepcion.ExcepcionLongitudValor;
import com.ceiba.dominio.excepcion.ExcepcionSinDatos;
import com.ceiba.dominio.excepcion.ExcepcionValorObligatorio;
import com.ceiba.orden.servicio.TestDataBuilder.OrdenTestDataBuilder;
import com.ceiba.producto.servicio.testdatabuilder.ProductoTestDataBuilder;
import com.ceiba.usuario.modelo.entidad.Orden;
import com.ceiba.usuario.modelo.entidad.Producto;
import com.ceiba.usuario.puerto.repositorio.RepositorioProducto;
import com.ceiba.usuario.servicio.producto.ServicioCrearProducto;
import org.junit.Test;
import org.mockito.Mockito;

import java.time.LocalDateTime;

public class ServicioCrearOrdenTest {

    @Test
    public void validarQueLaListaNoEsteVacia(){
        OrdenTestDataBuilder ordenTestDataBuilder = new OrdenTestDataBuilder();
        BasePrueba.assertThrows(() -> ordenTestDataBuilder.build(), ExcepcionValorObligatorio.class, "La lista de articulos no puedeser vacia");
    }

    @Test
    public void validarQueLaPersonaExista(){
        OrdenTestDataBuilder ordenTestDataBuilder = new OrdenTestDataBuilder();
        ordenTestDataBuilder.conPersona(null);
    }

}
