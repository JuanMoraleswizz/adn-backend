package com.ceiba.usuario.puerto.repositorio;

import com.ceiba.usuario.modelo.entidad.Producto;
import com.ceiba.usuario.modelo.entidad.Usuario;

public interface RepositorioProducto {
    /**
     * Permite crear un producto
     * @param producto
     * @return el id generado
     */
    Long crear(Producto producto);

    /**
     * Permite actualizar un producto
     * @param producto
     */
    void actualizar(Producto producto);

    /**
     * Permite eliminar un producto
     * @param id
     */
    void eliminar(Long id);

    /**
     * Permite validar si existe un producto con un codigo
     * @param codigo
     * @return si existe o no
     */
    boolean existe(String codigo);

}
