package com.ceiba.usuario.puerto.repositorio;

import com.ceiba.usuario.modelo.entidad.ArticulosOrden;
import com.ceiba.usuario.modelo.entidad.Orden;

public interface RepositorioOrden {
    /**
     * Permite crear una orden
     *
     * @param orden
     * @return el id generado
     */
    Long crear(Orden orden);

    /**
     * Permite actualizar una orden
     *
     * @param orden
     */
    void actualizar(Orden orden);

    /**
     * Permite actualizar un articulo de la orden
     *
     * @param articuloOrden
     */
    void actualizar(ArticulosOrden articuloOrden);

    /**
     * Permite eliminar articulos orden
     *
     * @param idOrden
     */
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

    /**
     * Permite validar si una orden ya existe
     *
     * @param id
     * @return si existe o no
     */
    boolean existe(Long id);
}
