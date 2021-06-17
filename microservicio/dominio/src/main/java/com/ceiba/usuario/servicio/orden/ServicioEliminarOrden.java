package com.ceiba.usuario.servicio.orden;

import com.ceiba.usuario.puerto.repositorio.RepositorioOrden;
import com.ceiba.usuario.puerto.repositorio.RepositorioPersona;


public class ServicioEliminarOrden {
    private final RepositorioOrden repositorioOrden;

    public ServicioEliminarOrden(RepositorioOrden repositorioOrden){
        this.repositorioOrden = repositorioOrden;
    }

    public void ejecutar(Long idOrden){ repositorioOrden.eliminar(idOrden);}

}
