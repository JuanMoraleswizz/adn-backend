package com.ceiba.orden.servicio.testdatabuilder;

import com.ceiba.orden.comando.ComandoOrden;
import com.ceiba.orden.comando.ComandoOrdenDetalle;
import com.ceiba.persona.comando.ComandoPersona;
import com.ceiba.usuario.modelo.entidad.Persona;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ComandoOrdenTestDataBuilder {
    private Long id;
    private ComandoPersona idPersona;
    private LocalDateTime fecha;
    List<ComandoOrdenDetalle> listaDetalle;

    public ComandoOrdenTestDataBuilder(){
        idPersona = new ComandoPersona(1L,"1038125422","Juan David","Morales","Muñoz","Masculino");
        fecha = LocalDateTime.now();
        listaDetalle = new ArrayList<>();
        ComandoOrdenDetalleTestDataBuilder testDetalle = new ComandoOrdenDetalleTestDataBuilder();
        listaDetalle.add(testDetalle.buildDetalle());
    }

    public ComandoOrden build(){
        return  new ComandoOrden(id,idPersona,fecha,listaDetalle);
    }
    public  ComandoOrden buildConId(){ return  new ComandoOrden(1L,idPersona,fecha,listaDetalle);}
}
