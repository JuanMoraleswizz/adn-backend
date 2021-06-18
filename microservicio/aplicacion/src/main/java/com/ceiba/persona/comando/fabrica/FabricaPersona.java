package com.ceiba.persona.comando.fabrica;


import com.ceiba.persona.comando.ComandoPersona;
import com.ceiba.usuario.modelo.entidad.Persona;
import org.springframework.stereotype.Component;

@Component
public class FabricaPersona {
    private FabricaPersona() {
    }

    public static Persona crear(ComandoPersona comandoPersona){
        return new Persona(
                comandoPersona.getId(),
                comandoPersona.getIdentificacion(),
                comandoPersona.getNombres(),
                comandoPersona.getPrimerApellido(),
                comandoPersona.getSegundoApellido(),
                comandoPersona.getSexo());
    }
}
