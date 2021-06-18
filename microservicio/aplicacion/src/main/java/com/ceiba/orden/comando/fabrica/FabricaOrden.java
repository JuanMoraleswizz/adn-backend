package com.ceiba.orden.comando.fabrica;


import com.ceiba.orden.comando.ComandoOrden;
import com.ceiba.persona.comando.fabrica.FabricaPersona;
import com.ceiba.usuario.modelo.entidad.Orden;
import org.springframework.stereotype.Component;

@Component
public class FabricaOrden {
    public Orden crear(ComandoOrden comandoOrden){
        FabricaOrdenDetalle fabricaOrdenDetalle = new FabricaOrdenDetalle();
        return new Orden(
                comandoOrden.getId(),
                FabricaPersona.crear(comandoOrden.getPersona()),
                comandoOrden.getFecha(),
                fabricaOrdenDetalle.crear(comandoOrden.getListaDetalle())
                );
    }
}
