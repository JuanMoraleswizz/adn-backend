package com.ceiba.producto.comando.manejador;

import com.ceiba.usuario.servicio.producto.ServicioEliminarProducto;
import org.springframework.stereotype.Component;
import com.ceiba.manejador.ManejadorComando;
@Component
public class ManejadorEliminarProducto implements ManejadorComando<Long>  {

    private final ServicioEliminarProducto servicioEliminarProducto;

    public ManejadorEliminarProducto(ServicioEliminarProducto servicioEliminarProducto){
        this.servicioEliminarProducto = servicioEliminarProducto;
    }
    public void ejecutar(Long id){ servicioEliminarProducto.ejecutar(id);}
}
