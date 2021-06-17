package com.ceiba.usuario.servicio.orden;

import com.ceiba.usuario.modelo.entidad.ArticulosOrden;
import com.ceiba.usuario.puerto.repositorio.RepositorioOrdenDetalle;

public class ServicioCrearOrdenDetalle {
    private final RepositorioOrdenDetalle repositorioOrdenDetalle;

    public ServicioCrearOrdenDetalle(RepositorioOrdenDetalle repositorioOrdenDetalle){
        this.repositorioOrdenDetalle = repositorioOrdenDetalle;
    }

    public void ejecutar(ArticulosOrden articulosOrden){
        this.repositorioOrdenDetalle.crear(articulosOrden);
    }
}
