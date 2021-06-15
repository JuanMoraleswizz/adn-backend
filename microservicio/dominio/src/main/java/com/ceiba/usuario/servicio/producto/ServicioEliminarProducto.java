package com.ceiba.usuario.servicio.producto;

import com.ceiba.usuario.puerto.repositorio.RepositorioProducto;

public class ServicioEliminarProducto {

    private final RepositorioProducto repositorioProducto;

    public ServicioEliminarProducto(RepositorioProducto repositorioProducto){
        this.repositorioProducto = repositorioProducto;
    }

    public void ejecutar(Long id){ repositorioProducto.eliminar(id);}

}
