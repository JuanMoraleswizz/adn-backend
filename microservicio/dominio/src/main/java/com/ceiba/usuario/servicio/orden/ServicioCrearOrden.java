package com.ceiba.usuario.servicio.orden;

import com.ceiba.usuario.modelo.entidad.Orden;
import com.ceiba.usuario.puerto.repositorio.RepositorioOrden;


public class ServicioCrearOrden {
    private final RepositorioOrden repositorioOrden;

    public ServicioCrearOrden(RepositorioOrden repositorioOrden){
        this.repositorioOrden = repositorioOrden;
    }

    public Long ejecutar(Orden orden){
        return this.repositorioOrden.crear(orden);
    }
}
