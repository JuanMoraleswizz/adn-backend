package com.ceiba.persona.comando.manejador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.persona.comando.ComandoPersona;
import com.ceiba.persona.comando.fabrica.FabricaPersona;
import com.ceiba.usuario.modelo.entidad.Persona;
import com.ceiba.usuario.servicio.persona.ServicioCrearPersona;
import org.springframework.stereotype.Component;

@Component
public class ManejadorCrearPersona {
    private final ServicioCrearPersona servicioCrearPersona;

    public ManejadorCrearPersona( ServicioCrearPersona servicioCrearPersona){
        this.servicioCrearPersona = servicioCrearPersona;
    }
    public ComandoRespuesta<Long> ejecutar(ComandoPersona comandoPersona) {
        Persona persona = FabricaPersona.crear(comandoPersona);
        return new ComandoRespuesta<>(this.servicioCrearPersona.ejecutar(persona));
    }
}
