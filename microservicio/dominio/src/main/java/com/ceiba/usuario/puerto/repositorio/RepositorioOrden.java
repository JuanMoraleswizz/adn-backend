package com.ceiba.usuario.puerto.repositorio;

import com.ceiba.usuario.modelo.entidad.Orden;
import com.ceiba.usuario.modelo.entidad.Persona;

public interface RepositorioOrden {
    /**
     * Permite crear un persona
     * @param orden
     * @return el id generado
     */
    Long crear(Orden orden);

    /**
     * Permite actualizar un
     * @param orden
     */
    void actualizar(Orden orden);

    /**
     * Permite eliminar una persona
     * @param idOrden
     */
    void eliminarPorOrden(Long idOrden);
    /**
     * Permite eliminar una persona
     * @param id
     */
    void eliminar(Long id);

    /**
     * Permite validar si existe un persona con una identificacion
     * @param id
     * @return si existe o no
     */
    boolean existe(Long id);
}
