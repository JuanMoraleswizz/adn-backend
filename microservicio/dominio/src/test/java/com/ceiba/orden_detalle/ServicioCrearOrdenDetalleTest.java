package com.ceiba.orden_detalle;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import com.ceiba.dominio.excepcion.ExcepcionValorObligatorio;
import com.ceiba.orden.servicio.TestDataBuilder.OrdenTestDataBuilder;
import com.ceiba.orden_detalle.tesdatabuilder.ArticulosOrdenTestDataBuilder;
import com.ceiba.persona.servicio.testdatabuilder.PersonaTestDataBuilder;
import com.ceiba.usuario.modelo.entidad.Persona;
import com.ceiba.usuario.puerto.repositorio.RepositorioPersona;
import com.ceiba.usuario.servicio.persona.ServicioActualizarPersona;
import org.junit.Test;
import org.mockito.Mockito;

public class ServicioCrearOrdenDetalleTest {

    private static final Double VALOR_0 =0.0;
    private static final Double VALOR_NEGATIVO =-1.0;
    @Test
    public void elValorDelArticuloDebeSerMayoA0(){
       ArticulosOrdenTestDataBuilder articulosOrdenTestDataBuilder = new ArticulosOrdenTestDataBuilder();
       articulosOrdenTestDataBuilder.conValorUnitario(VALOR_0);
        BasePrueba.assertThrows(() -> articulosOrdenTestDataBuilder.build(), ExcepcionValorInvalido.class, "El valor no puede ser menor a 0");
    }

    @Test
    public void validarQueTengaUnProductoAsociado(){
        ArticulosOrdenTestDataBuilder articulosOrdenTestDataBuilder = new ArticulosOrdenTestDataBuilder();
        articulosOrdenTestDataBuilder.conProducto(null);
        BasePrueba.assertThrows(() -> articulosOrdenTestDataBuilder.build(), ExcepcionValorObligatorio.class, "Se debe selecionar un producto");
    }

    @Test
    public void elValorDelIvaNoPuedeSerNegativo(){
        ArticulosOrdenTestDataBuilder articulosOrdenTestDataBuilder = new ArticulosOrdenTestDataBuilder();
        articulosOrdenTestDataBuilder.conValorIva(VALOR_NEGATIVO);
        BasePrueba.assertThrows(() -> articulosOrdenTestDataBuilder.build(), ExcepcionValorInvalido.class, "El valor no puede ser menor a 0");

    }

}
