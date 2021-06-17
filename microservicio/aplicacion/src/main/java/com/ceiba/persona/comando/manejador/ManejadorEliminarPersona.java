package com.ceiba.persona.comando.manejador;


import com.ceiba.usuario.servicio.persona.ServicioEliminarPersona;
import org.springframework.stereotype.Component;

@Component
public class ManejadorEliminarPersona {
    private final ServicioEliminarPersona servicioEliminarPersona;

    public ManejadorEliminarPersona(ServicioEliminarPersona servicioEliminarPersona){
        this.servicioEliminarPersona = servicioEliminarPersona;
    }
    public void ejecutar(Long id){ servicioEliminarPersona.ejecutar(id);}
}
