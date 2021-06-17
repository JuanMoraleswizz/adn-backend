package com.ceiba.orden.comando.manejador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.orden.comando.ComandoOrden;
import com.ceiba.orden.comando.fabrica.FabricaOrden;
import com.ceiba.orden.comando.fabrica.FabricaOrdenDetalle;
import com.ceiba.usuario.servicio.orden.ServicioCrearOrden;
import com.ceiba.usuario.servicio.orden.ServicioCrearOrdenDetalle;
import org.springframework.stereotype.Component;

@Component
public class ManejadorCrearOrden {
    private final FabricaOrden fabricaOrden;
    private final ServicioCrearOrden servicioCrearOrden;
    private final FabricaOrdenDetalle fabricaOrdenDetalle;
    private final ServicioCrearOrdenDetalle servicioCrearOrdenDetalle;
    public ManejadorCrearOrden(FabricaOrden fabricaOrden, ServicioCrearOrden servicioCrearOrden,
                               FabricaOrdenDetalle fabricaOrdenDetalle, ServicioCrearOrdenDetalle servicioCrearOrdenDetalle) {
        this.fabricaOrden = fabricaOrden;
        this.servicioCrearOrden = servicioCrearOrden;
        this.fabricaOrdenDetalle = fabricaOrdenDetalle;
        this.servicioCrearOrdenDetalle=servicioCrearOrdenDetalle;

    }

    public ComandoRespuesta<Long> ejecutar(ComandoOrden comandoOrden) {
        Long id = this.servicioCrearOrden.ejecutar(fabricaOrden.crear(comandoOrden));
        comandoOrden.getListaDetalle().forEach(detalle -> { detalle.setIdOrden(id); });
        fabricaOrdenDetalle.crear(comandoOrden).forEach(detalle ->{
            servicioCrearOrdenDetalle.ejecutar(detalle);
        });
        return new ComandoRespuesta<>(id);
    }

}
