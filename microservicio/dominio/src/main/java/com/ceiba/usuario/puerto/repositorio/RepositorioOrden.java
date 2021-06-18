package com.ceiba.usuario.puerto.repositorio;

import com.ceiba.usuario.modelo.entidad.Orden;

public interface RepositorioOrden {
    /**
     * Permite crear una orden
     *
     * @param orden
     * @return el id generado
     */
    Long crear(Orden orden);

    void eliminarPorOrden(Long idOrden);

    /**
     * Permite eliminar una orden
     *
     * @param id
     */
    void eliminar(Long id);

    /**
     * Permite eliminar un articulo de una orden
     *
     * @param id
     */
    void eliminarArticulo(Long id);

}
