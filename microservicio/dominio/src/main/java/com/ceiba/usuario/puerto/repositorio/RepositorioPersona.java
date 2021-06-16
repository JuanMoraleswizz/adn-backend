package com.ceiba.usuario.puerto.repositorio;

import com.ceiba.usuario.modelo.entidad.Persona;

public interface RepositorioPersona {
    /**
     * Permite crear un persona
     * @param persona
     * @return el id generado
     */
    Long crear(Persona persona);

    /**
     * Permite actualizar un
     * @param persona
     */
    void actualizar(Persona persona);

    /**
     * Permite eliminar una persona
     * @param id
     */
    void eliminar(Long id);

    /**
     * Permite validar si existe un persona con una identificacion
     * @param identificacion
     * @return si existe o no
     */
    boolean existe(String identificacion);
}
