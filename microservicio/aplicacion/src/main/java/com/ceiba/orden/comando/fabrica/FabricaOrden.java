package com.ceiba.orden.comando.fabrica;


import com.ceiba.orden.comando.ComandoOrden;
import com.ceiba.usuario.modelo.entidad.Orden;
import org.springframework.stereotype.Component;

@Component
public class FabricaOrden {
    public Orden crear(ComandoOrden comandoOrden){
        return new Orden(
                comandoOrden.getId(),
                comandoOrden.getIdPersona(),
                comandoOrden.getFecha()
                );
    }
}
