package com.ceiba.usuario.servicio.persona;

import com.ceiba.usuario.puerto.repositorio.RepositorioPersona;

public class ServicioEliminarPersona {
    private final RepositorioPersona repositorioPersona;

    public ServicioEliminarPersona(RepositorioPersona repositorioPersona){
        this.repositorioPersona = repositorioPersona;
    }
    public void ejecutar(Long id){ repositorioPersona.eliminar(id);}

}
