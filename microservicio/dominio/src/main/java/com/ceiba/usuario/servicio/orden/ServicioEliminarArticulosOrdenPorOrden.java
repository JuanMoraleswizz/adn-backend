package com.ceiba.usuario.servicio.orden;

import com.ceiba.usuario.puerto.repositorio.RepositorioOrden;

public class ServicioEliminarArticulosOrdenPorOrden {
    private final RepositorioOrden repositorioOrden;

    public ServicioEliminarArticulosOrdenPorOrden(RepositorioOrden repositorioOrden){
        this.repositorioOrden = repositorioOrden;
    }

    public void ejecutar(Long idOrden){ repositorioOrden.eliminarPorOrden(idOrden);}
}
