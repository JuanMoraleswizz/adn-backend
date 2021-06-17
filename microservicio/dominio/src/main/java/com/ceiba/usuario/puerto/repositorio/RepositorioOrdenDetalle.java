package com.ceiba.usuario.puerto.repositorio;

import com.ceiba.usuario.modelo.entidad.ArticulosOrden;

public interface RepositorioOrdenDetalle {
    /**
     * Permite crear un persona
     * @param articulosOrden
     * @return el id generado
     */
    Long crear(ArticulosOrden articulosOrden);

    /**
     * Permite actualizar un
     * @param articulosOrden
     */
    void actualizar(ArticulosOrden articulosOrden);

    /**
     * Permite eliminar una persona
     * @param id
     */
    void eliminar(Long id);

}
