package com.ceiba.orden_detalle;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import com.ceiba.dominio.excepcion.ExcepcionValorObligatorio;
import com.ceiba.orden.servicio.TestDataBuilder.OrdenTestDataBuilder;
import com.ceiba.orden_detalle.tesdatabuilder.ArticulosOrdenTestDataBuilder;
import org.junit.Test;

public class ServicioCrearOrdenDetalleTest {

    private static final Double VALOR_0 =0.0;

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
}
