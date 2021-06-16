package com.ceiba.usuario.puerto.dao;

import com.ceiba.usuario.modelo.dto.DtoPersona;
import com.ceiba.usuario.modelo.dto.DtoProducto;

import java.util.List;

public interface DaoPersona {
    List<DtoPersona> listar();
}
