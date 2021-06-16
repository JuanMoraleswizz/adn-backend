package com.ceiba.usuario.servicio.persona;

import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.usuario.modelo.entidad.Persona;
import com.ceiba.usuario.modelo.entidad.Producto;
import com.ceiba.usuario.puerto.repositorio.RepositorioPersona;
import com.ceiba.usuario.puerto.repositorio.RepositorioProducto;

public class ServicioActualizarPersona {
    private static final String LA_PERSONA_YA_EXISTE_EN_EL_SISTEMA="La Persona ya existe en el sistema";
    private final RepositorioPersona repositorioPersona;

    public ServicioActualizarPersona(RepositorioPersona repositorioPersona){
        this.repositorioPersona = repositorioPersona;
    }

    public void ejecutar(Persona persona){
        validarExistenciaPrevia(persona);
        this.repositorioPersona.actualizar(persona);
    }
    private void validarExistenciaPrevia(Persona persona) {
        boolean existe = this.repositorioPersona.existe(persona.getIdentificacion());
        if(existe) {
            throw new ExcepcionDuplicidad(LA_PERSONA_YA_EXISTE_EN_EL_SISTEMA);
        }
    }
}
