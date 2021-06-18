package com.ceiba.orden.servicio.TestDataBuilder;

import com.ceiba.orden_detalle.tesdatabuilder.ArticulosOrdenTestDataBuilder;
import com.ceiba.persona.servicio.testdatabuilder.PersonaTestDataBuilder;
import com.ceiba.usuario.modelo.entidad.ArticulosOrden;
import com.ceiba.usuario.modelo.entidad.Orden;
import com.ceiba.usuario.modelo.entidad.Persona;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class OrdenTestDataBuilder {
    private Long id;
    private Persona persona;
    private LocalDateTime fecha;
    List<ArticulosOrden> listaArticulos;

    public OrdenTestDataBuilder(){
        PersonaTestDataBuilder personaTestDataBuilder = new PersonaTestDataBuilder();
        personaTestDataBuilder =personaTestDataBuilder.conId(1L);
        persona = personaTestDataBuilder.build();
        fecha = LocalDateTime.now();
        listaArticulos = new ArrayList<>();
    }

    public OrdenTestDataBuilder conId(Long id){
        this.id = id;
        return this;
    }
    public OrdenTestDataBuilder conArticulos(List<ArticulosOrden> listaArticulos){
        this.listaArticulos = listaArticulos;
        return this;
    }

    public Orden build(){
        return new Orden(id,persona,fecha,listaArticulos);
    }

}
