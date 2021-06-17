package com.ceiba.usuario.servicio.orden;

import com.ceiba.usuario.puerto.repositorio.RepositorioOrden;
import com.ceiba.usuario.puerto.repositorio.RepositorioOrdenDetalle;

public class ServicioEliminarOrdenDetalle {
    private final RepositorioOrdenDetalle repositorioOrdenDetalle;

    public ServicioEliminarOrdenDetalle(RepositorioOrdenDetalle repositorioOrdenDetalle){
        this.repositorioOrdenDetalle = repositorioOrdenDetalle;
    }

    public void ejecutar(Long id){ repositorioOrdenDetalle.eliminar(id);}

}
