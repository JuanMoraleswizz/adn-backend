package com.ceiba.producto.comando.manejador;

import com.ceiba.producto.comando.ComandoProducto;
import com.ceiba.producto.comando.fabrica.FabricaProducto;
import com.ceiba.usuario.modelo.entidad.Producto;
import com.ceiba.usuario.servicio.producto.ServicioActualizarProducto;
import org.springframework.stereotype.Component;
import com.ceiba.manejador.ManejadorComando;
@Component
public class ManejadorActualizarProducto implements ManejadorComando<ComandoProducto> {
    private final FabricaProducto fabricaProducto;
    private final ServicioActualizarProducto servicioActualizarProducto;

    public ManejadorActualizarProducto(FabricaProducto fabricaProducto, ServicioActualizarProducto servicioActualizarProducto){
        this.fabricaProducto = fabricaProducto;
        this.servicioActualizarProducto = servicioActualizarProducto;
    }
    public void ejecutar(ComandoProducto comandoProducto) {
        Producto producto = this.fabricaProducto.crear(comandoProducto);
        this.servicioActualizarProducto.ejecutar(producto);
    }

}
