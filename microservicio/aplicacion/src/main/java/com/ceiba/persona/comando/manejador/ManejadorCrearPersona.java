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
    private final FabricaPersona fabricaPersona;
    public ManejadorCrearPersona( ServicioCrearPersona servicioCrearPersona, FabricaPersona fabricaPersona){
        this.servicioCrearPersona = servicioCrearPersona;
        this.fabricaPersona = fabricaPersona;
    }
    public ComandoRespuesta<Long> ejecutar(ComandoPersona comandoPersona) {
        Persona persona = fabricaPersona.crear(comandoPersona);
        return new ComandoRespuesta<>(this.servicioCrearPersona.ejecutar(persona));
    }
}
