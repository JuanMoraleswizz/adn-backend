package com.ceiba.orden.comando.manejador;


import com.ceiba.usuario.servicio.orden.ServicioEliminarOrden;
import com.ceiba.usuario.servicio.orden.ServicioEliminarOrdenDetallePorOrden;
import org.springframework.stereotype.Component;

@Component
public class ManejadorEliminarOrden {
    private final ServicioEliminarOrden servicioEliminarOrden;
    private final ServicioEliminarOrdenDetallePorOrden servicioEliminarOrdenDetallePorOrden;

    public ManejadorEliminarOrden(ServicioEliminarOrden servicioEliminarOrden, ServicioEliminarOrdenDetallePorOrden servicioEliminarOrdenDetallePorOrden) {
        this.servicioEliminarOrden = servicioEliminarOrden;
        this.servicioEliminarOrdenDetallePorOrden = servicioEliminarOrdenDetallePorOrden;
    }

    public void ejecutar(Long id) {
        servicioEliminarOrden.ejecutar(id);
        servicioEliminarOrdenDetallePorOrden.ejecutar(id);
    }
}
