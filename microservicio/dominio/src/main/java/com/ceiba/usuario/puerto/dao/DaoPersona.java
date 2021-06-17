package com.ceiba.usuario.puerto.dao;

import com.ceiba.usuario.modelo.dto.DtoPersona;

import java.util.List;

public interface DaoPersona {
    List<DtoPersona> listar();

    List<DtoPersona> listarPorIdentificacion(String identificacion);

}
