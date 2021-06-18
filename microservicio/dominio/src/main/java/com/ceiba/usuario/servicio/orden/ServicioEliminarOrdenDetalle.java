package com.ceiba.usuario.servicio.orden;

import com.ceiba.usuario.puerto.repositorio.RepositorioOrden;


public class ServicioEliminarOrdenDetalle {
    private final RepositorioOrden repositorioOrden;

    public ServicioEliminarOrdenDetalle(RepositorioOrden repositorioOrden){
        this.repositorioOrden = repositorioOrden;
    }

    public void ejecutar(Long id){ repositorioOrden.eliminar(id);}

}
