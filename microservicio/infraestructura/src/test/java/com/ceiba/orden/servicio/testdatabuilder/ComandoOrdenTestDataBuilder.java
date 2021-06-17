package com.ceiba.orden.servicio.testdatabuilder;

import com.ceiba.orden.comando.ComandoOrden;
import com.ceiba.orden.comando.ComandoOrdenDetalle;
import com.ceiba.persona.comando.ComandoPersona;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ComandoOrdenTestDataBuilder {
    private Long id;
    private Long idPersona;
    private LocalDateTime fecha;
    List<ComandoOrdenDetalle> listaDetalle;

    public ComandoOrdenTestDataBuilder(){
        idPersona = 1L;
        fecha = LocalDateTime.now();
        listaDetalle = new ArrayList<>();
        ComandoOrdenDetalleTestDataBuilder testDetalle = new ComandoOrdenDetalleTestDataBuilder();
        listaDetalle.add(testDetalle.buildDetalle());
    }

    public ComandoOrden build(){
        return  new ComandoOrden(id,idPersona,fecha,listaDetalle);
    }
}
