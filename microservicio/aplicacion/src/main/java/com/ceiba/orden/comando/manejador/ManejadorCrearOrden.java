package com.ceiba.orden.comando.manejador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.orden.comando.ComandoOrden;
import com.ceiba.orden.comando.fabrica.FabricaOrden;
import com.ceiba.usuario.servicio.orden.ServicioCrearOrden;
import org.springframework.stereotype.Component;

@Component
public class ManejadorCrearOrden {
    private final FabricaOrden fabricaOrden;
    private final ServicioCrearOrden servicioCrearOrden;
    public ManejadorCrearOrden(FabricaOrden fabricaOrden, ServicioCrearOrden servicioCrearOrden) {
        this.fabricaOrden = fabricaOrden;
        this.servicioCrearOrden = servicioCrearOrden;
    }

    public ComandoRespuesta<Long> ejecutar(ComandoOrden comandoOrden) {
        return new ComandoRespuesta<>( this.servicioCrearOrden.ejecutar(fabricaOrden.crear(comandoOrden)));
    }

}
