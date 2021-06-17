package com.ceiba.usuario.servicio.orden;

import com.ceiba.usuario.puerto.repositorio.RepositorioOrden;

public class ServicioEliminarOrdenDetallePorOrden {
    private final RepositorioOrden repositorioOrden;

    public ServicioEliminarOrdenDetallePorOrden(RepositorioOrden repositorioOrden){
        this.repositorioOrden = repositorioOrden;
    }

    public void ejecutar(Long idOrden){ repositorioOrden.eliminarPorOrden(idOrden);}
}
