package com.ceiba.persona.comando.manejador;

import com.ceiba.persona.comando.ComandoPersona;
import com.ceiba.persona.comando.fabrica.FabricaPersona;
import com.ceiba.usuario.modelo.entidad.Persona;
import com.ceiba.usuario.servicio.persona.ServicioActualizarPersona;
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
