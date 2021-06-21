package com.ceiba.orden.comando.manejador;


import com.ceiba.usuario.servicio.orden.ServicioEliminarOrden;
import com.ceiba.usuario.servicio.orden.ServicioEliminarArticulosOrdenPorOrden;
import org.springframework.stereotype.Component;

@Component
public class ManejadorEliminarOrden {
    private final ServicioEliminarOrden servicioEliminarOrden;
    private final ServicioEliminarArticulosOrdenPorOrden servicioEliminarArticulosOrdenPorOrden;

    public ManejadorEliminarOrden(ServicioEliminarOrden servicioEliminarOrden, ServicioEliminarArticulosOrdenPorOrden servicioEliminarArticulosOrdenPorOrden) {
        this.servicioEliminarOrden = servicioEliminarOrden;
        this.servicioEliminarArticulosOrdenPorOrden = servicioEliminarArticulosOrdenPorOrden;
    }

    public void ejecutar(Long id) {
        servicioEliminarOrden.ejecutar(id);
        servicioEliminarArticulosOrdenPorOrden.ejecutar(id);
    }
}
