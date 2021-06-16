package com.ceiba.persona.comando.manejador;

import com.ceiba.persona.comando.ComandoPersona;
import com.ceiba.persona.comando.fabrica.FabricaPersona;
import com.ceiba.producto.comando.ComandoProducto;
import com.ceiba.producto.comando.Fabrica.FabricaProducto;
import com.ceiba.usuario.modelo.entidad.Persona;
import com.ceiba.usuario.modelo.entidad.Producto;
import com.ceiba.usuario.servicio.persona.ServicioActualizarPersona;
import com.ceiba.usuario.servicio.producto.ServicioActualizarProducto;
import org.springframework.stereotype.Component;

@Component
public class ManejadorActualizarPersona {
    private final FabricaPersona fabricaPersona;
    private final ServicioActualizarPersona servicioActualizarPersona;

    public ManejadorActualizarPersona(FabricaPersona fabricaPersona, ServicioActualizarPersona servicioActualizarPersona){
        this.fabricaPersona = fabricaPersona;
        this.servicioActualizarPersona = servicioActualizarPersona;
    }
    public void ejecutar(ComandoPersona comandoPersona) {
        Persona persona = this.fabricaPersona.crear(comandoPersona);
        this.servicioActualizarPersona.ejecutar(persona);
    }
}
